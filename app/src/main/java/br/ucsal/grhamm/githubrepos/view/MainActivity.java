package br.ucsal.grhamm.githubrepos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.ucsal.grhamm.githubrepos.R;
import br.ucsal.grhamm.githubrepos.Repository;
import br.ucsal.grhamm.githubrepos.persistence.Database;
import br.ucsal.grhamm.githubrepos.view.viewmodel.UserViewModel;
import br.ucsal.grhamm.githubrepos.view.viewmodel.UserViewModelFabric;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private RecyclerView listView;
    private UserCustomAdapter adapter;
    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(Database.getInstance(this).userDAO());

        UserViewModelFabric fabric = new UserViewModelFabric(repository);

        ViewModelProvider provider = new ViewModelProvider(this, fabric);

        userViewModel = provider.get(UserViewModel.class);

        adapter = new UserCustomAdapter();

        listView = findViewById(R.id.search_history_list);

        listView.setAdapter(adapter);

        listView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        userViewModel.getUsers().observe(this, i -> adapter.update(i));

        searchView = findViewById(R.id.search_username);
    }

    public void btnSearchAction(View view) {
        String content = this.searchView.getText().toString();

        Intent i = new Intent(MainActivity.this, SearchActivity.class);

        i.putExtra("username", content);

        startActivity(i);
    }
}
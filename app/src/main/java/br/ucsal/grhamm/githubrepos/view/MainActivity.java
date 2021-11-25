package br.ucsal.grhamm.githubrepos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.ucsal.grhamm.githubrepos.R;
import br.ucsal.grhamm.githubrepos.Repository;
import br.ucsal.grhamm.githubrepos.model.User;
import br.ucsal.grhamm.githubrepos.persistence.Database;
import br.ucsal.grhamm.githubrepos.view.viewmodel.UserViewModel;
import br.ucsal.grhamm.githubrepos.view.viewmodel.UserViewModelFabric;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private RecyclerView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository repository = new Repository(Database.getInstance(this).userDAO());

        UserViewModelFabric fabric = new UserViewModelFabric(repository);

        ViewModelProvider provider = new ViewModelProvider(this, fabric);

        userViewModel = provider.get(UserViewModel.class);

        adapter = new CustomAdapter();

        listView = findViewById(R.id.search_history_list);

        listView.setAdapter(adapter);

        listView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        userViewModel.getUsers().observe(this, i -> adapter.update(i));
    }
}
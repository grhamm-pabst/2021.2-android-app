package br.ucsal.grhamm.githubrepos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ucsal.grhamm.githubrepos.R;
import br.ucsal.grhamm.githubrepos.model.Repo;
import br.ucsal.grhamm.githubrepos.view.viewmodel.RepoViewModel;
import br.ucsal.grhamm.githubrepos.view.viewmodel.RepoViewModelFabric;

public class SearchActivity extends AppCompatActivity {

    private String username;

    private RepoViewModel repoViewModel;

    private RecyclerView listView;

    private RepoCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        List<Repo> repos = new ArrayList<Repo>();

        Intent intent = getIntent();

        if(intent != null){
            this.username = intent.getStringExtra("username");
        }

        RepoViewModelFabric fabric = new RepoViewModelFabric();

        ViewModelProvider provider = new ViewModelProvider(this, fabric);

        repoViewModel = provider.get(RepoViewModel.class);

        listView = findViewById(R.id.repo_list);

        adapter = new RepoCustomAdapter(repos);

        listView.setAdapter(adapter);

        listView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        repoViewModel.getRepos(this.username).observe(this, i -> adapter.update(i));
    }


}
package br.ucsal.grhamm.githubrepos.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.ucsal.grhamm.githubrepos.Repository;
import br.ucsal.grhamm.githubrepos.api.Service;
import br.ucsal.grhamm.githubrepos.model.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoViewModel extends ViewModel {


    private MutableLiveData<List<Repo>> repos;


    public LiveData<List<Repo>> getRepos(String username){
        if(repos == null){
            repos = new MutableLiveData<List<Repo>>();
            Call<List<Repo>> call = Service.getInstance().getService().listRepos(username);
            call.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    List<Repo> t = response.body();
                    repos.postValue(t);
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    Log.e("Request failed", t.getMessage());
                }
            });

        }
        return repos;
    }

}
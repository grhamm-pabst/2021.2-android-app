package br.ucsal.grhamm.githubrepos.view.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.ucsal.grhamm.githubrepos.Repository;

public class UserViewModelFabric implements ViewModelProvider.Factory {
    private Repository repository;

    public UserViewModelFabric(Repository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(repository);
    }
}

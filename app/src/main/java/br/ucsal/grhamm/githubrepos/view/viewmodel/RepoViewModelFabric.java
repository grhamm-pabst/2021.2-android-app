package br.ucsal.grhamm.githubrepos.view.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.ucsal.grhamm.githubrepos.Repository;

public class RepoViewModelFabric implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RepoViewModel();
    }
}

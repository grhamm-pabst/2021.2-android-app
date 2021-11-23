package br.ucsal.grhamm.githubrepos.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.ucsal.grhamm.githubrepos.Repository;
import br.ucsal.grhamm.githubrepos.model.User;

public class UserViewModel extends ViewModel {
    private Repository repository;

    private MutableLiveData<List<User>> users;

    public UserViewModel(Repository repository){
        this.repository = repository;
    }

    public LiveData<List<User>> getUsers(){
        if(users == null) {
            users = new MutableLiveData<List<User>>();
        }

        this.users.postValue(repository.getUserDAO().findAll());

        return users;
    }
}

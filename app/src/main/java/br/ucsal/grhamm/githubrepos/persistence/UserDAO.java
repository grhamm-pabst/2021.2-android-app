package br.ucsal.grhamm.githubrepos.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.ucsal.grhamm.githubrepos.model.User;

@Dao
public interface UserDAO {

    @Insert
    public void insert(User user);

    @Query("SELECT * FROM User")
    public List<User> findAll();
}

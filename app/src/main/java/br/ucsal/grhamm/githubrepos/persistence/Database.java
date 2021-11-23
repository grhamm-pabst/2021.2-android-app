package br.ucsal.grhamm.githubrepos.persistence;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.ucsal.grhamm.githubrepos.model.User;

@androidx.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database instance = null;
    public abstract UserDAO userDAO();
    static final ExecutorService executor = Executors.newFixedThreadPool(4);


    public static synchronized Database getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, Database.class,
                    "banco.db")
                    .build();
        }
        return instance;
    }
}

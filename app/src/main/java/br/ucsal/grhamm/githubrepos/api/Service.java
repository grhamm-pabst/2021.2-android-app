package br.ucsal.grhamm.githubrepos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Service instance;

    private WebService service;

    private Service() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WebService.class);
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }

        return instance;
    }

    public WebService getService(){
        return service;
    }
}

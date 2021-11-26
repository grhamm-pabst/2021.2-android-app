package br.ucsal.grhamm.githubrepos.api;

import java.util.List;

import br.ucsal.grhamm.githubrepos.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("grhamm-pabst/repos")
    Call<List<Repo>> listRepos();
}

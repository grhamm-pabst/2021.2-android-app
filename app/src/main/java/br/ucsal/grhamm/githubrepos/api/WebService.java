package br.ucsal.grhamm.githubrepos.api;

import java.util.List;

import br.ucsal.grhamm.githubrepos.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {
    @GET("{username}/repos")
    Call<List<Repo>> listRepos(@Path("username") String username);
}

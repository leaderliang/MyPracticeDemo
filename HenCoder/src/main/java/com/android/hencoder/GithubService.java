package com.android.hencoder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

import java.util.List;

public interface GithubService {

    @GET("/users/leaderliang/repos")
    Call<List<Repo>> getUserRepos();



}

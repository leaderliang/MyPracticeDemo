package com.android.hencoder.dynamic_proxy;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * 声明自己的网络请求接口
 */
public interface GithubService {

    @GET("/users/leaderliang/repos")
    Call<List<Repo>> getUserRepos();

}

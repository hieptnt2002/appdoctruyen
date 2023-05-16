package com.example.appdoctruyen.adapter.api;

import com.example.appdoctruyen.object.TruyenTranh;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("layTruyen.php")
    Call<List<TruyenTranh>> getList();

}

package ru.notasi.imagesgridjson.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkInterface {
    @GET("task-m-001/list.php")
    Call<List<String>> loadImages();
}
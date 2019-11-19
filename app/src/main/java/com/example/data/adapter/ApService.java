package com.example.data.adapter;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kouxin on 2019/9/4.
 */

public interface ApService {

    String getUri="http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Call<Bean> getJson();
}

package com.yfo.monolith;

import com.yfo.monolith.pojo.ListQueryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {

    @GET("/api/unknown")
    Call<ListQueryResponse> getList();

}

package com.yfo.monolith.remote;

import com.yfo.monolith.data.ListQueryResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ListApi {

    @GET("/api/unknown")
    Single<ListQueryResponse> getList();

}

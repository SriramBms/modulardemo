package com.yfo.monolith.repo;

import com.yfo.monolith.data.ListQueryResponse;
import com.yfo.monolith.remote.ApiClient;
import com.yfo.monolith.remote.RetrofitProvider;

import io.reactivex.Single;

public class ListRepository {

    private ApiClient mApi;

    public ListRepository(){
        mApi = new ApiClient(RetrofitProvider.getClient());
    }

    public Single<ListQueryResponse> getList(){
        return mApi.getList();
    }
}

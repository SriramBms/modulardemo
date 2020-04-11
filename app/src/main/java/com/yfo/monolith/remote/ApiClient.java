package com.yfo.monolith.remote;

import com.yfo.monolith.data.ListQueryResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class ApiClient {
    ListApi mListApi;
    public ApiClient(Retrofit retrofit){
        mListApi = retrofit.create(ListApi.class);
    }

    public Single<ListQueryResponse> getList(){
        return mListApi.getList();
    }


}

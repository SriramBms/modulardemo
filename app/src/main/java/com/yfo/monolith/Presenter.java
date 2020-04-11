package com.yfo.monolith;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yfo.monolith.data.ListItem;
import com.yfo.monolith.data.ListQueryResponse;
import com.yfo.monolith.repo.ListRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Presenter implements Contract.Presenter
{
    private Contract.View mView;
    private ListRepository mRepo;

    public Presenter(Contract.View view){
        mView = view;
        mRepo = new ListRepository();
    }
    @Override
    public LiveData<List<ListItem>> getList() {
        final MutableLiveData<List<ListItem>> result = new MutableLiveData<>();
        mRepo.getList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver< ListQueryResponse > (){

                    @Override
                    public void onSuccess(ListQueryResponse value) {
                        result.postValue(value.data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        result.postValue(new ArrayList<ListItem>());
                    }
                });
        return result;
    }
}

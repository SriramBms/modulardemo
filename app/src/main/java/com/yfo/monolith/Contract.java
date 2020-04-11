package com.yfo.monolith;

import androidx.lifecycle.LiveData;

import com.yfo.monolith.data.ListItem;

import java.util.List;

public interface Contract {
   public interface View {
       void handleError(int errorCode);
   }

   public interface Presenter {
       LiveData<List<ListItem>> getList();
   }
}

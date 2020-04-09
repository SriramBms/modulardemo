package com.yfo.monolith;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.yfo.monolith.pojo.ListItem;
import com.yfo.monolith.pojo.ListQueryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ListQueryResponse> call = apiInterface.getList();
        call.enqueue(new Callback<ListQueryResponse>() {
            @Override
            public void onResponse(Call<ListQueryResponse> call, Response<ListQueryResponse> response) {
                String displayResponse = "";
                ListQueryResponse resource = response.body();
                List<ListItem> data = resource.data;

                for (ListItem item : data) {
                    displayResponse += item.id + " " + item.name + "\n";
                }
                responseText.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<ListQueryResponse> call, Throwable t) {
                call.cancel();
            }
        });


    }
}

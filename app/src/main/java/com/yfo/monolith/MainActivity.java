package com.yfo.monolith;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.yfo.monolith.data.ListItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {

    TextView mResponseTv;
    Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter(this);
        mResponseTv = findViewById(R.id.responseText);

    }

    @Override
    protected void onResume(){
        super.onResume();
        mPresenter.getList().observe(this, listItems -> {
            String displayResponse = "";
            for (ListItem item : listItems) {
                displayResponse += item.id + " " + item.name + "\n";
            }
            mResponseTv.setText(displayResponse);
        });
    }

    @Override
    public void handleError(int errorCode) {
        mResponseTv.setText("Error code: " + errorCode);
    }
}

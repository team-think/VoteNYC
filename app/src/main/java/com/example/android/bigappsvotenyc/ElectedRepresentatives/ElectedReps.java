package com.example.android.bigappsvotenyc.ElectedRepresentatives;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigappsvotenyc.ElectedRepresentatives.controller.RepOfficialAdapter;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.RepResponse;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.service.RepService;
import com.example.android.bigappsvotenyc.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by catwong on 1/29/17.
 */

public class ElectedReps extends AppCompatActivity {

    private static final String TAG = ElectedReps.class.getSimpleName();
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    private RecyclerView recyclerView;
    private RepOfficialAdapter officialAdapter;
    private RepService service;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elected);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectToServer();
    }

    private void connectToServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepService.class);

        Call<RepResponse> call = service.getRepresentatives();

        call.enqueue(new Callback<RepResponse>() {

            @Override
            public void onResponse(Call<RepResponse> call, Response<RepResponse> response) {
                officialAdapter = new RepOfficialAdapter(response.body());
                Log.d(TAG, "Response: " + response.body());
                Log.d(TAG, "Size: " + response.body().getOfficials());
                recyclerView.setAdapter(officialAdapter);
            }

            @Override
            public void onFailure(Call<RepResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());

            }
        });

    }

}

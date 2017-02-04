package com.example.android.bigappsvotenyc.PollingLocations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigappsvotenyc.MainFragment;
import com.example.android.bigappsvotenyc.PollingLocations.Internet.VoterInfoService;
import com.example.android.bigappsvotenyc.PollingLocations.Model.VoterInfo;
import com.example.android.bigappsvotenyc.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mathcore on 1/30/17.
 */

public class PollLocationsActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.android.bigappsvotenyc;";
    private static final String TAG = PollLocationsActivity.class.getSimpleName();
    private String key = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";
    private RecyclerView recyclerView;
    private PollAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        recyclerView = (RecyclerView) findViewById(R.id.rv_locations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        downloadData();

    }

    public void downloadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/civicinfo/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoterInfoService service = retrofit.create(VoterInfoService.class);
        Intent intent = getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        Call<VoterInfo> call = service.getData(address, "2000", key);

        call.enqueue(new Callback<VoterInfo>() {
            @Override
            public void onResponse(Call<VoterInfo> call, Response<VoterInfo> response) {
                adapter = new PollAdapter((VoterInfo) response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VoterInfo> call, Throwable t) {

                Log.d(TAG, "Error: " + t.getMessage());

            }
        });
    }
}

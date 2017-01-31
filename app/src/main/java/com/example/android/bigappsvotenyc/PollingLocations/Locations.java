package com.example.android.bigappsvotenyc.PollingLocations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.bigappsvotenyc.Internet.VoterInfoService;
import com.example.android.bigappsvotenyc.Model.VoterInfo;
import com.example.android.bigappsvotenyc.PollAdapter;
import com.example.android.bigappsvotenyc.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mathcore on 1/30/17.
 */

public class Locations extends AppCompatActivity {

    private static final String TAG = Locations.class.getSimpleName();
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

    public void downloadData(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/civicinfo/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        VoterInfoService service = retrofit.create(VoterInfoService.class);

        Call<List<VoterInfo>> call = service.getData("682 Seneca Ave Queens NY 11385", "2000", key);

        call.enqueue(new Callback<List<VoterInfo>>() {
            @Override
            public void onResponse(Call<List<VoterInfo>> call, Response<List<VoterInfo>> response) {
                adapter = new PollAdapter((VoterInfo) response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<VoterInfo>> call, Throwable t) {

                Log.d(TAG, "Error: " + t.getMessage());

            }
        });
    }
}

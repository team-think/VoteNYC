package com.example.android.bigappsvotenyc.PollingLocations;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mathcore on 1/30/17.
 */

public class PollLocationsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = PollLocationsActivity.class.getSimpleName();
    private String key = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";
    private RecyclerView recyclerView;
    private PollAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_locations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        downloadData();
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng pollingPlace = getLocationFromAddress("682 Seneca Ave. 3R Ridgewood NY 11385");
        googleMap.addMarker(new MarkerOptions().position(pollingPlace).title("Political"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pollingPlace,11));
    }

    public void downloadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/civicinfo/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoterInfoService service = retrofit.create(VoterInfoService.class);

        Intent intent = getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        String city = intent.getStringExtra(MainFragment.EXTRA_MESSAGE2);
        String state = intent.getStringExtra(MainFragment.EXTRA_MESSAGE3);
        String zipcode = intent.getStringExtra(MainFragment.EXTRA_MESSAGE4);


        Call<VoterInfo> call = service.getData(address + city + state + zipcode, "2000", key);

        call.enqueue(new Callback<VoterInfo>() {
            @Override
            public void onResponse(Call<VoterInfo> call, Response<VoterInfo> response) {
                adapter = new PollAdapter(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VoterInfo> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());

            }
        });
    }

    public LatLng getLocationFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location=address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());

            return p1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p1;

    }


}

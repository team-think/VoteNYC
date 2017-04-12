package com.example.android.bigappsvotenyc.PollingLocations;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by catwong on 4/12/17.
 */

public class PollFragment extends Fragment implements OnMapReadyCallback{

    private static final String TAG = PollFragment.class.getSimpleName();
    private String key = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";
    private RecyclerView recyclerView;
    private View mRoot;
    private MapFragment mapFragment;
    private PollAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_poll, parent, false);
        mapFragment = new MapFragment();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container_map, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);
        return mRoot;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LatLng newyorkcity = new LatLng(40.7128, -74.0059);
        googleMap.addMarker(new MarkerOptions().position(newyorkcity).title("Political"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newyorkcity,11));
    }

    public void downloadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/civicinfo/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoterInfoService service = retrofit.create(VoterInfoService.class);

        Intent intent = getActivity().getIntent();
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
}

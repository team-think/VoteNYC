package com.example.android.bigappsvotenyc.GoogleMaps;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class GoogleMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
//        LatLng newyorkcity = new LatLng(40.7128, -74.0059);
//        googleMap.addMarker(new MarkerOptions().position(newyorkcity).title("Political"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newyorkcity,11));
    }
}
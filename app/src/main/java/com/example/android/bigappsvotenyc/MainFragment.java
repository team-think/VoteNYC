package com.example.android.bigappsvotenyc;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.PollingLocations.Locations;

/**
 * Created by catwong on 1/29/17.
 */

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private ImageView voteBanner, pollLocation;
    private View mRoot;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_main, parent, false);
        clickPollButton();
        return mRoot;
    }

    private void clickPollButton(){

        pollLocation = (ImageView) mRoot.findViewById(R.id.iv_location_pin);
        pollLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPollLocations();
            }
        });


    }

    private void gotoPollLocations() {

        Intent intent = new Intent(getActivity(), Locations.class);
        MainFragment.this.startActivity(intent);


    }
}
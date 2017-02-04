package com.example.android.bigappsvotenyc;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.ElectedOfficials.ElectedOfficialsActivity;
import com.example.android.bigappsvotenyc.PollingLocations.PollLocationsActivity;
import com.example.android.bigappsvotenyc.RecentBills.RecentBillsActivity;




/**
 * Created by catwong on 1/29/17.
 */

public class MainFragment extends Fragment {

    public final static String EXTRA_MESSAGE = "com.example.android.bigappsvotenyc;";
    private static final String TAG = MainFragment.class.getSimpleName();
    private ImageView getOfficials;
    private ImageView getElections;
    private ImageView getLocations;
    private ImageView getRecentBills;
    private View mRoot;
    public String address;
    public EditText editText;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_main, parent, false);
        clickPollButton();
        clickRepButton();
        clickBills();
        return mRoot;
    }

    private void clickPollButton() {
        getLocations = (ImageView) mRoot.findViewById(R.id.iv_location_pin);
        getLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPollLocations();
            }
        });
    }

    private void gotoPollLocations() {
        Intent intent = new Intent(getActivity(), PollLocationsActivity.class);
        editText = (EditText) mRoot.findViewById(R.id.et_address);
        String address = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, address);
        MainFragment.this.startActivity(intent);
    }

    private void clickRepButton() {
        getOfficials = (ImageView) mRoot.findViewById(R.id.iv_officials);
        getOfficials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                representativesByInfo();
            }
        });
    }

    private void representativesByInfo() {
        Intent intent = new Intent(getActivity(), ElectedOfficialsActivity.class);
        MainFragment.this.startActivity(intent);
    }

    public void clickBills() {
        getRecentBills = (ImageView) mRoot.findViewById(R.id.iv_bill);
        getRecentBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRecentBills();
            }
        });
    }

    public void goToRecentBills() {
        Intent intent = new Intent(getActivity(), RecentBillsActivity.class);
        MainFragment.this.startActivity(intent);
    }
//    public void getAddress(){
//        editText = (EditText) mRoot.findViewById(R.id.et_address);
//        String address = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, address);
//    }

}
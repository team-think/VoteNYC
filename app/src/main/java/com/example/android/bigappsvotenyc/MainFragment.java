package com.example.android.bigappsvotenyc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * Created by catwong on 1/29/17.
 */

public class MainFragment extends Fragment {

    public final static String EXTRA_MESSAGE = "com.example.android.bigappsvotenyc;";
    private static final String TAG = MainFragment.class.getSimpleName();
    public static final String EXTRA_MESSAGE2 = "com.example.android.bigappsvotenyc";
    public static final String EXTRA_MESSAGE3 = "com.example.android.bigappsvotenyc";
    public static final String EXTRA_MESSAGE4 = "com.example.android.bigappsvotenyc";

    private ImageView getOfficials;
    private ImageView getElections;
    private ImageView getLocations;
    private ImageView getRecentBills;
    private View mRoot;
    public EditText etAddress;
    public EditText etCity;
    public EditText etState;
    public EditText etZipCode;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_main2, parent, false);
//        clickPollButton();
//        clickOfficialsButton();
//        clickBills();
//        clickElectionsButton();
        return mRoot;
    }


//    private void clickPollButton() {
//        getLocations = (ImageView) mRoot.findViewById(R.id.iv_location_pin);
//        getLocations.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                gotoPollLocations();
//            }
//        });
//    }
//
//    private void gotoPollLocations() {
//        Intent intent = new Intent(getActivity(), PollLocationsActivity.class);
//        etAddress = (EditText) mRoot.findViewById(R.id.et_address);
//        etCity = (EditText) mRoot.findViewById(R.id.et_city);
//        etState = (EditText) mRoot.findViewById(R.id.et_state);
//        etZipCode = (EditText) mRoot.findViewById(R.id.et_zip);
//        String address = etAddress.getText().toString();
//        String city = etCity.getText().toString();
//        String state = etState.getText().toString();
//        String zipcode = etZipCode.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, address);
//        intent.putExtra(EXTRA_MESSAGE2, city);
//        intent.putExtra(EXTRA_MESSAGE3, state);
//        intent.putExtra(EXTRA_MESSAGE4, zipcode);
//        MainFragment.this.startActivity(intent);
//    }
//
//    private void clickOfficialsButton() {
//        getOfficials = (ImageView) mRoot.findViewById(R.id.iv_officials);
//        getOfficials.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToOfficials();
//            }
//        });
//    }
//
//    private void goToOfficials() {
//        Intent intent = new Intent(getActivity(), ElectedOfficialsActivity.class);
//        etAddress = (EditText) mRoot.findViewById(R.id.et_address);
//        etCity = (EditText) mRoot.findViewById(R.id.et_city);
//        etState = (EditText) mRoot.findViewById(R.id.et_state);
//        etZipCode = (EditText) mRoot.findViewById(R.id.et_zip);
//        String address = etAddress.getText().toString();
//        String city = etCity.getText().toString();
//        String state = etState.getText().toString();
//        String zipcode = etZipCode.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, address);
//        intent.putExtra(EXTRA_MESSAGE2, city);
//        intent.putExtra(EXTRA_MESSAGE3, state);
//        intent.putExtra(EXTRA_MESSAGE4, zipcode);
//        MainFragment.this.startActivity(intent);
//    }
//
//    public void clickBills() {
//        getRecentBills = (ImageView) mRoot.findViewById(R.id.iv_bill);
//        getRecentBills.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToRecentBills();
//            }
//        });
//    }
//
//    public void goToRecentBills() {
//        Intent intent = new Intent(getActivity(), RecentBillsActivity.class);
//        MainFragment.this.startActivity(intent);
//    }
//
//    private void clickElectionsButton() {
//        getElections = (ImageView) mRoot.findViewById(R.id.iv_ballot);
//        getElections.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToNextElections();
//            }
//        });
//    }
//
//    private void goToNextElections() {
//        Intent intent = new Intent(getActivity(), NextElectionActivity.class);
//        MainFragment.this.startActivity(intent);
//    }
}
package com.example.android.bigappsvotenyc.ElectedOfficials;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.ElectedOfficials.model.Office;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.Official;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.RepResponse;
import com.example.android.bigappsvotenyc.ElectedOfficials.service.RepService;
import com.example.android.bigappsvotenyc.MainFragment;
import com.example.android.bigappsvotenyc.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by catwong on 1/31/17.
 */

public class OfficialsTopFragment extends Fragment {

    private static final String TAG = ElectedOfficialsActivity.class.getSimpleName();
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    private static final boolean INCLUDE_OFFICES = true;
    private static final String LEVELS_NATIONAL = "country";
    private static final String LEVELS_STATE_1 = "administrativeArea1";
    private static final String LEVELS_STATE_2 = "administrativeArea2";
    private static final String LEVELS_STATE_3 = "regional";
    private static final String LEVELS_LOCALITY = "locality";
    private static final String LEVELS_SUBLOCALITY_1 = "subLocality1";
    private static final String LEVELS_SUBLOCALITY_2 = "subLocality2";
    private static final String LEVELS_SPECIAL = "special";
    private static final String ROLES_HEAD_OF_STATE = "headOfState";
    private static final String ROLES_HEAD_OF_GOVERNMENT = "headOfGovernment";
    private static final String ROLES_DEPUTY_HEAD_OF_GOVERNMENT = "deputyHeadOfGovernment";
    private static final String ROLES_GOVERNMENT_OFFICER = "governmentOfficer";
    private static final String ROLES_EXECUTIVE_COUNCIL = "executiveCouncil";
    private static final String ROLES_LEGISLATOR_UPPER_BODY = "legislatorUpperBody";
    private static final String ROLES_LEGISLATOR_LOWER_BODY = "legislatorLowerBody";
    private static final String ROLES_HIGHEST_COURT_JUDGE = "highestCourtJudge";
    private static final String ROLES_JUDGE = "judge";
    private static final String ROLES_SCHOOLBOARD = "schoolBoard";
    private static final String ROLES_SPECIAL_PURPOSE_OFFICER = "specialPurposeOfficer";
    private static final String GOOGLE_CIVIC_API_KEY = "AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA";
    private RepService service;
    private List<Official> officialList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ImageView official_national;
    private ImageView official_state;
    private View mRoot;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
        connectToServer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_officials, parent, false);
        clickNationalOfficials();
        clickStateOfficials();
        return mRoot;
    }


    private void clickNationalOfficials() {
        official_national = (ImageView) mRoot.findViewById(R.id.iv_officials_national);
        official_national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToNationalOfficials();
            }
        });
    }

    private void clickStateOfficials(){
        official_state = (ImageView) mRoot.findViewById(R.id.iv_officials_state);
        official_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToStateOfficials();
            }
        });
    }


    private void connectToServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepService.class);

        Intent intent = getActivity().getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        String city = intent.getStringExtra(MainFragment.EXTRA_MESSAGE2);
        String state = intent.getStringExtra(MainFragment.EXTRA_MESSAGE3);
        String zipcode = intent.getStringExtra(MainFragment.EXTRA_MESSAGE4);

        Call<RepResponse> call = service.getOfficials(address + city + state + zipcode, INCLUDE_OFFICES, LEVELS_NATIONAL, LEVELS_STATE_1, LEVELS_STATE_2, LEVELS_STATE_3, LEVELS_LOCALITY, LEVELS_SUBLOCALITY_1, LEVELS_SUBLOCALITY_2, LEVELS_SPECIAL, ROLES_HEAD_OF_STATE, ROLES_HEAD_OF_GOVERNMENT, ROLES_DEPUTY_HEAD_OF_GOVERNMENT, ROLES_GOVERNMENT_OFFICER, ROLES_EXECUTIVE_COUNCIL, ROLES_LEGISLATOR_UPPER_BODY, ROLES_LEGISLATOR_LOWER_BODY, ROLES_HIGHEST_COURT_JUDGE, ROLES_JUDGE, ROLES_SCHOOLBOARD, ROLES_SPECIAL_PURPOSE_OFFICER, GOOGLE_CIVIC_API_KEY);

        call.enqueue(new Callback<RepResponse>() {

            @Override
            public void onResponse(Call<RepResponse> call, Response<RepResponse> response) {
                officialList = new ArrayList<Official>();
                officialList = response.body().getOfficials();
                setOfficePosition(response.body());

                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) officialList);
                OfficialsBottomFragment fragment = new OfficialsBottomFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_national, fragment).commit();
            }

            @Override
            public void onFailure(Call<RepResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());
            }
        });

    }

    private void connectToNationalOfficials() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepService.class);

        // https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=country&key={YOUR_API_KEY}

        Intent intent = getActivity().getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        String city = intent.getStringExtra(MainFragment.EXTRA_MESSAGE2);
        String state = intent.getStringExtra(MainFragment.EXTRA_MESSAGE3);
        String zipcode = intent.getStringExtra(MainFragment.EXTRA_MESSAGE4);

        Call<RepResponse> callNational = service.getNationalOfficials(address + city + state + zipcode, INCLUDE_OFFICES, LEVELS_NATIONAL, GOOGLE_CIVIC_API_KEY);

        callNational.enqueue(new Callback<RepResponse>() {
            @Override
            public void onResponse(Call<RepResponse> call, Response<RepResponse> response) {
                officialList = new ArrayList<Official>();
                officialList = response.body().getOfficials();
                setOfficePosition(response.body());

                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) officialList);
                OfficialsBottomFragment fragment = new OfficialsBottomFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_national, fragment).commit();
            }

            @Override
            public void onFailure(Call<RepResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());
            }
        });

    }


    private void connectToStateOfficials() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepService.class);

    //   https://www.googleapis.com/civicinfo/v2/representatives?address=91+boerum+st&includeOffices=true&levels=administrativeArea1&levels=administrativeArea2&key={YOUR_API_KEY}

        Intent intent = getActivity().getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        String city = intent.getStringExtra(MainFragment.EXTRA_MESSAGE2);
        String state = intent.getStringExtra(MainFragment.EXTRA_MESSAGE3);
        String zipcode = intent.getStringExtra(MainFragment.EXTRA_MESSAGE4);

        Call<RepResponse> callState = service.getStateOfficials(address + city + state + zipcode, INCLUDE_OFFICES, LEVELS_STATE_1, LEVELS_STATE_2, LEVELS_STATE_3, GOOGLE_CIVIC_API_KEY);

        callState.enqueue(new Callback<RepResponse>() {
            @Override
            public void onResponse(Call<RepResponse> call, Response<RepResponse> response) {
                officialList = new ArrayList<Official>();
                officialList = response.body().getOfficials();
                setOfficePosition(response.body());

                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) officialList);
                OfficialsBottomFragment fragment = new OfficialsBottomFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_national, fragment).commit();
            }

            @Override
            public void onFailure(Call<RepResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());
            }
        });
    }

    private void setOfficePosition(RepResponse response){
        int officialIndex = 0;
        List<Office> offices = response.getOffices();
        Log.d("OFFICES",offices.size()+"");
        for (Official official : response.getOfficials()) {
            for (int i = 0; i < offices.size(); i++) {
                if(offices.get(i).getOfficialIndices().contains(officialIndex))
                    official.setOffice(offices.get(i));
            }
            officialIndex++;
        }

    }
}

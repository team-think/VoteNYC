package com.example.android.bigappsvotenyc.NextElection;

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

import com.example.android.bigappsvotenyc.MainFragment;
import com.example.android.bigappsvotenyc.NextElection.model.Contest;
import com.example.android.bigappsvotenyc.NextElection.model.ElectionResponse;
import com.example.android.bigappsvotenyc.NextElection.service.NextElectionService;
import com.example.android.bigappsvotenyc.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.android.bigappsvotenyc.ElectedOfficials.service.RepService.API_KEY;

/**
 * Created by catwong on 4/6/17.
 */

public class NextElectionTopFragment extends Fragment {

    private static final String TAG = NextElectionTopFragment.class.getSimpleName();
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2";
    private static final int NY_VIP_ELECTION_ID = 2000;
    private static final boolean OFFICIAL_ONLY = false;
    private static final boolean RETURN_ALL_AVAILABLE_DATA = true;
    private static final String FIELDS_CONTESTS_ELECTIONS = "contests%2Celection";
    private List<Contest> contestList;
    private NextElectionService service;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ImageView official_national;
    private ImageView official_state;
    private ImageView official_city;
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
        mRoot = inflater.inflate(R.layout.fragment_next_election_top, parent, false);
        clickNationalElections();
        clickStateElections();
        clickCityElections();
        return mRoot;
    }

    private void clickNationalElections(){
        official_national = (ImageView) mRoot.findViewById(R.id.iv_national_election);
        official_national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void clickStateElections(){
        official_state = (ImageView) mRoot.findViewById(R.id.iv_state_election);
        official_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void clickCityElections(){
        official_city = (ImageView) mRoot.findViewById(R.id.iv_national_election);
        official_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void connectToServer(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(NextElectionService.class);

        Intent intent = getActivity().getIntent();
        String address = intent.getStringExtra(MainFragment.EXTRA_MESSAGE);
        String city = intent.getStringExtra(MainFragment.EXTRA_MESSAGE2);
        String state = intent.getStringExtra(MainFragment.EXTRA_MESSAGE3);
        String zipcode = intent.getStringExtra(MainFragment.EXTRA_MESSAGE4);


        // https://www.googleapis.com/civicinfo/v2/voterinfo?address=91+boerum+st&electionId=2000&officialOnly=false&returnAllAvailableData=true&fields=contests%2Celection&key=AIzaSyA1G4Wrf-G7pz3l-eXh6T6WPOoshE6aQQA

        Call<ElectionResponse> callAllElections = service.callAllElections(address + city + state + zipcode, NY_VIP_ELECTION_ID, OFFICIAL_ONLY, RETURN_ALL_AVAILABLE_DATA, FIELDS_CONTESTS_ELECTIONS, API_KEY);

        callAllElections.enqueue(new Callback<ElectionResponse>() {
            @Override
            public void onResponse(Call<ElectionResponse> call, Response<ElectionResponse> response) {
                contestList = new ArrayList<Contest>();
                contestList = response.body().getContests();

                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) contestList);
                NextElectionBottomFragment fragment = new NextElectionBottomFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_containter_next_election_bottom, fragment).commit();

            }

            @Override
            public void onFailure(Call<ElectionResponse> call, Throwable t) {
                Log.d(TAG, "RESPONSE ERROR: " + t.getMessage());
            }
        });

    }

}

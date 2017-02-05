package com.example.android.bigappsvotenyc.RecentBills;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.R;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;
import com.example.android.bigappsvotenyc.RecentBills.model.BillResponse;
import com.example.android.bigappsvotenyc.RecentBills.model.Result;
import com.example.android.bigappsvotenyc.RecentBills.service.RecentBillsService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by catwong on 2/2/17.
 */

public class BillsFragmentTop extends Fragment {

    private static final String BASE_URL = "https://api.propublica.org/congress/v1/";
    private static final String TAG = BillsFragmentTop.class.getSimpleName();
    private List<Result> resultList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private RecentBillsService service;
    private Button bt_house_of_reps;
    private Button bt_senate;
    private View mRoot;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_recent_bills, parent, false);
        clickHouseOfReps();
        clickSenate();
        return mRoot;
    }

    private void clickHouseOfReps() {
        bt_house_of_reps = (Button) mRoot.findViewById(R.id.bt_bills_house);
        bt_house_of_reps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToHouse();
            }
        });

    }

    private void clickSenate() {
        bt_senate = (Button) mRoot.findViewById(R.id.bt_bills_senate);
        bt_senate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectToSenate();
            }
        });

    }


    private void connectToHouse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RecentBillsService.class);

        Call<BillResponse> callHouse = service.getRecentHouseBills();

        callHouse.enqueue(new Callback<BillResponse>() {
            @Override
            public void onResponse(Call<BillResponse> call, Response<BillResponse> response) {
                resultList =  response.body().getResults();
                System.out.println("SIZE: " + resultList.get(0).getBills());
                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) resultList.get(0).getBills());
                BillsFragmentBottom fragmentBottom = new BillsFragmentBottom();
                fragmentBottom.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_recent_bills_bottom, fragmentBottom).commit();

            }

            @Override
            public void onFailure(Call<BillResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());

            }
        });


    }

    private void connectToSenate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RecentBillsService.class);

        Call<BillResponse> callSenate = service.getRecentSenateBills();

        callSenate.enqueue(new Callback<BillResponse>() {
            @Override
            public void onResponse(Call<BillResponse> call, Response<BillResponse> response) {
                resultList =  response.body().getResults();
                System.out.println("SIZE: " + resultList.get(0).getBills());
                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) resultList.get(0).getBills());
                BillsFragmentBottom fragmentBottom = new BillsFragmentBottom();
                fragmentBottom.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_recent_bills_bottom, fragmentBottom).commit();

            }

            @Override
            public void onFailure(Call<BillResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());

            }
        });


    }
}

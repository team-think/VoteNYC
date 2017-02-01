package com.example.android.bigappsvotenyc.ElectedOfficials;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.ElectedOfficials.controller.RepOfficialAdapter;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.Official;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.RepResponse;
import com.example.android.bigappsvotenyc.ElectedOfficials.service.RepService;
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

public class OfficialsFragment extends Fragment {

    private static final String TAG = ElectedOfficialsActivity.class.getSimpleName();
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    private RepService service;
    private List<Official> officialList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ImageView official_national;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
        connectToServer();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
       View mRoot = inflater.inflate(R.layout.fragment_officials, parent, false);
        return mRoot;
    }


    private void clickNationalOfficial(){
        official_national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    private void connectToServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepService.class);

        Call<RepResponse> call = service.getRepresentatives();

        call.enqueue(new Callback<RepResponse>() {

            @Override
            public void onResponse(Call<RepResponse> call, Response<RepResponse> response) {
                officialList = new ArrayList<Official>();
                officialList = response.body().getOfficials();
                fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("DATA", (ArrayList<? extends Parcelable>) officialList);
                OfficialsBottomFragment fragment = new OfficialsBottomFragment();
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container_national,fragment).commit();

            }

            @Override
            public void onFailure(Call<RepResponse> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());

            }
        });

    }
}

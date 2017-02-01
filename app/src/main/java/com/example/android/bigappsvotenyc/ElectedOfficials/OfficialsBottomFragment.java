package com.example.android.bigappsvotenyc.ElectedOfficials;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.ElectedOfficials.controller.RepOfficialAdapter;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.Official;
import com.example.android.bigappsvotenyc.ElectedOfficials.service.RepService;
import com.example.android.bigappsvotenyc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 1/31/17.
 */

public class OfficialsBottomFragment extends Fragment {

    private static final String TAG = ElectedOfficialsActivity.class.getSimpleName();
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    private RecyclerView recyclerView;
    private RepOfficialAdapter officialAdapter;
    private RepService service;
    private List<Official> officialList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            officialList = bundle.getParcelableArrayList("DATA");
        } else {
            officialList = new ArrayList<>();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_officials_national, parent, false);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_officials_national);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        officialAdapter = new RepOfficialAdapter();
        officialAdapter.setData(officialList);
        recyclerView.setAdapter(officialAdapter);
    }
}

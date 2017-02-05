package com.example.android.bigappsvotenyc.RecentBills;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.R;
import com.example.android.bigappsvotenyc.RecentBills.controller.BillAdapter;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;
import com.example.android.bigappsvotenyc.RecentBills.model.Result;
import com.example.android.bigappsvotenyc.RecentBills.service.RecentBillsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 2/4/17.
 */

public class BillsFragmentBottom extends Fragment{

    private RecyclerView recyclerView;
    private BillAdapter billAdapter;
    private RecentBillsService service;
    private List<Bill> billList;
    private View mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            billList = bundle.getParcelableArrayList("DATA");
            System.out.println("dfdsdsfsd" + billList.size());
        } else {
            billList = new ArrayList<>();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_recent_bills_bottom, parent, false);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.rv_recent_bills);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        billAdapter = new BillAdapter();
        billAdapter.setData(billList);
        recyclerView.setAdapter(billAdapter);
    }
}

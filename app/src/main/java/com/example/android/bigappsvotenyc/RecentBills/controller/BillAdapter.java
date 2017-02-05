package com.example.android.bigappsvotenyc.RecentBills.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.R;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;
import com.example.android.bigappsvotenyc.RecentBills.model.Result;
import com.example.android.bigappsvotenyc.RecentBills.view.BillViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 2/2/17.
 */

public class BillAdapter extends RecyclerView.Adapter<BillViewHolder> {

    List<Bill> billsList = new ArrayList<>();

    public BillAdapter() {
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.bills_holder, parent, false);
        return new BillViewHolder(rowView);


    }

    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        holder.bind(billsList.get(position));

    }

    @Override
    public int getItemCount() {
        return billsList.size();
    }

    public void setData(List<Bill> data){
        this.billsList = data;
    }
}

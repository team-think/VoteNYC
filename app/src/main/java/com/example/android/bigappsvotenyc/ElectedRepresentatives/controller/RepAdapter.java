package com.example.android.bigappsvotenyc.ElectedRepresentatives.controller;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.Office;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.Official;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.RepResponse;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.view.RepViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 1/29/17.
 */

public class RepAdapter extends RecyclerView.Adapter<RepViewHolder>{

    private final List<Official> officialList;
//    private final List<Office> officeList;


//    public RepAdapter(RepResponse data) {
//        this.officialList = data.getOfficials();
////        this.officeList = data.getOffices();
//    }

    public RepAdapter(List<Official> officialList) {
        this.officialList = officialList;
    }

    @Override
    public RepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepViewHolder(parent);

    }

    @Override
    public void onBindViewHolder(RepViewHolder holder, int position) {
        holder.bind(officialList.get(position));
//        holder.bind(officeList.get(position));
    }

    @Override
    public int getItemCount() {
        return officialList.size();
//        return officeList.size();
    }
}

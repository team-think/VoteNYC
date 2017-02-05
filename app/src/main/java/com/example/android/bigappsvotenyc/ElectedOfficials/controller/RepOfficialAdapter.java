package com.example.android.bigappsvotenyc.ElectedOfficials.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.ElectedOfficials.model.Official;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.RepResponse;
import com.example.android.bigappsvotenyc.ElectedOfficials.view.RepViewHolder;
import com.example.android.bigappsvotenyc.R;

import java.util.List;

/**
 * Created by catwong on 1/29/17.
 */

public class RepOfficialAdapter extends RecyclerView.Adapter<RepViewHolder> {

    private List<Official> officialList;

    public RepOfficialAdapter(){

    }

    public RepOfficialAdapter(RepResponse data) {
        this.officialList = data.getOfficials();
    }


    @Override
    public RepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.reps_holder, parent, false);
        return new RepViewHolder(rowView);

    }

    @Override
    public void onBindViewHolder(RepViewHolder holder, int position) {
        holder.bind(officialList.get(position));
    }

    @Override
    public int getItemCount() {
        return officialList.size();
    }

    public void setData(List<Official> data){
        this.officialList = data;
    }
}

package com.example.android.bigappsvotenyc.NextElection.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.NextElection.model.Contest;
import com.example.android.bigappsvotenyc.NextElection.model.ElectionResponse;
import com.example.android.bigappsvotenyc.NextElection.view.NextElectionViewHolder;
import com.example.android.bigappsvotenyc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 4/6/17.
 */

public class NextElectionAdapter extends RecyclerView.Adapter<NextElectionViewHolder> {

    List<Contest> contestList = new ArrayList<>();

    public NextElectionAdapter() {

    }

    public NextElectionAdapter(ElectionResponse data) {
        this.contestList = data.getContests();
    }

    @Override
    public NextElectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.reps_holder, parent, false);
        return new NextElectionViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(NextElectionViewHolder holder, int position) {
        holder.bind(contestList.get(position));

    }

    @Override
    public int getItemCount() {
        return contestList.size();
    }
}


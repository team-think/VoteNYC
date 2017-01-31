package com.example.android.bigappsvotenyc.PollingLocations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.PollingLocations.Model.Election;
import com.example.android.bigappsvotenyc.PollingLocations.Model.PollingLocation;
import com.example.android.bigappsvotenyc.PollingLocations.Model.VoterInfo;
import com.example.android.bigappsvotenyc.R;

import java.util.List;

/**
 * Created by mathcore on 1/30/17.
 */

public class PollAdapter extends RecyclerView.Adapter<PollViewHolder> {

    private Election election;
    private List<PollingLocation> pollLists;

    public PollAdapter(VoterInfo voterData) {
        this.pollLists = voterData.getPollingLocations();
//        this.election = voterData.getElection();
    }

    @Override
    public PollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.poll_holder, parent, false);
        return new PollViewHolder(view);


    }

    @Override
    public void onBindViewHolder(PollViewHolder holder, int position) {
        holder.bind(pollLists.get(position));
//        holder.bind(election);
    }

    @Override
    public int getItemCount() {
        return pollLists.size();
    }
}

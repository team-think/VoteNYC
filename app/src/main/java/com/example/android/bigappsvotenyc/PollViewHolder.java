package com.example.android.bigappsvotenyc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.Model.Election;
import com.example.android.bigappsvotenyc.Model.PollingLocation;

/**
 * Created by mathcore on 1/30/17.
 */

public class PollViewHolder extends RecyclerView.ViewHolder {

    private TextView electionDay;
    private TextView pollName;
    private TextView pollAddressLine1;
    private TextView pollCity;
    private TextView pollState;
    private TextView pollZipCode;
    private TextView pollNotes;
    private TextView pollHours;



    public PollViewHolder(View itemView) {
        super(itemView);

        electionDay = (TextView) itemView.findViewById(R.id.tv_election_day);
        pollName = (TextView) itemView.findViewById(R.id.tv_poll_name);
        pollAddressLine1 = (TextView) itemView.findViewById(R.id.tv_poll_address_line1);
        pollCity = (TextView) itemView.findViewById(R.id.tv_poll_address_city);
        pollState = (TextView) itemView.findViewById(R.id.tv_poll_address_state);
        pollZipCode = (TextView) itemView.findViewById(R.id.tv_poll_address_zip);
        pollNotes = (TextView) itemView.findViewById(R.id.tv_poll_notes);
        pollHours = (TextView) itemView.findViewById(R.id.tv_poll_hours);

    }

    public void bind(PollingLocation pollingLocation) {

        pollName.setText("Name: " + pollingLocation.getAddress().getLocationName());
        pollAddressLine1.setText("Address: " + pollingLocation.getAddress().getLine1());
        pollCity.setText("City: " + pollingLocation.getAddress().getCity());
        pollState.setText("State: " + pollingLocation.getAddress().getState());
        pollZipCode.setText("ZIP: " + pollingLocation.getAddress().getZip());
        pollNotes.setText("Notes:" + pollingLocation.getNotes());
        pollHours.setText("Hours: " + pollingLocation.getPollingHours());






    }

    public void bind(Election election){

        electionDay.setText("Next Election: " + election.getElectionDay());
    }
}
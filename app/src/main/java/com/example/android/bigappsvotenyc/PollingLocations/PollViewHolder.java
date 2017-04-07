package com.example.android.bigappsvotenyc.PollingLocations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.PollingLocations.Model.Election;
import com.example.android.bigappsvotenyc.PollingLocations.Model.PollingLocation;
import com.example.android.bigappsvotenyc.R;

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
    private String addressLine1;
    private String addressCity;
    private String addressState;
    private String addressZipCode;
    private String addressTotal;


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
        pollName.setText(pollingLocation.getAddress().getLocationName());
        pollAddressLine1.setText(pollingLocation.getAddress().getLine1());
        pollCity.setText(pollingLocation.getAddress().getCity());
        pollState.setText(pollingLocation.getAddress().getState());
        pollZipCode.setText(pollingLocation.getAddress().getZip());
        pollNotes.setText("Notes: " + pollingLocation.getNotes());
        pollHours.setText("Hours: " + pollingLocation.getPollingHours());

    }

    public void bind(Election election) {
        electionDay.setText("Next Election: " + election.getElectionDay());
    }

    public String physicalAddress(PollingLocation pollingLocation){
        addressLine1 = pollingLocation.getAddress().getLine1();
        addressCity = pollingLocation.getAddress().getCity();
        addressState = pollingLocation.getAddress().getState();
        addressZipCode = pollingLocation.getAddress().getZip();
        addressTotal = addressLine1 + " " + addressCity + " " + addressState + " " + addressZipCode;
        return addressTotal;
    }
}

package com.example.android.bigappsvotenyc.NextElection.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.NextElection.model.Contest;
import com.example.android.bigappsvotenyc.R;

/**
 * Created by catwong on 4/6/17.
 */

public class NextElectionViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_election_type;
    private TextView tv_election_level;
    private TextView tv_election_district_name;
    private TextView tv_election_scope;
    private TextView tv_election_position;
    private TextView tv_candidate_name;
    private TextView tv_candidate_party;
    private TextView tv_candidate_phone;
    private TextView tv_candidate_email;
    private TextView tv_candidate_url;
    private TextView tv_candidate_channel1_type;
    private TextView tv_candidate_channel1_id;
    private TextView tv_candidate_channel2_type;
    private TextView tv_candidate_channel2_id;
    private TextView tv_candidate_channel3_type;
    private TextView tv_candidate_channel3_id;


    public NextElectionViewHolder(View itemView) {
        super(itemView);
        tv_election_type = (TextView) itemView.findViewById(R.id.tv_election_type);
        tv_election_level = (TextView) itemView.findViewById(R.id.tv_election_level);
        tv_election_district_name = (TextView) itemView.findViewById(R.id.tv_election_district);
        tv_election_scope = (TextView) itemView.findViewById(R.id.tv_election_scope);
        tv_election_position = (TextView) itemView.findViewById(R.id.tv_election_position);
        tv_candidate_name = (TextView) itemView.findViewById(R.id.tv_candidate_name);

    }

    public void bind(Contest contest) {
        tv_election_type.setText(contest.getType());
        tv_election_level.setText(contest.getLevel().get(0));
        tv_election_district_name.setText(contest.getDistrict().getName());
        tv_election_scope.setText(contest.getDistrict().getScope());

    }
}

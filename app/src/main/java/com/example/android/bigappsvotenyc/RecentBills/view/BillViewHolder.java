package com.example.android.bigappsvotenyc.RecentBills.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.R;
import com.example.android.bigappsvotenyc.RecentBills.model.Bill;

/**
 * Created by catwong on 2/2/17.
 */

public class BillViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_bill_number;
    private TextView tv_bill_uri;
    private TextView tv_bill_title;
    private TextView tv_bill_sponsors_url;
    private TextView tv_bill_introduced_date;
    private TextView tv_bill_cosponsors;
    private TextView tv_bill_committees;
    private TextView tv_bill_primary_subject;
    private TextView tv_bill_latest_major_action_date;
    private TextView tv_bill_latest_major_action_action;


    public BillViewHolder(View itemView) {
        super(itemView);

        tv_bill_number = (TextView) itemView.findViewById(R.id.tv_bill_number);
//        tv_bill_uri = (TextView) itemView.findViewById(R.id.tv_bill_uri);
        tv_bill_title = (TextView) itemView.findViewById(R.id.tv_bill_title);
//        tv_bill_sponsors_url = (TextView) itemView.findViewById(R.id.tv_bill_sponsors_url);
        tv_bill_introduced_date = (TextView) itemView.findViewById(R.id.tv_bill_introduced_date);
        tv_bill_cosponsors = (TextView) itemView.findViewById(R.id.tv_bill_cosponsors);
        tv_bill_committees = (TextView) itemView.findViewById(R.id.tv_bill_committees);
        tv_bill_latest_major_action_date = (TextView) itemView.findViewById(R.id.tv_bill_latest_major_action_date);
        tv_bill_latest_major_action_action = (TextView) itemView.findViewById(R.id.tv_bill_latest_major_action);
    }

    public void bind(Bill bill) {
        tv_bill_number.setText("Bill " + bill.getNumber());
//            tv_bill_uri.setText(bill.getBill_uri());
        tv_bill_title.setText(bill.getTitle());
//            tv_bill_sponsors_url.setText(bill.getSponsor_uri());
        tv_bill_introduced_date.setText("Introduced Date: " + bill.getIntroduced_date());
        tv_bill_cosponsors.setText("Cosponsors: " + bill.getCosponsors());
        tv_bill_committees.setText("Committees: " + bill.getCommittees());
        tv_bill_latest_major_action_date.setText("Latest Major Action Date: " + bill.getLatest_major_action_date());
        tv_bill_latest_major_action_action.setText("Latest Major Action: " + bill.getLatest_major_action());


    }
}

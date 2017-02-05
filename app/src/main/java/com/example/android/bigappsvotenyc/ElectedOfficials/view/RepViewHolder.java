package com.example.android.bigappsvotenyc.ElectedOfficials.view;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.ElectedOfficials.model.Office;
import com.example.android.bigappsvotenyc.ElectedOfficials.model.Official;
import com.example.android.bigappsvotenyc.R;

/**
 * Created by catwong on 1/29/17.
 */

public class RepViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_repName;
    private TextView tv_party;
    private TextView tv_address_line1;
    private TextView tv_address_line2;
    private TextView tv_address_city;
    private TextView tv_address_state;
    private TextView tv_address_zip;
    private TextView tv_phone;
    private TextView tv_email;
    private TextView tv_website;
    private TextView tv_channel1_type;
    private TextView tv_channel1_id;
    private TextView tv_channel2_type;
    private TextView tv_channel2_id;
    private TextView tv_channel3_type;
    private TextView tv_channel3_id;
    private TextView tv_officePosition;
    private Resources resources;


    public RepViewHolder(View itemView) {
        super(itemView);
        resources = itemView.getResources();

        tv_repName = (TextView) itemView.findViewById(R.id.tv_rep_name);
        tv_officePosition = (TextView) itemView.findViewById(R.id.tv_office_position);
        tv_party = (TextView) itemView.findViewById(R.id.tv_rep_party);
        tv_address_line1 = (TextView) itemView.findViewById(R.id.tv_rep_address_line1);
        tv_address_line2 = (TextView) itemView.findViewById(R.id.tv_rep_address_line2);
        tv_address_city = (TextView) itemView.findViewById(R.id.tv_rep_address_city);
        tv_address_state = (TextView) itemView.findViewById(R.id.tv_rep_address_state);
        tv_address_zip = (TextView) itemView.findViewById(R.id.tv_rep_address_zip);
        tv_phone = (TextView) itemView.findViewById(R.id.tv_rep_phones);
        tv_email = (TextView) itemView.findViewById(R.id.tv_email);
        tv_website = (TextView) itemView.findViewById(R.id.tv_rep_urls);
        tv_channel1_type = (TextView) itemView.findViewById(R.id.tv_rep_channel1_type);
        tv_channel1_id = (TextView) itemView.findViewById(R.id.tv_rep_channel1_id);
        tv_channel2_type = (TextView) itemView.findViewById(R.id.tv_rep_channel2_type);
        tv_channel2_id = (TextView) itemView.findViewById(R.id.tv_rep_channel2_id);
        tv_channel3_type = (TextView) itemView.findViewById(R.id.tv_rep_channel3_type);
        tv_channel3_id = (TextView) itemView.findViewById(R.id.tv_rep_channel3_id);
    }

    public void bind(Official official) {
        tv_officePosition.setText(official.getOffice().getName());
        tv_repName.setText(official.getName());

        if(official.getParty().equalsIgnoreCase("Republican")) {
            tv_party.setText(official.getParty());
            tv_party.setTextColor(Color.rgb(233,29,14));
        } else if(official.getParty().equalsIgnoreCase("Democratic")) {
            tv_party.setText(official.getParty());
            tv_party.setTextColor(Color.BLUE);
        } else {
            tv_party.setText(official.getParty());

        }

        tv_address_line1.setText(official.getAddress().get(0).getLine1());
        Linkify.addLinks(tv_address_line1, Linkify.MAP_ADDRESSES);


        if (official.getAddress().get(0).getLine2() == null) {
            tv_address_line2.setVisibility(View.GONE);

        } else {
            tv_address_line2.setText(official.getAddress().get(0).getLine2());
            Linkify.addLinks(tv_address_line2, Linkify.ALL);

        }

        tv_address_city.setText(official.getAddress().get(0).getCity());
        Linkify.addLinks(tv_address_city, Linkify.MAP_ADDRESSES);
        tv_address_state.setText(official.getAddress().get(0).getState());
        Linkify.addLinks(tv_address_state, Linkify.MAP_ADDRESSES);
        tv_address_zip.setText(official.getAddress().get(0).getZip());
        Linkify.addLinks(tv_address_zip, Linkify.MAP_ADDRESSES);


        if (official.getPhones() == null) {
            tv_phone.setVisibility(View.GONE);
        } else {
            tv_phone.setText("Phone: " + official.getPhones().get(0));
            Linkify.addLinks(tv_phone, Linkify.PHONE_NUMBERS);
        }

        if (official.getEmails() == null) {
            tv_email.setVisibility(View.GONE);
        } else {
            tv_email.setText("Email: " + official.getEmails().get(0));
            Linkify.addLinks(tv_email, Linkify.EMAIL_ADDRESSES);
        }

        if (official.getUrls() == null) {
            tv_website.setVisibility(View.GONE);
        } else {
            tv_website.setText("Website: " + official.getUrls().get(0));
            Linkify.addLinks(tv_website, Linkify.WEB_URLS);
        }


        if (official.getChannels() == null) {
            tv_channel1_type.setVisibility(View.GONE);
            tv_channel1_id.setVisibility(View.GONE);
            tv_channel2_type.setVisibility(View.GONE);
            tv_channel2_id.setVisibility(View.GONE);
            tv_channel3_type.setVisibility(View.GONE);
            tv_channel3_id.setVisibility(View.GONE);
        } else if (official.getChannels().size() == 2) {
            tv_channel1_type.setText(official.getChannels().get(0).getType());
            tv_channel1_id.setText("Id: " + official.getChannels().get(0).getId());
            tv_channel2_type.setText(official.getChannels().get(1).getType());
            tv_channel2_id.setText("Id: " + official.getChannels().get(1).getId());
        } else if (official.getChannels().size() == 1) {
            tv_channel1_type.setText(official.getChannels().get(0).getType());
            tv_channel1_id.setText("Id: " + official.getChannels().get(0).getId());
        } else if (official.getChannels().size() == 3) {
            tv_channel1_type.setText(official.getChannels().get(0).getType());
            tv_channel1_id.setText("Id: " + official.getChannels().get(0).getId());
            tv_channel2_type.setText(official.getChannels().get(1).getType());
            tv_channel2_id.setText("Id: " + official.getChannels().get(1).getId());
            tv_channel3_type.setText(official.getChannels().get(2).getType());
            tv_channel3_id.setText("Id: " + official.getChannels().get(2).getId());
        }

    }


}

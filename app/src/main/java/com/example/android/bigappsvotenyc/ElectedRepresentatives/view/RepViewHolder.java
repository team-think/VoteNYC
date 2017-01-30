package com.example.android.bigappsvotenyc.ElectedRepresentatives.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.Office;
import com.example.android.bigappsvotenyc.ElectedRepresentatives.model.Official;
import com.example.android.bigappsvotenyc.R;

import java.util.List;

/**
 * Created by catwong on 1/29/17.
 */

public class RepViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_repName;
    private TextView tv_party;
    private TextView tv_address;
    private TextView tv_phone;
    private TextView tv_officePosition;


    public RepViewHolder(View itemView) {
        super(itemView);

        tv_repName = (TextView) itemView.findViewById(R.id.tv_rep_name);
        tv_party = (TextView) itemView.findViewById(R.id.tv_rep_party);
//        tv_address = (TextView) itemView.findViewById(R.id.tv_rep_address);
//        tv_phone = (TextView) itemView.findViewById(R.id.tv_rep_phones);
//        tv_officePosition = (TextView) itemView.findViewById(R.id.tv_office_position);
    }


    public void bind(Official official) {
        tv_repName.setText("Representative: " + official.getName());
        tv_party.setText("Polical Party: " + official.getParty());

    }

    public void bind(Office office) {
        tv_officePosition.setText("Position: " + office.getName());
    }
}

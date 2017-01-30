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


    public RepViewHolder(View itemView) {
        super(itemView);

        tv_repName = (TextView) itemView.findViewById(R.id.tv_rep_name);
        tv_party = (TextView) itemView.findViewById(R.id.tv_rep_party);
    }


    public void bind(Official official) {
        tv_repName.setText(official.getName());
        tv_party.setText(official.getParty());

    }
}

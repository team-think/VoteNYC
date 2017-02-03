package com.example.android.bigappsvotenyc.RecentBills;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.bigappsvotenyc.R;

/**
 * Created by catwong on 2/2/17.
 */

public class RecentBillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_recent_bills, new BillsFragment())
                    .commit();
        }
    }


}

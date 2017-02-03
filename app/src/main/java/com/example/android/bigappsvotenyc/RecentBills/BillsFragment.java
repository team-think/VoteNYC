package com.example.android.bigappsvotenyc.RecentBills;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.bigappsvotenyc.R;

/**
 * Created by catwong on 2/2/17.
 */

public class BillsFragment extends Fragment {

    private View mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_recent_bills, parent, false);
        return mRoot;
    }

}

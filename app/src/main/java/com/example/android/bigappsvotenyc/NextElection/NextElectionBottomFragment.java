package com.example.android.bigappsvotenyc.NextElection;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bigappsvotenyc.NextElection.controller.NextElectionAdapter;
import com.example.android.bigappsvotenyc.NextElection.model.Contest;
import com.example.android.bigappsvotenyc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catwong on 4/6/17.
 */

public class NextElectionBottomFragment extends Fragment {

    private RecyclerView recyclerView;
    private NextElectionAdapter adapter;
    private List<Contest> contestList;
    private View mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            contestList = bundle.getParcelableArrayList("DATA");
        } else {
            contestList = new ArrayList<>();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_next_election_bottom, parent, false);
        return mRoot;
    }
}

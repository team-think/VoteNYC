package com.example.android.bigappsvotenyc.NextElection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.bigappsvotenyc.R;

public class NextElectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_election);

        if (savedInstanceState != null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_containter_next_election_top, new NextElectionTopFragment(), "fragment_election_top")
                    .add(R.id.fragment_containter_next_election_bottom, new NextElectionBottomFragment(), "fragment_election_bottom")
                    .commit();
        }
    }
}

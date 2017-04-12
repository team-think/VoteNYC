package com.example.android.bigappsvotenyc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.android.bigappsvotenyc.ElectedOfficials.OfficialsFragment;
import com.example.android.bigappsvotenyc.NextElection.NextElectionTopFragment;
import com.example.android.bigappsvotenyc.PollingLocations.PollFragment;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.android.bigappsvotenyc;";
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE2 = "com.example.android.bigappsvotenyc";
    public static final String EXTRA_MESSAGE3 = "com.example.android.bigappsvotenyc";
    public static final String EXTRA_MESSAGE4 = "com.example.android.bigappsvotenyc";
    public EditText etAddress;
    public EditText etCity;
    public EditText etState;
    public EditText etZipCode;
    private View mRoot;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        setBottomNavButtons();

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new MainFragment())
                    .commit();
        }

    }

    private void setBottomNavButtons() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        setHomeFragment();
                        break;
                    case R.id.action_poll:
                        setPollFragment();
                        break;
                    case R.id.action_officials:
                        setOfficialsFragment();
                        break;
                    case R.id.action_elections:
                        setElectionsFragment();
                        break;
                }
                return true;
            }

        });
    }

    private void setHomeFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new MainFragment())
                .addToBackStack(null)
                .commit();

    }

    private void setElectionsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new NextElectionTopFragment())
                .addToBackStack(null)
                .commit();
    }

    private void setOfficialsFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new OfficialsFragment())
                .addToBackStack(null)
                .commit();
    }


    private void setPollFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new PollFragment())
                .addToBackStack(null)
                .commit();
    }
}
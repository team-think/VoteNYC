package com.example.android.bigappsvotenyc.ElectedOfficials;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.android.bigappsvotenyc.R;

/**
 * Created by catwong on 1/29/17.
 */

public class ElectedOfficialsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officials);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_officals, new OfficialsTopFragment(), "fragment_officials_top")
                    .add(R.id.fragment_container_national, new OfficialsBottomFragment(), "fragment_officials_bottom")
                    .commit();
        }

    }

}

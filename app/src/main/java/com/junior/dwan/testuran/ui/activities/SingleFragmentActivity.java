package com.junior.dwan.testuran.ui.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.junior.dwan.testuran.R;
import com.junior.dwan.testuran.ui.fragments.MainFragment;

/**
 * Created by Might on 28.12.2016.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract MainFragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
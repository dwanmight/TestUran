package com.junior.dwan.testuran.ui.activities;


import com.junior.dwan.testuran.ui.fragments.MainFragment;
import com.junior.dwan.testuran.utils.DBHelper;

public class MainActivity extends SingleFragmentActivity {
    DBHelper mDBHelper;

    @Override
    protected MainFragment createFragment() {
        return new MainFragment();

    }
}

package com.altoros.study.BiDirectionScrolling;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_container, new ScrollFragment(), "ScrollFragment").commit();
    }
}

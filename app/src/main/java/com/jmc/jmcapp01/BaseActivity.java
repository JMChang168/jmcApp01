package com.jmc.jmcapp01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
    }
}

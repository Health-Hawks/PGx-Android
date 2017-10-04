package com.timbuchalka.pg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GetStartedActivity extends AppCompatActivity {
    private static final String TAG = "GetStartedActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate==========================================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }
}

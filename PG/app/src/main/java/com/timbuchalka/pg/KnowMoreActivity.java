package com.timbuchalka.pg;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class KnowMoreActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "KnowMoreActivity";

    public ConstraintLayout knowMore, knowMore1, knowMore2, knowMore3;
    public View currentLayout;
    public TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_more);
        mTextView = (TextView) findViewById(R.id.know_more_1);
        mTextView.setText(R.string.know_more_intro);

        knowMore = (ConstraintLayout) findViewById(R.id.know_more);
        knowMore1 = (ConstraintLayout) findViewById(R.id.know_more_first);
        knowMore2 = (ConstraintLayout) findViewById(R.id.know_more_second);
        knowMore3 = (ConstraintLayout) findViewById(R.id.know_more_third);

//        knowMore.setOnClickListener(mOnClickListener);
//        knowMore2.setOnClickListener(mOnClickListener);
//        knowMore3.setOnClickListener(mOnClickListener);


        currentLayout = findViewById(R.id.know_more);

        Log.d(TAG, "root view is " + currentLayout.getId() + " and " + R.id.know_more);
        currentLayout.setOnClickListener(mOnClickListener);

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch(currentLayout.getId()) {
                case R.id.know_more:
                    setContentView(R.layout.know_more_first);
                    mTextView = (TextView) findViewById(R.id.know_more_1);
                    mTextView.setText(R.string.know_more_1);
                    currentLayout = findViewById(R.id.know_more_first);
                    currentLayout.setOnClickListener(mOnClickListener);
                    break;
                case R.id.know_more_first:
                    setContentView(R.layout.know_more_second);
                    currentLayout = findViewById(R.id.know_more_second);
                    currentLayout.setOnClickListener(mOnClickListener);
                    break;
                case R.id.know_more_second:
                    setContentView(R.layout.know_more_third);
                    mTextView = (TextView) findViewById(R.id.know_more_1);
                    mTextView.setText(com.timbuchalka.pg.R.string.know_more_third);
                    currentLayout = findViewById(R.id.know_more_third);
                    currentLayout.setOnClickListener(mOnClickListener);
                    break;
                case R.id.know_more_third:
                    startActivity(new Intent(KnowMoreActivity.this, MainActivity.class));
                    currentLayout = findViewById(R.id.activity_main);
                    break;
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);


    }

    @Override
    public void onClick(View v) {

    }
}

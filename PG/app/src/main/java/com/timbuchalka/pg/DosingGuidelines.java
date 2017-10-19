package com.timbuchalka.pg;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DosingGuidelines extends AppCompatActivity implements SpinnerAdapter{
    private static final String TAG = "DosingGuidelines";

    private Spinner alleleSpinner1, alleleSpinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosing_guidelines);

        alleleSpinner1 = (Spinner) findViewById(R.id.allele_spinner1);
        ArrayAdapter<CharSequence> allele1Adapter = ArrayAdapter.createFromResource(this,
                R.array.allele1_array, android.R.layout.simple_spinner_item);
        allele1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alleleSpinner1.setAdapter(allele1Adapter);

        alleleSpinner2 = (Spinner) findViewById(R.id.allele_spinner2);
        ArrayAdapter<CharSequence> allele2Adapter = ArrayAdapter.createFromResource(this,
                R.array.allele2_array, android.R.layout.simple_spinner_item);
        allele2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alleleSpinner2.setAdapter(allele2Adapter);

        String gene = getIntent().getStringExtra("gene");
        String drug = getIntent().getStringExtra("drug");

        TextView textView = (TextView) findViewById(R.id.dosing_guideline_tv);

        Log.d(TAG, "onCreate: s = " + gene);
        textView.setText("Dosing Guidelines for " + gene + " and " + drug);

    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

package com.timbuchalka.pg;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class GetStartedActivity extends AppCompatActivity implements SpinnerAdapter, AdapterView.OnItemSelectedListener{
    private static final String TAG = "GetStartedActivity";

    private Spinner geneSpinner, drugSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate==========================================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        geneSpinner = (Spinner) findViewById(R.id.gene_spinner);
        drugSpinner = (Spinner) findViewById(R.id.drug_spinner);

        ArrayAdapter<CharSequence> geneAdapter = ArrayAdapter.createFromResource(this,
                R.array.gene_array, android.R.layout.simple_spinner_item);
        geneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        geneSpinner.setAdapter(geneAdapter);
        geneSpinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> drugAdapter = ArrayAdapter.createFromResource(this,
                R.array.drugs_array, android.R.layout.simple_spinner_item);
        drugAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drugSpinner.setAdapter(drugAdapter);
        drugSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(!geneSpinner.getSelectedItem().toString().equals("Select gene") && !drugSpinner.getSelectedItem().toString().equals("Select drug") ) {
            Intent intent = new Intent(GetStartedActivity.this, DosingGuidelines.class);
            intent.putExtra("drug", drugSpinner.getSelectedItem().toString());
            intent.putExtra("gene", geneSpinner.getSelectedItem().toString());
            startActivity(intent);

        }

//        Intent intent = new Intent(GetStartedActivity.this, DosingGuidelines.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("drug", drugSpinner.getSelectedItem().toString());
//        bundle.putString("gene", geneSpinner.getSelectedItem().toString());
//
//        intent.putExtras(bundle);
//        startActivity(intent);








//        if(geneSpinner.getItemAtPosition(position).toString() == "TPMT (Thiopurine methyltransferase)" && drugSpinner.getItemAtPosition(position).toString() == "Azasan") {
//            startActivity(new Intent(GetStartedActivity.this, DosingGuidelines.class));
//        }



//        if(parent.getItemAtPosition(position).toString() == "TPMT (Thiopurine methyltransferase)") {
//            switch(parent.getItemAtPosition(position).toString()) {//parent still refers to TPMT
//                case "Azasan":
//                    startActivity(new Intent(this, DosingGuidelines.class));
//                    Toast.makeText(parent.getContext(),
//                            "Selecting Item : " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//                    break;
//
//            }
//        } else {
//            switch(parent.getItemAtPosition(position).toString()) {
//                case "":
//                    break;
//            }
//
//
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

package com.timbuchalka.pg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AlleleActivity extends AppCompatActivity {
    public String poorMet;
    public String normMet;
    public String intMet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allele);
        poorMet = (String) getString(R.string.poor_met);
        normMet = (String) getString(R.string.normal_met);
        intMet = (String) getString(R.string.int_met);

        String gene = getIntent().getStringExtra("gene");
        String drug = getIntent().getStringExtra("drug");
        String allele1 = getIntent().getStringExtra("allele1");
        String allele2 = getIntent().getStringExtra("allele2");
        String alleles = allele1 + " " + allele2;
        Toast.makeText(this, alleles, Toast.LENGTH_SHORT).show();

        TextView header = (TextView) findViewById(R.id.heading_tv);
        TextView metabolizer = (TextView) findViewById(R.id.metabolizer_tv);
        TextView recommendations = (TextView) findViewById(R.id.recs_txt_tv);
        header.setText(gene + " and " + drug + " with the alleles " + allele1 + " and " + allele2 + ":");

        switch(gene) {
            case "TPMT (Thiopurine methyltransferase)":
                switch(drug) {
                    case "Mercaptopurine":
                    case "6MP":
                    case "Purinethol":
                    case "Purixan":
                    case "6Mercaptopurine":
                        switch (alleles) {
                            case "*1 *1":
                            case "*1 *1S":
                            case "*1S *1S":
                                metabolizer.setText(normMet);
                                recommendations.setText("Start with normal starting dose:\n" +
                                        "Adult: 2.5 mg/kg daily   (include drug calculator option with each dose)\n" +
                                        "Pediatric: 1.25-2.5 mg/kg (50-70 mg/m2) daily\n" +
                                        "Allow 2 weeks to reach steady state after each dose adjustment.\n");
                                break;
                            case "*1 *2":
                            case "*1 *3A":
                            case "*1 *3B":
                            case "*1 *3C":
                            case "*1 *4":
                            case "*1S *2":
                            case "*1S *3A":
                            case "*1S *3B":
                            case "*1S *3C":
                            case "*1S *4":
                                metabolizer.setText(intMet);
                                recommendations.setText("Start with 30-70% reduction from normal starting dose:\n" +
                                        "Adult: 0.75-1.75 mg/kg daily  (include drug calculator option with each dose)\n" +
                                        "Pediatric: 0.375-1.75 mg/kg (15-49 mg/m2) daily\n" +
                                        "Allow 2-4 weeks to reach steady state after each dose adjustment. \n" +
                                        "In those who require a dosage reduction based on myelosuppression, the median dose may be ~40% lower \n");
                                break;
                            case "*2 *2":
                            case "*2 *3A":
                            case "*2 *3B":
                            case "*2 *3C":
                            case "*2 *4":
                                metabolizer.setText(poorMet);
                                recommendations.setText("For malignancy, reduce daily dose by 10-fold from normal starting dose and reduce frequency to thrice weekly instead of daily:\n" +
                                        "Adult: 0.25 mg/kg Three Times Weekly (include drug calculator option with each dose)\n" +
                                        "Pediatric: 0.125-0.25 mg/kg (5-7 mg/m2) Three Times Weekly\n" +
                                        "Allow 4-6 weeks to reach steady state after each dose adjustment. \n" +
                                        "For nonmalignant conditions, consider alternative nonthiopurine immunosuppressant therapy.\n");
                                break;
                        }
                    case "Thioguanine":
                    case "6TG":
                    case "6Thioguanine":
                    case "Tabloid":
                        switch (alleles) {
                            case "*1 *1":
                            case "*1 *1S":
                            case "*1S *1S":
                                metabolizer.setText(normMet);
                                recommendations.setText("Start with normal starting dose:\n" +
                                        "Adult and Pediatric: 2 mg/kg/day  (include dosage calculator)\n" +
                                        "Allow 2-4 weeks to reach steady state after each dose adjustment.\n" +
                                        "May cautiously increase to 3 mg/kg/day if no response after 4 weeks\n");
                                break;
                            case "*1 *2":
                            case "*1 *3A":
                            case "*1 *3B":
                            case "*1 *3C":
                            case "*1 *4":
                            case "*1S *2":
                            case "*1S *3A":
                            case "*1S *3B":
                            case "*1S *3C":
                            case "*1S *4":
                                metabolizer.setText(intMet);
                                recommendations.setText("Start with 30-50% reduction from normal starting dose:\n" +
                                        "1 -1.4 mg/kg daily  (include drug calculator option with each dose)\n" +
                                        "Allow 2-4 weeks to reach steady state after each dose adjustment. \n");
                                break;
                            case "*2 *2":
                            case "*2 *3A":
                            case "*2 *3B":
                            case "*2 *3C":
                            case "*2 *4":
                                metabolizer.setText(poorMet);
                                recommendations.setText("Reduce daily dose by 10-fold from normal starting dose and reduce frequency to thrice weekly instead of daily:\n" +
                                        " 0.2 mg/kg Three Times Weekly (include drug calculator option with each dose) \n" +
                                        "Allow 4-6 weeks to reach steady state after each dose adjustment. \n" +
                                        "For nonmalignant conditions, consider alternative nonthiopurine immunosuppressant therapy.\n");
                                break;
                        }
                    case "Azathioprine":
                    case "Azasan":
                    case "Imuran":
                        switch (alleles) {
                            case "*1 *1":
                            case "*1 *1S":
                            case "*1S *1S":
                                metabolizer.setText(normMet);
                                recommendations.setText("Start with normal starting dose:\n" +
                                        "Immunosuppressant/Kidney Transplantation  (include dosage calculator) \n" +
                                        "Adult: 3-5 mg/kg/day\n" +
                                        "Rheumatoid Arthritis\n" +
                                        "Adult: 1 mg/kg/day\n" +
                                        "Juvenile Idiopathic Arthritis \n" +
                                        "Pediatric: 1 mg/kg/day\n");
                                break;
                            case "*1 *2":
                            case "*1 *3A":
                            case "*1 *3B":
                            case "*1 *3C":
                            case "*1 *4":
                            case "*1S *2":
                            case "*1S *3A":
                            case "*1S *3B":
                            case "*1S *3C":
                            case "*1S *4":
                                metabolizer.setText(intMet);
                                recommendations.setText("Start with 30-70% reduction from normal starting dose:\n" +
                                        "Immunosuppressant/Kidney Transplantation \n" +
                                        "Adult: 0.9-3.5 mg/kg daily  (include drug calculator option with each dose)\n" +
                                        "Rheumatoid Arthritis\n" +
                                        "Adult: 0.3-0.7 mg/kg/day\n" +
                                        "Juvenile Idiopathic Arthritis \n" +
                                        "Pediatric: 0.3-0.7 mg/kg/day\n" +
                                        "Allow 2-4 weeks to reach steady state after each dose adjustment. \n");
                                break;
                            case "*2 *2":
                            case "*2 *3A":
                            case "*2 *3B":
                            case "*2 *3C":
                            case "*2 *4":
                                metabolizer.setText(poorMet);
                                recommendations.setText("Consider alternate therapy.\n" +
                                        "If you do use, reduce daily dose by 10-fold from normal starting dose and reduce frequency to thrice weekly instead of daily:\n" +
                                        " Immunosuppressant/Kidney Transplantation \n" +
                                        "Adult: 0.3-0.5 mg/kg Three Times Weekly   (include drug calculator option with each dose)\n" +
                                        "Rheumatoid Arthritis\n" +
                                        "Adult: 0.1 mg/kg Three Times Weekly\n" +
                                        "Juvenile Idiopathic Arthritis \n" +
                                        "Pediatric: 0.1 mg/kg Three Times Weekly\n" +
                                        "Allow 4-6 weeks to reach steady state after each dose adjustment. \n");

                        }

                }
            }
        }


    }



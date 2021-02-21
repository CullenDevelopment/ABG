package com.cullendevelopment.abg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class AnalyseActivity extends MainActivity {

    public AnalyseActivity() {
        /* No args constructor */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analyse_activity);

        //Hypoxia - hypoxeamia  - not enough O2 reaching tissues or available in blood
        TextView hypoxiaTextView = findViewById(R.id.hypoxia);
        if (paO2Num < 10) hypoxiaTextView.setText(R.string.hypoxia);

        //alveolar - arterial gap - difference between O2 available and amount that crosses into bloodstream
        TextView alveolarArterialGradient = findViewById(R.id.a_a_gradient);
        if (a_a_gap > 40) {
            alveolarArterialGradient.setText(R.string.a_a_g_very_high);
        } else if (a_a_gap < 10) {
            alveolarArterialGradient.setText(R.string.a_a_g_normal);
        } else {
            alveolarArterialGradient.setText(R.string.a_a_g_high);
        }

        // acid base balance is blood acid, alkaline or normal pH
        TextView phTextView = findViewById(R.id.ph_textview);
        if(pHNum > 7.45) {
            phTextView.setText(R.string.alkalaemia);
        }else if(pHNum < 7.35) {
            phTextView.setText(R.string.acidaemia);
        } else {
            phTextView.setText(R.string.ph_normal);
        }

        TextView phTextView2 = findViewById(R.id.ph_textview2);
        if(pHNum < 7.11) {
            phTextView2.setText(R.string.severe_acidaemia);
        }

        //respiratory acidosis, alkalosis or normal due to high, low or normal CO2 levels in blood
        TextView paco2TextView = findViewById(R.id.paco2_textview);
        if(paCO2Num > 6.0) {
            if(paCO2Num < 6.5) {
                paco2TextView.setText(R.string.resp_acidosis_mild);
            }else if(paCO2Num < 10.0) {
                paco2TextView.setText(R.string.resp_acidosis_moderate);
            }else {
                    paco2TextView.setText(R.string.resp_acidosis_severe);
            }

        }else if(paCO2Num < 4.7) {
            if(paCO2Num > 4.2) {
                paco2TextView.setText(R.string.resp_alkalosis_mild);
            }else if(paCO2Num > 3.0) {
                paco2TextView.setText(R.string.resp_alkalosis_moderate);
            }else {
                paco2TextView.setText(R.string.resp_alkalosis_severe);
            }
        }else {
            paco2TextView.setText(R.string.paco2_normal);
        }

        //metabolic acidosis, alkalosis or is Bicarb or Base Excess normal?
        TextView hCO3TextView = findViewById(R.id.hco3_textview);
        if(hCO3Num <22) {
            if(hCO3Num > 18) {
                hCO3TextView.setText(R.string.metabolic_acidosis_mild);
            }else if(hCO3Num > 14) {
                hCO3TextView.setText(R.string.metabolic_acidosis_moderate);
            }else {
                hCO3TextView.setText(R.string.metabolic_acidosis_severe);
            }
        } else if(hCO3Num > 26 ) {
            if(hCO3Num < 29) {
                hCO3TextView.setText(R.string.metabolic_alkalosis_mild);
            }else if(hCO3Num <  34) {
                hCO3TextView.setText(R.string.metabolic_alkalosis_moderate);
            }else {
                hCO3TextView.setText(R.string.metabolic_alkalosis_severe);
            }
        }else {
            hCO3TextView.setText(R.string.bicarb_normal);
        }



        // the fuller picture - how the respiratory and renal systems work together to try to determine cause.
        TextView conclusionTextView = findViewById(R.id.conclusion);
        if(paCO2Num > 6.0 && pHNum < 7.35 && hCO3Num > 22 && hCO3Num < 26) {
            conclusionTextView.setText(R.string.primary_resp_acidosis);

        }else if(pHNum < 7.35 && paCO2Num > 4.7 && hCO3Num < 22 && paCO2Num < 6.0) {
            conclusionTextView.setText(R.string.primary_metabolic_acidosis);

        } else if(pHNum > 7.45 && paCO2Num < 4.7 && hCO3Num > 22 && hCO3Num < 26) {
            conclusionTextView.setText(R.string.primary_respiratory_alkalosis);

        }else if(pHNum > 7.45 && paCO2Num > 4.7 && hCO3Num > 26 && paCO2Num < 6.0) {
            conclusionTextView.setText(R.string.primary_metabolic_alkalosis);

        }else if(pHNum < 7.35 && paCO2Num > 6.0 && hCO3Num > 26) {
            conclusionTextView.setText(R.string.resp_acidosis_renal_comp);

        }else if(pHNum < 7.35 && paCO2Num <4.7 && hCO3Num < 22) {
            conclusionTextView.setText(R.string.metabolic_acidosis_resp_comp);

        }else if(pHNum > 7.45 && paCO2Num < 4.7 && hCO3Num < 22) {
            conclusionTextView.setText(R.string.resp_alkalosis_renal_comp);

        } else if(pHNum > 7.5 && paCO2Num > 6.0 && hCO3Num > 26) {
            conclusionTextView.setText(R.string.metabolic_alkalosis_resp_comp);

        }else if(pHNum <7.35 && paCO2Num > 6.0 && hCO3Num < 22) {
            conclusionTextView.setText(R.string.mixed_acidosis);

        }else if(pHNum > 7.45 && paCO2Num < 4.7 && hCO3Num > 26) {
            conclusionTextView.setText(R.string.mixed_alkalosis);
        }
    }

    public void back_button(View view) {
        // Create a new intent to open the {@link Main Activity}
        Intent back_intent = new Intent(AnalyseActivity.this, MainActivity.class);

        // Start the new activity
        startActivity(back_intent); // opens up the Main Activity Home page Activity
    }
}


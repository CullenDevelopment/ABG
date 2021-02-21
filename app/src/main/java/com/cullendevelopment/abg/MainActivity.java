package com.cullendevelopment.abg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    protected static float fiO2Num = 0;
    protected static float pHNum = 0;
    protected static float paO2Num = 0;
    protected static float paCO2Num = 0;
    protected static float hCO3Num = 0;
    protected static float bENum = 0;
    protected static float oxygenPercent = 0;
    protected static float a_a_gap = 0;


    protected static String FIO2 = "FIO2";
    protected static String PH = "PH";
    protected static String PAO2 = "PAO2";
    protected static String PACO2 = "PACO2";
    protected static String HCO3 = "HCO3";
    protected static String BE = "BE";
    protected static String OXYGEN_PERCENT = "OXYGEN_PERCENT";
    protected static String A_A_GAP = "A_A_GAP";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(FIO2, fiO2Num);
        outState.putFloat(PH, pHNum);
        outState.putFloat(PAO2, paO2Num);
        outState.putFloat(PACO2, paCO2Num);
        outState.putFloat(HCO3, hCO3Num);
        outState.putFloat(BE, bENum);
        outState.putFloat(OXYGEN_PERCENT, oxygenPercent);
        outState.putFloat(A_A_GAP, a_a_gap);

    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        fiO2Num = savedInstanceState.getFloat(FIO2);

        pHNum = savedInstanceState.getFloat(PH);

        paO2Num =savedInstanceState.getFloat(PAO2);

        paCO2Num = savedInstanceState.getFloat(PACO2);

        hCO3Num = savedInstanceState.getFloat(HCO3);

        bENum = savedInstanceState.getFloat(BE);

        oxygenPercent = savedInstanceState.getFloat(OXYGEN_PERCENT);

        a_a_gap = savedInstanceState.getFloat(A_A_GAP);

    }

    public void analyse_button(View view) {
        EditText fiO2 = (EditText) findViewById(R.id.oxygen_editview);
        String fiO2Value = fiO2.getText().toString();
        fiO2Num = Float.parseFloat(fiO2Value);

        EditText pH = (EditText) findViewById(R.id.ph_editview);
        String pHValue = pH.getText().toString();
        pHNum = Float.parseFloat(pHValue);

        EditText paO2 = (EditText) findViewById(R.id.paO2_editview);
        String paO2Value = paO2.getText().toString();
        paO2Num = Float.parseFloat(paO2Value);

        EditText paCO2 = (EditText) findViewById(R.id.paCO2_editview);
        String paCO2Value = paCO2.getText().toString();
        paCO2Num = Float.parseFloat(paCO2Value);

        EditText hCO3 = (EditText) findViewById(R.id.hco3_editview);
        String hCO3Value = hCO3.getText().toString();
        hCO3Num = Float.parseFloat(hCO3Value);


        oxygenPercent = fiO2Num * 100;
        a_a_gap = oxygenPercent - paO2Num;


        // Create a new intent to open the {@link AnalyseActivity}
        Intent analyse_intent = new Intent(MainActivity.this, AnalyseActivity.class);

        // Start the new activity
        startActivity(analyse_intent); // opens up the AnalyseActivity

    }

}
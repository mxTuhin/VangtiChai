package com.scorpionsstudio.vangtichai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //View Fields Access
    TextView numDigit;
    LinearLayout portrainLayout, landscapeLayout, cLandscapeLayout ,calcBox;

    TextView[] portraitTexts = new TextView[8];
    TextView[] landscapeTexts = new TextView[8];

    String tempDigit;
    int[] notes = {500,100,50,20,10,5,2,1};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            landscapeLayout.setVisibility(View.VISIBLE);
            portrainLayout.setVisibility(View.GONE);
            cLandscapeLayout.setVisibility(View.VISIBLE);
        }else{
            landscapeLayout.setVisibility(View.GONE);
            portrainLayout.setVisibility(View.VISIBLE);
            cLandscapeLayout.setVisibility(View.GONE);
        }
    }

    private void initViews()
    {
        numDigit = (TextView)findViewById(R.id.NumDigit);
        tempDigit="Taka: ";

        portrainLayout = (LinearLayout) findViewById(R.id.portraitLayout);
        landscapeLayout = (LinearLayout) findViewById(R.id.landscapeLayout);
        cLandscapeLayout = findViewById(R.id.cLandscapeLayout);
        calcBox = findViewById(R.id.calcBox);
        landscapeLayout.setVisibility(View.GONE);
        cLandscapeLayout.setVisibility(View.GONE);

        portraitTexts[0] = findViewById(R.id.B500);
        portraitTexts[1] = findViewById(R.id.B100);
        portraitTexts[2] = findViewById(R.id.B50);
        portraitTexts[3] = findViewById(R.id.B20);
        portraitTexts[4] = findViewById(R.id.B10);
        portraitTexts[5] = findViewById(R.id.B5);
        portraitTexts[6] = findViewById(R.id.B2);
        portraitTexts[7] = findViewById(R.id.B1);

        landscapeTexts[0] = findViewById(R.id.BL500);
        landscapeTexts[1] = findViewById(R.id.BL100);
        landscapeTexts[2] = findViewById(R.id.BL50);
        landscapeTexts[3] = findViewById(R.id.BL20);
        landscapeTexts[4] = findViewById(R.id.BL10);
        landscapeTexts[5] = findViewById(R.id.BL5);
        landscapeTexts[6] = findViewById(R.id.BL2);
        landscapeTexts[7] = findViewById(R.id.BL1);



    }

    private void setValue(String givenValue)
    {
        tempDigit += givenValue;
        numDigit.setText(tempDigit);
        performCalculation(Integer.parseInt(tempDigit.split(" ")[1]));
    }

    private void performCalculation(int _value){

        int amount = _value;
        for(int i =0; i<notes.length; ++i){
            int noteRequired = (int) (amount/notes[i]);
            amount = amount-noteRequired*notes[i];
            String toSet = notes[i]+": "+noteRequired;
            portraitTexts[i].setText(toSet);
            landscapeTexts[i].setText(toSet);

        }
    }



    public void clearOnClick(View view)
    {
        numDigit.setText("Taka: ");
        tempDigit="Taka: ";
        for(int i=0; i<portraitTexts.length; ++i){
            String toSet = notes[i]+": 0";
            portraitTexts[i].setText(toSet);
            landscapeTexts[i].setText(toSet);
        }
    }


    public void sevenOnClick(View view)
    {
        setValue("7");
    }

    public void eightOnClick(View view)
    {
        setValue("8");
    }

    public void nineOnClick(View view)
    {
        setValue("9");
    }


    public void fourOnClick(View view)
    {
        setValue("4");
    }

    public void fiveOnClick(View view)
    {
        setValue("5");
    }

    public void sixOnClick(View view)
    {
        setValue("6");
    }
    

    public void oneOnClick(View view)
    {
        setValue("1");
    }

    public void twoOnClick(View view)
    {
        setValue("2");
    }

    public void threeOnClick(View view)
    {
        setValue("3");
    }

    public void zeroOnClick(View view)
    {
        setValue("0");
    }
}
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

    String tempDigit;

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

    }

    private void setWorkings(String givenValue)
    {
        tempDigit += givenValue;
        numDigit.setText(tempDigit);
    }


    public void equalsOnClick(View view)
    {
        Double result = null;


    }


    private boolean isNumeric(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }


    public void clearOnClick(View view)
    {
        numDigit.setText("Taka: ");
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketsOnClick(View view)
    {
        if(leftBracket)
        {
            setWorkings("(");
            leftBracket = false;
        }
        else
        {
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void powerOfOnClick(View view)
    {
        setWorkings("^");
    }

    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void timesOnClick(View view)
    {
        setWorkings("*");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        setWorkings("-");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }
}
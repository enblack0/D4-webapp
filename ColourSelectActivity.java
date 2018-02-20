package com.enb1g16.activitylauncher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class ColourSelectActivity extends AppCompatActivity {

    private String r1String;
    private String g1String;
    private String b1String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_select);
        r1String = "FF";
        g1String = "FF";
        b1String = "FF";
        SeekBar r1SeekBar = findViewById(R.id.r1SeekBar);
        SeekBar g1SeekBar = findViewById(R.id.g1SeekBar);
        SeekBar b1SeekBar = findViewById(R.id.b1SeekBar);
        r1SeekBar.setProgress(255);
        g1SeekBar.setProgress(255);
        b1SeekBar.setProgress(255);
        r1SeekBar.setOnSeekBarChangeListener(r1SeekBarListener);
        g1SeekBar.setOnSeekBarChangeListener(g1SeekBarListener);
        b1SeekBar.setOnSeekBarChangeListener(b1SeekBarListener);

    }

    public SeekBar.OnSeekBarChangeListener b1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        String b1Val;
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            RequestsSingleton.getInstance(getApplicationContext()).setB1Val(b1Val);
            RequestsSingleton.getInstance(getApplicationContext()).sendData();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            b1Val = ""+progress;
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            b1String = Integer.toHexString(progress);
            if(progress<16){
                b1String = "0"+b1String;
            }
            String colourString = "#"+r1String+g1String+b1String;
            colour1Layout.setBackgroundColor(Color.parseColor(colourString));

        }
    };

    public SeekBar.OnSeekBarChangeListener g1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        String g1Val;
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            RequestsSingleton.getInstance(getApplicationContext()).setG1Val(g1Val);
            RequestsSingleton.getInstance(getApplicationContext()).sendData();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            g1Val = ""+progress;
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            g1String = Integer.toHexString(progress);
            if(progress<16){
                g1String = "0"+g1String;
            }
            String colourString = "#"+r1String+g1String+b1String;
            colour1Layout.setBackgroundColor(Color.parseColor(colourString));
        }
    };

    public SeekBar.OnSeekBarChangeListener r1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        String r1Val;
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            RequestsSingleton.getInstance(getApplicationContext()).setR1Val(r1Val);
            RequestsSingleton.getInstance(getApplicationContext()).sendData();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            r1Val = ""+progress;
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            r1String = Integer.toHexString(progress);
            if(progress<16){
                r1String = "0"+r1String;
            }
            String colourString = "#"+r1String+g1String+b1String;
            colour1Layout.setBackgroundColor(Color.parseColor(colourString));
        }
    };
}

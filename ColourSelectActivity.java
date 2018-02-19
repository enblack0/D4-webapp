package com.enb1g16.activitylauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class ColourSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_select);

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
        }
    };
}

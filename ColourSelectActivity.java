package com.enb1g16.activitylauncher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import org.json.JSONObject;

public class ColourSelectActivity extends AppCompatActivity {

    private DataHandler dataHandler = new DataHandler("2",255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //send initial colour data
        DataPacket packet = dataHandler.getProcessedData();
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        setContentView(R.layout.activity_colour_select);
        SeekBar r1SeekBar = findViewById(R.id.r1SeekBar);
        SeekBar g1SeekBar = findViewById(R.id.g1SeekBar);
        SeekBar b1SeekBar = findViewById(R.id.b1SeekBar);
        SeekBar r2SeekBar = findViewById(R.id.r2SeekBar);
        SeekBar g2SeekBar = findViewById(R.id.g2SeekBar);
        SeekBar b2SeekBar = findViewById(R.id.b2SeekBar);
        SeekBar r3SeekBar = findViewById(R.id.r3SeekBar);
        SeekBar g3SeekBar = findViewById(R.id.g3SeekBar);
        SeekBar b3SeekBar = findViewById(R.id.b3SeekBar);
        r1SeekBar.setProgress(255);
        g1SeekBar.setProgress(255);
        b1SeekBar.setProgress(255);
        r2SeekBar.setProgress(255);
        g2SeekBar.setProgress(255);
        b2SeekBar.setProgress(255);
        r3SeekBar.setProgress(255);
        g3SeekBar.setProgress(255);
        b3SeekBar.setProgress(255);
        r1SeekBar.setOnSeekBarChangeListener(r1SeekBarListener);
        g1SeekBar.setOnSeekBarChangeListener(g1SeekBarListener);
        b1SeekBar.setOnSeekBarChangeListener(b1SeekBarListener);
        r2SeekBar.setOnSeekBarChangeListener(r2SeekBarListener);
        g2SeekBar.setOnSeekBarChangeListener(g2SeekBarListener);
        b2SeekBar.setOnSeekBarChangeListener(b2SeekBarListener);
        r3SeekBar.setOnSeekBarChangeListener(r3SeekBarListener);
        g3SeekBar.setOnSeekBarChangeListener(g3SeekBarListener);
        b3SeekBar.setOnSeekBarChangeListener(b3SeekBarListener);
    }

    public SeekBar.OnSeekBarChangeListener b1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setB1(progress);
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            colour1Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour1()));

        }
    };

    public SeekBar.OnSeekBarChangeListener g1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setG1(progress);
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            colour1Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour1()));
        }
    };

    public SeekBar.OnSeekBarChangeListener r1SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setR1(progress);
            RelativeLayout colour1Layout = findViewById(R.id.colour1Layout);
            colour1Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour1()));
        }
    };

    public SeekBar.OnSeekBarChangeListener r2SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setR2(progress);
            RelativeLayout colour2Layout = findViewById(R.id.colour2Layout);
            colour2Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour2()));
        }
    };

    public SeekBar.OnSeekBarChangeListener g2SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setG2(progress);
            RelativeLayout colour2Layout = findViewById(R.id.colour2Layout);
            colour2Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour2()));
        }
    };

    public SeekBar.OnSeekBarChangeListener b2SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setB2(progress);
            RelativeLayout colour2Layout = findViewById(R.id.colour2Layout);
            colour2Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour2()));
        }
    };

    public SeekBar.OnSeekBarChangeListener r3SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setR3(progress);
            RelativeLayout colour3Layout = findViewById(R.id.colour3Layout);
            colour3Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour3()));
        }
    };

    public SeekBar.OnSeekBarChangeListener g3SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setG3(progress);
            RelativeLayout colour3Layout = findViewById(R.id.colour3Layout);
            colour3Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour3()));
        }
    };

    public SeekBar.OnSeekBarChangeListener b3SeekBarListener = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            DataPacket packet = dataHandler.getProcessedData();
            RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            dataHandler.setB3(progress);
            RelativeLayout colour3Layout = findViewById(R.id.colour3Layout);
            colour3Layout.setBackgroundColor(Color.parseColor(dataHandler.getBackgroundColour3()));
        }
    };
}

package com.enb1g16.activitylauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONObject;

public class ModeSelectActivity extends AppCompatActivity {
    public DataHandler dataHandler = new DataHandler("1",255);
    //public NukeSSLCerts nukeSSlCerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // nukeSSlCerts.nuke();

    }

    public void startAutoMode(View view){
        dataHandler.setMode("1");
        JSONObject data = dataHandler.getProcessedData();
        //RequestsSingleton.getInstance(getApplicationContext()).sendGet();
        RequestsSingleton.getInstance(getApplicationContext()).sendData(data);
    }

    public void startSelectColour(View view){
        // String data = dataHandler.getProcessedData();
        // RequestsSingleton.getInstance(getApplicationContext()).sendData(data);
        Intent startIntent = new Intent(getApplicationContext(), ColourSelectActivity.class);
        startActivity(startIntent);
    }

    public void startSoundReact(View view){
        dataHandler.setMode("3");
        JSONObject data = dataHandler.getProcessedData();
        RequestsSingleton.getInstance(getApplicationContext()).sendData(data);
    }

}

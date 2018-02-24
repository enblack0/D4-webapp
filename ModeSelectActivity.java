package com.enb1g16.activitylauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import org.json.JSONObject;

public class ModeSelectActivity extends AppCompatActivity {
    public DataHandler dataHandler = new DataHandler("1",255); //initialize mode to 1 and colours to 255
    //public NukeSSLCerts nukeSSlCerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch enableSwitch = findViewById(R.id.onSwitch);
        enableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                DataPacket packet = new DataPacket(isChecked, DataPacket.packet_type.ENABLE);
                RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
            }
        });
       // nukeSSlCerts.nuke();

    }

    public void startAutoMode(View view){
        dataHandler.setMode("1");
        DataPacket packet = dataHandler.getProcessedData();
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
    }

    public void startSelectColour(View view){
        // String data = dataHandler.getProcessedData();
        // RequestsSingleton.getInstance(getApplicationContext()).sendData(data);
        Intent startIntent = new Intent(getApplicationContext(), ColourSelectActivity.class);
        startActivity(startIntent);
    }

    public void startSoundReact(View view){
        dataHandler.setMode("3");
        DataPacket packet = dataHandler.getProcessedData();
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
    }

}

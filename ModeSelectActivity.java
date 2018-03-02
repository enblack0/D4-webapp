package com.enb1g16.activitylauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import org.json.JSONObject;

import static com.enb1g16.activitylauncher.DataPacket.packet_type.MODE;

public class ModeSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toggleEnable(View view){
        DataPacket packet = new DataPacket(true, DataPacket.packet_type.ENABLE);
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet, this);
    }

    public void startAutoMode(View view){
        DataPacket packet = new DataPacket("1",MODE);
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet, this);
    }

    public void startSelectColour(View view){
        // String data = dataHandler.getProcessedData();
        // RequestsSingleton.getInstance(getApplicationContext()).sendData(data);
        Intent startIntent = new Intent(getApplicationContext(), ColourSelectActivity.class);
        startActivity(startIntent);
    }

    public void startSoundReact(View view){
        DataPacket packet = new DataPacket("3",MODE);
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet, this);
    }

}

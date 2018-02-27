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
                Button autoModeBtn = findViewById(R.id.autoModeBtn);
                Button colSelectBtn = findViewById(R.id.colSelectBtn);
                Button soundReactBtn = findViewById(R.id.soundReactBtn);
                if(isChecked){
                    autoModeBtn.setEnabled(true);
                    colSelectBtn.setEnabled(true);
                    soundReactBtn.setEnabled(true);
                }else{
                    autoModeBtn.setEnabled(false);
                    colSelectBtn.setEnabled(false);
                    soundReactBtn.setEnabled(false);
                }
                RequestsSingleton.getInstance(getApplicationContext()).postData(packet, getApplicationContext());

            }
        });
       // nukeSSlCerts.nuke();

    }

    public void startAutoMode(View view){
        dataHandler.setMode("1");
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
        dataHandler.setMode("3");
        DataPacket packet = new DataPacket("3",MODE);
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet, this);
    }

}

package com.enb1g16.activitylauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAutoMode(View view){
        RequestsSingleton.getInstance(getApplicationContext()).setMode("1");
        RequestsSingleton.getInstance(getApplicationContext()).sendData();
    }

    public void startSelectColour(View view){
        RequestsSingleton.getInstance(getApplicationContext()).setMode("2");
        //always start this mode at full brightness, white light
        RequestsSingleton.getInstance(getApplicationContext()).setR1Val("255");
        RequestsSingleton.getInstance(getApplicationContext()).setG1Val("255");
        RequestsSingleton.getInstance(getApplicationContext()).sendData();
        Intent startIntent = new Intent(getApplicationContext(), ColourSelectActivity.class);
        startActivity(startIntent);
    }

    public void startSoundReact(View view){
        RequestsSingleton.getInstance(getApplicationContext()).setMode("3");
        RequestsSingleton.getInstance(getApplicationContext()).sendData();
    }
}

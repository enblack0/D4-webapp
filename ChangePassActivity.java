package com.enb1g16.activitylauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangePassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
    }

    public void changePassword(View view){
        EditText oldPassEditText = (EditText) findViewById(R.id.oldPassEditText);
        EditText newPassEditText = (EditText) findViewById(R.id.newPassEditText);
        String oldPass = oldPassEditText.getText().toString();
        String newPass = newPassEditText.getText().toString();
        DataPacket packet = new DataPacket(oldPass, newPass, 2);
        RequestsSingleton.getInstance(getApplicationContext()).postData(packet);
    }
}

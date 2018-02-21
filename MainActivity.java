package com.enb1g16.activitylauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{

    private String response;

    public NukeSSLCerts nukeSSlCerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select); //should really be activity_login!
        nukeSSlCerts.nuke();
    }

    public void attemptLogin(View view){
        EditText pwdEditText = (EditText) findViewById(R.id.pwdEditText);
        RequestsSingleton.getInstance(getApplicationContext()).postLogin(pwdEditText.getText().toString(), new httpResponseInterface(){
            @Override
            public void onHttpResponse(String httpResponse){
                response = httpResponse;
                if(response.equals("Incorrect password")){
                    Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    RequestsSingleton.getInstance(getApplicationContext()).setAuthToken(response);
                    Intent startIntent = new Intent(getApplicationContext(), ModeSelectActivity.class);
                    startActivity(startIntent);
                }
            }
        });
    }
}

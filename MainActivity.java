package com.enb1g16.activitylauncher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        setContentView(R.layout.activity_main);
        SharedPreferences storedPassFile = this.getSharedPreferences("JarvisAppData",Context.MODE_PRIVATE);
        Button storedPwdButton = findViewById(R.id.storedPwdBtn);
        if(storedPassFile.contains("Password")){
            storedPwdButton.setVisibility(View.VISIBLE);
        }else{
            storedPwdButton.setVisibility(View.GONE);
        }
        nukeSSlCerts.nuke();
    }

    public void goToChangePass(View view){
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).setURL(url);
        Intent changePassIntent =  new Intent(getApplicationContext(), ChangePassActivity.class);
        startActivity(changePassIntent);
    }

    public void attemptStoredPwdLogin(View view) {
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).setURL(url);
        SharedPreferences storedPassFile = this.getSharedPreferences("JarvisAppData", Context.MODE_PRIVATE);
        final String password = storedPassFile.getString("Password", null);
        RequestsSingleton.getInstance(getApplicationContext()).postLogin(password);
    }


    public void attemptLogin(View view){
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).setURL(url);
        EditText pwdEditText = (EditText) findViewById(R.id.pwdEditText);
        final String password = pwdEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).postLogin(password);
    }
}

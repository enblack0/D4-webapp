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

    public void goToChangePass(View view){
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).setURL(url);
        Intent changePassIntent =  new Intent(getApplicationContext(), ChangePassActivity.class);
        startActivity(changePassIntent);
    }

    public void attemptLogin(View view){
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).setURL(url);
        EditText pwdEditText = (EditText) findViewById(R.id.pwdEditText);
        final String password = pwdEditText.getText().toString();
        RequestsSingleton.getInstance(getApplicationContext()).postLogin(password, new httpResponseInterface(){
            @Override
            public void onHttpResponse(String httpResponse){
                response = httpResponse;
                if(response.equals("Incorrect password")){
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }else if(response.equals("Change default password")) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    Intent changePassIntent = new Intent(getApplicationContext(), ChangePassActivity.class);
                    startActivity(changePassIntent);
                } else if(response.equals("Correct password")) {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    RequestsSingleton.getInstance(getApplicationContext()).setPassword(password);
                    Intent startIntent = new Intent(getApplicationContext(), ModeSelectActivity.class);
                    startActivity(startIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

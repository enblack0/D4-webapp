package com.enb1g16.activitylauncher;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 19/02/2018.
 */

public class RequestsSingleton {
    private static RequestsSingleton myInstance;
    private RequestQueue myRequestQueue;
    private static Context myContext;

    //private String url = "http://192.168.0.51/index.php"; //ip address of rpi
    private String url = "https://192.168.0.51:8080"; //testing python
    //private String url = "https://google.com"; //testing https

    private StringRequest stringRequest;

    private RequestsSingleton(Context context) {
        myContext = context;
        myRequestQueue = getRequestQueue();
    }

    public static synchronized RequestsSingleton getInstance(Context context) {
        if (myInstance == null) {
            myInstance = new RequestsSingleton(context);
        }
        return myInstance;
    }

    public RequestQueue getRequestQueue() {
        if (myRequestQueue == null) {
            myRequestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
        }
        return myRequestQueue;
    }

    public<T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

    public void sendGet() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("Response","response received");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("error", e.toString());
            }
        });
        addToRequestQueue(stringRequest);
    }

    public void sendData(final JSONObject data){
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url,data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("response","response received");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Log.e("error",e.toString());
                    }
                });

        addToRequestQueue(jsonRequest);
    }

}

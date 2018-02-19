package com.enb1g16.activitylauncher;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 19/02/2018.
 */

public class RequestsSingleton {
    private static RequestsSingleton myInstance;
    private RequestQueue myRequestQueue;
    private static Context myContext;

    private String url = "http://192.168.0.51/index.php"; //ip address of rpi
    private StringRequest stringRequest;

    private String r1Val = "0";
    private String g1Val = "0";
    private String b1Val = "0";
    private String mode = "1"; //should start in mode 1 (auto mode)

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

    public void setMode(String m){
        mode = m;
    }

    public void setR1Val(String r1){
        r1Val = r1;
    }

    public void setG1Val(String g1){
        g1Val = g1;
    }

    public void setB1Val(String b1){
        b1Val = b1;
    }

    public void sendData(){
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("",response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Log.e("error",e.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                params.put("mode",mode);
                params.put("r1", r1Val);
                params.put("g1", g1Val);
                params.put("b1", b1Val);
                return params;
            }
        };
        addToRequestQueue(stringRequest);
    }

}

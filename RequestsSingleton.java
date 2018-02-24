package com.enb1g16.activitylauncher;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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

import static com.enb1g16.activitylauncher.DataPacket.packet_type.CHANGE_PASS;
import static com.enb1g16.activitylauncher.DataPacket.packet_type.ENABLE;
import static com.enb1g16.activitylauncher.DataPacket.packet_type.FULL_DATA;
import static com.enb1g16.activitylauncher.DataPacket.packet_type.MODE;

/**
 * Created by user on 19/02/2018.
 */

public class RequestsSingleton {
    private static RequestsSingleton myInstance;
    private RequestQueue myRequestQueue;
    private static Context myContext;
    private String password;
    private String responseCode = "init";

    private String url = "https://192.168.0.51/index.php"; //ip address of rpi
    //private String url = "https://192.168.0.51:8080"; //testing python
    //private String url = "https://google.com"; //testing https

    public void setURL(String Url){
        url = Url;
    }

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


    public void postLogin(final String password, final httpResponseInterface callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseCode = response.trim();
                        callback.onHttpResponse(responseCode);
                        Log.i("Response",responseCode);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("error", e.toString());
                Toast.makeText(myContext.getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
               responseCode = e.toString().trim();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String>  params = new HashMap<String, String>();
                params.put("password", password);
                return params;
            }
        };
        addToRequestQueue(stringRequest);
    }

    public void postData(final DataPacket packet) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Response",response.trim());
                        Toast.makeText(myContext.getApplicationContext(), response.trim(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("error", e.toString());
                Toast.makeText(myContext.getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String>  params = new HashMap<String, String>();
                if(packet.pack_type==FULL_DATA) {
                    params.put("password", password);
                    params.put("mode", packet.mode);
                    params.put("colour1", packet.colour1);
                    params.put("colour2", packet.colour2);
                    params.put("colour3", packet.colour3);
                }else if(packet.pack_type==MODE){
                    params.put("password",password);
                    params.put("mode",packet.mode);
                }else if(packet.pack_type==CHANGE_PASS){
                    params.put("oldPassword",packet.oldPassword);
                    params.put("newPassword",packet.newPassword);
                }else if(packet.pack_type==ENABLE){
                    params.put("password",password);
                    params.put("enable",packet.enable);
                }
                return params;
            }
        };
        addToRequestQueue(stringRequest);
    }

    public void setPassword(String pass){
        password = pass;
    }

}

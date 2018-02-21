package com.enb1g16.activitylauncher;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by user on 20/02/2018.
 */

public class DataHandler {

    private String colour1;
    private String colour2;
    private String colour3;
    private String mode;
    private JSONObject dataPacket = new JSONObject();
    private String r1,g1,b1,r2,g2,b2,r3,g3,b3;

    //constructor to initialise a uniform colour
    public DataHandler(String startMode, int startColour){
        mode = startMode;
        setR1(startColour);
        setG1(startColour);
        setB1(startColour);
        setR2(startColour);
        setG2(startColour);
        setB2(startColour);
        setR3(startColour);
        setG3(startColour);
        setB3(startColour);
    }

    public JSONObject getProcessedData(){
        try{
            dataPacket.put("mode",mode);
            dataPacket.put("colour1",colour1);
            dataPacket.put("colour2",colour2);
            dataPacket.put("colour3",colour3);
        }catch(Exception e){
            Log.e("error in Json code",e.toString());
        }
        return dataPacket;
    }

    public void setMode(String m){
        mode = m;
    }

    public void setR1(int red1){
        r1 = Integer.toHexString(red1);
            if(red1<16){
                r1 = "0"+r1;
            }
        setColour1();
    }
    public void setG1(int green1){
        g1 = Integer.toHexString(green1);
        if(green1<16){
            g1 = "0"+g1;
        }
        setColour1();
    }

    public void setB1(int blue1){
        b1 = Integer.toHexString(blue1);
        if(blue1<16){
            b1 = "0"+b1;
        }
        setColour1();
    }

    public void setR2(int red2){
        r2 = Integer.toHexString(red2);
        if(red2<16){
            r2 = "0"+r2;
        }
        setColour2();
    }
    public void setG2(int green2){
        g2 = Integer.toHexString(green2);
        if(green2<16){
            g2 = "0"+g2;
        }
        setColour2();
    }

    public void setB2(int blue2){
        b2 = Integer.toHexString(blue2);
        if(blue2<16){
            b2 = "0"+b2;
        }
        setColour2();
    }

    public void setR3(int red3){
        r3 = Integer.toHexString(red3);
        if(red3<16){
            r3 = "0"+r3;
        }
        setColour3();
    }
    public void setG3(int green3){
        g3 = Integer.toHexString(green3);
        if(green3<16){
            g3 = "0"+g3;
        }
        setColour3();
    }

    public void setB3(int blue3){
        b3 = Integer.toHexString(blue3);
        if(blue3<16){
            b3 = "0"+b3;
        }
        setColour3();
    }


    private void setColour1(){
        colour1 = r1+g1+b1;
    }

    private void setColour2(){
        colour2 = r2+g2+b2;
    }

    private void setColour3(){
        colour3 = r3+g3+b3;
    }

    public String getBackgroundColour1(){
        return "#7F"+colour1; //50% transparent
    }

    public String getBackgroundColour2(){
        return "#7F"+colour2;
    }

    public String getBackgroundColour3(){
        return "#7F"+colour3;
    }
}

package com.enb1g16.activitylauncher;

/**
 * Created by user on 24/02/2018.
 */

public class DataPacket {
    public String mode, colour1, colour2, colour3, newPassword, oldPassword, enable;
    public int num_items;

    public DataPacket(String en, int numitems){
        enable = en;
        num_items = numitems;
    }

    public DataPacket(String oldpassword, String newpassword, int numitems){
        newPassword = newpassword;
        oldPassword = oldpassword;
        num_items = numitems;
    }

    public DataPacket(String m, String col1, String col2, String col3, int numitems){
        mode = m;
        colour1 = col1;
        colour2 = col2;
        colour3 = col3;
        num_items = numitems;
    }

}

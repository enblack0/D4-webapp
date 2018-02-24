package com.enb1g16.activitylauncher;

/**
 * Created by user on 24/02/2018.
 */

public class DataPacket {
    public enum packet_type{MODE, ENABLE, FULL_DATA, CHANGE_PASS};

    public String mode, colour1, colour2, colour3, newPassword, oldPassword;
    public String enable = "1";
    packet_type pack_type;
    //public int num_items;

    public DataPacket(boolean en, packet_type packtype){
        if(en){
            enable="1";
        } else{
            enable = "0";
        }
        pack_type = packtype;
    }

    public DataPacket(String oldpassword, String newpassword, packet_type packtype){
        newPassword = newpassword;
        oldPassword = oldpassword;
        pack_type = packtype;
    }

    public DataPacket(String m, String col1, String col2, String col3, packet_type packtype){
        mode = m;
        colour1 = col1;
        colour2 = col2;
        colour3 = col3;
        pack_type = packtype;
    }

}

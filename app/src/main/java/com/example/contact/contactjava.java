package com.example.contact;

import java.util.PriorityQueue;

public class contactjava {
    private String mName;
    private String mPhone;






    public contactjava(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public contactjava() {
        this.mName ="Thanh";
        this.mPhone = "0987";
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return "Name:" +getmName() + " \n" +"Phone: "+getmPhone();
    }
}
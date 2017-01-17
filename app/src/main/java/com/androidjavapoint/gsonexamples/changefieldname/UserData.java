package com.androidjavapoint.gsonexamples.changefieldname;

import com.google.gson.annotations.SerializedName;

public class UserData {

    public String name;

    public String gender;

    @SerializedName("phoneNumber")
    public long phoneNo;

    @SerializedName("cardNumber")
    public long cardNo;

    public int pin;
}

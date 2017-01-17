package com.androidjavapoint.gsonexamples.ignorefieldvalue;

import com.google.gson.annotations.Expose;

public class UserDetails {

    @Expose
    public String name;

    @Expose(deserialize = false)
    public String gender;

    @Expose(serialize = false, deserialize = false)
    public long phoneNumber;

    @Expose(serialize = false)
    public long cardNumber;

    public int pin;
}

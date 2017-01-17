package com.androidjavapoint.gsonexamples;


import com.androidjavapoint.gsonexamples.customadapter.UserDetailsModel;
import com.androidjavapoint.gsonexamples.ignorefieldvalue.UserDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

public class CustomAdapterTest {
    private static final String INPUT_JSON = "{\"name\":\"EmployeeName\",\"gender\":\"Male\",\"phoneNumber\":\"9876543210\",\"cardNumber\":\"283808120\",\"pin\":\"1234\"}";

    @Test
    public void deserialize() throws Exception {
        GsonBuilder builder = new GsonBuilder();
//      Here CustomAdapter will convert the phoneNumber, cardNumber, pin values. From the input json
//      the values of these fields are in String format but this adapter convert it into Integer
//      and parse it into UserDetailsModel Model.
        builder.registerTypeAdapter(UserDetails.class, new CustomAdapter());
        Gson gson = builder.create();

        UserDetailsModel userDetails = gson.fromJson(INPUT_JSON, UserDetailsModel.class);

        Assert.assertNotNull(userDetails);
    }


}

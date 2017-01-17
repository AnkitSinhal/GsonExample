package com.androidjavapoint.gsonexamples;


import com.androidjavapoint.gsonexamples.ignorefieldvalue.UserDetails;
import com.androidjavapoint.gsonexamples.nullvalues.EmployeeDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

public class IgnoreFieldTest {
    private static final String INPUT_JSON = "{\"name\":\"EmployeeName\",\"gender\":\"Male\",\"phoneNumber\":\"9876543210\",\"cardNumber\":\"283808120\",\"pin\":\"1234\"}";

    @Test
    public void ignoreFieldFromSerializedJson() throws Exception {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        UserDetails userDetails = new UserDetails();
        userDetails.name = "UserName";
        userDetails.gender = "Male";
        userDetails.phoneNumber = 1234567890;
        userDetails.cardNumber = 283808120;
        userDetails.pin = 4321;

        String serializedJson = gson.toJson(userDetails);
        System.out.println("Ignored fields from Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void deserialize() throws Exception {
        Gson gson = new Gson();

        UserDetails userDetails = gson.fromJson(INPUT_JSON, UserDetails.class);

        Assert.assertNotNull(userDetails);
    }


}

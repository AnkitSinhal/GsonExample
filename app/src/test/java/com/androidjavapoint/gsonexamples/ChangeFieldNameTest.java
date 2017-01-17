package com.androidjavapoint.gsonexamples;


import com.androidjavapoint.gsonexamples.changefieldname.UserData;
import com.androidjavapoint.gsonexamples.ignorefieldvalue.UserDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

public class ChangeFieldNameTest {
    private static final String INPUT_JSON = "{\"name\":\"EmployeeName\",\"gender\":\"Male\",\"phoneNumber\":\"9876543210\",\"cardNumber\":\"283808120\",\"pin\":\"1234\"}";

    @Test
    public void changeFieldFromSerializedJson() throws Exception {
        Gson gson = new Gson();

        UserData userData = new UserData();
        userData.name = "UserName";
        userData.gender = "Male";
        userData.phoneNo = 1234567890;
        userData.cardNo = 283808120;
        userData.pin = 4321;

        String serializedJson = gson.toJson(userData);
        System.out.println("Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void deserialize() throws Exception {
        Gson gson = new Gson();

        UserDetails userDetails = gson.fromJson(INPUT_JSON, UserDetails.class);

        Assert.assertNotNull(userDetails);
    }


}

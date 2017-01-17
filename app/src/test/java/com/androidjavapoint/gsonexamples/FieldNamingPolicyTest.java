package com.androidjavapoint.gsonexamples;


import com.androidjavapoint.gsonexamples.fieldnamingpolicy.UserDetailsPolicy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

public class FieldNamingPolicyTest {

    @Test
    public void identitySerializedJson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        Gson gson = gsonBuilder.create();

        UserDetailsPolicy userDetailsPolicy = new UserDetailsPolicy();
        userDetailsPolicy._name = "UserName";
        userDetailsPolicy.Gender = "Male";
        userDetailsPolicy.phone_number = 1234567890;
        userDetailsPolicy.CardNumber = 283808120;
        userDetailsPolicy.Pin = 4321;

        String serializedJson = gson.toJson(userDetailsPolicy);
        System.out.println("Identity Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void lowerCaseSerializedJson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();

        UserDetailsPolicy userDetailsPolicy = new UserDetailsPolicy();
        userDetailsPolicy._name = "UserName";
        userDetailsPolicy.Gender = "Male";
        userDetailsPolicy.phone_number = 1234567890;
        userDetailsPolicy.CardNumber = 283808120;
        userDetailsPolicy.Pin = 4321;

        String serializedJson = gson.toJson(userDetailsPolicy);
        System.out.println("Lower Case Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void upperCamelCaseSerializedJson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        Gson gson = gsonBuilder.create();

        UserDetailsPolicy userDetailsPolicy = new UserDetailsPolicy();
        userDetailsPolicy._name = "UserName";
        userDetailsPolicy.Gender = "Male";
        userDetailsPolicy.phone_number = 1234567890;
        userDetailsPolicy.CardNumber = 283808120;
        userDetailsPolicy.Pin = 4321;

        String serializedJson = gson.toJson(userDetailsPolicy);
        System.out.println("Upper Camel Case Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }
}

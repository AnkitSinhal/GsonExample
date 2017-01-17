package com.androidjavapoint.gsonexamples;

import com.androidjavapoint.gsonexamples.customadapter.UserDetailsModel;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class CustomAdapter extends TypeAdapter<UserDetailsModel> {
    @Override
    public UserDetailsModel read(JsonReader reader) throws IOException {
        UserDetailsModel userDetails = new UserDetailsModel();
        reader.beginObject();
        String fieldName = null;
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldName = reader.nextName();
            }
            if ("phoneNumber".equals(fieldName)) {
                //move to next token
                token = reader.peek();
                int phoneNo = Integer.parseInt(reader.nextString());
                userDetails.phoneNumber = phoneNo;
            }
            if ("cardNumber".equals(fieldName)) {
                //move to next token
                token = reader.peek();
                int cardNo = Integer.parseInt(reader.nextString());
                userDetails.cardNumber = cardNo;
            }
            if ("pin".equals(fieldName)) {
                //move to next token
                token = reader.peek();
                int pin = Integer.parseInt(reader.nextString());
                userDetails.pin = pin;
            }
        }
        reader.endObject();
        return userDetails;
    }

    @Override
    public void write(JsonWriter writer, UserDetailsModel userDetails) throws IOException {
        writer.beginObject();
        writer.name("phoneNumber");
        writer.value(userDetails.phoneNumber);
        writer.name("cardNumber");
        writer.value(userDetails.cardNumber);
        writer.name("pin");
        writer.value(userDetails.pin);
        writer.endObject();
    }
}

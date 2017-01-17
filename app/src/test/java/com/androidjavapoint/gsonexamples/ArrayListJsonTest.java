package com.androidjavapoint.gsonexamples;


import com.androidjavapoint.gsonexamples.array.Item;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArrayListJsonTest {
    private static final String INOUT_JSON = "[{\"item\":\"Item 1\",\"description\":\"Item 1 description\",\"price\":200},{\"item\":\"Item 2\",\"description\":\"Item 2 description\",\"price\":131},{\"item\":\"Item 3\",\"description\":\"Item 3 description\",\"price\":450}]\n";

    @Test
    public void arraySerializedJson() throws Exception {
        Gson gson = new Gson();

        Item item1 = new Item();
        item1.description = "My Item 1";
        item1.price = 322;

        Item item2 = new Item();
        item2.description = "My Item 2";
        item2.price = 987;

        Item[] itemArray = new Item[2];
        itemArray[0] = item1;
        itemArray[1] = item2;

        String serializedJson = gson.toJson(itemArray);
        System.out.println("Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void arrayDeserializedJson() throws Exception {
        Gson gson = new Gson();

        Item[] items = gson.fromJson(INOUT_JSON, Item[].class);

        Assert.assertNotNull(items);
    }

    @Test
    public void listSerializedJson() throws Exception {
        Gson gson = new Gson();

        Item item1 = new Item();
        item1.description = "My Item 1";
        item1.price = 322;

        Item item2 = new Item();
        item2.description = "My Item 2";
        item2.price = 987;

        List<Item> myItemList = new ArrayList<>();
        myItemList.add(item1);
        myItemList.add(item2);

        String serializedJson = gson.toJson(myItemList);
        System.out.println("Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void listDeserializedJson() throws Exception {
        Gson gson = new Gson();
        Type itemListType = new TypeToken<ArrayList<Item>>() {
        }.getType();

        List<Item> itemList = gson.fromJson(INOUT_JSON, itemListType);

        Assert.assertNotNull(itemList);
    }

}

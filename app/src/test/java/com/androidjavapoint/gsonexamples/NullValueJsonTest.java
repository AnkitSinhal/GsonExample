package com.androidjavapoint.gsonexamples;

import com.androidjavapoint.gsonexamples.nested.Author;
import com.androidjavapoint.gsonexamples.nested.Book;
import com.androidjavapoint.gsonexamples.nullvalues.EmployeeDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NullValueJsonTest {
    private static final String INPUT_JSON = "{\"name\":\"EmployeeName\",\"id\":123,\"age\":23,\"gender\":\"Male\",\"phoneNumber\":9876543210}";

    @Test
    public void removeNullFromSerializedJson() throws Exception {
        Gson gson = new Gson();

        EmployeeDetails details = new EmployeeDetails();
        details.name = "Test Employee";
        details.id = 1111;
        details.age = 43;
        details.gender = "Male";
        details.address = null;
        details.phoneNumber = 1234567890;

        String serializedJson = gson.toJson(details);
        System.out.println("Removed Null in Serialized Json " + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void keepNullFromSerializedJson() throws Exception {
        Gson gson = new GsonBuilder().serializeNulls().create();

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.name = "Test Employee";
        employeeDetails.id = 1111;
        employeeDetails.age = 43;
        employeeDetails.gender = "Male";
        employeeDetails.address = null;
        employeeDetails.phoneNumber = 1234567890;

        String serializedJson = gson.toJson(employeeDetails);
        System.out.println("Keep Null in Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void deserialize() throws Exception {
        Gson gson = new Gson();

        EmployeeDetails details = gson.fromJson(INPUT_JSON, EmployeeDetails.class);

        Assert.assertNotNull(details);
    }


}
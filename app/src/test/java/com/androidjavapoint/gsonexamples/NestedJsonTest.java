package com.androidjavapoint.gsonexamples;

import com.androidjavapoint.gsonexamples.array.Item;
import com.androidjavapoint.gsonexamples.nested.Author;
import com.androidjavapoint.gsonexamples.nested.Book;
import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NestedJsonTest {
    private static final String INPUT_JSON = "{\"title\":\"A Good Coder\",\"isbn\":\"AD47J59K\",\"author\":{\"id\":1111,\"name\":\"Author Name\"}}";

    @Test
    public void arraySerializedJson() throws Exception {
        Gson gson = new Gson();

        Author author = new Author();
        author.name = "Author A";
        author.id = "37492";

        Book bookObject = new Book();
        bookObject.title = "My Book";
        bookObject.isbn = "JL76KK85KJ";
        bookObject.author = author;

        String serializedJson = gson.toJson(bookObject);
        System.out.println("Serialized Json" + serializedJson);
        Assert.assertNotNull(serializedJson);
    }

    @Test
    public void arrayDeserializedJson() throws Exception {
        Gson gson = new Gson();

        Book book = gson.fromJson(INPUT_JSON, Book.class);

        Assert.assertNotNull(book);
    }
}
package com.example.disen.myapplication.backend;

import com.example.MyJokes;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

   private MyJokes jokes;

    MyBean(){jokes = new MyJokes();
    }

    public String getJokes() {
        return jokes.getJoke();
    }
}
package com.if5b.myapplication.model;

import java.util.List;

public class ValueWithData {
    private int success;
    private String message;
    private List<Post> data;

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Post> getData() {
        return data;
    }
}

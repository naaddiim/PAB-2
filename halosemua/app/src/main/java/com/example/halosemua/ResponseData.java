package com.example.halosemua;

import java.util.List;

public class ResponseData<RIN> {
    private boolean status;
    private String message;
    private List<RIN> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<RIN> getData() {
        return data;
    }
}

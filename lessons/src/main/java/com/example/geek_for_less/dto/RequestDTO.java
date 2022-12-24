package com.example.geek_for_less.dto;

import java.io.Serializable;

public class RequestDTO implements Serializable {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

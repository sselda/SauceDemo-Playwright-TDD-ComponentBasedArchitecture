package com.saucedemo.api.model;

import java.util.List;

public class UserResponse {

    private int page;
    private List<User> data;

    public int getPage() { return page; }
    public List<User> getData() { return data; }
}

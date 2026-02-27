package com.saucedemo.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class BaseApiClient {

    protected RequestSpecification requestSpec;

    public BaseApiClient() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com")
                .addHeader("Content-Type", "application/json")
                .build();
    }

}

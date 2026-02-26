package com.saucedemo.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    protected RequestSpecification requestSpec;

    public BaseApiClient() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent","Automation-Test")
                .build();
    }

}

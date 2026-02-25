package com.saucedemo.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    protected RequestSpecification requestSpec;

    public BaseApiClient(String baseUrl) {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    public RequestSpecification request() {
        return given().spec(requestSpec);
    }
}

package com.saucedemo.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseApiClient{

   public Response getUsers() {
       return given()
               .spec(requestSpec)
               .when()
               .get("/users");
   }

   public Response getInvalidEndpoint() {
       return given()
               .spec(requestSpec)
               .when()
               .get("/invalid");
   }

}

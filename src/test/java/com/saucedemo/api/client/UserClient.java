package com.saucedemo.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseApiClient{

   public Response getUsers(int page) {
       return given()
               .spec(requestSpec)
               .queryParam("page", page)
               .when()
               .get("/api/users");
   }

   public Response getInvalidEndpoint() {
       return given()
               .spec(requestSpec)
               .when()
               .get("/api/invalid-endpoint");
   }

}

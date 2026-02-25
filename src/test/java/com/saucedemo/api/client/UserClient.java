package com.saucedemo.api.client;

import io.restassured.response.Response;


public class UserClient extends BaseApiClient{

   public UserClient() {
       super("https://reqres.in");
   }

   public Response getUsers(int page) {
       return request()
               .queryParam("page", page)
               .when()
               .get("/api/users")
               .then()
               .extract()
               .response();
   }



}

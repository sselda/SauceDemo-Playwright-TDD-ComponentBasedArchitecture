package com.saucedemo.api.tests;

import com.saucedemo.api.client.UserClient;
import com.saucedemo.api.model.UserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserApiContractTest {

    private final UserClient userClient = new UserClient();

    @Test
    void shouldValidateUserApiContract() {

        var response = userClient.getUsers(2);
        assertEquals(200, response.statusCode());
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("contract/user-schema.json"));
    }

    @Test
    void shouldMapResponseToModel() {

        UserClient userClient = new UserClient();
        UserResponse response =
                userClient.getUsers(2).as(UserResponse.class);

        assertEquals(2, response.getPage());
        assertFalse(response.getData().isEmpty());
    }

    @Test
    void shouldReturn404ForInvalidEndpoint() {
        UserClient userClient = new UserClient();
        int status =
                userClient.getInvalidEndpoint()
                        .getStatusCode();

        assertEquals(404, status);
    }
}

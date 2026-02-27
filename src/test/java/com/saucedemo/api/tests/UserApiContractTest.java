package com.saucedemo.api.tests;

import com.saucedemo.api.client.UserClient;
import com.saucedemo.api.model.UserResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

public class UserApiContractTest {

    private final UserClient userClient = new UserClient();

    @Test
    void shouldValidateUserApiContract() {

        Response response = userClient.getUsers();
        assertEquals(200, response.statusCode());
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("contract/user-schema.json"));
    }

    @Test
    void shouldMapResponseToModel() {

        UserResponse response =
                userClient.getUsers().as(UserResponse.class);

        assertFalse(response.getUsers().isEmpty());
        assertTrue(response.getTotal() > 0);
    }

    @Test
    void shouldReturn404ForInvalidEndpoint() {

        int status =
                userClient.getInvalidEndpoint()
                        .getStatusCode();

        assertEquals(404, status);
    }
}

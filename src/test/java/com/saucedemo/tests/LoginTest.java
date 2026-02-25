package com.saucedemo.tests;

import com.saucedemo.components.LoginFormComponent;
import com.saucedemo.core.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void userShouldLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        LoginFormComponent form = loginPage.getLoginForm();

       form.enterUsername("standard_user");
       form.enterPassword("secret_sauce");
       form.submit();

        assertTrue(loginPage.isOnProductsPage());

    }

}

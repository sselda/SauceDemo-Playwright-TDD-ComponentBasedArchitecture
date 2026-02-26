package com.saucedemo.tests;

import com.saucedemo.components.ProductCardComponent;
import com.saucedemo.core.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTest extends BaseTest {

    @Test
    void userShouldSeeProductAfterLogin() {

        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();

        loginPage.getLoginForm().enterUsername("standard_user");
        loginPage.getLoginForm().enterPassword("secret_sauce");
        loginPage.getLoginForm().submit();

        ProductsPage productsPage = new ProductsPage(page);
        ProductCardComponent firstProduct = productsPage.getFirstProduct();
        String productName = firstProduct.getName();
        firstProduct.addToCard();

        assertTrue(productName != null && !productName.isEmpty());
    }

}

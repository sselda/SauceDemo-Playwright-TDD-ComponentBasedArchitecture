package com.saucedemo.tests;

import com.saucedemo.core.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @Test
    void CART_OO1_Should_Display_Added_Product_In_Cart() {

        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.getFirstProduct().addToCard();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(page);

        assertTrue(cartPage.hasItems());
    }
}

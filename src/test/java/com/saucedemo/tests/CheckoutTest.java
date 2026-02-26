package com.saucedemo.tests;

import com.saucedemo.components.ReviewSectionComponent;
import com.saucedemo.core.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    void userShouldCompleteCheckoutSuccessfully() {

        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.getFirstProduct().addToCard();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(page);
        assertTrue(cartPage.hasItems());
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.getCheckoutForm()
                .enterFirstName("Maria")
                .enterLastName("Test")
                .enterZip("12345")
                .continueCheckout()
                .finishCheckout();

        assertTrue(checkoutPage.isOrderCompleted());
    }

    @Test
    void CHECKOUT_001_Should_Complete_Payment_Successfully() {

        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.getFirstProduct().addToCard();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(page);
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(page);
        ReviewSectionComponent review = checkoutPage.getReviewSection();

        review.enterCardNumber("4242 4242 4242 4242");
        review.enterExpiryDate("12/40");
        review.enterCvc("123");
        review.acceptTerms();
        review.clickPay();

        assertTrue(review.isConfirmationVisible());
    }
}

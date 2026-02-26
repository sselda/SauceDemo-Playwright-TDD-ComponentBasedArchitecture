package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import com.saucedemo.components.CheckoutFormComponent;
import com.saucedemo.components.ReviewSectionComponent;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public ReviewSectionComponent getReviewSection() {
        return new ReviewSectionComponent(page);
    }

    public CheckoutFormComponent getCheckoutForm() {
        return new CheckoutFormComponent(page);
    }

    public boolean isOrderCompleted() {
        page.waitForURL("**/checkout-complete.html");
        return page.locator(".complete-header").innerText().contains("Thank you");
    }

}

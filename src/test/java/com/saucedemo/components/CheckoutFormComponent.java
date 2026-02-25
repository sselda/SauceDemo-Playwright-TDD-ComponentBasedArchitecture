package com.saucedemo.components;

import com.microsoft.playwright.Page;

public class CheckoutFormComponent extends BaseComponent{

    public CheckoutFormComponent(Page page) {
        super(page, page.locator("form"));
    }

    public CheckoutFormComponent enterFirstName(String firstName) {
        root.locator("#first-name").fill(firstName);
        return this;
    }

    public CheckoutFormComponent enterLastName(String lastName) {
        root.locator("#last-name").fill(lastName);
        return this;
    }

    public CheckoutFormComponent enterZip(String zip) {
        root.locator("#postal-code").fill(zip);
        return this;
    }

    public CheckoutFormComponent continueCheckout() {
        root.locator("#continue").click();
        return this;
    }

    public void finishCheckout() {
        page.click("#finish");
    }


}

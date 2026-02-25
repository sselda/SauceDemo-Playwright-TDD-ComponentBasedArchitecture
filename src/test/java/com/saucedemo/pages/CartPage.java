package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage{

    public CartPage(Page page) {
        super(page);
    }

    public boolean hasItems() {
        return page.locator(".cart_item").count() > 0;
    }

    public void checkout() {
        page.click("#checkout");
    }
}

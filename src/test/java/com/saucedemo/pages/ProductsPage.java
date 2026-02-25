package com.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.saucedemo.components.ProductCardComponent;

public class ProductsPage extends BasePage{

    public ProductsPage(Page page){
        super(page);
    }

    public boolean hasProducts() {
        page.waitForURL("**/inventory.html");
        return page.locator(".inventory_item").count() > 0;
    }

    public ProductCardComponent getFirstProduct() {
        Locator firstProduct = page.locator(".inventory_item").first();
        return new ProductCardComponent(page, firstProduct);
    }

    public void goToCart() {
        page.click(".shopping_cart_link");
    }
}

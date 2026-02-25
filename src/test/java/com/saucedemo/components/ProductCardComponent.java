package com.saucedemo.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCardComponent extends BaseComponent{

    public ProductCardComponent(Page page, Locator root){
        super(page, root);
    }

    private Locator productName() {
        return root.locator(".inventory_item_name");
    }

    private Locator addToCartButton() {
        return root.locator("button");
    }

    public String getName() {
        return productName().innerText();
    }

    public void addToCard() {
        addToCartButton().click();
    }
}

package com.saucedemo.pages;


import com.microsoft.playwright.Page;
import com.saucedemo.components.LoginFormComponent;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public void navigateToLoginPage() {
        page.navigate("https:/www.saucedemo.com");
    }

    public LoginFormComponent getLoginForm() {
        return new LoginFormComponent(page);
    }

    public boolean isOnProductsPage() {
        page.waitForURL("**/inventory.html");
        return page.url().contains("inventory");
    }
}

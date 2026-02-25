package com.saucedemo.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginFormComponent extends BaseComponent {

    public LoginFormComponent(Page page) {
        super(page, page.locator("form"));
    }

    private Locator usernameField() {
        return root.locator("#user-name");
    }

    private Locator passwordField() {
        return root.locator("#password");
    }

    private Locator loginButton() {
        return root.locator("#login-button");
    }

    public void enterUsername(String username) {
        usernameField().fill(username);
    }

    public void enterPassword(String password) {
        passwordField().fill(password);
    }

    public void submit() {
        loginButton().click();
    }
}

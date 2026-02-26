package com.saucedemo.core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }

    public void loginAsStandardUser() {

        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateToLoginPage();
        loginPage.getLoginForm().enterUsername("standard_user");
        loginPage.getLoginForm().enterPassword("secret_sauce");

        loginPage.getLoginForm().submit();
    }

}

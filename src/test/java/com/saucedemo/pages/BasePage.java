package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void navigate(String url) {
        page.navigate(url);
    }

    protected String getTitle() {
        return page.title();
    }

}

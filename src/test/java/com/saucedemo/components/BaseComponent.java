package com.saucedemo.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

    public abstract class BaseComponent {

        protected Page page;
        protected Locator root;

        public BaseComponent(Page page, Locator root) {
            this.page = page;
            this.root = root;
        }
    }


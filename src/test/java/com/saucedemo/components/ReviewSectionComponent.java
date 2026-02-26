package com.saucedemo.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ReviewSectionComponent extends BaseComponent{

    public ReviewSectionComponent(Page page){
        super(page, page.locator("review-section"));
    }

    private Locator cardNumberInput() {
        return root.locator("#card-number");
    }

    private Locator expiryInput() {
        return root.locator("#expiry-date");
    }

    private Locator cvcInput() {
        return root.locator("#cvc");
    }

    private Locator termsCheckbox() {
        return root.locator("terms");
    }

    private Locator payButton() {
        return root.locator("pay");
    }

    private Locator confirmationBox() {
        return root.locator(".confirmation");
    }

    public void enterExpiryDate(String expiry) {
        expiryInput().fill(expiry);
    }

    public void enterCvc(String cvc) {
        cvcInput().fill(cvc);
    }

    public void acceptTerms() {
        termsCheckbox().check();
    }

    public boolean isConfirmationVisible() {
        return confirmationBox().isVisible();
    }

    public void enterCardNumber(String cardNumber) {
        cardNumberInput().fill(cardNumber);
    }

    public void clickPay() {
        payButton().click();
    }
}

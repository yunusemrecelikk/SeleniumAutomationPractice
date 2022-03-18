package com.automationpractice.cases.negative;

import com.automationpractice.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class InvalidMailAddress {
    Methods methods;

    private final String emailAddress = "pageg318086";

    public InvalidMailAddress() { methods = new Methods(); }

    public void clickSignInButton() {
        try {
            By signinButtonLocator = By.cssSelector(".header_user_info > .login");
            methods.waitUntilElementCliclable(signinButtonLocator);
            methods.clickElement(signinButtonLocator);

            By signinTextLocator = By.cssSelector("#create-account_form > .page-subheading");
            String signinText = methods.getElementsText(signinTextLocator);
            Assert.assertEquals("Verification Failed: Account creation verification failed," +
                    " test case failed.", "CREATE AN ACCOUNT", signinText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEmail() {
        try {
            By emailInputLocator = By.id("email_create");
            methods.sendKeysToElement(emailInputLocator, emailAddress);
            String emailInputText = methods.getElementsValue(emailInputLocator);
            Assert.assertEquals("Verification Failed: Email text verification failed," +
                    " test case failed.", emailAddress, emailInputText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCreateAccount() {
        try {
            By createAccountButton = By.id("SubmitCreate");
            methods.clickElement(createAccountButton);

            By errorTextLocator = By.xpath("//*[@id=\"create_account_error\"]//ol[not(@id) or not(@class)]" +
                    "//li[not(@id) or not(@class)]");

            Assert.assertEquals("Verification Failed: "+methods.getElementsText(errorTextLocator)+" ," +
                    " test case failed.", "Invalid email address.", methods.getElementsText(errorTextLocator));

            System.out.println("====================");
            System.out.println("Test successfully passed!");
            System.out.println("====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

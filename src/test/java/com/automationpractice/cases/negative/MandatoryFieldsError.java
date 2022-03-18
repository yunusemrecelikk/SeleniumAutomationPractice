package com.automationpractice.cases.negative;

import com.automationpractice.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MandatoryFieldsError {
    Methods methods;
    private final String emailAddress = "test@ishop2k.com";

    public MandatoryFieldsError() { methods = new Methods(); }

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
            String errorTextCheck = methods.getElementsAttribute(By.id("create_account_error"), "style");
            Assert.assertNotEquals("Verification Failed: Invalid email error," +
                    " test case failed.", "display: block;", errorTextCheck);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterInformation() {
        try {
            methods.waitUntilElementLocated(By.cssSelector(".account_creation > .clearfix"));
            By genderRadio = By.id("id_gender1");
            methods.clickElement(genderRadio);
            Assert.assertTrue("Verification Failed: The radio button of title status is not selected, " +
                    "test case failed", methods.isElementSelected(genderRadio));

            By dobDay = By.id("days");
            methods.selectByValue(dobDay, "1");
            Assert.assertEquals("Verification failed: The DoB Day select value is not 1  , " +
                    "test case failed.", "1  ", methods.getSelectedText(dobDay));

            By dobMonth = By.id("months");
            methods.selectByValue(dobMonth, "1");
            Assert.assertEquals("Verification failed: The DoB Month select text is not January , " +
                    "test case failed.", "January ", methods.getSelectedText(dobMonth));

            By dobYear = By.id("years");
            methods.selectByValue(dobYear, "2000");
            Assert.assertEquals("Verification failed: The DoB Year select text is not 2000  , " +
                    "test case failed.", "2000  ", methods.getSelectedText(dobYear));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRegisterButton() {
        try {
            methods.clickElement(By.id("submitAccount"));

            By errorTextLocator = By.xpath("//*[@class=\"alert alert-danger\"]//ol[not(@id) and not(@class)]//li[contains(text(),'required.')]");
            methods.waitUntilElementLocated(errorTextLocator);

            String errorText = methods.getElementsText(errorTextLocator);
            boolean errorTextContains = errorText.contains("required");
            Assert.assertTrue("Verification Failed: Error text does not contains \"required\"", errorTextContains);
            System.out.println("Verification Successful.");

            System.out.println("====================");
            System.out.println("Test successfully passed!");
            System.out.println("====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

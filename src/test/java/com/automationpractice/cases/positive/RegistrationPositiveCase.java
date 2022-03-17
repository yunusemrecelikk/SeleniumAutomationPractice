package com.automationpractice.cases.positive;

import com.automationpractice.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegistrationPositiveCase {
    Methods methods;

    private final String emailAddress = "pageg318086@ishop2k.com";

    public RegistrationPositiveCase() {
        methods = new Methods();
    }

    public void ClickSignInButton() {
        try {
            By signinButtonLocator = By.cssSelector(".header_user_info > .login");
            methods.waitUntilElementCliclable(signinButtonLocator);
            methods.clickElement(signinButtonLocator);

            By signinTextLocator = By.cssSelector("#create-account_form > .page-subheading");
            String signinText = methods.getElementsText(signinTextLocator);
            Assert.assertEquals("Verification Failed: Registration page verification failed," +
                    " test case failed.", "CREATE AN ACCOUNT", signinText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertEmail() {
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

    public void ClickCreateAccount() {
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

    public void EnterInformation() {
        try {
            methods.waitUntilElementLocated(By.cssSelector(".account_creation > .clearfix"));
            By genderRadio = By.id("id_gender1");
            methods.clickElement(genderRadio);
            Assert.assertTrue("Verification Failed: The radio button of title status is not selected, " +
                    "test case failed", methods.isElementSelected(genderRadio));

            By firstNameInput = By.id("customer_firstname");
            methods.sendKeysToElement(firstNameInput, "Selenium");
            Assert.assertEquals("Verification failed: The firstname input text is not Selenium, " +
                    "test case failed.", "Selenium", methods.getElementsValue(firstNameInput));

            By lastNameInput = By.id("customer_lastname");
            methods.sendKeysToElement(lastNameInput, "Automation");
            Assert.assertEquals("Verification failed: The lastname input text is not Automation, " +
                    "test case failed.", "Automation", methods.getElementsValue(lastNameInput));

            By emailInput = By.id("email");
            Assert.assertEquals("Verification failed: The email input text is not "+emailAddress+", " +
                    "test case failed.", emailAddress, methods.getElementsValue(emailInput));

            By passwordInput = By.id("passwd");
            methods.sendKeysToElement(passwordInput, "1q2w3e4r5t");
            Assert.assertEquals("Verification failed: The password input text is not 1q2w3e4r5t, " +
                    "test case failed.", "1q2w3e4r5t", methods.getElementsValue(passwordInput));

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

            By addressFirstNameInput = By.id("firstname");
            Assert.assertEquals("Verification failed: The adress firstname input text is not Selenium, " +
                    "test case failed.", "Selenium", methods.getElementsValue(addressFirstNameInput));

            By addressLastNameInput = By.id("lastname");
            Assert.assertEquals("Verification failed: The address lastname input text is not Automation, " +
                    "test case failed.", "Automation", methods.getElementsValue(addressLastNameInput));

            By addressInformationInput = By.id("address1");
            methods.sendKeysToElement(addressInformationInput, "random address information");
            Assert.assertEquals("Verification failed: The address information input text " +
                    "is not random address information, " +
                    "test case failed.", "random address information",
                    methods.getElementsValue(addressInformationInput));

            By addressCityInput = By.id("city");
            methods.sendKeysToElement(addressCityInput, "New York");
            Assert.assertEquals("Verification failed: The address city input text is not New York, " +
                    "test case failed.", "New York", methods.getElementsValue(addressCityInput));

            By addressStateSelect = By.id("id_state");
            methods.selectByValue(addressStateSelect, "1");
            Assert.assertEquals("Verification failed: The address state select is not Alabama, " +
                    "test case failed.", "Alabama", methods.getSelectedText(addressStateSelect));

            By addressZipInput = By.id("postcode");
            methods.sendKeysToElement(addressZipInput, "34100");
            Assert.assertEquals("Verification failed: The address zip input is not 34100, " +
                    "test case failed.", "34100", methods.getElementsValue(addressZipInput));

            By addressPhoneNumberInput = By.id("phone_mobile");
            methods.sendKeysToElement(addressPhoneNumberInput, "1234567890");
            Assert.assertEquals("Verification failed: The address phone number input is not 1234567890, " +
                    "test case failed.", "1234567890", methods.getElementsValue(addressPhoneNumberInput));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ClickRegisterButton() {
        try {
            methods.clickElement(By.id("submitAccount"));

            By myAccountLocator = By.cssSelector(".header_user_info > .account");
            methods.waitUntilElementLocated(myAccountLocator);
            String accountCheckText = methods.getElementsText(myAccountLocator);
            Assert.assertEquals("Verification failed: Account name didn't match, test case failed.",
                    "Selenium Automation", accountCheckText);

            System.out.println("====================");
            System.out.println("Test successfully passed!");
            System.out.println("====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

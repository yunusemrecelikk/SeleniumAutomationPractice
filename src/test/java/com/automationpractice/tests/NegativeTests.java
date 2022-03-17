package com.automationpractice.tests;

import com.automationpractice.cases.negative.InvalidMailAddress;
import com.automationpractice.driver.BaseTest;
import org.junit.Test;

public class NegativeTests extends BaseTest {

    @Test
    public void negativeRegistrationTest() { // Verify invalid email address error.
        InvalidMailAddress registrationNegativeCase = new InvalidMailAddress();

        registrationNegativeCase.clickSignInButton();
        registrationNegativeCase.insertEmail();
        registrationNegativeCase.clickCreateAccount();
    }

}

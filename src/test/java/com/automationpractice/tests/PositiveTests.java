package com.automationpractice.tests;

import com.automationpractice.cases.positive.RegistrationPositiveCase;
import com.automationpractice.driver.BaseTest;
import org.junit.Test;

public class PositiveTests extends BaseTest {

    @Test
    public void positiveRegistrationTest() { // Automate User Registration process of e-commerce website.
        RegistrationPositiveCase registrationPositiveCase = new RegistrationPositiveCase();

        registrationPositiveCase.ClickSignInButton();
        registrationPositiveCase.InsertEmail();
        registrationPositiveCase.ClickCreateAccount();
        registrationPositiveCase.EnterInformation();
        registrationPositiveCase.ClickRegisterButton();
    }

}

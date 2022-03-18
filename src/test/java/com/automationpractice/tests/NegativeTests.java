package com.automationpractice.tests;

import com.automationpractice.cases.negative.IncorrectValues;
import com.automationpractice.cases.negative.InvalidMailAddress;
import com.automationpractice.cases.negative.MandatoryFieldsError;
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

    @Test
    public void negativeMandatoryFields() { // Verify error messages for mandatory fields.
        MandatoryFieldsError mandatoryFieldsError = new MandatoryFieldsError();
        mandatoryFieldsError.clickSignInButton();
        mandatoryFieldsError.insertEmail();
        mandatoryFieldsError.clickCreateAccount();
        mandatoryFieldsError.enterInformation();
        mandatoryFieldsError.clickRegisterButton();
    }

    @Test
    public void negativeIncorrectValues() { // Verify error messages for entering incorrect values in fields.
        IncorrectValues incorrectValues = new IncorrectValues();
        incorrectValues.clickSignInButton();
        incorrectValues.insertEmail();
        incorrectValues.clickCreateAccount();
        incorrectValues.enterInformation();
        incorrectValues.clickRegisterButton();
    }

}

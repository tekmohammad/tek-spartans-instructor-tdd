package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTests extends UIBaseClass {

    @Test
    public void createNewAccountTestPositive() {
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);

        String expectedEmail = DataGenerator.generateRandomEmail("Mohammad");

        signUpPage.fillUpCreateAccountForm("Mohammad",
                expectedEmail,
                "Password@123");

        String actualEmail = getElementText(accountProfilePage.accountEmailInfo);

        Assert.assertEquals(actualEmail, expectedEmail,
                "Profile Page should have same email as Created");
    }

    /*
    Story 4.1 (Activity 15 Minute)
    Navigate to Create Account page and Create new Account
    With existing email and validate error message "this email is already exist, please use another email address".
     */
}

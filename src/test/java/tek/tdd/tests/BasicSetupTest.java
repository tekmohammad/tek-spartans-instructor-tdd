package tek.tdd.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class BasicSetupTest extends UIBaseClass {

    @Test
    public void validateTopLeftCornerLogo() {
       String actualLogoText = getElementText(By.className("top-nav__logo"));

        Assert.assertEquals(actualLogoText, "TEKSCHOOL", "Logo text should match");
    }

    /*
    Navigate to retail app and make sure top-left corner text in TEKSCHOOL
    And make sure Sign in button is enabled.
     */
}


package com.petfinder.tests.regressionE2eTests.loginTests;

import com.petfinder.pages.HomePage;
import com.petfinder.pages.NavBar;
import com.petfinder.tests.regressionE2eTests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TestSuccessfulLogin extends BaseTest {
    String email;
    String password;

    @BeforeClass
    @Description("Read test data from .env file")
    @Step("Read test data from .env file")
    public void readTestData () {
        Dotenv dotenv = Dotenv.load();
        email = dotenv.get("REGISTERED_EMAIL");
        password = dotenv.get("VALID_PASSWORD");
    }
    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void testSuccessfulLogin () {
        new HomePage(driver)
                .navigateToHomePage().submitLoginForm(email,password);
        Assert.assertTrue(false);

                //.closeApplicationAd();
//        new NavBar(driver)
//                .clickSignin()
//                .clickLogin()
//                .fillLoginFormThenSubmit(email, password);
//        String msg = new HomePage(driver).getSigninSuccessMessage();
//        Assert.assertEquals(msg, "Please wait while we finish signing you in...",
//                "Sign in success message is not as expected found: " + msg);
//        var profileSideMenu = new NavBar(driver).clickProfileIcon();
//        String name = profileSideMenu.getProfileOwnerName();
//        Assert.assertEquals(name, "Abdelaziz Nassif",
//                "user name is not as expected found: " + name);
    }
}

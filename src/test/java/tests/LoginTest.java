package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends tests.BasePageTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    void navigate() {
        navigateToURL("https://school.qa.guru/cms/system/login");
    }

    @Test
    void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.enterEmail(ConfigReader.getProperty("email"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.isUserSuccessfullyLogin(), "User can not login");
    }
}

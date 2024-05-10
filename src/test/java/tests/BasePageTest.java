package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ScreenShot;
import utils.SeleniumActions;

public class BasePageTest {


    protected void navigateToURL(String URL) {
        DriverFactory.goToUrl(URL);
    }

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        SeleniumActions.setActions();
    }

    @AfterMethod
    void makeScreenScreenShotIfFails(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenShot.makeScreenShot(result.getName());
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quiteDriver();
        SeleniumActions.removeActions();
    }
}
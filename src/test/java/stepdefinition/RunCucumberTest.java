package stepdefinition;


import com.test.helpers.KEYS;
import com.test.utilities.DriverUtils;
import com.test.utilities.ScreenShotUtils;
import com.test.utilities.ThisRun;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    private ThisRun thisRun  = ThisRun.getInstance();
    private static Logger logger = LogManager.getLogger(RunCucumberTest.class.getName());
    DriverUtils driverUtils;
    WebDriver driver;

    @io.cucumber.java.Before
    public void setup() throws IOException {
       // logger.info("Running scenario : "+ scenario.getName());
        loadFromPropertiesFile();
        addDriverProperties();
       logger.debug("----------------Driver value------------" + driver);

    }

    private void loadFromPropertiesFile() throws IOException {
        FileInputStream fileStream =
                new FileInputStream(thisRun.get(KEYS.TEST_RESOURCES.toString()) + "/CommonProperties.properties");
        Properties commonProperties = new Properties();
        commonProperties.load(fileStream);
        thisRun.add(KEYS.BROWSER, commonProperties.getProperty(KEYS.BROWSER.toString()));
        thisRun.add(KEYS.APP_URL, commonProperties.getProperty(KEYS.APP_URL.toString()));
    }

    private void addDriverProperties() {
        driverUtils = new DriverUtils(thisRun.getAsString(KEYS.BROWSER.toString()));
        driver = driverUtils.getDriver();
        thisRun.add(KEYS.DRIVER, driver);
    }

    @io.cucumber.java.After
     public void tearDown() {
        logger.info("Inside teardown(), now Browser will quit.....");
        logger.debug("----------------Driver value------------" + driver);

        //ScreenShotUtils.embedScreenShotInReport(scenario, scenario.getName());
        driverUtils.quitBrowser();
    }
}

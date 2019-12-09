package stepdefinition;


import com.test.helpers.KEYS;
import com.test.utilities.DriverUtils;
import com.test.utilities.ThisRun;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    private static Logger logger = LogManager.getLogger(RunCucumberTest.class.getName());

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    private ThisRun thisRun = ThisRun.getInstance();
    private DriverUtils driverUtils;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @io.cucumber.java.Before
    public void setUp() throws IOException {
        loadFromPropertiesFile();
        driverUtils = new DriverUtils(thisRun.getAsString(KEYS.BROWSER.name()));
        driver.set(driverUtils.getDriver());
        getDriver().get(thisRun.getAsString(KEYS.APP_URL.name()));
    }

    @io.cucumber.java.After
    public void teardown() {
        getDriver().quit();
    }

    private void loadFromPropertiesFile() throws IOException {
        logger.info("Loading common properties..");
        FileInputStream fileStream =
                new FileInputStream(thisRun.get(KEYS.TEST_RESOURCES.toString()) + "/CommonProperties.properties");
        Properties commonProperties = new Properties();
        commonProperties.load(fileStream);
        thisRun.add(KEYS.BROWSER, commonProperties.getProperty(KEYS.BROWSER.toString()));
        thisRun.add(KEYS.APP_URL, commonProperties.getProperty(KEYS.APP_URL.toString()));
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

}

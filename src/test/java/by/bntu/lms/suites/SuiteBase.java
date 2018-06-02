package by.bntu.lms.suites;

import by.bntu.lms.driver.Driver;
import by.bntu.lms.pages.AbstractPage;
import by.bntu.lms.pages.common.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class SuiteBase {
    public static WebDriver driver;

    private AbstractPage abstractPage;
    LoginPage loginPage;
    String ADMIN_LOGIN;
    String ADMIN_PASSWORD;
    private String startURL;
    private String browserType;
    private String extentConfig;
    private String reportLocation;
    private String workDir;

    private int counter = 0;

    //for reports
    private static ExtentReports extent;
    private static ExtentTest test;
    public static ExtentTestInterruptedException testexception;

    public SuiteBase() throws IOException {
        Properties properties = loadProjectProperties();
        this.ADMIN_LOGIN = properties.getProperty("adminLogin");
        this.ADMIN_PASSWORD = properties.getProperty("adminPassword");
        this.startURL = properties.getProperty("initialURL");
        this.browserType = properties.getProperty("browserType");
        this.browserType = properties.getProperty("browserType");
        this.extentConfig = properties.getProperty("extent-config");
        this.reportLocation = properties.getProperty("reportLocation");
        this.workDir = properties.getProperty("workDir");
    }

    @BeforeSuite
    public void beforeSuite() {
        //Report Directory and Report Name
        extent = new ExtentReports(reportLocation, true);
        extent.loadConfig(new File(extentConfig)); //Supporting File for Extent Reporting
        extent.addSystemInfo("Environment", "Test environment"); //It will provide Execution Machine Information
    }

    @AfterSuite
    public void afterSuite() {
        extent.close();  // close the Test Suite
    }

    private void cleanWorkDirectory() throws IOException {
        FileUtils.cleanDirectory(new File(workDir));
    }

    @BeforeMethod(alwaysRun = true)
    public void callReports(Method method) {
        test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
        test.assignAuthor("LMS Test Bot"); //Test Script Author Name
        test.assignCategory("Smoke  :: " + "admin functionality" + " :: API VERSION - " + "v1.1");
    }

    @BeforeMethod(alwaysRun = true)
    public void init() throws Exception {
        driver = Driver.getWebDriverInstance(browserType);
        loginPage = new LoginPage(driver);
        abstractPage = new AbstractPage(driver);
        driver.get(startURL);
        driver.manage().window().fullscreen();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) throws Exception {
        abstractPage.takeScreenshot(counter++ + "_" + method.getName(), workDir);
        driver.quit();
    }

    private Properties loadProjectProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("./configurations/project.properties");
        properties.load(in);
        in.close();
        return properties;
    }
}
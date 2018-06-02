package by.bntu.lms.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Driver {
    private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";
    private static final int IMPLICIT_TIME = 30;

    private static WebDriverTypes defaultDriverType = WebDriverTypes.CHROME;

    private static HashMap<String, org.openqa.selenium.WebDriver> instances = new HashMap<>();


    public static WebDriver getWebDriverInstance(String name,
                                                 WebDriverTypes type) throws Exception {
        WebDriver driver;
       /* if (!instances.containsKey(name)) {*/
        switch (type) {
            case FIREFOX: {
                driver = new FirefoxDriver();
                break;
            }
            case IE: {
                System.setProperty("webdriver.ie.driver",
                        "./drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            }
            case CHROME: {
                System.setProperty("webdriver.chrome.driver",
                        "./drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case REMOTE_CHROME: {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setJavascriptEnabled(true);
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.LINUX);
                RemoteWebDriver rwd = new RemoteWebDriver(new URL("http://10.153.30.106:5555/wd/hub"), capabilities);
                rwd.setLogLevel(Level.OFF);
                driver = rwd;
                break;
            }
            default:
                throw new Exception("Unknown web driver specified: " + type);
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        instances.put(name, driver);
        /*} else {
            //driver = instances.get(name);
            *//*DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://10.153.30.106:4444"), capability);*//*
            driver = new ChromeDriver();
        }*/
        return driver;
    }

    public static WebDriver getWebDriverInstance(String name) throws Exception {
        return getWebDriverInstance(name, defaultDriverType);
    }

    public static WebDriver getWebDriverInstance() throws Exception {
        return getWebDriverInstance(DEFAULT_WEB_DRIVER, defaultDriverType);
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

}

package trangbui.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import trangbui.selenium.common.Constants;
import trangbui.selenium.common.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        setupDriver();
        Log.configure();
        Log.startTestCase(this.getClass().getSimpleName(), System.getProperty("os.name"), Constants.BROWSER);
    }

    @AfterClass
    public void afterClass() {
        Log.endTestCase();
//        driver.quit();
    }

    public void setupDriver() {
        Log.info("Setup Browser driver");
        switch (Constants.BROWSER.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--no-proxy-server");
                chromeOptions.addArguments("--enable-automation");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--enable-precise-memory-info");
                chromeOptions.addArguments("--ignore-ssl-errors=true");
                chromeOptions.addArguments("--allow-insecure-localhost");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.setAcceptInsecureCerts(true);

                if(Constants.HEADLESS) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1980,1080");
                }

                DesiredCapabilities desiredCapabilities = null;
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                desiredCapabilities.setCapability("javascriptEnabled", true);

                Map<String, Object> chromePreferences = new HashMap<String, Object>();
                chromePreferences.put("credentials_enable_service", false);
                chromePreferences.put("profile.password_manager_enabled", false);

                if(Constants.DISABLE_PDF_VIEWER) {
                    chromePreferences.put("plugins.always_open_pdf_externally", false);
                    desiredCapabilities.setCapability("plugins.plugins_disabled","Chrome PDF Viewer");
                }

                chromeOptions.setExperimentalOption("prefs", chromePreferences);

                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(new FirefoxProfile());

                if(Constants.DISABLE_PDF_VIEWER) {
                    firefoxOptions.addPreference("plugin.disable_full_page_plugin_for_types", "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
                    firefoxOptions.addPreference("pdfjs.disabled", true);
                    firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/pdf,application/csv,application/vnd.ms-excel");
                }

                if(Constants.HEADLESS) {
                    firefoxOptions.setHeadless(true);
                }

                driver = new FirefoxDriver(firefoxOptions);

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

        }

        if(Constants.MAXIMIZE_WINDOW) {
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();

        // Set timeout to wait for an element to appear
        // Find more at: https://www.guru99.com/implicit-explicit-waits-selenium.html
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }
}


package tests.tests_settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.ui.*;

public class BaseTest {
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected AdminPage adminPage;
    protected HeaderPage headerPage;

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true, description = "Open browser")
    public void setup(@Optional("chrome") String browser) {
        Configuration.timeout = 20000;
        Configuration.clickViaJs = true;
        Configuration.browserSize = "1920x1080";

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--incognito", "--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized", "--private", "--headless");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        threadLocalDriver.set(driver);
        WebDriverRunner.setWebDriver(driver);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );

        loginPage = new LoginPage();
        addProjectPage = new AddProjectPage();
        projectsPage = new ProjectsPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        adminPage = new AdminPage();
        headerPage = new HeaderPage();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }
}

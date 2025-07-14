package tests.TestSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.UI.*;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;
    protected DashboardPage dashboardPage;
    protected ProjectPage projectPage;
    protected TestCasesPage testCasesPage;
    protected TestSectionPage testSectionPage;

    SoftAssert softAssert = new SoftAssert();

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        Objects.requireNonNull(driver, "Driver initialization failed!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        context.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectPage = new ProjectPage(driver);
        testCasesPage = new TestCasesPage(driver);
        testSectionPage = new TestSectionPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

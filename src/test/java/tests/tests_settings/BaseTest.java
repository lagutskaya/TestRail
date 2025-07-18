package tests.tests_settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.ui.*;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected AdminPage adminPage;
    protected HeaderPage headerPage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Open browser")
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
            Configuration.browserSize = "1366x768";
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
            Configuration.browserSize = "1366x768";
        }
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        loginPage = new LoginPage();
        addProjectPage = new AddProjectPage();
        projectsPage = new ProjectsPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        adminPage = new AdminPage();
        headerPage = new HeaderPage();
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

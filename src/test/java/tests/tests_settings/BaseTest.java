package tests.tests_settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.ui.*;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;
    protected DashboardPage dashboardPage;
    protected ProjectPage projectPage;
    protected TestCasesPage testCasesPage;
    protected TestSectionPage testSectionPage;
    protected AdminPage adminPage;
    protected HeaderPage headerPage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Открытие браузера")
    public void setup() {
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        loginPage = new LoginPage();
        addProjectPage = new AddProjectPage();
        projectsPage = new ProjectsPage();
        dashboardPage = new DashboardPage();
        projectPage = new ProjectPage();
        testCasesPage = new TestCasesPage();
        testSectionPage = new TestSectionPage();
        adminPage = new AdminPage();
        headerPage = new HeaderPage();
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

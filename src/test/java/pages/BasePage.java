package pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BasePage {

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));


    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = "https://qatesttestrailfinalproject123.testrail.io/index.php?/auth/login";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;

//        loginPage = new LoginPage();
//        projectsPage = new ProjectsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        closeWebDriver();
    }
}


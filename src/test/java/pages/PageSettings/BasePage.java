package pages.PageSettings;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

public class BasePage {

    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected String base_url = System.getProperty("base_url", PropertyReader.getProperty("base_url"));

    @BeforeMethod
    public void setup() {
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }
}

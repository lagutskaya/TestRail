package pages.UI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.PageSettings.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DashboardPage extends BasePage {

    private final SelenideElement
            DASHBOARD_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            BACK_TO_DASHBOARD_BUTTON = $("[data-testid='backToDashboardButton']");
    private final String PROJECT_NAME_PATTERN = "//a[text()='%s']";

    @Step("Open Dashboard page")
    public DashboardPage openDashboardPage() {
        BACK_TO_DASHBOARD_BUTTON.shouldBe(visible).click();
        return this;
    }

    @Step("Dashboard page is opened")
    public DashboardPage isPageOpened() {
        DASHBOARD_TITLE.shouldBe(visible);
        log.info("Dashboard page is opened");
        return this;
    }

    @Step("Open project '{projectName}'")
    public DashboardPage clickOnCreatedProject(String projectName) {
        String projectNameXPath = String.format(PROJECT_NAME_PATTERN, projectName);
        $x(projectNameXPath).click();
        return this;
    }
}

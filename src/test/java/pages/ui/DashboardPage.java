package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DashboardPage extends BasePage {

    private final SelenideElement
            DASHBOARD_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            BACK_TO_DASHBOARD_BUTTON = $("[data-testid='backToDashboardButton']"),
            ADMIN_BUTTON = $("[data-testid='navigationUser']");
    private final String PROJECT_NAME_PATTERN = "//a[text()='%s' and @style]";

    @Step("Open Dashboard page")
    public DashboardPage openDashboardPage() {
        BACK_TO_DASHBOARD_BUTTON.shouldBe(visible).click();
        return this;
    }

    @Step("Dashboard page is open")
    public DashboardPage isPageOpened() {
        DASHBOARD_TITLE.shouldBe(visible);
        log.info("Dashboard page is open");
        return this;
    }

    @Step("Open project '{projectName}'")
    public DashboardPage clickOnCreatedProject(String projectName) {
        String projectNameXPath = String.format(PROJECT_NAME_PATTERN, projectName);
        $x(projectNameXPath).click();
        log.info("Project {} is open", projectName);
        return this;
    }

    @Step("Open admin page")
    public DashboardPage openAdminPage() {
        ADMIN_BUTTON.click();
        log.info("Open admin page");
        return this;
    }
}

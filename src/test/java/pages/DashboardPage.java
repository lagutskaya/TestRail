package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {

    private final SelenideElement DASHBOARD_TITLE = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement ADD_PROJECT_BUTTON = $("[data-testid='sidebarProjectsAddButton']");

    public void isPageOpened() {
        DASHBOARD_TITLE.shouldBe(visible);
    }

    public void clickOnAddProjectButton() {
        ADD_PROJECT_BUTTON.click();
    }
}

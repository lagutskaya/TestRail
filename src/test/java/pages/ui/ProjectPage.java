package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class ProjectPage extends BasePage {

    private final SelenideElement
            TEST_CASES_PAGE = $("[data-testid='navigateToCasesButton']"),
            PROJECT_TITLE = $("[data-testid='testCaseContentHeaderTitle']");
    private final String OPEN_PROJECT_PATTERN = "//a[contains(@href,'/projects/overview/%d') and text()='%s']]";


    @Step("Open project page")
    public ProjectPage isPageOpened() {
        PROJECT_TITLE.shouldBe(visible);
        log.info("Project page is open");
        return this;
    }

    @Step("Open created project")
    public ProjectPage openCreatedProject(String projectName) {
        String projectNameXPath = String.format(OPEN_PROJECT_PATTERN, projectName);
        $x(projectNameXPath).click();
        log.info("Project {} is open", projectName);
        return this;
    }

    @Step("Open project's test cases")
    public ProjectPage openTestCases() {
        TEST_CASES_PAGE.click();
        log.info("Test cases page is opened");
        return this;
    }
}

package pages.UI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class TestCasesPage {

    private final SelenideElement
            TEST_CASES_BUTTON = $("[data-testid='navigateToCasesButton']"),
            TEST_CASES_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            ADD_SECTION_BUTTON = $("[data-testid='addSectionInline']");

    @Step("Test Cases page is opened")
    public TestCasesPage isPageOpened() {
        TEST_CASES_TITLE.shouldBe(visible);
        log.info("Test cases page is opened");
        return this;
    }

    @Step("Open project's test cases")
    public TestCasesPage openProjectsTestCases() {
        TEST_CASES_BUTTON.click();
        log.info("Project's test cases is opened");
        return this;
    }

    @Step("Click on add section button")
    public TestCasesPage clickOnAddSectionButton() {
        ADD_SECTION_BUTTON.shouldBe(clickable).click();
        log.info("'Add section button' button is clicked");
        return this;
    }

}

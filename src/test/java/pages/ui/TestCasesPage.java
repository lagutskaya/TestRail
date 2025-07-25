package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestCasesPage {

    private final SelenideElement
            TEST_CASES_BUTTON = $("[data-testid='navigateToCasesButton']"),
            TEST_CASES_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            ADD_TEST_CASE_BUTTON = $(By.xpath("//div[@class='button-group']/a[not (@data-testid)]")),
            SAVE_TEST_CASE_BUTTON = $($(By.id("accept"))),
            TEST_CASE_MODAL = $(By.id("noSectionContainer")),
            TEST_CASE_TITLE = $("[data-testid='addEditCaseTitle']"),
            ERROR_MESSAGE = $("[class='message message-error']");

    @Step("Test Cases page is opened")
    public TestCasesPage isPageOpened() {
        TEST_CASES_TITLE.shouldBe(visible);
        log.info("Test cases page is opened");
        return this;
    }

    @Step("Open project's test cases")
    public TestCasesPage openProjectsTestCases() {
        TEST_CASES_BUTTON.click();
        TEST_CASE_MODAL.shouldBe(visible);
        log.info("Project's test cases is opened");
        return this;
    }

    @Step("Click on add test case button")
    public TestCasesPage clickOnAddTestCaseButton() {
        ADD_TEST_CASE_BUTTON.click();
        log.info("'Add test case' button is clicked");
        return this;
    }

    @Step("Set values for test case")
    public TestCasesPage setTestCase(String testCaseTitle) {
        TEST_CASE_TITLE.setValue(testCaseTitle);
        log.info("Test case is filled");
        return this;
    }

    @Step("Click on save test case button")
    public TestCasesPage clickSaveTestCaseButton() {
        SAVE_TEST_CASE_BUTTON.scrollIntoView(true);
        SAVE_TEST_CASE_BUTTON.submit();
        log.info("'Save test case' button is clicked");
        return this;
    }

    @Step("Check invisibility of test case")
    public boolean isTestCaseIsNotCreated() {
        ERROR_MESSAGE.shouldHave(text("Field Title is a required field."));
        log.info("Error message is visible");
        return true;
    }
}

package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestSectionPage extends BasePage {
    private final SelenideElement
            SECTION_NAME_FIELD = $("[data-testid='editSectionName']"),
            SECTION_DESCRIPTION_FIELD =
                    $(By.xpath(
                            "//div[@data-testid='editSectionDescription' " +
                                    "and @id='editSectionDescription_display']")),
            CREATE_SECTION_BUTTON = $("[data-testid='addSectionInline']"),
            TEST_SECTION_MODAL_WINDOW = $(By.id("ui-dialog-title-editSectionDialog")),
            ADD_CASE_BUTTON = $(By.xpath("//span[@data-testid='suiteAddCaseLink']")),
            CASE_TITLE_FIELD = $(By.xpath("//input[@name='title']")),
            CASE_TITLE_SUBMIT = $("[data-testid='iconButtonAccept']"),
            MODAL_WINDOW_CREATE_TEST_SECTION = $(By.id("editSectionForm"));


    @Step("Test section page is opened")
    public TestSectionPage isPageOpened() {
        CREATE_SECTION_BUTTON.shouldBe(visible);
        log.info("Test section page is opened");
        return this;
    }

    @Step("Create new test section")
    public TestSectionPage setTestSection(String sectionName) {
        CREATE_SECTION_BUTTON.click();
        SECTION_NAME_FIELD.setValue(sectionName);
        SECTION_NAME_FIELD.shouldHave(value(sectionName));
        log.info("Test section is filled");
        return this;
    }

    @Step("Click on 'Create test section' button")
    public TestSectionPage clickOnCreateSectionButton() {
        CREATE_SECTION_BUTTON.click();
        log.info("'Create test section' button is clicked");
        return this;
    }

    @Step("Verify created test section")
    public boolean testSectionIsCreated() {
        TEST_SECTION_MODAL_WINDOW.shouldNotBe(visible);
        log.info("Test section is created");
        return true;
    }

    @Step("Add test case in test section")
    public TestSectionPage addCaseInSection(String caseTitle) {
        ADD_CASE_BUTTON.shouldBe(visible).click();
        CASE_TITLE_FIELD.setValue(caseTitle);
        CASE_TITLE_SUBMIT.click();
        log.info("Test case added in test section");
        return this;
    }
}

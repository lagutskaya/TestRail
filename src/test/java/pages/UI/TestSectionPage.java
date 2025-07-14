package pages.UI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageSettings.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestSectionPage extends BasePage {
    private final SelenideElement
            SECTION_NAME_FIELD = $("[data-testid='editSectionName']"),
            SECTION_DESCRIPTION_FIELD =
                    $(By.xpath(
                            "//div[@data-testid='editSectionDescription' " +
                                    "and @id='editSectionDescription_display']")),
            CREATE_SECTION_BUTTON = $("[data-testid='editSectionSubmit']"),
            TEST_SECTION_MODAL_WINDOW = $(By.id("ui-dialog-title-editSectionDialog")),
            ADD_CASE_BUTTON = $(By.xpath("//span[@data-testid='suiteAddCaseLink']")),
            CASE_TITLE_FIELD = $(By.xpath("//input[@name='title']")),
            CASE_TITLE_SUBMIT = $("[data-testid='iconButtonAccept']");
    private final String TEST_CASE_TITLE_PATTERN = "//*[@data-testid='sectionCaseTitle' and text()='%s']";


    public TestSectionPage(WebDriver driver) {
        super();
    }

    @Step("Test section page is opened")
    public TestSectionPage isPageOpened() {
        CREATE_SECTION_BUTTON.shouldBe(visible);
        log.info("Test section page is opened");
        return this;
    }

    @Step("Create new test section")
    public TestSectionPage createTestSection(String sectionName, String sectionDescription) {
        SECTION_NAME_FIELD.setValue(sectionName);
        SECTION_DESCRIPTION_FIELD.setValue(sectionDescription);
        CREATE_SECTION_BUTTON.submit();
        log.info("Test section is created");
        return this;
    }

    public boolean testSectionIsCreated() {
        TEST_SECTION_MODAL_WINDOW.shouldBe(visible);
        return true;
    }

    @Step("Add test case in test section")
    public TestSectionPage addCaseInSection(String caseTitle) {
        ADD_CASE_BUTTON.shouldBe(visible).click();
        CASE_TITLE_FIELD.setValue(caseTitle);
        CASE_TITLE_SUBMIT.submit();
        log.info("Test case added in test section");
        return this;
    }

    public boolean caseIsCreated(String testCaseTitle) {
        String testCaseTitleXPath = String.format(TEST_CASE_TITLE_PATTERN, testCaseTitle);
        $x(testCaseTitleXPath).click();
        return true;
    }

}

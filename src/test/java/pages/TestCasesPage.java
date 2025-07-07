package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage {

    private final SelenideElement TEST_CASES_BUTTON = $("[data-testid='navigateToCasesButton']");
    private final SelenideElement TEST_CASES_TITLE = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement ADD_SECTION_BUTTON = $("[data-testid='addSectionInline']");
    private final SelenideElement SECTION_NAME_FIELD = $("[data-testid='editSectionName']");
    private final SelenideElement SECTION_DESCRIPTION_FIELD = $("editSectionDescription");
    private final SelenideElement CREATE_SECTION_BUTTON = $("[data-testid='editSectionSubmit']");

    public void isPageOpened() {
        TEST_CASES_TITLE.shouldBe(visible);
    }

    public void openProjectsTestCases() {
        TEST_CASES_BUTTON.click();
    }

    public void ClickOnAddSectionButton() {
        ADD_SECTION_BUTTON.click();
    }

    public void createTestSection(String sectionName, String sectionDescription) {
        SECTION_NAME_FIELD.setValue(sectionName);
        SECTION_DESCRIPTION_FIELD.setValue(sectionDescription);
        CREATE_SECTION_BUTTON.submit();
    }

}

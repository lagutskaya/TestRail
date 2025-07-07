package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {

    private final SelenideElement ADD_PROJECT_TITLE = $("[data-testid='testCaseContentHeaderTitle']");
    private final SelenideElement PROJECT_NAME_FIELD = $("[data-testid='addProjectNameInput']");
    private final SelenideElement PROJECT_ANNOUNCEMENT_FIELD = $("[data-testid='addEditProjectAnnouncement']");
    private final SelenideElement SHOW_ANNOUNCEMENT_CHECKBOX = $("[data-testid='addEditProjectShowAnnouncement']");
    private final SelenideElement ADD_PROJECT_BUTTON = $("[data-testid='addEditProjectAddButton']");

    public void isPageOpened() {
        ADD_PROJECT_TITLE.shouldBe(visible);
    }

    public void createNewProject(String projectName, String projectAnnouncement) {
        PROJECT_NAME_FIELD.setValue(projectName);
        PROJECT_ANNOUNCEMENT_FIELD.setValue(projectAnnouncement);
        SHOW_ANNOUNCEMENT_CHECKBOX.click();
        ADD_PROJECT_BUTTON.click();
    }
}

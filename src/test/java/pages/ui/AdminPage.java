package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AdminPage extends BasePage {

    private final SelenideElement
            PROJECTS_PAGE = $("[data-testid='administrationSidebarProjects']"),
            PROJECT_DELETE_BUTTON = $("[data-testid='projectDeleteButton']"),
            CHECKBOX_DELETE_PROJECT = $(By.xpath(
                    "//span[contains(@class, 'dialog-confirm-busy')]" +
                            "/ancestor::label//input[@data-testid='deleteCheckBoxTestId']")),
            OK_BUTTON_IN_MODAL_FOR_DELETE_PROJECT = $("[data-testid='caseFieldsTabDeleteDialogButtonOk']"),
            SUCCESS_MESSAGE = $("[data-testid='messageSuccessDivBox']"),
            EDIT_PROJECT_BUTTON = $("[data-testid='projectEditButton']"),
            SAVE_PROJECT_BUTTON = $("[data-testid='addEditProjectAddButton']"),
            PROJECT_DESCRIPTION_FIELD = $("[data-testid='addEditProjectAnnouncement']");

    @Step("Admin page is opened")
    public AdminPage isPageOpened() {
        PROJECTS_PAGE.shouldBe(visible);
        log.info("Admin page is opened");
        return this;
    }

    @Step("Open projects page")
    public AdminPage openProjectsPage() {
        PROJECTS_PAGE.click();
        log.info("Projects page is opened");
        return this;
    }

    @Step("Delete project")
    public AdminPage deleteProject(String projectName) {
        PROJECT_DELETE_BUTTON.click();
        CHECKBOX_DELETE_PROJECT.click();
        OK_BUTTON_IN_MODAL_FOR_DELETE_PROJECT.click();
        log.info("Delete {} project ", projectName);
        return this;
    }

    @Step("Project is deleted")
    public boolean isProjectDeleted() {
        SUCCESS_MESSAGE.shouldHave(text("Successfully deleted the project.")).shouldBe(visible);
        log.info("Project is deleted");
        return true;
    }

    @Step("Update project description")
    public AdminPage updateProjectDescription(String projectName, String updatedProjectDescription) {
        EDIT_PROJECT_BUTTON.click();
        PROJECT_DESCRIPTION_FIELD.shouldBe(visible).clear();
        PROJECT_DESCRIPTION_FIELD.setValue(updatedProjectDescription);
        SAVE_PROJECT_BUTTON.scrollIntoView(true);
        SAVE_PROJECT_BUTTON.click();
        log.info("The project description {} has been updated to {}", projectName, updatedProjectDescription);
        return this;
    }

    @Step("Project description is updated")
    public boolean isProjectDescriptionUpdated() {
        SUCCESS_MESSAGE.shouldHave(text("Successfully updated the project.")).shouldBe(visible);
        log.info("Project description updated");
        return true;
    }
}

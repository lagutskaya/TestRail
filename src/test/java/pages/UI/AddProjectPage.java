package pages.UI;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AddProjectPage {

    private final SelenideElement
            ADD_PROJECT_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            PROJECT_NAME_FIELD = $("[data-testid='addProjectNameInput']"),
            PROJECT_ANNOUNCEMENT_FIELD = $("[data-testid='addEditProjectAnnouncement']"),
            SHOW_ANNOUNCEMENT_CHECKBOX = $("[data-testid='addEditProjectShowAnnouncement']"),
            ADD_PROJECT_BUTTON = $("[data-testid='sidebarProjectsAddButton']"),
            MODAL_WINDOW = $(By.id("pendo-close-guide-b5501343")),
            CREATE_PROJECT_BUTTON = $("[data-testid='addEditProjectAddButton']");


    @Step("Click on 'Add new project' button")
    public AddProjectPage clickOnAddNewProjectButton() {
        try {
            log.info("Modal window with ads is opened");
            (MODAL_WINDOW)
                    .shouldBe(visible, Duration.ofSeconds(3))
                    .click();
        } catch (ElementNotFound | TimeoutException e) {
            log.info("Modal window with ads is closed");
        }
        ADD_PROJECT_BUTTON.click();
        log.info("Project button is clicked");
        return this;
    }

    @Step("Verify project page is opened")
    public AddProjectPage isPageOpened() {
        ADD_PROJECT_TITLE.shouldBe(visible);
        log.info("Create project page is opened");
        return this;
    }

    @Step("Create new project with name: '{projectName}' and announcement: '{projectAnnouncement}'")
    public AddProjectPage createNewProject(String projectName, String projectAnnouncement) {
        PROJECT_NAME_FIELD.setValue(projectName);
        PROJECT_ANNOUNCEMENT_FIELD.setValue(projectAnnouncement);
        SHOW_ANNOUNCEMENT_CHECKBOX.click();
        actions()
                .scrollToElement(CREATE_PROJECT_BUTTON)
                .perform();
        CREATE_PROJECT_BUTTON.click();
        log.info("Project {} is created ", projectName);
        return this;
    }
}

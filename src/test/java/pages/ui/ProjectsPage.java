package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsPage {

    private final SelenideElement
            SUCCESS_CREATED_PAGE_MESSAGE = $("[data-testid='messageSuccessDivBox']"),
            PROJECTS_TITLE = $("[data-testid='testCaseContentHeaderTitle']"),
            ERROR_MESSAGE = $("[class='message message-error']");


    @Step("Projects page is opened")
    public ProjectsPage isPageOpened() {
        PROJECTS_TITLE.shouldBe(visible);
        log.info("Projects page is opened");
        return this;
    }

    @Step("Project is created")
    public boolean projectIsCreated() {
        SUCCESS_CREATED_PAGE_MESSAGE.shouldBe(visible);
        log.info("Project is created");
        return true;
    }

    @Step("Project isn't created")
    public boolean projectIsNotCreated() {
        ERROR_MESSAGE.shouldBe(visible);
        log.info("Project is created");
        return true;
    }
}

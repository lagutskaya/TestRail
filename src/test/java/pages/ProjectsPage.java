package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {

    private final SelenideElement SUCCESS_CREATED_PAGE_MESSAGE = $("[data-testid='messageSuccessDivBox']");

    public void isPageOpened() {

    }

    public boolean projectIsCreated() {
        SUCCESS_CREATED_PAGE_MESSAGE.shouldBe(visible);
        return true;
    }

    public void openProject(String projectName) {
        $(By.xpath("//a[contains(@class, 'project-name') and text()='" + projectName + "']"))
                .shouldBe(Condition.visible).click();
    }
}

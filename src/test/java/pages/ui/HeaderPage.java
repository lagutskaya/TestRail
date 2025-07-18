package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

//@Log4j2
public class HeaderPage extends BasePage {

    private final SelenideElement
            USER_DROPDOWN = $(By.xpath("//a[@data-testid='userDropdown']")),
            LOG_OUT_BUTTON = $("[data-testid='logoutButton']"),
            SIGN_IN_FORM = $("[data-testid='loginPageForm']");

    @Step("Open User drop down")
    public HeaderPage logout() {
        USER_DROPDOWN.shouldBe(visible).click();
        LOG_OUT_BUTTON.shouldBe(visible).click();
        //   log.info("User dropdown is open");
        return this;
    }

    @Step("User is log out")
    public boolean userIslogout() {
        SIGN_IN_FORM.shouldBe(visible);
        //   log.info("User is log out");
        return true;
    }
}

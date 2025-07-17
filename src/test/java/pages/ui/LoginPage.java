package pages.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.page_settings.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    private final SelenideElement
            LOGIN_FIELD = $("[data-testid='loginIdName']"),
            PASSWORD_FIELD = $("[data-testid='loginPasswordFormDialog']");

    @Step("Open Login page")
    public LoginPage openPage() {
        open(base_url);
        log.info("Open Login page");
        return this;
    }

    @Step("Login page is open")
    public LoginPage isPageOpened() {
        LOGIN_FIELD.shouldBe(visible);
        log.info("Login page is open");
        return this;
    }

    @Step("Login")
    public LoginPage login() {
        LOGIN_FIELD.setValue(user);
        PASSWORD_FIELD.setValue(password).submit();
        log.info("User is log in");
        return this;
    }
}



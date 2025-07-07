package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    private final SelenideElement LOGIN_FIELD = $("[data-testid='loginIdName']");
    private final SelenideElement PASSWORD_FIELD = $("[data-testid='loginPasswordFormDialog']");

    public void openPage() {
        open();
    }

    public void isPageOpened() {
        LOGIN_FIELD.shouldBe(visible);
    }

    public void login() {
        LOGIN_FIELD.setValue(user);
        PASSWORD_FIELD.setValue(password).submit();
    }
}



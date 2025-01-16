package screens.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SkipButtonComponent {
    private final SelenideElement skipButtonLocator = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Нажать на кнопку Skip")
    public void clickSkipButton() {
        $(skipButtonLocator).click();
    }
}

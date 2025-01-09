package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorScreen {

    private final SelenideElement errorFieldElement = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    @Step("Проверить, что произошла ошибка")
    public void checkError(String textError) {

        assertThat(errorFieldElement).isNotNull();

        String errorOnPage = errorFieldElement.getAttribute("text");
        assertThat(errorOnPage).isEqualTo(textError);
    }
}
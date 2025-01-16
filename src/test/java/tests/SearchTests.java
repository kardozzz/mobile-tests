package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ErrorScreen;
import screens.LanguageScreen;
import screens.MainScreen;
import screens.SearchResultScreen;
import screens.components.SkipButtonComponent;

@DisplayName("Тесты на поиск статей")
@Tag("mobile")
public class SearchTests extends TestBase {

    private final MainScreen mainScreen = new MainScreen();
    private final SearchResultScreen searchResultScreen = new SearchResultScreen();
    private final ErrorScreen errorScreen = new ErrorScreen();
    private final SkipButtonComponent skipButtonComponent = new SkipButtonComponent();
    @DisplayName("Тест на успешный поиск")
    @Test
    void successfulSearchTest() {
        skipButtonComponent.clickSkipButton();
        mainScreen.searchQuery("Appium");
        searchResultScreen.checkSearchResult();
    }

    @DisplayName("Тест на не успешный поиск")
    @Test
    void findSpringBootTest() {
        skipButtonComponent.clickSkipButton();
        mainScreen.searchQuery("Spring Boot");
        searchResultScreen.checkSearchResult();

    }

}
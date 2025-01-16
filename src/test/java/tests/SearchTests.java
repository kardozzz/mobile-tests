package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ErrorScreen;
import screens.MainScreen;
import screens.SearchResultScreen;

@DisplayName("Тесты на поиск статей")
@Tag("mobile")
public class SearchTests extends TestBase {

    private final MainScreen mainScreen = new MainScreen();
    private final SearchResultScreen searchResultScreen = new SearchResultScreen();
    private final ErrorScreen errorScreen = new ErrorScreen();

    @DisplayName("Тест на успешный поиск")
    @Test
    void successfulSearchTest() {
        mainScreen.searchQuery("Appium");
        searchResultScreen.checkSearchResult();
    }

    @DisplayName("Тест на не успешный поиск")
    @Test
    void findSpringBootTest() {
        mainScreen.searchQuery("Spring Boot");
        searchResultScreen.openArticle();
        errorScreen.checkError("An error occurred");
    }

}
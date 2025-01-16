package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.DataAndPrivacyScreen;
import screens.ExploreScreen;
import screens.LanguageScreen;
import screens.ReadingListsScreen;
import screens.components.ContinueButtonComponent;
import screens.components.SkipButtonComponent;

@DisplayName("Тесты на онбординг")
@Tag("mobile")
public class OnboardingTests extends TestBase {

    private final LanguageScreen languageScreen = new LanguageScreen();
    private final ContinueButtonComponent continueButtonComponent = new ContinueButtonComponent();
    private final ExploreScreen exploreScreen = new ExploreScreen();
    private final ReadingListsScreen readingListsScreen = new ReadingListsScreen();
    private final DataAndPrivacyScreen dataAndPrivacyScreen = new DataAndPrivacyScreen();
    private final SkipButtonComponent skipButtonComponent = new SkipButtonComponent();

    @DisplayName("Тест начального экрана")
    @Test
    void onboardingScreenTest() {
        languageScreen.checkVisibilityOfDefaultLanguage();
        continueButtonComponent.clickContinueButton();
        exploreScreen.checkTextInPrimaryTextView();
        continueButtonComponent.clickContinueButton();
        readingListsScreen.checkJoinWikipediaText();
        continueButtonComponent.clickContinueButton();
        dataAndPrivacyScreen.checkVisibilityOfSecondaryTextView();
    }

    @DisplayName("Тест пропуска онбординга")
    @Test
    void skipOnboardingScreenTest() {
        languageScreen.checkVisibilityOfDefaultLanguage();
        skipButtonComponent.clickSkipButton();
        exploreScreen.checkOpenExplorePage();
    }
}
package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthWikiConfig;
import config.BrowserstackDriverConfig;
import config.ConfigReader;
import helpers.BrowserstackFileHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final BrowserstackDriverConfig config;
    private final AuthWikiConfig authWikiConfig;

    public BrowserstackDriver() {
        this.config = ConfigReader.INSTANCE.readBrowserstackConfig();
        this.authWikiConfig = ConfigReader.INSTANCE.readAuthWikiConfig();
    }

    BrowserstackFileHelper browserstackFileHelper = new BrowserstackFileHelper();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authWikiConfig.user());
        caps.setCapability("browserstack.key", authWikiConfig.key());
        caps.setCapability("app", browserstackFileHelper.checkUploadedAppsList());
        caps.setCapability("device", config.getDevice());
        caps.setCapability("os_version", config.getOsVersion());

        try {
            return new RemoteWebDriver(
                    new URL(config.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
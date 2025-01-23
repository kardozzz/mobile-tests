package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final BrowserstackDriverConfig browserstackConfig =
            ConfigFactory.create(
                    BrowserstackDriverConfig.class,
                    System.getProperties()
            );
    private static final AuthWikiConfig authWikiConfig =
            ConfigFactory.create(
                    AuthWikiConfig.class,
                    System.getProperties()
            );

    public BrowserstackDriverConfig readBrowserstackConfig() {
        return browserstackConfig;
    }

    public AuthWikiConfig readAuthWikiConfig() {
        return authWikiConfig;
    }
}
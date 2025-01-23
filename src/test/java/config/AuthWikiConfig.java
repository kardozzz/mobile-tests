package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth.properties"
})
public interface AuthWikiConfig extends Config {

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();
}
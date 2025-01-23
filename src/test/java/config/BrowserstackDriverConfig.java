package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface BrowserstackDriverConfig extends Config {

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();
}
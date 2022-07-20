package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        {"classpath:${env}.properties"})


public interface WebConfig extends Config {
    @Key("browser.name")
    @DefaultValue("CHROME")
    String browserName();

    @Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("baseURL")
    @DefaultValue("https://github.com")
    String baseURL();

    @Key("remoteURL")
    String remoteURL();

}

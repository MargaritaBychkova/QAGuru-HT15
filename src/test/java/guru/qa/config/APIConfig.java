package guru.qa.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties"})

public interface APIConfig extends Config{
    @Key("baseURI")
    String baseURI();

    @Key("email")
    String email();
}

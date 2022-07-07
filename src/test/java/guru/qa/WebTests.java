package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WebTests {
    @BeforeAll
    static void setUp(){
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.baseUrl = config.baseURL();
        Configuration.remote = config.remoteURL();
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
    }

    @Test
    @DisplayName("Проверка поиска в Wiki проекта Selenide")
    public void selenideWikiSearchTest (){

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box ul li button").click();
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $$(".markdown-body").find(Condition.text("Using JUnit5 extend test class")).shouldBe(Condition.visible);
    }
}

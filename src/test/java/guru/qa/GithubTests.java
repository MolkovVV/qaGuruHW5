package guru.qa;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {
    SelenideElement dropdown;

    @BeforeEach
    public void setBasicConfiguration() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    public void openEnterprisePageFromNavMenu() {
        open("");
        $$("button.HeaderMenu-link").findBy(text("Solutions")).hover();
        dropdown = $$(".HeaderMenu-dropdown").findBy(visible);
        dropdown.shouldHave(text("Enterprise"));
        dropdown.$$("a").findBy(text("Enterprise"))
                .click();
        $("h4.h6-mktg").shouldHave(text("GitHub for enterprises"));
        $("h1.h1-mktg").shouldHave(text("Build like the best"));
    }
}

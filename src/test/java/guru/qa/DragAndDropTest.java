package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest{
    @BeforeEach
    public void setBasicConfiguration(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    public void rectangleShouldBeDragAndDrop(){
        open("drag_and_drop");
        $("#column-a").dragAndDropTo(element("#column-b"));
        $("#column-a header").shouldHave(text("b"));
        $("#column-b header").shouldHave(text("a"));
    }

    @Test
    public void rectangleShouldBeRemoveWithActions(){
        open("drag_and_drop");
        Selenide.actions().clickAndHold(element("#column-a")).moveToElement(element("#column-b")).click();
        $("#column-a header").shouldHave(text("b"));
        $("#column-b header").shouldHave(text("a"));
    }
}

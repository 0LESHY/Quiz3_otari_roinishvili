import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
@Listeners({ScreenShooter.class})
public class SelenideTests {
    public SelenideTests(){
        reportsFolder = "src/main/resources/Failed";
    }

    @Test
    public void dropdownTest() {
        baseUrl="https://the-internet.herokuapp.com/dropdown";

        open(baseUrl);

        $("#dropdown").selectOption("Option 2");

        Assert.assertEquals("Option 2", Selenide.$("#dropdown").getSelectedText());
    }

    @Test
    public void inputTest(){
        baseUrl="https://the-internet.herokuapp.com/inputs";

        open(baseUrl);

        $("input[type=\"number\"]").setValue("100");

        Assert.assertTrue(Selenide.$("input[type=\"number\"]").getAttribute("value").isEmpty());

        sleep(3000);
    }
}

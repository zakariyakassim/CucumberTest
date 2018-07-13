
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features={"src/test/java/assessment.feature"}
)

public class WebTest {




}

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    WebDriver driver;

    ExtentReports extent;

    ExtentTest test;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        extent = new ExtentReports(Constants.report_file,true);

        test = extent.startTest("reportTesting");


        if (driver != null) {
            driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        }

    }


    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();


        extent.endTest(test);
        extent.flush();

    }

}

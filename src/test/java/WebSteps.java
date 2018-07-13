import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class WebSteps {


    WebDriver driver;

    ExtentReports extent;

    ExtentTest test;

    DashboardPage dashboardPage;



    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        extent = new ExtentReports(Constants.report_file,true);

        test = extent.startTest("reportTesting");


        if (driver != null) {
            driver.get(Constants.login);
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();

        extent.endTest(test);
        extent.flush();

    }



    @Given("^the login page$")
    public void the_login_page() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.handleSignIn(Constants.username,Constants.password);

        if (driver.getCurrentUrl().equals(Constants.login)) {
            test.log(LogStatus.INFO, "Login page.");
        }



    }

    @When("^I login$")
    public void I_login() {



        test.log(LogStatus.PASS, "Logged in");

        assertTrue(!Constants.login.equals(driver.getCurrentUrl()));

        if (driver.getCurrentUrl().equals(Constants.retryLogin)){
            test.log(LogStatus.FAIL, "Wrong username or password.");
        } else if (driver.getCurrentUrl().equals(Constants.loginSuccessful)) {
            test.log(LogStatus.PASS, "Login successful.");
        }



    }

    @When("^I click the PIM tab$")
    public void I_click_the_PIM_tab() {

        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);

        dashboardPage.getPimTab().click();

        test.log(LogStatus.PASS, "Successfully clicked on the PIM tab.");


    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException {

        Thread.sleep(3000);

        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);

        dashboardPage.addEmployee.click();

        test.log(LogStatus.PASS, "Successfully clicked on the Add Employee tab.");

    }

    @When("^I fill out the Employee Details correctly$")
    public void I_fill_out_the_Employee_Details_correctly() {

        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        addEmployeeForm.fillOutEmployeeDetails();


        test.log(LogStatus.PASS, "Successfully filled out the employee details.");

    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void I_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);


        addEmployeeForm.loginDetailsCheckBox();

        test.log(LogStatus.PASS, "Successfully checked the login details checkbox.");

    }

    @When("^I fill out the Login Details correctly$")
    public void I_fill_out_the_Login_Details_correctly() throws InterruptedException {
        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);

        Thread.sleep(1000);

        addEmployeeForm.fillOutLoginDetails();

        test.log(LogStatus.PASS, "Successfully filled out the employee login details.");
    }

    @When("^I click the Save button$")
    public void I_click_the_Save_button() throws InterruptedException {
        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);


        Thread.sleep(2000);
        addEmployeeForm.clickSaveButton();

        test.log(LogStatus.PASS, "Successfully saved the employee details.");


    }

    @Then("^I can search for the Employee I have just created$")
    public void I_can_search_for_the_Employee_I_have_just_created() {

        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        addEmployeeForm.searchEmployee();


        test.log(LogStatus.PASS, "Successfully searched.");

    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() {

        AddEmployeeForm addEmployeeForm = PageFactory.initElements(driver , AddEmployeeForm.class);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        addEmployeeForm.selectEmployee();
    }


}

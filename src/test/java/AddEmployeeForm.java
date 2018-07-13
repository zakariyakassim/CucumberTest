import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AddEmployeeForm {

    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    WebElement pimTab;
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "middleName")
    WebElement middleName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "employeeId")
    WebElement employeeId;


    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    WebElement locationDropDown;


    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    WebElement createLoginDetailsSelector;

    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "confirmPassword")
    WebElement txtConfirmPassword;

    @FindBy(id = "systemUserSaveBtn")
    WebElement btnSave;

    @FindBy(id = "employee_name_quick_filter_employee_list_value")
            WebElement txtSearch;


    String _firstName = nameGen();
    String _middleName = nameGen();
    String _lastName = nameGen();


    public void fillOutEmployeeDetails() {

        firstName.sendKeys(_firstName);
        middleName.sendKeys(_middleName);
        lastName.sendKeys(_lastName);


        locationDropDown.click();
        locationDropDown.sendKeys(Keys.chord("l"));
        locationDropDown.sendKeys(Keys.ENTER);


    }

    public void loginDetailsCheckBox() {


        createLoginDetailsSelector.click();


    }

    public void fillOutLoginDetails() {


        txtUsername.sendKeys(usernameGen());

        String password = passwordGen();

        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(password);





    }


    public void clickSaveButton() {

        btnSave.click();

        btnSave.submit();

    }


    public void searchEmployee(){
        txtSearch.sendKeys(_firstName);
        txtSearch.sendKeys(Keys.ENTER);

    }



    public void selectEmployee(){

    }



    public String nameGen() {

        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

        final java.util.Random rand = new java.util.Random();

        // consider using a Map<String,Boolean> to say whether the identifier is being used or not
        final Set<String> identifiers = new HashSet<String>();

        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }




    public String usernameGen(){
        Random rnd = new Random();
        String firstname = _firstName;
        String lastname = _lastName;

        String result;

        result = Character.toString(firstname.charAt(0)); // First char
        if (lastname.length() > 5)
            result += lastname.substring(0, 5);
        else
            result += lastname;
        result += Integer.toString(rnd.nextInt(99));

        return result;

    }

    public String passwordGen(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String pwd = RandomStringUtils.random( 15, characters );

        return pwd;
    }

}

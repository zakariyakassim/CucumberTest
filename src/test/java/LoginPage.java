import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "txtUsername")
    WebElement txtUserName;

    @FindBy(id = "txtPassword")
    WebElement txtPassword;

    @FindBy(id = "btnLogin")
    WebElement btnSignIn;

    public void handleSignIn(String username, String password){

        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSignIn.submit();

    }

}

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {



    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    WebElement pimTab;
    @FindBy(id = "menu_pim_addEmployee")
    WebElement addEmployee;


    public WebElement getAddEmployee() {
        return addEmployee;
    }

    public WebElement getPimTab() {
        return pimTab;
    }
}

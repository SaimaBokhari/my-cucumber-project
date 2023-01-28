package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(partialLinkText = "Login")  // it's got <a which means anchor/link
    public WebElement homePageLoginButton;

    @FindBy(id="dropdown-basic-button")
    public WebElement userId;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;


}

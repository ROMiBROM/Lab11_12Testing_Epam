package Page_object.page;

import Page_object.Model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyHomePage {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;


    @FindBy(xpath = "//button[@class='Button-sc-qlcn5g-0 jsmWVV']")
    private WebElement buttonOpenLoginForm;
    @FindBy(xpath = "//input[@id='login-username']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='login-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement buttonLoginIntoAccount;

    public SpotifyHomePage loginIntoAccount(User user) {
        buttonOpenLoginForm.click();
        waitForElementLocatedBy(driver,inputEmail);
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonLoginIntoAccount.click();
        logger.info("Main page opened!");
        return this;
    }

    public SpotifyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.elementToBeClickable(by));
    }



    public SpotifyHomePage openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, Duration.ofMillis(20));
        return this;
    }
}

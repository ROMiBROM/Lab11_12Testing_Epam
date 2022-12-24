package Page_object.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SpotifyMakePublicPlaylist {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    @FindBy(xpath = "//div/div/li[a/span/text()='ChillIN123']" )
    WebElement buttonPlayList4;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/div/section/div[2]/div[2]/div[4]/div/div/div/div/button")
    WebElement buttonProperties;

    @FindBy(xpath = "//*[@id=\"context-menu\"]/ul/li[3]/button")
    WebElement buttonProfile;

    @FindBy(xpath = "/html/body/div[17]/div/div/div/div[2]/div[4]/button")
    WebElement buttonSave;


    public SpotifyMakePublicPlaylist(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean MakePublic()
    {

        try{
            waitForElementLocatedBy(driver, buttonPlayList4);
            buttonPlayList4.click();
            waitForElementLocatedBy(driver,buttonProperties );
            buttonProperties.click();
            waitForElementLocatedBy(driver,buttonProfile );
            buttonProfile.click();
            logger.info("Playlist Made public!");
            sleep(2000);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }

    }
    public void AfterM()
    {
        waitForElementLocatedBy(driver,buttonProperties );
        buttonProperties.click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementLocatedBy(driver,buttonProfile );
        buttonProfile.click();
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

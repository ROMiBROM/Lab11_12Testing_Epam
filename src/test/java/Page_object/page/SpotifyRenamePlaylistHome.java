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

public class SpotifyRenamePlaylistHome {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    @FindBy(xpath = "//div/div/li[a/span/text()='Top']" )
    WebElement buttonPlayList4;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/div/section/div[1]/div[5]/span/button/span/h1")
    WebElement buttonNamePlaylist;

    @FindBy(xpath = "/html/body/div[17]/div/div/div/div[2]/div[2]/input")
    WebElement InputNamePlaylist;

    @FindBy(xpath = "/html/body/div[17]/div/div/div/div[2]/div[4]/button")
    WebElement buttonSave;


    public SpotifyRenamePlaylistHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean RenameSong()
    {

        try{
            waitForElementLocatedBy(driver, buttonPlayList4);
            buttonPlayList4.click();
            waitForElementLocatedBy(driver,buttonNamePlaylist );
            buttonNamePlaylist.click();
            waitForElementLocatedBy(driver,InputNamePlaylist );
            InputNamePlaylist.sendKeys("ChillIN");
            waitForElementLocatedBy(driver,buttonSave );
            buttonSave.click();
            logger.info("Playlist was renamed!");
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
        waitForElementLocatedBy(driver,buttonNamePlaylist );
        buttonNamePlaylist.click();
        waitForElementLocatedBy(driver,InputNamePlaylist );
        InputNamePlaylist.click();
        InputNamePlaylist.clear();
        InputNamePlaylist.sendKeys("Top");
        waitForElementLocatedBy(driver,buttonSave );
        buttonSave.click();
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

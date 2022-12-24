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

public class SpotifySongQueueHome {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a" )
    WebElement SearchAreaButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[3]/div/div/form/input")
    WebElement SearchArea;
    @FindBy(xpath = "//*[@id=\"searchPage\"]/div/div/section[2]/div[2]/div/div/div/div[2]/div[1]/div")
    WebElement SongAtSearch;
    @FindBy(xpath = "//*[@id=\"searchPage\"]/div/div/section[2]/div[2]/div/div/div/div[2]/div[1]/div/div[2]/button[2]")
    WebElement buttonOptionsAtSong;

    @FindBy(xpath = "//*[@id=\"context-menu\"]/ul/li[1]")
    WebElement buttontoAddAtQueue;


    public SpotifySongQueueHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean AddSongAtQueue(String song)
    {

        try{
            waitForElementLocatedBy(driver, SearchAreaButton);
            SearchAreaButton.click();
            waitForElementLocatedBy(driver,SearchArea );
            SearchArea.sendKeys(song);
            waitForElementLocatedBy(driver,SongAtSearch );
            SongAtSearch.click();
            waitForElementLocatedBy(driver,buttonOptionsAtSong );
            buttonOptionsAtSong.click();
            waitForElementLocatedBy(driver,buttontoAddAtQueue );
            buttontoAddAtQueue.click();
            sleep(2000);
                logger.info("Song added to Queue!");
                return true;

        }
        catch(Exception e)
        {
            return false;
        }
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

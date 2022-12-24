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

public class SpotifyLoveMusicHome {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    @FindBy(xpath = "//div[div/div/div/div/a/p/text()='Chill']" )
    WebElement buttonPlayListChill;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/div/section/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div")
    WebElement SonginPlayListChill;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/div/section/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div/div[5]/button[1]")
    WebElement buttonLoveChill;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/section/div[4]/div/div[2]/div[2]/div[1]/div/div[5]/button[1]")
    WebElement buttonLovePLAYLOVE;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/nav/div[1]/div[2]/div/div[2]/a")
    WebElement buttonLovePlayListChill;
    @FindBy(xpath = "//div/div/div/a/div[text()='Малиновый закат']")
    WebElement SongNameinPlayList;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/section/div[4]/div/div[2]/div[2]/div[1]/div/div[1]")
    WebElement SonginPlayListLove;

    public SpotifyLoveMusicHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean AddSong()
    {

        try{
            waitForElementLocatedBy(driver, buttonPlayListChill);
            buttonPlayListChill.click();
            waitForElementLocatedBy(driver,SonginPlayListChill );
            SonginPlayListChill.click();
            waitForElementLocatedBy(driver,buttonLoveChill );
            buttonLoveChill.click();
            waitForElementLocatedBy(driver,buttonLovePlayListChill );
            buttonLovePlayListChill.click();
            sleep(2000);
            waitForElementLocatedBy(driver,SongNameinPlayList );
            String x=SongNameinPlayList.getText();
            if(x.equals("Малиновый закат")) {
                logger.info("Song was added at LovePlayList!");
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void AfterM()
    {
        waitForElementLocatedBy(driver,SonginPlayListLove );
        SonginPlayListLove.click();
        waitForElementLocatedBy(driver,buttonLovePLAYLOVE );
        buttonLovePLAYLOVE.click();
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

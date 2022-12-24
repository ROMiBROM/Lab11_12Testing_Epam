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

public class SpotifySubscribeHome {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a" )
    WebElement SearchAreaButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[3]/div/div/form/input")
    WebElement SearchArea;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/div[1]/div/div/div/div[1]/a[5]/button")
    WebElement ButtonofSingers;
    @FindBy(xpath = "//*[@id=\"searchPage\"]/div/div/div/div[1]/div[2]/div/div[3]")
    WebElement buttonSinger;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/main/section/div/div[2]/div[2]/div[4]/div/div/div/div/button[1]")
    WebElement buttonSubcr;


    @FindBy(xpath = "//div/button[text()='Подписка']")
    WebElement buttonSubcr2;
    public SpotifySubscribeHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean SubscribeOnSinger(String singer)
    {

        try{
            waitForElementLocatedBy(driver, SearchAreaButton);
            SearchAreaButton.click();
            waitForElementLocatedBy(driver,SearchArea );
            SearchArea.sendKeys(singer);
            waitForElementLocatedBy(driver,ButtonofSingers );
            ButtonofSingers.click();
            waitForElementLocatedBy(driver,buttonSinger );
            buttonSinger.click();
            waitForElementLocatedBy(driver,buttonSubcr );
            buttonSubcr.click();
                logger.info("Subscribed on Singer!");
                return true;

        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void AfterM()
    {
        buttonSubcr.click();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

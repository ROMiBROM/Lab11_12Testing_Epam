package Page_object.test;

import Page_object.Driver.DriverSingleton;
import Page_object.page.SpotifyRenamePlaylistHome;
import Page_object.page.SpotifySubscribeHome;
import Page_object.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners({TestListener.class})
public class ConditionsTestRenamePlaylistTest {
    public static WebDriver Driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        Driver = DriverSingleton.getDriver();
        Driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        new SpotifyRenamePlaylistHome(Driver).AfterM();
        DriverSingleton.closeDriver();
    }
}

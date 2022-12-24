package Page_object.test;

import Page_object.Model.User;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifyLoveMusicHome;
import Page_object.page.SpotifySubscribeHome;
import Page_object.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubcribeSingerTest extends ConditionsTestSubscribedOnSinger {

    @Test
    public void SubscribedOnSingerTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfSubscribed = new SpotifySubscribeHome(Driver)
                .SubscribeOnSinger("Miyagi");

        Assert.assertTrue(checkIfSubscribed);
    }
}

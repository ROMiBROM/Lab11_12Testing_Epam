package Page_object.test;

import Page_object.Model.User;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifyRenamePlaylistHome;
import Page_object.page.SpotifySubscribeHome;
import Page_object.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylistTest extends ConditionsTestRenamePlaylistTest {
    @Test
    public void SubscribedOnSingerTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfRenamed = new SpotifyRenamePlaylistHome(Driver)
                .RenameSong();

        Assert.assertTrue(checkIfRenamed);
    }
}

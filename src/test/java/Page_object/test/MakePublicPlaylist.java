package Page_object.test;

import Page_object.Model.User;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifyMakePublicPlaylist;
import Page_object.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakePublicPlaylist extends ConditionsTestMakePublicPlaylist {
    @Test
    public void MakePublicPlaylistTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfMadePublic = new SpotifyMakePublicPlaylist(Driver)
                .MakePublic();
        Assert.assertTrue(checkIfMadePublic);
    }
}

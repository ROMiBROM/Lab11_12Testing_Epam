package Page_object.test;

import Page_object.Model.User;
import Page_object.page.SpotifyDelFromLovePlaylistHome;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifyLoveMusicHome;
import Page_object.page.SpotifyTakeInformHome;
import Page_object.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddInLovePlayList extends Conditions{

    @Test
    public void AddSongatTheLovePlayListAtTheAccount() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfSongAdded = new SpotifyLoveMusicHome(Driver)
                .AddSong();

        Assert.assertTrue(checkIfSongAdded);
    }



    @Test
    public void DeleteSongFromLovePlaylist(){
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfSongDelete = new SpotifyDelFromLovePlaylistHome(Driver)
                .DeleteFromLovePlaylist();

        Assert.assertTrue(checkIfSongDelete);
    }
}

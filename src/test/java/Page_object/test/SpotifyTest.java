package Page_object.test;

import Page_object.Model.User;
import Page_object.page.*;
import Page_object.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotifyTest extends Conditions{





    @Test
    public void CreateNewPlayListAtTheAccountTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfPlayListIsCreate = new SpotifySearchResultPage(Driver)
                .CreateNewPlayList();

        Assert.assertTrue(checkIfPlayListIsCreate);
    }
    @Test
    public void ChooseSingerTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfChoosedSinger = new FromSongToSingerHome(Driver)
                .ChooseSingerAtSong("20K");
        Assert.assertTrue(checkIfChoosedSinger);
    }
    @Test
    public void AddSongAtQueueTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfAddedSongAtQueue = new SpotifySongQueueHome(Driver)
                .AddSongAtQueue("Yamakasi");
        Assert.assertTrue(checkIfAddedSongAtQueue);
    }

    @Test
    public void TakeInformationofSongTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfTookInformation = new SpotifyTakeInformHome(Driver)
                .TakeInformation("Brooklyn");

        Assert.assertTrue(checkIfTookInformation);
    }

}

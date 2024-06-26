import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class PlaylistTest.
 *
 * @author  Cara Tang
 * @version 2020.09.07
 */
public class PlaylistTest
{
    private final Song EXISTING_SONG = new Song("Title1", "Artist1", 155, 1);
    private final Song EXISTING_SONG2 = new Song("Title2", "Artist2", 280, 3);
    
    private Playlist playlist;
    
    @Before
    public void setUp() {
        playlist = new Playlist("Rock");
    }

    @Test
    public void playlistStartsEmpty() {
        assertEquals(0, playlist.getNumberOfSongs());
    }

    @Test
    public void addSongObjectAddsSong() {
        playlist.addSong(EXISTING_SONG);
        assertEquals(1, playlist.getNumberOfSongs());
    }

    @Test
    public void addSongByPropertiesAddsSong() {
        playlist.addSong("Song Title", "Artist", 200);
        assertEquals(1, playlist.getNumberOfSongs());
    }

    @Test
    public void getNumberOfSongsReturnsNumberOfSongs() {
        playlist.addSong(EXISTING_SONG);
        assertEquals(1, playlist.getNumberOfSongs());
        playlist.addSong(EXISTING_SONG2);
        assertEquals(2, playlist.getNumberOfSongs());
    }

    @Test
    public void clearPlaylistClearsSongs() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        playlist.clearPlaylist();
        assertEquals(0, playlist.getNumberOfSongs());
    }

    @Test
    public void printPlaylistPrintsAllSongs() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        System.out.println("------------- should print 2 songs in playlist -------------");
        playlist.printPlaylist();
        System.out.println("------------------------------------------------------------");
    }

    @Test
    public void _1_populateSongsAddsSongsBeyondThe2Given() {
        playlist.populateSongs();
        assertTrue("playlist does not have > 2 songs", playlist.getNumberOfSongs() > 2);
    }

    @Test
    public void _2_findSongFindsExistingSongByTitle() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        Song returnedSong = playlist.findSong(new String(EXISTING_SONG2.getTitle()));
        assertNotNull(returnedSong);
        assertEquals(EXISTING_SONG2, returnedSong);
    }

    @Test
    public void _2_findSongReturnsNullForNonExistingSong() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        assertNull(playlist.findSong("nbgswrhbntgsr"));
    }

    @Test
    public void _2_findSongReturnsNullForSongWithSimilarButNotEqualTitle() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        assertNull(playlist.findSong(EXISTING_SONG.getTitle() + "a"));
        assertNull(playlist.findSong(EXISTING_SONG2.getTitle().substring(1)));
    }

    @Test
    public void _3_removeSongRemovesSongWithTitle() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        int numSongs = playlist.getNumberOfSongs();
        playlist.removeSong(EXISTING_SONG2.getTitle());
        assertEquals(numSongs-1, playlist.getNumberOfSongs());
        assertNull(playlist.findSong(new String(EXISTING_SONG2.getTitle())));
    }
    
    @Test
    public void _3_removeSongHasNoEffectOnSongTitleNotInPlaylist() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        int numSongs = playlist.getNumberOfSongs();
        playlist.removeSong("hgut54ruinire");
        assertEquals(numSongs, playlist.getNumberOfSongs());
    }

    @Test
    public void _4_getSongsByArtistReturnsEmptyListWhenNoSongsByArtist() {
        playlist.addSong(EXISTING_SONG);
        playlist.addSong(EXISTING_SONG2);
        ArrayList<Song> songsByArtist = playlist.getSongsByArtist("goirfegvjbnwiarelojn");
        assertNotNull(songsByArtist);
        assertEquals(0, songsByArtist.size());
    }

    @Test
    public void _4_getSongsByArtistReturnsListOfSongsByArtist() {
        final String ARTIST = "Artist-ABC";
        playlist.addSong(new Song("Title1", ARTIST, 152));
        playlist.addSong(new Song("Title2", "Artist4", 255, 1));
        playlist.addSong(new Song("Title5", ARTIST, 89, 3));
        ArrayList<Song> songsByArtist = playlist.getSongsByArtist(new String(ARTIST));
        assertNotNull(songsByArtist);
        assertEquals(2, songsByArtist.size());
        for (Song s : songsByArtist) {
            assertEquals(ARTIST, s.getArtist());
        }
    }

    @Test
    public void _5_getNumSongsWithRatingReturnsZeroWhenNoSongsInPlaylist() {
        assertEquals(0, playlist.getNumSongsWithRating(3));
    }

    @Test
    public void _5_getNumSongsWithRatingReturnsZeroWhenNoSongsWithRating() {
        playlist.addSong(new Song("Title1", "Artist1", 255));
        playlist.addSong(new Song("Title2", "Artist4", 255, 1));
        playlist.addSong(new Song("Title3", "Artist3", 255, 2));
        playlist.addSong(new Song("Title4", "Artist4", 255, 4));
        assertEquals(0, playlist.getNumSongsWithRating(3));
    }

    @Test
    public void _5_getNumSongsWithRatingReturnsNumSongsWithRating() {
        playlist.addSong(new Song("Title1", "Artist1", 255));
        playlist.addSong(new Song("Title2", "Artist4", 255, 1));
        playlist.addSong(new Song("Title3", "Artist3", 0, 2));
        playlist.addSong(new Song("Title4", "Artist4", 255, 4));
        playlist.addSong(new Song("Title5", "Artist5", 0, 2));
        assertEquals(2, playlist.getNumSongsWithRating(2));
    }

    // If you implement the optional TODO, uncomment these tests
    
    //@Test
    //public void _6_getMaxRatingOfASongReturnsZeroIfNoSongsInPlaylist() {
    //    assertEquals(0, playlist.getMaxRatingOfASong());
    //}

    //@Test
    //public void _6_getMaxRatingOfASongReturnsMaxRating() {
    //    playlist.addSong(new Song("Title1", "Artist1", 255));
    //    playlist.addSong(new Song("Title2", "Artist4", 255, 1));
    //    playlist.addSong(new Song("Title3", "Artist3", 0, 2));
    //    playlist.addSong(new Song("Title4", "Artist4", 255, 3));
    //    playlist.addSong(new Song("Title4b", "Artist4", 255, 3));
    //    playlist.addSong(new Song("Title5", "Artist5", 0, 2));
    //    assertEquals(3, playlist.getMaxRatingOfASong());
    //}

    @Test
    public void _7_printPlaylistSummaryStats() {
        playlist.addSong(new Song("Title1", "Artist1", 199));
        playlist.addSong(new Song("Title2", "Artist2", 255, 1));
        playlist.addSong(new Song("Title3", "Artist3", 0, 2));
        playlist.addSong(new Song("Title4", "Artist4", 255, 4));
        playlist.addSong(new Song("Title5", "Artist3", 0, 2));
        System.out.println("-------- summary stats (tot: 5 ** 1, 0, 2, 1, 1 ** max: 4) --------");
        playlist.printPlaylistSummaryStats();
        System.out.println("-------------------------------------------------------------------");
    }
}
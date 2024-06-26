import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SongTest.
 *
 * @author  Cara Tang
 * @version 2020.09.06
 */

public class SongTest
{
    private static final String TITLE = "Song Title Here";
    private static final String ARTIST = "Artist Here";
    private static final int LENGTH = 245;
    
    @Test
    public void fourArgConstructorInitializesProperties()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH, 2);
        assertEquals(TITLE, song.getTitle());
        assertEquals(ARTIST, song.getArtist());
        assertEquals(LENGTH, song.getLengthInSeconds());
        assertEquals(2, song.getRating());
    }
    
    @Test
    public void _1_threeArgConstructorInitializesPropertiesAndSetsRatingToZero()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH);
        assertEquals(TITLE, song.getTitle());
        assertEquals(ARTIST, song.getArtist());
        assertEquals(LENGTH, song.getLengthInSeconds());
        assertEquals(0, song.getRating());
    }
    
    @Test
    public void setLengthInSecondsWithValidLengthWorks()
    {
        int newLength = LENGTH + 50;
        Song song = new Song(TITLE, ARTIST, LENGTH, 2);
        song.setLengthInSeconds(newLength);
        assertEquals(newLength, song.getLengthInSeconds());
    }
    
    @Test
    public void setLengthInSecondsWithLength1Works()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH, 2);
        song.setLengthInSeconds(1);
        assertEquals(1, song.getLengthInSeconds());
    }
    
    @Test
    public void _2_getRatingReturnsRating()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH, 2);
        assertEquals(2, song.getRating());
    }
    
    @Test
    public void resetRatingSetsRatingToZero()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH, 2);
        assertNotEquals(0, song.getRating());
        song.resetRating();
        assertEquals(0, song.getRating());
    }
    
    @Test
    public void _3_setRatingWithValidRatingWorks()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH);
        song.setRating(3);
        assertEquals(3, song.getRating());
    }

    @Test
    public void _3_setRatingWithValidRatingWorksBoundaryValues()
    {
        Song song = new Song(TITLE, ARTIST, LENGTH);
        song.setRating(1);
        assertEquals(1, song.getRating());
        song.setRating(4);
        assertEquals(4, song.getRating());
    }
    
    @Test
    public void _4_increaseRatingIncreasesRatingByOne()
    {
        final int ORIG_RATING = 2;
        Song song = new Song(TITLE, ARTIST, LENGTH, ORIG_RATING);
        
        song.increaseRating();
        assertEquals(ORIG_RATING + 1, song.getRating());
        song.increaseRating();
        assertEquals(ORIG_RATING + 2, song.getRating());
    }

    @Test
    public void _5_decreaseRatingDecreasesRatingByOne()
    {
        final int ORIG_RATING = 3;
        Song song = new Song(TITLE, ARTIST, LENGTH, ORIG_RATING);
        
        song.decreaseRating();
        assertEquals(ORIG_RATING - 1, song.getRating());
        song.decreaseRating();
        assertEquals(ORIG_RATING - 2, song.getRating());
    }

    @Test
    public void _6_printSongInfoPrintsSongPropertiesIncludingRating()
    {
        System.out.println("--------- Song info printed with rating 3: ----------");
        Song song = new Song(TITLE, ARTIST, LENGTH, 3);
        song.printSongInfo();
        System.out.println("--------- -------------------------------- ----------");
    }
}
/**
 * A song, such as one in a music store which can be rated
 *
 * Modifications:
 * CT: Created class with properties, constructor, and getters
 * CT: Added setter for lengthInSeconds
 * CT: Added methods to reset and increase rating
 * CT: Added method to print song properties
 * 
 * 
 * @author Cara Tang, Braden Gerlach
 * @version 2024.16.054
 *
 */
public class Song
{
    private String title;
    private String artist;
    private int lengthInSeconds;
    private int rating; // valid ratings are 1-5 or 0 meaning not rated
    
    /**
     * Create a song with the given title, artist, length, and rating
     * @param songTitle the song title
     * @param songArtist the song artist
     * @param songLength the length of the song in seconds
     * @param songRating the song's rating
     */
    public Song(String songTitle, String songArtist, int songLength, int songRating)
    {
        title = songTitle;
        artist = songArtist;
        lengthInSeconds = songLength;
        rating = songRating;
    }

    
    /**
     * New Constructor without rating
     * Create a song with the given title, artist, length
     * @param songTitle the song title
     * @param songArtist the song artist
     * @param songLength the length of the song in seconds
     * @param songRating to 0
     */
    public Song(String songTitle, String songArtist, int songLength)
    {
        title = songTitle;
        artist = songArtist;
        lengthInSeconds = songLength;
        rating = 0; // Initialize rating to 0 (not rated)
    }
    
    /**
     * @return the song title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @return the song artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * @return the song length (in seconds)
     */
    public int getLengthInSeconds()
    {
        return lengthInSeconds;
    }
    
    /**
     * Set the length of this song to the value given
     * @param newLength new length (in seconds) for this song
     */
    public void setLengthInSeconds(int newLength)
    {
        lengthInSeconds = newLength;
    }
    
    // TODO: ----------------- 2 -------------------
    // TODO: Create the getRating method that returns this song's rating
    // TODO: Don't forget the comment header!
    
    /**
     * this is the get rating method
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * Sets new rating
     */
    public void setRating(int newRating)
    {
        rating = newRating;
    }
    
    
    
    /**
     * Reset the rating of this song to not rated
     */
    public void resetRating()
    {
        rating = 0;
    }
        
    /**
     * Increase the rating of this song by 1
     */
    public void increaseRating()
    {
        // Fixed I beleive but it could also be overflowed as there is no user input
        // control
        rating =+ 1;
    }
    
    /**
     * 
     * Method for decreasing the value
     * 
     */
    public void decreaseRating()
    {
    
       rating = rating -1; 
    
    }


    /**
     * Print information on this song
     */
    public void printSongInfo()
    {
        System.out.println("---------------------------------");
        System.out.println("Song Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Length: " + lengthInSeconds + " seconds");
        System.out.println("Rating:"+rating+" Out of 5");
        System.out.println("---------------------------------");
    }
}
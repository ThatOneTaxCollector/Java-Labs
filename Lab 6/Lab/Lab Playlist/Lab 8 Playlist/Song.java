/**
 * A song, such as one in a music store which can be rated
 *
 * Modifications:
 * CT: Added validation to setLengthInSeconds
 *
 * @author Cara Tang, Braden Gerlach
 * @version 2024.06.10
 * redone slightly after correcting the problems with the Playlist class
 */
public class Song {
    private String title;
    private String artist;
    private int lengthInSeconds;
    private int rating; // valid ratings are 1-4 or 0 meaning not rated

    /**
     * Create a song with the given title, artist, length, and rating
     * @param songTitle the song title
     * @param songArtist the song artist
     * @param songLength the length of the song in seconds
     * @param songRating the song's rating
     */
    public Song(String songTitle, String songArtist, int songLength, int songRating) {
        title = songTitle;
        artist = songArtist;
        setLengthInSeconds(songLength);
        setRating(songRating);
    }

    /**
     * Create an unrated song with the given title, artist, and length
     * @param songTitle the song title
     * @param songArtist the song artist
     * @param songLength the length of the song in seconds
     */
    public Song(String songTitle, String songArtist, int songLength) {
        title = songTitle;
        artist = songArtist;
        setLengthInSeconds(songLength);
        rating = 0;
    }

    /**
     * @return the song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the song artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return the song length (in seconds)
     */
    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    /**
     * Set the length of this song to the value given.
     * The length must be greater than 0.
     * @param newLength new length (in seconds) for this song
     */
    public void setLengthInSeconds(int newLength) {
        if (newLength > 0) {
            lengthInSeconds = newLength;
        } else {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    /**
     * @return true if this song has not been rated, false otherwise
     */
    public boolean isUnrated() {
        return rating == 0;
    }

    /**
     * @return the song rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Update this song's rating to the one given
     * @param newRating new rating for this song
     */
    public void setRating(int newRating) {
        if (newRating >= 1 && newRating <= 4) {
            rating = newRating;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 4");
        }
    }

    /**
     * Reset the rating of this song to not rated
     */
    public void resetRating() {
        rating = 0;
    }

    /**
     * Increase the rating of this song by 1
     */
    public void increaseRating() {
        if (rating < 4) {
            rating++;
        }
    }

    /**
     * Decrease the rating of this song by 1
     */
    public void decreaseRating() {
        if (rating > 1) {
            rating--;
        }
    }

    /**
     * @return a string giving the song length in minutes (m) and seconds (s).
     * Example: If lengthInSeconds is 150, the string returned is "2m 30s"
     */
    public String getLengthAsString() {
        int minutes = lengthInSeconds / 60;
        int seconds = lengthInSeconds % 60;
        return minutes + "m" + seconds + "s";
    }
    
    /**
     * Print information about the song
     */
    public void printSongInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Length: " + getLengthAsString());
        System.out.println("Rating: " + (isUnrated() ? "Unrated" : rating));
        System.out.println("--------------------------------");
    }
}
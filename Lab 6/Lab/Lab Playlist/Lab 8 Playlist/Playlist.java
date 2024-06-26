import java.util.ArrayList;
/**
 * A playlist for managing songs
 *
 * Modifications:
 * Added all of the thing required for the assignment as well as added some
 * great songs to the populate method
 *
 *
 * @author Cara Tang, Braden Gerlach
 * @version 2024.10.6
 */
public class Playlist
{
    private String playlistName;
    private ArrayList<Song> playlist;
    
    /**
     * Creates an empty playlist with the given name
     * @param name the name for this playlist
     */
    public Playlist(String name)
    {
        playlistName = name;
        playlist = new ArrayList<Song>();
    }
    
    /**
     * Populates the playlist with a few songs.
     * As well as allowing for creation of new songs to populate the playlist 
     * using this method.
    */
    public void populateSongs()
    {
        addSong(new Song("Decay", "Home", 154, 4));
        addSong(new Song("Buttercup", "Jack Stauber", 355, 5));
        addSong(new Song("I fall in love too easily", "Chet Baker", 322, 4));
        addSong(new Song("Rolling Down The Street, In My Katamari", "Fearofdark", 435, 4));
        addSong(new Song("The Butcher's Share", "Daniel Kahn & The Painted Bird", 541, 5));
        addSong(new Song("PRETTY BENGLES", "Jippy", 111, 4));
        // TODO: Teach please listen to thses songs as I find them to be great
    }

    /**
     * @return the playlist name
     */
    public String getPlaylistName()
    {
        return playlistName;
    }

    /**
     * Add the given song to the end of this playlist
     * @param aSong a song to add
     */
    public void addSong(Song aSong)
    {
        playlist.add(aSong);
    }
    
    /**
     * Creates an unrated song with the given title, artist, and length, and
     * add it to the end of this playlist.
     * @param title title of the song
     * @param artist the song's artist
     * @param length length of the song in seconds
     */
    public void addSong(String title, String artist, int length)
    {
        playlist.add(new Song(title, artist, length));
    }

    /**
     * @return the number of songs in this playlist
     */
    public int getNumberOfSongs()
    {
        return playlist.size();
    }
    
    /**
     * Remove all the songs from this playlist
     */
    public void clearPlaylist()
    {
        playlist.clear();
    }

    /**
     * Print the playlist
     */
    public void printPlaylist()
    {
        System.out.println("============= Playlist: " + playlistName + " =============");
        if (getNumberOfSongs() == 0) {
            System.out.println("No songs in this playlist");
        }
        else {
            for (Song currentSong : playlist) {
                currentSong.printSongInfo();
            }
        }
        System.out.println("=============================================");
    }
    
    /**
     * Find a song based on its title
     * @param title the title of the song to search for
     * @return the first song with the given title in this playlist
     *         or null if there is no song with that title in this playlist
     */
    public Song findSong(String title)
    {
        for (Song song : playlist) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }
    
    /**
     * Remove the first song with the given title from this playlist
     * @param title the title of the song to remove
     */
    public void removeSong(String title)
    {
        Song songToRemove = findSong(title);
        if (songToRemove != null) {
            playlist.remove(songToRemove);
        }
    }
    
    /**
     * Get songs by a given artist
     * @param artist the artist to filter by
     * @return a list of songs by the given artist
     */
    public ArrayList<Song> getSongsByArtist(String artist)
    {
        ArrayList<Song> songsByArtist = new ArrayList<>();
        for (Song song : playlist) {
            if (song.getArtist().equals(artist)) {
                songsByArtist.add(song);
            }
        }
        return songsByArtist;
    }
    
    /**
     * Get the number of songs with a given rating
     * @param rating the rating to filter by
     * @return the number of songs with the given rating
     */
    public int getNumSongsWithRating(int rating) {
        int count = 0;
        for (Song song : playlist) {
            if (song.getRating() == rating) {
                count++;
            }
        }
        return count;
    }   
    
    /**
     * Prints the summary statistics for the playlist,
     * as well as implementing the maxRating into the summary stats.
     */
      public void printPlaylistSummaryStats() {
        int[] ratingCounts = new int[5]; // Index 0 is not used; indices 1-4 represent ratings 1-4
        int unratedCount = 0;
    
        for (Song song : playlist) {
            int rating = song.getRating();
            if (rating == 0) {
                unratedCount++;
            } else {
                ratingCounts[rating]++;
            }
        }
    
        System.out.println("======== SUMMARY STATS for Playlist: " + playlistName + " ========");
        System.out.println("# of songs: " + playlist.size());
        for (int i = 1; i <= 4; i++) {
            System.out.println("# rated " + i + ": " + ratingCounts[i]);
        }
        System.out.println("# unrated: " + unratedCount);
        // If you have implemented getMaxRatingOfASong, include it here
        System.out.println("=================================================");
    }
    
    /**
     * Gets the maximum rating of a song in the playlist
     * @return the maximum rating, or 0 if no songs in the playlist
     */
    public int getMaxRatingOfASong() {
        int maxRating = 0;
        for (Song song : playlist) {
            maxRating = Math.max(maxRating, song.getRating());
        }
        return maxRating;
    }
}
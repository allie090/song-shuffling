/**
 * Class Name: Song 
 * @author: Allie Marcum 
 * @version: 1.0
 * Course: CSE 274
 * Date: October 1, 2023
 * 
 * Function: Construct attributes of a song
 */
public class Song { 
	
	// attributes for songs 
	String song; // the title of the song 
	String artist; // the name of the artist 
	
	/**
	 * Constructor 
	 * @param song, the name of the song 
	 * @param artist, the name of the artist 
	 */
	public Song (String song, String artist) { 
		this.song = song; 
		this.artist = artist; 
	} 

	/**
	 * Method to get song 
	 * 
	 * @return the name of the song 
	 */
	public String getSong() {
		return song;
	} 

	/**
	 * Method to set breed 
	 * 
	 * @param breed, the name of the song 
	 */
	public void setSong(String song) {
		this.song = song;
	}

	/**
	 * Method to get artist 
	 * 
	 * @return the name of the artist
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Method to set artist 
	 * 
	 * @param breed, the name of the artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	
	
}

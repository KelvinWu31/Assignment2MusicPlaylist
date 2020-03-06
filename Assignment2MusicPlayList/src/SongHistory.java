/* README
 *  Class: SongHistory
 * 
 * Description: 
 * Using SongHistory, the program will add in songs as it is being played in the main method. 
 * Using "addSong", a parameter is read in and added to first. If it first is null, it means
 * that "first" is the first song being read in. If not, then it will call the setNext of 
 * Songs in class Songs to update it.Using "previousListen", user can call this method to
 *  return the previous song listened.
 * 
 */

public class SongHistory {
	private Songs song; 
	
	public boolean isEmpty(){
		return song == null; // returns null if song is null
	}
	
	public void addSong(Songs song) {  // allows the main method to call to set listened songs
		if (isEmpty()) {
			this.song = song;
		}
		else {
			song.setNext(song);
			this.song = song ;
		}
	}
	
	public Songs previousListen() { 
		return song; 
	}
	
}

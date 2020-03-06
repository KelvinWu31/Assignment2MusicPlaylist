/* README
 * 
 * Class: SongPlayList
 * 
 * Description: 
 * SongPlayList is the heart of program that takes in all the previous classes to allow
 * users to monitor and control the songs being played in main using queue. SongPlayList
 * also implements SongHistory object to collect all the songs being played.
 * 
 */
public class SongPlayList {
	private Songs first; 
	private Songs last; 
	
	private SongHistory songHistory = new SongHistory();
	
	
	public void insertSong(Songs songs) { 
		if (isEmpty()) {                     // if the playlist is empty then set both first and last to the read in parameter songs.
			first = songs;
			last = songs;
		}
		else { 
			songs.setNext(last); 			// sets the next song as the last one.
			songs.setPrevious(songs);		// sets the previous song as the the current song.
			last = songs;					// then adds in the current song into last. 
		}
	} // end of insertSong
	
	public Songs CurrentSong() { 
		Songs currentSong; 
		
		if(isEmpty()) { 
			return null;                   // only returns null if there is no song in the playlist.
		}
		else { 
			currentSong = first;         // else it will set the first/ head as the current song and delete after playing it. 
			delete(); 
			
		}
		songHistory.addSong(currentSong);  // regardless of the if statement. it will add the songs to songHistory
		return currentSong;                // return the current being played
	} // end of current
	
	public void delete() {
		if (!(isEmpty())) { 
			if (first.getPrevious() != null) { 
				first = first.getPrevious();       // if first/ head is not empty then get the previous song.				
			}
			else { 
				first = null;                        // else set first as null
			}
		} // end of if empty statement
	} // end of delete
	
	public Songs nextSong() {
		return first;                               // return the next song on the playlist
	} // end of nextSong
	
	
	public boolean isEmpty() { 
		return last == null;
	} // end of isEmpty
	
	public Songs previousListen(){
		return songHistory.previousListen();       // goes into songHistory to retrieve the previous song.
	}
}

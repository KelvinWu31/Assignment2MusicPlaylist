/* README
 * Class: Songs
 * 
 * Description: 
 * 
 * This class of Songs is used to keep track of songs that is currently played from the playlist. 
 * Using "current" to keep track the current song that is being played.
 * Using "next" to get and set the value of the next song of the playlist.
 * Using "previous" to get and set the value of the previous song of the playlist.
 * 
 */
public class Songs {
	private String current; // allows the user to keep track of the current song being played. 
	private Songs next;  // allows the user to use the node to access the next song of the playlist. 
	private Songs previous;  // allows the user to use the node to access the previous song of the playlist.
	
	public Songs(String current) { 
		this.current = current;    // using a constructor with a parameter, the other classes add in a track. 
	}
	
	public void setNext(Songs next) {  // using a setter, Songs can update the value of next; 
		this.next = next; 
	}
	
	public void setPrevious(Songs previous) {  // using a setter, Songs can update the value of previous; 
		this.previous = previous; 
		
	}
	public Songs getNext() { // using a getter, Songs can retrieve the value of next; 
		return next; 
	}

	public Songs getPrevious() { // using a getter, Songs can retrieve the value of previous
		return previous;  
	}
}

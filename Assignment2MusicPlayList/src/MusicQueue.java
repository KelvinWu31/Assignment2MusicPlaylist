/* README
 * Class: MusicQueue
 * 
 * Description: 
 * MusicQueue contains a constructor that reads in multiple files of CSV files using a BufferedReader and 
 * sorts out the song titles. The songs are then sorted and placed in alphabetical order. Then using a 
 * deleteDuplicates, the duplicates are deleted from the arraylist. Using an enhanced for loop, the songNames
 * are added back the musicQueue.
 * 
 * MusicQueue also contains a mergeSorts in reference of https://mrtan.me/post/28.html which allows me to call
 * this method in the main method to merge two sorts and alphabetize them and return a newly merged sort of 
 * alphabetized songs.
 */

import java.util.*; 
import java.io.*;

public class MusicQueue extends LinkedList {
	
	public MusicQueue() {
		// empty constructor for the merging of two sorted queues.
	}
	
	// second constructor that accepts an string of fileName as parameter. 
	public MusicQueue (String fileName) throws Exception { 
		ArrayList <String> musicQueue = new ArrayList<> (); // creates an ArrayList of type string to hold all queues of song titles.
		
		
		try {
			BufferedReader brFile= new BufferedReader(new FileReader("data" + fileName)); 
		// using the BufferedReader, it will read in input files that are in the data folder
																					
		brFile.readLine();
		brFile.readLine();
		
		String line;
		while((line= brFile.readLine()) != null) { 
			String stringLine = brFile.readLine();
			int comma = stringLine.indexOf(",");
			int commaAfterSong = stringLine.indexOf(",", comma+ 1);
			
			boolean stringComma = false;
			while(!stringComma) { 
				if (stringLine.charAt(commaAfterSong + 1) == ' '|| (Character.isDigit(stringLine.charAt(commaAfterSong)- 1)) 
						&& Character.isDigit(commaAfterSong = stringLine.indexOf(",", commaAfterSong +1)));
				else 
					stringComma = true; 
				
			} // end of inner while loop 
			String song = stringLine.substring(comma + 1, commaAfterSong);

			if (song.charAt(0) == '"') { 
				song = song.substring(1, song.length()- 1);
			} // end of if statement
			
			musicQueue.add(song);                         // adds the  extracted, but unsorted song names from multiples files
			
		} // end of while loop
		
		musicQueue.sort(String.CASE_INSENSITIVE_ORDER); // sorts the song names 
		deleteDuplicates(musicQueue);                  // calls on deleteDuplicates to delete any duplicate song titles.
		for (String songNames : musicQueue) {
			add(songNames);                           // convert the queue of songs into enhanced for loop that adds song names into the .   
		}
		
		
		} // end of try 
		catch (IOException e){
			System.out.println("File has not been read in.");
		} // end of catch 
		
	} // end of musicQueue Constructor
	
	public static void deleteDuplicates(ArrayList <String> musicQueue) {
		LinkedHashSet<String> hashMusicQueue = new LinkedHashSet <String> (musicQueue); // calls the linkedHashSet and sends the musicQueue as parameter
		musicQueue.clear();                                                            //  deletes all the elements of musicQueue
		musicQueue.addAll(hashMusicQueue);                                            // then adds in the elements from LinkedHashSet that has removed all the duplicate song names. 
	} // end of deleteDuplicates
	
	public static MusicQueue MergeQueueSorts (MusicQueue first, MusicQueue second) throws Exception {
		MusicQueue mergeMusicQueue = new MusicQueue(); 								// creates an object of music queue

		while(!first.isEmpty() && !second.isEmpty()) {   							// while loop that goes through both first and second queue to make sure its not empty.  

			String left = first.peek().toString();  
			String right = second.peek().toString();
			
			if(left.compareTo(right) < 0) { 
				mergeMusicQueue.add(first.poll()); 
			}
			else {
				mergeMusicQueue.add(second.poll());
			}
	
		} // end of while Loop
		
		// If there are remaining items left in the first or second queue; the two While statements will execute. 
		while(!first.isEmpty()) {
			mergeMusicQueue.add(first.poll()); 
		}
		while(!second.isEmpty()) { 
			mergeMusicQueue.add(second.poll());
		}
		
		return mergeMusicQueue; 
	} // end of mergeQueueSorts
		
} // end of MusicQueue class

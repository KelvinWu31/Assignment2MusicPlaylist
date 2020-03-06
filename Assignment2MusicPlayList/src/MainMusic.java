/*README
 * 
 * Name: Kelvin Wu 
 * CISC 3130 TY2 
 * 03/05/2020
 * Assignment # 2
 * 
 * Class: MainMusic 
 * 
 * Description: This Java Program was intended to read in multiple (6) csv files of 
 * Spotify charts from 01/17 to 02/28 into multiple arraylist and queues that will 
 * strip out the unnecessary information such as artist names, url, streams and 
 * position. Then in multiple Queue Arrays, it will merge the multiple sorts into 
 * into one, remove any duplicates and be sorted alphabetically. 
 * 
 * Errors: 
 * - My program was able to detect 6 files and print out the catch i had set up on 
 *   the MusicQueue Constructor.
 * - I have been unable to detect the problem as the IDE has shown no errors in the 
 * 	 try part. 
 * 
 * Output: 
 * File has not been read in.
 * File has not been read in.
 * File has not been read in.
 * File has not been read in.
 * File has not been read in.
 * File has not been read in.
 *
 */
import java.io.*;
import java.util.*;

public class MainMusic {

	public static void main(String[] args) throws Exception {
		ArrayList<String> files = new ArrayList <>();
		File[] folder = new File("data").listFiles();
	
		if(folder != null) { 
			for (File newFile : folder) { 
				if (newFile.isFile()) { 
					files.add(newFile.getName());
				}
			} // end of for loop
		
		}
		else { 
			System.out.println("Error: NO FILES WERE FOUND. PLEASE FIX.");
		}
		
		 int count = countFiles(files); 
		
		int numberOfFiles = 6;
		MusicQueue [] allWeeks = new MusicQueue[numberOfFiles];
		Iterator myFiles = files.iterator();
		
		for(int i = 0; i < numberOfFiles; i++) { 
			allWeeks[i] = new MusicQueue(myFiles.next().toString());    //fills the musicQueue Array with song titles from the list data 
		}
		
		MusicQueue mergedQueueSorts = MusicQueue.MergeQueueSorts(allWeeks[0], allWeeks[1]);

		int j = 2; 
		while(j < numberOfFiles) { 
			mergedQueueSorts = MusicQueue.MergeQueueSorts(mergedQueueSorts, allWeeks[j]);
		}
		
		SongPlayList songPlayList = new SongPlayList(); 
		
		while(!(mergedQueueSorts.isEmpty())) { 
			songPlayList.insertSong(new Songs(mergedQueueSorts.poll().toString())); 
		}
		
		while(!(songPlayList.isEmpty())) { 
			System.out.println(songPlayList.CurrentSong());
		}
		
	} // end of main method
	
	public static int countFiles(ArrayList<String> files) {
		List <String> newFiles = new ArrayList<>(); 
		int c = 0; 
		
		for(String string : files) { 
			String newString = string.substring(string.length()- 3, string.length());
			if(newString.equals("csv")) {
				c++;
			}
			else {
				newFiles.add(newString);
			}
		}
		files.removeAll(newFiles);
		return c;
	}

} // end of MainMusic

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Class Name: Driver 
 * @author: Allie Marcum 
 * @version: 1.0
 * Course: CSE 274
 * Date: October 1, 2023
 * 
 * Function: to handle the main and file reading/writing 
 */
public class Driver {
	
	/**
	 * Function: to read the text file and make a generic linked 
	 * list of songs and artists
	 * 
	 * @param inputFileName, the name of the input file 
	 * @return a generic linked list of the songs and artists within the file 
	 */
	public static GenericLinkedList<String> 
		readFile (String inputFileName) { 
		
		GenericLinkedList<String> info = 
				new GenericLinkedList<String>(); 

	
		// create the scanner to read from the file 
		// initialize the file 
		Scanner inFile = null; 
		File inputFile = new File (inputFileName);
		
		// assign the scanner 
		// catch if the file isn't found 
		try { 
			inFile = new Scanner (inputFile);
		}
		catch (IOException ex) { 
			ex.printStackTrace(); 
			System.out.println("The file was not found, please try again."); 
			System.exit(1);
		}
		
		// read off each variable and assign it to a dog or cat object 
		// then each objects gets assigned to petInfo array list 
		try { 
			// end once there's no lines to read 
			while (inFile.hasNextLine()) {
				String song = inFile.nextLine(); 
				String artist = inFile.nextLine();  
				
				Song s = new Song (song, artist); 
				
				info.add(s.getSong()); 
				info.add(s.getArtist());
				
			}// end while loop 
			
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			System.out.println("There was an issue reading the file."); 
		} 
		
		// close the scanner 
		inFile.close();
		
		return info; 
		
	} // end readFile method 
	
	/**
	 * Function: prints the information to file 
	 * Activated when the user chooses to save to file 
	 *
	 * @param outputFileName, the name of the output file 
	 * @param info, the generic linked list with the 
	 * information of song and artist names 
	 */
	public static void writeToFile (String outputFileName, 
			GenericLinkedList<String> info) { 
		
		// open the printwriter to write to file
		PrintWriter outToFile = null; 
		//String outputFileName = "songs.txt"; 
		
		// assign the printwriter if the file is found 
		try { 
			outToFile = new PrintWriter(outputFileName); 
		} 
		catch (IOException ex) { 
			ex.printStackTrace(); 
			System.out.println("The file was not found, try again."); 
			System.exit(1);
		}
		
		// after the file is opened, write to it 
		// catch if there's an issue printing 
		try { 
			// print toPrint to the file 
			outToFile.print(info.toString(true)); 
		} 
		catch (Exception ex) { 
			ex.printStackTrace(); 
			System.out.println("There was an issue printing to file. "
					+ "Try again.");
		} 
			
			// close the printer 
			outToFile.close();
		
		return; 
		

	} // end writeToFile method 
	
	/**
	 * Main method - starting point of the program 
	 * 
	 * @param args
	 */
	public static void main (String [] args) { 

		Scanner in = new Scanner (System.in); 
		
		GenericLinkedList<String> info = readFile("songs.txt"); 
		
		boolean exit = false; 
		while (!exit) {
			// ASK USER FOR INPUT 
			System.out.println("Please note, you must type in the "
					+ "functions as shown below. Also, don't enter in "
					+ "any extra spaces.\n"
					+ "The functions available to you are: \n"
					+ "Play (list), shuffle, remove (by name), "
					+ "add, save (to file), and exit\n"); 
			String function = in.nextLine ();
		
			// PLAY IS ENTERED 
			if (function.equalsIgnoreCase("play")) { 
				System.out.println("The following are the "
						+ "songs currently on the playlist: "); 
				System.out.println(info.toString(false));
			}
			
			// SAVE IS ENTERED 
			else if (function.equalsIgnoreCase("Save")) { 
				writeToFile("songs.txt", info); 
				System.out.println("The songs have been saved."); 
			}
			
			// SHUFFLE IS ENTERED 
			else if(function.equalsIgnoreCase("shuffle")) {
				System.out.println("The following is the new playlist order: \n");
				info.toArray(); 
				System.out.println("Would you like to save "
						+ "this shuffle? (Y/N) : "); 
				String saveShuffle = in.nextLine(); 
				if (saveShuffle.equalsIgnoreCase("Y")) { 
					writeToFile("songs.txt", info); 
				}
			} 
			
			// ADD IS ENTERED 
			else if(function.equalsIgnoreCase("add")) {
				System.out.println("What song would you like to add? : "); 
				String song = in.nextLine(); 
				System.out.println("Who is the artist of this song? : "); 
				String artist = in.nextLine(); 
				Song s = new Song (song, artist); 
				
				info.add(s.getSong());
				info.add(s.getArtist()); 
			}
			
			// REMOVE IS ENTERED 
			else if (function.equalsIgnoreCase("remove")) { 
				System.out.println("What song would would like to remove?"
						+ "(Please enter the title of the song: "); 
				String songToDelete = in.nextLine();
				info.remove(songToDelete); 
			}
			
			// EXIT IS ENTERED 
			else if (function.equalsIgnoreCase("exit")) { 
				exit = true; 
				System.out.println("Goodbye."); 
			}
			
		}
		in.close(); 
		
	} // end main method 
} // end driver class

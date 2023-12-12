/**
 * Class Name: GenericLinkedList 
 * @author: Allie Marcum 
 * @version: 1.0
 * Course: CSE 274
 * Date: October 1, 2023
 * 
 * Function: to implement methods for the generic linked list for 
 * functionality of the driver class
 */
import java.util.*; 

public class GenericLinkedList<T> implements LinkedListADT<T> {
	private Node<T> topNode; 
	public int size; 
	
	/**
	 * constructor
	 */
	public GenericLinkedList()  {
		topNode = null; 
		size = 0; 
	} 
	
	
	/**
	 * Function: to remove a specific song from the linked list 
	 * 
	 * @param toDelete, the song to delete from list 
	 */
	@Override
	public void remove(String toDelete) {
		if(isEmpty()) {
			throw new NoSuchElementException();  
		}
		// create temporary nodes 
		Node<T> temp = topNode; 
		Node<T> replace = topNode; 
		
		// catches if the value is the first in the list 
		if (((String) temp.next.data).equalsIgnoreCase(toDelete)) { 
			replace = topNode.next; 
			topNode = replace.next; 
			replace = null; 
			size--; 
			System.out.println("The song was removed."); 
			return; 
		}
		
		// catches the other values 
		while (temp.next!= null) { 
			temp = temp.next; 
			if (((String)temp.next.data).equalsIgnoreCase(toDelete)) { 
				replace.next = temp.next; 
				temp = null; 
				size--; 
				System.out.println("The song was removed."); 
				return; 
			}
			replace = replace.next; 
		}
		System.out.println("The song was not found - please try again"); 
		
	} // end remove method 
	
	
	/**
	 * Function: to shuffle the list of songs and artists 
	 * 
	 * Node: this algorithm is from 
	 * https://www.geeksforgeeks.org/shuffle-a-given-
	 * array-using-fisher-yates-shuffle-algorithm/
	 * 
	 * @param array, a generic array converted from linked list to 
	 * implement Fisher - Yates shuffle algorithm 
	 * 
	 */
	@Override
	public void shuffle(T[] array) {
		// create new object 
		Random r = new Random (); 
		
		// Fisher-Yates algorithm 
		for (int i = (array.length / 2) -1; i > 0; i--) { 
			int random = r.nextInt(array.length); 

			T temp = array[i]; 
			
			array[i] = array[random]; 
			
			array[random] = temp; 
			
			//System.out.println("array[random]: " + array[random]); 
		} 
		
		// change the array back to a linked list 
		toList(array);
	} // end shuffle method 
	
	/**
	 * Function: format the string for printing or writing to file 
	 * 
	 * @param save, true if the information is getting printed to file 
	 * @return the string of formatted information 
	 */
	@Override
	public String toString (boolean save) {
		// create temporary node 
		Node<T> temp = topNode; 
		
		// create empty string to later return 
		String printing = ""; 
		
		// if the value is going to file 
		if (save) { 
			for (int i = 0; i < size; i++) { 
				printing = temp.data + "\n" + printing; 
				System.out.print(printing); 
				temp = temp.next; 
			}
			return printing; 
		}
		
		// else it's going to the console or terminal 
		for (int i = 0; i < size /2; i++) { 
			printing = temp.next.data + " by " + temp.data 
					+ "\n" + printing;
			temp = temp.next.next; 
		}
		return printing; 
	} // end toString method 

	

	/**
	 * Function: to add a song and artist to the linekd list 
	 * 
	 * @param data, the information to add
	 */
    @SuppressWarnings("rawtypes")
	@Override
	public void add(T data) { 
		// creating the new node 
		@SuppressWarnings("unchecked")
		Node<T> temp = new Node (data); 
				
		// identifying that the next will be the the current head 
		temp.next = topNode; 
				
		// the new head is the node created 
		topNode = temp; 
				
		size ++; 
		return; 
		
	} // end add method 

    /**
     * Function: to ensure the list isn't empty 
     * 
     * @return true if the list is empty 
     */
	@Override
	public boolean isEmpty() {
		return topNode == null; 
	} // end isEmpty method 
	
	/**
	 * Function: to change the linked list to an array 
	 * Necessary for the shuffle method 
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void toArray() {
		Object[] arrayOfO = new Object [size /2]; 
		T[] arrayOfT = (T[]) arrayOfO; 
		
		Node<T> temp = topNode; 
		
		for (int i = 0; i < size / 2; i++) { 
			arrayOfT[i] = (T) (temp.next.data + " by " + temp.data); 
			temp = temp.next.next; 
		}
		
		shuffle(arrayOfT); 
		return; 
	} // end toArray method 
	
	/**
	 * Function: to return the array back to a linked list 
	 * 
	 * @param array, the generic array to convert 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void toList(T[] array) {
		for (int i = 0; i < array.length; i++) { 
			T value = array[i]; 
			
			// prints out the values to user
			System.out.println((i + 1) + ": " + value); 
			
			// change to a string and split up the string by "by"
			String wordValue = (String) value; 
			int index = wordValue.indexOf(" by "); 
			
			String songValue = wordValue.substring(0, index); 
			String artistValue = 
					wordValue.substring(index + 4, wordValue.length()); 
			
			// create new object 
			Song s = new Song (songValue, artistValue); 
			
			// add the song name and artist to linked list 
			add((T) s.getSong()); 
			add((T) s.getArtist()); 
			 
		}

		return; 
		
	} // end of toList method 
	

	// A private Node class.  By making it an inner class, 
	// the outer class can access it easily, but the client cannot.	
	private class Node<X> {
		private T data;
		private Node<T> next;

		// Constructs a new node with the specified data
		private Node(T data) {
			this.data = data;
			this.next = null;
		}
	} // end of Node class
		


} // end GenericLinkedList class

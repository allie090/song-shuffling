
public interface LinkedListADT<T> {
	/**
	 * Function: to remove a specific song from the linked list 
	 * 
	 * @param toDelete, the song to delete from list 
	 */
	public void remove (String toDelete); 
	
	/**
	 * Function: format the string for printing or writing to file 
	 * 
	 * @param save, true if the information is getting printed to file 
	 * @return the string of formatted information 
	 */
	public String toString(boolean save); 
	
	/**
     * Function: to ensure the list isn't empty 
     * 
     * @return true if the list is empty 
     */
	public boolean isEmpty();
	
	/**
	 * Function: to shuffle the list of songs and artists 
	 * 
	 * @param array, a generic array converted from linked list to 
	 * implement Fisher - Yates shuffle algorithm 
	 */
	public void shuffle(T[] array);
	
	/**
	 * Function: to change the linked list to an array 
	 * Necessary for the shuffle method 
	 *
	 */
	public void toArray(); 

	/**
	 * Function: to return the array back to a linked list 
	 * 
	 * @param array, the generic array to convert 
	 */
	public void toList(T[] array);

	/**
	 * Function: to add a song and artist to the linekd list 
	 * 
	 * @param data, the information to add
	 */
	public void add(T data);

}

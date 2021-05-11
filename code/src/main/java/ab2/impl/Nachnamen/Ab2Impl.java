package ab2.impl.Nachnamen;

import ab2.Ab2;

import java.util.EmptyStackException;

/**
 * Created by Yahor Siarheyeu
 */

public class Ab2Impl implements Ab2 {


	/**
	 * Method inserts an element to Stack
	 *
	 * @param stack Der Stack auf den das Element gelegt werden soll
	 * 	        The stack onto which the given element should be pushed
	 *
	 * @param element Das hinzuzufügende Element
	 */
	private ListNode first;

	@Override
	public void push(Stack stack, int element)
	{
		ListNode oldFirst = first;
		first = new ListNode();
		first.value = element;
		first.next = oldFirst;
	}

	/**
	 * Method removes an element from Stack
	 *
	 * @param stack Der Stack, von dem das neueste Element entfernt werden soll
	 *              The stack from which the newest element should be popped
	 *
	 * @return element that was removed
	 */

	@Override
	public int pop(Stack stack)
	{
		int item = first.value;
		first = first.next;

		return item;
	}

	@Override
	public int exponentialSearch(int[] data, int element)
	{
		int bound = 1;
		// increase upper bound
		while (bound < data.length && data[bound] < element) {
			bound *= 2;
		}
		// do binary search with in the range
		return binarySearch(data, bound/2, Integer.min(bound + 1, data.length), element);
	}

	private static int binarySearch(int[] arr, int start, int end, int searchElement){
		// exit condition
		if(start > end){
			return -1;
		}
		int middle = (start+end)/2;
		// element found
		if(searchElement == arr[middle]){
			return middle;
		}
		// left half
		if(searchElement < arr[middle]){
			return binarySearch(arr, start, middle-1, searchElement);
		}else{
			// right half
			return binarySearch(arr, middle+1, end, searchElement);
		}
	}

	/**
	 * Method inserts an element in a hash table
	 *
	 * @param hashtable eine Hashtabelle in Form eines Arrays
	 *                  a hashset represented as an array
	 *
	 * @param element das einzufügende Element (sicher größer als -1)
	 */
	@Override
	public void insertIntoHashSet(int[] hashtable, int element) throws Exception {
		int attempts = 1;
		int position = quadraticProbing(attempts, hashtable, element);
		while (!tryAttempt(hashtable, position,element)){
			attempts++;
			position = quadraticProbing(attempts, hashtable, element);
		}


	}

	/**
	 * Method goes to the concrete position and inserts the element if it's possible.
	 *
	 * !!! Throws an exception if array is already full !!!
	 *
	 * @param hashTable is represented by array
	 * @param position where is element should be inserted
	 * @param element value of an element
	 * @return true if the element was inserted into array and false if not
	 */
	private boolean tryAttempt(int [] hashTable, int position, int element) throws Exception {
		int counter = 1;
		for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != -1){
				counter++;
			}
			if((position == i) && (hashTable[i] == -1)){
				hashTable[i] = element;
				return true;
			}
			if (counter > hashTable.length){
				throw new Exception("The hash table is full. Insertion is not possible...");
			}
		}
		return false;
	}

	/**
	 * Method is used in case if the position where the element should be is already occupied.
	 * then using quadratic probing is calculated a new position.
	 *
	 * @param attempts calculated the number of attempts
	 * @param hashTable is represented as array
	 * @param element value of an element
	 * @return new position of an element
	 */

	private int quadraticProbing(int attempts, int [] hashTable, int element){
		int position = hashFunktion(element, hashTable) + (int) ((Math.pow((attempts/2), 2)) * (Math.pow(-1,attempts)))%hashTable.length; //quadratic probing
		return position;
	}

	/**
	 * Presentation of hash funktion which is MOD from the value of an element
	 * @param element is the concrete element
	 * @param hashTable input array
	 * @return value for calculating the position
	 */
	private int hashFunktion(int element, int [] hashTable){
		return element % hashTable.length;
	}

	/**
	 * Method searches an element in the array hash table
	 *
	 * @param hashtable eine Hashtabelle in Form eines Arrays
	 *                  a hashset represented as an array
	 *
	 * @param element das gesuchte Element (sicher größer als -1)
	 *                the value to search for (always greater than -1)
	 *
	 * @return
	 */
	@Override
	public boolean containedInHashSet(int[] hashtable, int element)
	{
		if (element <= -1){
			throw new IllegalArgumentException("Input element is negative...");
		}
		for(int i = 0; i < hashtable.length; i++){
			if(element == hashtable[i]){
				return true;
			}
		}
		return false;
	}
}

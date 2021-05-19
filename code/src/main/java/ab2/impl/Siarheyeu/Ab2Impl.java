package ab2.impl.Siarheyeu;

import ab2.Ab2;

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
	@Override
	public void push(Stack stack, int element)
	{
		ListNode first = new ListNode();
		first.value = element;
		first.next = stack.head;
		stack.head = first;
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
		ListNode first = stack.head;
		if(first == null) {
			throw new RuntimeException("Empty stack");
		}
		stack.head = first.next;
		return first.value;
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
		return binarySearch(data, bound/2, Integer.min(bound + 1, data.length - 1), element);
	}

	static int binarySearch(int[] arr, int start, int end, int searchElement){
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
	public void insertIntoHashSet(int[] hashtable, int element){
		int position = findPosition(hashtable, element);
		if(position != -1) {
			hashtable[position] = element;
		}
	}

	static int findPosition(int[] hashtable, int element) {
		int size = hashtable.length;
		int hash = hashFunction(element, size);
		//int position = hash; //quadraticProbing(attempts, hashtable, element);
		for(int j = 0, pos = hash; j < size; j++) {
			if (hashtable[pos] == -1 || hashtable[pos] == element) {
				return pos;
			}
			pos = quadraticProbing(j, hash, size);
		}
		return -1; // not found
	}

	/**
	 * Method is used in case if the position where the element should be is already occupied.
	 * then using quadratic probing is calculated a new position.
	 *
	 * @param j attempts calculated the number of attempts
	 * @param hash element's hash value
	 * @param size size of the hashtable
	 * @return new position of an element
	 */
	static int quadraticProbing(int j, int hash, int size) {
		int j2 = (j+1) / 2; // ⌈j/2⌉ = ceil(j/2)
		int s = j2 * j2 * ((j & 1) == 1 ? -1 : 1); // ceil(j/2)^2 * (-1)^j
		int r = (hash - s) % size;
		if(r < 0)
			r += size;
		return r;
	}

	/**
	 * Presentation of hash function which is MOD from the value of an element
	 * @param element is the concrete element
	 * @param size hashtable size
	 * @return value for calculating the position
	 */
	static int hashFunction(int element, int size){
		return element % size;
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
	 * @return true if elements is in the hash set
	 */
	@Override
	public boolean containedInHashSet(int[] hashtable, int element)	{
		int pos = findPosition(hashtable, element);
		return pos != -1 && hashtable[pos] == element;
	}
}

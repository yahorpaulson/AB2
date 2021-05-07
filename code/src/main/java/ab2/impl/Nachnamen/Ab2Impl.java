package ab2.impl.Nachnamen;

import ab2.Ab2;

import java.util.EmptyStackException;

/**
 * Created by Yahor Siarheyeu
 */

public class Ab2Impl implements Ab2 {

	//TODO: write methods push and pop for stack

	@Override
	public void push(Stack stack, int element)
	{
		/*if (stack.head == null){
			stack.head = new ListNode();
			stack.head.value = element;
		} else {
			stack.head.next = new ListNode();
			stack.head.value = element;
		}*/
	}


	@Override
	public int pop(Stack stack)
	{
		return -1;
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

	@Override
	public void insertIntoHashSet(int[] hashtable, int element)
	{
		int attempts = 1;
		int position = quadraticProbing(attempts, hashtable, element);
		while (!tryAttempt(hashtable, position,element)){
			attempts++;
			position = quadraticProbing(attempts, hashtable, element);
		}


	}
	private boolean tryAttempt(int [] hashTable, int position, int element){
		for (int i = 0; i < hashTable.length; i++) {
			if((position == i) && (hashTable[i] == -1)){
				hashTable[i] = element;
				return true;
			}
		}
		return false;
	}

	private int quadraticProbing(int attempts, int [] hashTable, int element){
		int position = hashFunktion(element, hashTable) + (int) ((Math.pow((attempts/2), 2)) * (Math.pow(-1,attempts)))%hashTable.length; //quadratic probing
		return position;
	}
	private int hashFunktion(int element, int [] hashTable){
		return element % hashTable.length;
	}


	@Override
	public boolean containedInHashSet(int[] hashtable, int element)
	{
		for(int i = 0; i < hashtable.length; i++){
			if(element == hashtable[i]){
				return true;
			}
		}
		return false;
	}
}

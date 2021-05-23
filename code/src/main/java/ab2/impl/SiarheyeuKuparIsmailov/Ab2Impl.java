package ab2.impl.SiarheyeuKuparIsmailov;

import ab2.Ab2;

/**
 * @author Yahor Siarheyeu
 * @author Olga Kupar
 * @author Ramiz Ismailov
 */
public class Ab2Impl implements Ab2 {
	/**
	 * Method inserts an element to Stack
	 *
	 * @param stack   The stack onto which the given element should be pushed
	 * @param element Element to be added
	 */
	@Override
	public void push(Stack stack, int element) {
		ListNode first = new ListNode();
		first.value = element;
		first.next = stack.head;
		stack.head = first;
	}

	/**
	 * Method removes an element from Stack
	 *
	 * @param stack The stack from which the newest element should be popped
	 * @return element that was removed
	 */
	@Override
	public int pop(Stack stack) {
		ListNode first = stack.head;
		if (first == null) {
			throw new RuntimeException("Empty stack");
		}
		stack.head = first.next;
		return first.value;
	}

	/**
	 * Adapted version of the exponential search algorithm (lecture 5-42)
	 *
	 * @param data    just sorted array
	 * @param element for search
	 * @return zero_based_index or -1 if the element wasn't found
	 */
	@Override
	public int exponentialSearch(int[] data, int element) {
		int i = 1; //the interval bound

		while (i < data.length && data[i - 1] < element) {
			i *= 2;
		}

		//return binarySearch(data, i/2, Math.min(i, data.length - 1), element);
		return binary(data, element, i / 2, Math.min(i + 1, data.length + 1));
	}

	/**
	 * Binary search implementation (lecture 5-10)
	 * This method works with one-based arrays
	 *
	 * @param a     zero-based array
	 * @param k     element to be found
	 * @param left  start_index of the interval
	 * @param right end_index of the interval
	 * @return zero_based_index or -1 if the element wasn't found
	 */
	static int binary(int[] a, int k, int left, int right) {
		int m = (left + right) / 2; //the index of the middle
		if (m == left) {
			return -1;
		}
		if (k < a[m - 1]) {
			return binary(a, k, left, m);
		}
		if (k > a[m - 1]) {
			return binary(a, k, m, right);
		}
		return m - 1;
	}

	/**
	 * This method works with zero-based arrays
	 *
	 * @param arr           zero-based array
	 * @param searchElement element to be found
	 * @param start         start_index of the interval
	 * @param end           end_index of the interval
	 * @return zero-based index of the element or -1 if the element was not found
	 */
	static int binarySearch(int[] arr, int start, int end, int searchElement) {

		if (start > end) {
			return -1;
		}

		int middle = (start + end) / 2;

		if (searchElement == arr[middle]) {
			return middle;
		}

		if (searchElement < arr[middle]) {
			return binarySearch(arr, start, middle - 1, searchElement);
		} else {

			return binarySearch(arr, middle + 1, end, searchElement);
		}
	}

	/**
	 * Method inserts an element in a hash table
	 *
	 * @param hashtable a hashset represented as an array
	 * @param element   added element (greater than -1)
	 */
	@Override
	public void insertIntoHashSet(int[] hashtable, int element) {
		int position = findPosition(hashtable, element);
		if (position != -1) {
			hashtable[position] = element;
		}
	}

	static int findPosition(int[] hashtable, int element) {
		int size = hashtable.length;
		int hash = hashFunction(element, size);

		if (hashtable[hash] == -1 || hashtable[hash] == element) {
			return hash;
		}

		for (int j = 1; j < size; j++) {
			int pos = quadraticProbing(j, hash, size);
			if (hashtable[pos] == -1 || hashtable[pos] == element) {
				return pos;
			}
		}
		return -1; // not found
	}

	/**
	 * Adapted version of the algorithm (lecture 6-15)
	 * Method is used in case if the position where the element should be is already occupied.
	 * then using quadratic probing is calculated a new position.
	 *
	 * @param j    attempts calculated the number of attempts
	 * @param hash element's hash value
	 * @param size size of the hashtable
	 * @return new position of an element
	 */
	static int quadraticProbing(int j, int hash, int size) {
		int j2 = (j + 1) / 2; // ⌈j/2⌉ = ceil(j/2)
		int s = j2 * j2 * ((j & 1) == 1 ? -1 : 1); // ceil(j/2)^2 * (-1)^j
		int result = (hash - s) % size;
		if (result < 0)
			result += size;
		return result;
	}

	/**
	 * Presentation of hash function which is MOD from the value of an element
	 *
	 * @param element is the concrete element
	 * @param size    hashtable size
	 * @return value for calculating the position
	 */
	static int hashFunction(int element, int size) {
		return element % size;
	}

	/**
	 * Method searches an element in the array hash table
	 *
	 * @param hashtable a hashset represented as an array
	 * @param element   the value to search for (always greater than -1)
	 * @return true if elements is in the hash set
	 */
	@Override
	public boolean containedInHashSet(int[] hashtable, int element) {
		int pos = findPosition(hashtable, element);
		return pos != -1 && hashtable[pos] == element;
	}
}

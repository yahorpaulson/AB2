package ab2;

public interface Ab2 {

	/**
	 * Eine Klasse um eine einfach-verkettete Liste zu repräsentieren.
	 * A class to represent a singly-linked list.
	 */
	public class ListNode {
		public ListNode next; /** Pointer to next element */
		public int value; /** The value of the current element */
	}

	/**
	 * Eine Klasse um einen Stack auf Basis einer einfach verketteten Liste
	 * zu repärsentieren. Das erste Element der Liste soll immer das
	 * zuletzt hinzugefügte Element sein.
	 *
	 * A class to represent a stack, based on a singly-linked list. The
	 * most recently added element should always be the first element in
	 * the list.
	 */
	public class Stack {
		public ListNode head;
	}

	/**
	 * Implementieren Sie die Stack-Datenstruktur (LIFO) auf Basis einer
	 * einfach verketteten Liste. Die Push-Operation fügt ein neues Element
	 * vor dem Head-Element der Liste des Stacks ein.
	 *
	 * Implement a stack data structure (LIFO) based on a singly-linked
	 * list. The push operation adds a new element to before the head of
	 * the list representing the stack.
	 *
	 * @param stack Der Stack auf den das Element gelegt werden soll
	 * 	        The stack onto which the given element should be pushed
	 *
	 * @param element Das hinzuzufügende Element
	 *                The element to be added
	 */
	public void push(Stack stack, int element);
	
	
	/**
	 * Implementieren Sie die Stack-Datenstruktur (LIFO) auf Basis einer
	 * einfach verketteten Liste. Die Pop-Operation entfernt das zuletzt
	 * hinzugefügte Element aus dem Stack und gibt dessen Wert zurück.
	 *
	 * Implement a stack data structure (LIFO) based on a singly-linked
	 * list. The pop operation removes the most recently added element from
	 * the stack and returns its value.
	 *
	 * @param stack Der Stack, von dem das neueste Element entfernt werden soll
	 *              The stack from which the newest element should be popped
	 *
	 * @return Den Wert des entfernten Elements
	 *         The value of the removed element
	 */
	public int pop(Stack stack);
	
	
	/**
	 * Implementieren Sie die Methode der exponentiellen Suche mit
	 * anschließender binärer Suche basierend auf einem sortierten
	 * Eingabe-Array.
	 *
	 * Implement the exponential search procedure with subsequent binary
	 * search based on a sorted input array.
	 *
	 * @param data Das zu durchsuchende Array, welches immer sortiert ist
	 *             The array to be searched, which is always sorted
	 *
	 * @param element Das gesuchte Element
	 *                The element to be searched for
	 *
	 * @return Die Position, an der das Element gefunden wurde, oder sonst -1
	 *         The position where the element was found, or -1 otherwise
	 */
	public int exponentialSearch(int[] data, int element);

	/**
	 * Fügt ein Element in ein Array ein, welches eine Menge an
	 * Integer-Werten in Form einer Hashtabelle repräsentiert. Leere
	 * Stellen im Hashtabellen-Array sind mit dem Integer-Wert '-1'
	 * gefüllt. Zum Einfügen soll f(k) = k mod n als Hashfunktion verwendet
	 * werden, wobei n gleich der Länge des übergebenen Arrays ist. Bei
	 * Kollisionen soll quadratisches Sondieren angewendet werden. Sie
	 * können davon ausgehen, nur Arrays übergeben zu bekommen, in denen
	 * alle Werte -1 sind, oder in die Elemente mittels dieser Methode
	 * eingefügt wurden.
	 *
	 * Inserts an element into an array representing a set of integer
	 * values as a hashset. Empty cells are marked with value '-1'. Use
	 * f(k) = k mod n as the hash function for inserting into the hashset,
	 * where n is the length of the given array. To avoid collisions, use
	 * quadratic probing. You can assume that input arrays either contain
	 * only the value '-1' in all cells, or that the array has been
	 * modified using only the present method.
	 *
	 * @param hashtable eine Hashtabelle in Form eines Arrays
	 *                  a hashset represented as an array
	 *
	 * @param element das einzufügende Element (sicher größer als -1)
	 *                the value to be added (always greater than -1)
	 */
	public void insertIntoHashSet(int[] hashtable, int element);

	/**
	 * Sucht ein Element in einem Array, welches eine Menge an
	 * Integer-Werten in Form einer Hashtabelle repräsentiert. Leere
	 * Stellen im Hashtabellen-Array sind mit dem Integer-Wert '-1'
	 * gefüllt. Zum Einfügen soll f(k) = k mod n als Hashfunktion verwendet
	 * werden, wobei n gleich der Länge des übergebenen Arrays ist. Bei
	 * Kollisionen soll quadratisches Sondieren angewendet werden. Sie können
	 * davon ausgehen, nur Arrays übergeben zu bekommen, in denen alle
	 * Werte -1 sind, oder in die Elemente mittels der obigen Methode
	 * eingefügt wurden.
	 *
	 * Inserts an element into an array representing a set of integer
	 * values as a hashset. Empty cells are marked with value '-1'. Use
	 * f(k) = k mod n as the hash function for inserting into the hashset,
	 * where n is the length of the given array. To avoid collisions, use
	 * quadratic probing. You can assume that input arrays either contain
	 * only the value '-1' in all cells, or that the array has been
	 * modified using only the method above.
	 *
	 * @param hashtable eine Hashtabelle in Form eines Arrays
	 *                  a hashset represented as an array
	 *
	 * @param element das gesuchte Element (sicher größer als -1)
	 *                the value to search for (always greater than -1)
	 *
	 * @return true wenn gefunden, sonst false
	 *         true if found, otherwise false
	 */
	public boolean containedInHashSet(int[] hashtable, int element);
}

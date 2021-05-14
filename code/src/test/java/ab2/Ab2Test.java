package ab2;

import ab2.impl.Siarheyeu.Ab2Impl;
import ab2.Ab2.Stack;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Ab2Test {

	private Random rand = new Random(System.currentTimeMillis());

	private static Ab2 ab2Impl = new Ab2Impl();

	private static int pts = 0;

	private static int NUM_TESTS = 50;
	private static int NUM_TESTS_LARGE = 500000;
	private static int ARRAY_SIZE_SMALL = 20000;
	private static int ARRAY_SIZE_LARGE = 500000;
	private static int ARRAY_SIZE_HUGE = 25_000_000;
	private static int HASHSET_SIZE = 6691; // prime number
	private static int HASHSET_SIZE_LARGE = 10_003_121; // prime number

	//assertEquals
	//assertTrue
	//assertArrayEquals
	
	@Test
	public void testStackPushOnePopOne()
	{
		int[] test = getRandomArray(ARRAY_SIZE_LARGE);
		Stack stack = new Stack();

		for (int j : test) {
			ab2Impl.push(stack, j);
			assertEquals(j, ab2Impl.pop(stack));
		}
	}

	@Test
	public void testStackPushAllPopAll()
	{
		int[] test = getRandomArray(ARRAY_SIZE_LARGE);
		Stack stack = new Stack();

		for (int j : test) ab2Impl.push(stack, j);

		for(int i = test.length - 1; i >= 0; --i)
			assertEquals(test[i], ab2Impl.pop(stack));
	}

	@Test
	public void testExponentialSearchFound()
	{
		int[] test = getRandomSortedArray(ARRAY_SIZE_HUGE);

		for(int i = 0; i < test.length; ++i)
		{
			assertEquals(i, ab2Impl.exponentialSearch(test, test[i]));
		}
	}

	@Test
	public void testExponentialSearchNotFound()
	{
		int[] test = getRandomSortedArray(ARRAY_SIZE_HUGE);

		assertEquals(-1, ab2Impl.exponentialSearch(test, 0));
		assertEquals(-1, ab2Impl.exponentialSearch(test, test[test.length - 1] + 1));

		for(int i = 1; i < test.length; ++i)
			if(test[i] - test[i-1] < 2) continue;
			else assertEquals(-1, ab2Impl.exponentialSearch(test, (test[i] + test[i-1])/2));
	}

	@Test
	public void testHashSet() throws Exception {
		int[] test = new int[HASHSET_SIZE]; 
		HashSet<Integer> hashSetRef = new HashSet<>();
		
		for(int i = 0; i < test.length; ++i)
			test[i] = -1; // initialize 

		for (int i = 0; i < HASHSET_SIZE; i++) {
		    int val = rand.nextInt(30*HASHSET_SIZE);

		    ab2Impl.insertIntoHashSet(test, val);
		    hashSetRef.add(val);

		    int val2 = rand.nextInt(30*HASHSET_SIZE);

		    assertEquals(hashSetRef.contains(val2), ab2Impl.containedInHashSet(test, val2));
		}
	}

	@Test
	public void testHashSetDuplicates() throws Exception {
		int[] test = new int[HASHSET_SIZE]; 
		HashSet<Integer> hashSetRef = new HashSet<>();
		
		for(int i = 0; i < test.length; ++i)
			test[i] = -1; // initialize

		for (int i = 0; i < HASHSET_SIZE; i++) {
		    int val = rand.nextInt(30*HASHSET_SIZE);

		    ab2Impl.insertIntoHashSet(test, val);
		    ab2Impl.insertIntoHashSet(test, val);
		    ab2Impl.insertIntoHashSet(test, val);
		    hashSetRef.add(val);
		    hashSetRef.add(val);
		    hashSetRef.add(val);

		    int val2 = rand.nextInt(30*HASHSET_SIZE);

		    assertEquals(hashSetRef.contains(val), ab2Impl.containedInHashSet(test, val));
		    assertEquals(hashSetRef.contains(val2), ab2Impl.containedInHashSet(test, val2));
		}
	}

	@Test
	public void testHashSetCollisions() throws Exception {
		int[] test = new int[HASHSET_SIZE]; 
		HashSet<Integer> hashSetRef = new HashSet<>();
		
		for(int i = 0; i < test.length; ++i)
			test[i] = -1; // initialize 


	    	int val = rand.nextInt(HASHSET_SIZE);
		for (int i = 0; i < HASHSET_SIZE/2; i++)
		{
		    ab2Impl.insertIntoHashSet(test, val);
		    hashSetRef.add(val);
		    assertEquals(hashSetRef.contains(val), ab2Impl.containedInHashSet(test, val));
		    if(val - HASHSET_SIZE > 0) assertEquals(hashSetRef.contains(val - HASHSET_SIZE), ab2Impl.containedInHashSet(test, val - HASHSET_SIZE));
		    val += HASHSET_SIZE;
		}
	}

	private int[] getRandomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = Math.abs(rand.nextInt(2 * size));
		return arr;
	}

	private int[] getRandomSortedArray(int size) {
		int[] arr = new int[size];
		int prev = 1;
		for (int i = 0; i < size; i++)
			prev = arr[i] = prev + 1 + Math.abs(rand.nextInt(10));
		return arr;
	}
}

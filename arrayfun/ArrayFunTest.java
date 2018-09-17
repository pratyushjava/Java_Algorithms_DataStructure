
/** 
 * This class has a few @Test methods for testing a 
 * few of the 15 required methods in ArrayFun.java.
 * This will require you to write all @Test methods for 
 * most of the functions specified in ArrayFun.java
 * 
 * @author Pratyush Singh
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class ArrayFunTest {

	// If you include this variable, you can use myFun in all @Tests
	private ArrayFun myFun = new ArrayFun();

	@Test
	public void testFailedNumberOfPairsWhenNone() {
		String[] s = { "a", "a", "a" };
		assertEquals(2, myFun.numberOfPairs(s));

		assertEquals(0, myFun.numberOfPairs(new String[] { "a", "b", "c" }));
		assertEquals(2, myFun.numberOfPairs(new String[] { "a", "a", "a" }));
		assertEquals(2, myFun.numberOfPairs(new String[] { "a", "a", "b", "b" }));
		assertEquals(0, myFun.numberOfPairs(new String[] {}));
		assertEquals(0, myFun.numberOfPairs(new String[] { "a" }));
		assertEquals(5, myFun.numberOfPairs(new String[] { "a", "a", "a", "a", "a", "b", "b" }));

	}

	// test numberOfVowels function
	@Test
	public void testNumOfVowels() {
		assertEquals(10, myFun.numberOfVowels(new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' }));
		assertEquals(0, myFun.numberOfVowels(new char[] { 'y', 'Y' }));
		assertEquals(2, myFun.numberOfVowels(new char[] { 'a', 'X', 'a' }));
		assertEquals(0, myFun.numberOfVowels(new char[] {}));

	}

	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 4.0) returns true
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 6.6) returns false
	// sumGreaterThan( { }, -1.0) returns false
	// test sumGreaterThan function
	@Test
	public void testsumGreaterThan() {
		assertTrue(myFun.sumGreaterThan(new double[] { 1.1, 2.2, 3.3 }, 4.0));
		assertFalse(myFun.sumGreaterThan(new double[] { 1.1, 2.2, 3.3 }, 6.6));
		assertFalse(myFun.sumGreaterThan(new double[] {}, -1.0));

	}
	// You will need to write your own @Test methods and assertions
	// for most of the 15 methods in ArrayFun

	@Test
	// KEEP THIS BECAUSE IT IS PROMISED IN THE SPEC
	public void testStats() {
		Scanner scanner = new Scanner("90.0 80.0 70.0 68.0");
		double[] result = myFun.stats(scanner);
		assertEquals(3, result.length); // The capacity is always 3
		assertEquals(90.0, result[0], 1e-12); // The maximum is at index 0
		assertEquals(68.0, result[1], 1e-12); // The minimum is at index 1
		assertEquals(77.0, result[2], 1e-12); // The average is at index 2

		scanner = new Scanner("90.0 80.0 -70.0 68.0");
		result = myFun.stats(scanner);
		assertEquals(3, result.length); // The capacity is always 3
		assertEquals(90.0, result[0], 1e-12); // The maximum is at index 0
		assertEquals(-70.0, result[1], 1e-12); // The minimum is at index 1
		assertEquals(42.0, result[2], 1e-12); // The average is at index 2

	}

	@Test
	// KEEP THIS BECAUSE IT IS PROMISED IN THE SPEC
	public void testFrequencyWithOneZeroTwoOnesTwoTwosTwoFiveAndNoThreesOrFours() {
		Scanner scanner = new Scanner("5 0 1 2 1 5 2");

		int[] result = myFun.frequency(scanner);
		assertEquals(11, result.length);

		assertEquals(1, result[0]); // There was 1 zero
		assertEquals(2, result[1]);
		assertEquals(2, result[2]);
		assertEquals(0, result[3]);
		assertEquals(0, result[4]);
		assertEquals(2, result[5]); // There were 2 5s
		for (int score = 6; score <= 10; score++)
			assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s

		scanner = new Scanner("5 0 1 2 1 5 2 3 6");

		result = myFun.frequency(scanner);
		assertEquals(11, result.length);

		assertEquals(1, result[0]); // There was 1 zero
		assertEquals(2, result[1]);
		assertEquals(2, result[2]);
		assertEquals(1, result[3]);
		assertEquals(0, result[4]);
		assertEquals(2, result[5]); // There were 2 5s
		assertEquals(1, result[6]);
		for (int score = 7; score <= 10; score++)
			assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s

	}

	// test howMany function
	@Test
	public void testhowMany() {
		assertEquals(2, myFun.howMany(new String[] { "A", "a", "A", "a" }, "A"));
		assertEquals(1, myFun.howMany(new String[] { "And", "there", "goes", "another" }, "another"));
		assertEquals(0, myFun.howMany(new String[] { "And", "there", "goes", "another" }, "Not Here"));
		assertEquals(0, myFun.howMany(new String[] {}, "empty array"));
	}

	@Test
	public void testSortOfSort2() {
		int[] x = { 4, 80, 3, 90, 2, 70, 1 };
		myFun.sortOfSort(x);
		assertEquals(1, x[0]);
		assertEquals(90, x[6]);
		assertEquals(159, x[1] + x[2] + x[3] + x[4] + x[5]);

		x = new int[] { 4, 80, 100, 90, 2, 70, 1 };
		myFun.sortOfSort(x);
		assertEquals(1, x[0]);
		assertEquals(100, x[6]);
		assertEquals(246, x[1] + x[2] + x[3] + x[4] + x[5]);

		x = new int[] { 4, 3, 2, 0, 1, 2 };
		myFun.sortOfSort(x);
		assertEquals(0, x[0]);
		assertEquals(4, x[5]);

	}

	@Test
	public void testEvensLeft() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		myFun.evensLeft(a);

		// left side of the array at indexes 0..2 is even
		for (int i = 0; i <= 2; i++)
			assertEquals(0, a[i] % 2);

		// right side of the array at indexes 3..6 is odd
		for (int i = 3; i <= 6; i++)
			assertEquals(1, a[i] % 2);

		// {1, 0, 1, 0, 0, 1, 1} . { 0, 0, 0, 1, 1, 1, 1 }
		// {3, 3, 2} . . . . . . . { 2, 3, 3 }
		// {2, 2, 2} . . . . . . . { 2, 2, 2}

		a = new int[] { 1, 0, 1, 0, 0, 1, 1 };
		myFun.evensLeft(a);

		// left side of the array at indexes 0..2 is even
		for (int i = 0; i <= 2; i++)
			assertEquals(0, a[i]);

		// right side of the array at indexes 3..6 is odd
		for (int i = 3; i <= 6; i++)
			assertEquals(1, a[i]);

		a = new int[] { 3, 3, 2 };
		myFun.evensLeft(a);

		// left side of the array at indexes 0..2 is even
		assertEquals(2, a[0]);

		// right side of the array at indexes 3..6 is odd
		for (int i = 1; i <= 2; i++)
			assertEquals(3, a[i]);

		a = new int[] { 2, 2, 2 };
		myFun.evensLeft(a);

		// left side of the array at indexes 0..2 is even
		assertEquals(2, a[0]);
		assertEquals(2, a[1]);
		assertEquals(2, a[2]);

	}

	// tets shiftNTimes
	@Test
	public void testshiftNTimes() {
		int[] x = { 1, 2, 3, 4, 5, 6, 7 };
		myFun.shiftNTimes(x, 3);
		assertEquals(4, x[0]);
		assertEquals(5, x[1]);
		assertEquals(6, x[2]);
		assertEquals(7, x[3]);
		assertEquals(1, x[4]);
		assertEquals(2, x[5]);
		assertEquals(3, x[6]);

		x = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		myFun.shiftNTimes(x, 0);
		assertEquals(1, x[0]);
		assertEquals(2, x[1]);
		assertEquals(3, x[2]);
		assertEquals(4, x[3]);
		assertEquals(5, x[4]);
		assertEquals(6, x[5]);
		assertEquals(7, x[6]);

		x = new int[] { 1, 2, 3 };
		myFun.shiftNTimes(x, 5);
		assertEquals(3, x[0]);
		assertEquals(1, x[1]);
		assertEquals(2, x[2]);

		x = new int[] { 3 };
		myFun.shiftNTimes(x, 5);
		assertEquals(3, x[0]);
	}

	// replaced ({'A', 'B', 'C', 'D', 'B'}, 'B', '+') returns a
	// new array {'A', '+', 'C', 'D', '+'}
	//
	// replaced( { 'A', 'B', 'C', 'D', 'B'}, 'C', 'L' ) returns a
	// new array { 'A', 'B', 'L', 'D', 'B' }
	//
	// replaced( { 'n', 'n', 'n', 'D', 'n'}, 'n', 'T' ) returns a
	// new array { 'T', 'T', 'T', 'D', 'T' }
	//
	// replaced( { }, 'n', 'T' ) returns a
	// new array { }

	@Test
	public void testreplaced() {
		char[] x = { 'A', 'B', 'C', 'D', 'B' };
		char[] newX = myFun.replaced(x, 'B', '+');
		assertTrue(Arrays.equals(new char[] { 'A', 'B', 'C', 'D', 'B' }, x));
		assertTrue(Arrays.equals(new char[] { 'A', '+', 'C', 'D', '+' }, newX));
		assertEquals(5, x.length);
		assertEquals(5, newX.length);

		newX = myFun.replaced(x, 'C', 'L');
		assertTrue(Arrays.equals(new char[] { 'A', 'B', 'C', 'D', 'B' }, x));
		assertTrue(Arrays.equals(new char[] { 'A', 'B', 'L', 'D', 'B' }, newX));
		assertEquals(5, x.length);
		assertEquals(5, newX.length);

		char[] a = { 'n', 'n', 'n', 'D', 'n' };
		char[] newA = myFun.replaced(a, 'n', 'T');
		assertTrue(Arrays.equals(new char[] { 'n', 'n', 'n', 'D', 'n' }, a));
		assertTrue(Arrays.equals(new char[] { 'T', 'T', 'T', 'D', 'T' }, newA));
		assertEquals(5, a.length);
		assertEquals(5, newA.length);
	}

	@Test
	public void testFailedRange5() {
		int[] x = { -1, 1, -2, 2, -3, 4, -4, 4 };
		assertEquals(8, myFun.range(x));

		x = new int[] { 1, 2, 3, 4 };
		assertEquals(3, myFun.range(x));

		x = new int[] { 1, 2, -3, 4 };
		assertEquals(7, myFun.range(x));

		x = new int[] { 99 };
		assertEquals(0, myFun.range(x));

		x = new int[] {};
		assertEquals(0, myFun.range(x));
	}

	// test found methos
	@Test
	public void tetsFound() {
		assertTrue(myFun.found("A", new String[] { "A", "B", "C" }));
		assertFalse(myFun.found("a", new String[] { "A", "B", "C" }));
		assertFalse(myFun.found("x", new String[] { "a", "b", "c", "d" }));
		assertFalse(myFun.found("x", new String[] {}));
	}

	// test sort
	@Test
	public void tetsSort() {
		String[] s = new String[] { "B", "C", "A" };
		myFun.sort(s);
		assertTrue(Arrays.equals(new String[] { "A", "B", "C" }, s));

		s = new String[] { "g", "a", "X" };
		myFun.sort(s);
		assertTrue(Arrays.equals(new String[] { "X", "a", "g" }, s));
	}

	@Test
	public void fizzBuzz1() {
		String[] strs = myFun.fizzBuzz(1000, 1006);
		assertEquals(6, strs.length);
		assertEquals("Buzz", strs[0]);
		assertEquals("1001", strs[1]);
		assertEquals("Fizz", strs[2]);
		assertEquals("1003", strs[3]);
		assertEquals("1004", strs[4]);
		assertEquals("FizzBuzz", strs[5]);

		String[] strs1 = myFun.fizzBuzz(1, 6);
		assertEquals(5, strs1.length);
		assertEquals("1", strs1[0]);
		assertEquals("2", strs1[1]);
		assertEquals("Fizz", strs1[2]);
		assertEquals("4", strs1[3]);
		assertEquals("Buzz", strs1[4]);

		String[] strs2 = myFun.fizzBuzz(1, 8);
		assertEquals(7, strs2.length);
		assertEquals("1", strs2[0]);
		assertEquals("2", strs2[1]);
		assertEquals("Fizz", strs2[2]);
		assertEquals("4", strs2[3]);
		assertEquals("Buzz", strs2[4]);
		assertEquals("Fizz", strs2[5]);
		assertEquals("7", strs2[6]);

		String[] strs3 = myFun.fizzBuzz(1, 8);
		assertEquals(7, strs3.length);
		assertEquals("1", strs3[0]);
		assertEquals("2", strs3[1]);
		assertEquals("Fizz", strs3[2]);
		assertEquals("4", strs3[3]);
		assertEquals("Buzz", strs3[4]);
		assertEquals("Fizz", strs3[5]);
		assertEquals("7", strs3[6]);

		String[] strs4 = myFun.fizzBuzz(14, 21);
		assertEquals(7, strs4.length);
		assertEquals("14", strs4[0]);
		assertEquals("FizzBuzz", strs4[1]);
		assertEquals("16", strs4[2]);
		assertEquals("17", strs4[3]);
		assertEquals("Fizz", strs4[4]);
		assertEquals("19", strs4[5]);
		assertEquals("Buzz", strs4[6]);

		String[] strs5 = myFun.fizzBuzz(-6, -1);
		assertEquals(5, strs5.length);
		assertEquals("Fizz", strs5[0]);
		assertEquals("Buzz", strs5[1]);
		assertEquals("-4", strs5[2]);
		assertEquals("Fizz", strs5[3]);
		assertEquals("-2", strs5[4]);

	}

	// test maxSpan
	@Test
	public void testMaxSpan() {

		assertEquals(4, myFun.maxSpan(new int[] { 1, 2, 1, 1, 3 }));
		assertEquals(6, myFun.maxSpan(new int[] { 1, 4, 2, 1, 4, 1, 4 }));
		assertEquals(4, myFun.maxSpan(new int[] { 5, 5, 5, 5 }));
		assertEquals(1, myFun.maxSpan(new int[] { 99 }));
		assertEquals(0, myFun.maxSpan(new int[] {}));
	}

}

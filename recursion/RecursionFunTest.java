
// A unit test for Recursion fun that require 
// 12 free standing methods like combinations and arrayRange
// 2 methods in LinkedList<E>
// --- get(E) 
// --- duplicateElement(E)
// private boolean findExit(int row, int col) the uses recursive back tracking
// to find the exit in ObstacleCourse.
import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionFunTest {

	private RecursionFun rf = new RecursionFun();

	@Test
	public void testCombinations() {
		// n choices when choosing only 1
		assertEquals(1, rf.combinations(1, 1));
		assertEquals(5, rf.combinations(5, 1));
		assertEquals(178, rf.combinations(178, 1));

		// 1 choice when n==k
		assertEquals(1, rf.combinations(5, 5));
		assertEquals(1, rf.combinations(178, 178));

		// some simple ones
		assertEquals(4, rf.combinations(4, 3));
		assertEquals(3, rf.combinations(3, 2));
		assertEquals(6, rf.combinations(4, 2));
		assertEquals(10, rf.combinations(5, 2));

		// There are 2,598,960 possible poker hands:
		assertEquals(2598960, rf.combinations(52, 5));
	}

	@Test
	public void testFactorial() {
		assertEquals(1, rf.factorial(0));
		assertEquals(1, rf.factorial(1));
		assertEquals(2, rf.factorial(2));
		assertEquals(6, rf.factorial(3));
		assertEquals(24, rf.factorial(4));
	}

	@Test
	public void testAddreciprocals() {
		assertEquals(1.0, rf.addReciprocals(1), 1e-12);
		assertEquals(1.5, rf.addReciprocals(2), 1e-12);
		assertEquals(1.83333333333333, rf.addReciprocals(3), 1e-12);
		assertEquals(2.083333333333333, rf.addReciprocals(4), 1e-12);
	}

	@Test
	public void testGCD() {
		assertEquals(3, rf.GCD(24, 9));
		assertEquals(1, rf.GCD(17, 14));
		assertEquals(1, rf.GCD(14, 17));
		assertEquals(25, rf.GCD(25, 50));
		assertEquals(88, rf.GCD(88, 88));
		assertEquals(5, rf.GCD(35, 5));
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(rf.isPalindrome("racecar"));
		assertTrue(rf.isPalindrome(""));
		assertTrue(rf.isPalindrome("!"));
		assertTrue(rf.isPalindrome("abba"));
		assertFalse(rf.isPalindrome("aBba"));
		assertFalse(rf.isPalindrome("123"));
	}

	@Test
	public void testUnderscore() {
		assertEquals("", rf.underScore(""));
		assertEquals("t", rf.underScore("t"));
		assertEquals("tr", rf.underScore("tr"));
		assertEquals("hel_lo", rf.underScore("hello"));
		assertEquals("x_xy_y", rf.underScore("xxyy"));
		assertEquals("a_a_a_a", rf.underScore("aaaa"));
	}

	@Test
	public void testNoadjacents() {
		assertEquals("", rf.noAdjacents(""));
		assertEquals("a", rf.noAdjacents("a"));
		assertEquals("a", rf.noAdjacents("aa"));
		assertEquals("a", rf.noAdjacents("aaaaa"));
		assertEquals("ab", rf.noAdjacents("aabb"));
		assertEquals("yza", rf.noAdjacents("yyzzza"));
		assertEquals("abcd", rf.noAdjacents("abbbcd"));
		assertEquals("Helo", rf.noAdjacents("Hello"));
	}

	@Test
	public void testIntwithcommas() {
		assertEquals("9", rf.intWithCommas(9));
		assertEquals("123", rf.intWithCommas(123));
		assertEquals("1,234", rf.intWithCommas(1234));
		assertEquals("2,147,483,647", rf.intWithCommas(Integer.MAX_VALUE));
		assertEquals("1,007", rf.intWithCommas(1007));
		assertEquals("1,027", rf.intWithCommas(1027));
		assertEquals("1,000", rf.intWithCommas(1000));
		assertEquals("1,023,004,567", rf.intWithCommas(1023004567));
	}

	@Test
	public void testReverseWithLengthThree() {
		int[] a = { 2, 4, 6 };
		rf.reverseArray(a);
		assertEquals(6, a[0]);
		assertEquals(4, a[1]);
		assertEquals(2, a[2]);
		rf.reverseArray(a);
		assertEquals(6, a[2]);
		assertEquals(4, a[1]);
		assertEquals(2, a[0]);
	}

	@Test
	public void testReverse() {
		int[] b = { 2 };
		rf.reverseArray(b);
		assertEquals(2, b[0]);
		rf.reverseArray(b);
		assertEquals(2, b[0]);

		int[] a = { 2, 4, 6, 8 };
		rf.reverseArray(a);
		assertEquals(8, a[0]);
		assertEquals(6, a[1]);
		assertEquals(4, a[2]);
		assertEquals(2, a[3]);
		rf.reverseArray(a);
		assertEquals(2, a[0]);
		assertEquals(4, a[1]);
		assertEquals(6, a[2]);
		assertEquals(8, a[3]);
	}

	@Test
	public void testArrayrange() {
		assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
		assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
		assertEquals(0, rf.arrayRange(new int[] { 3 }));
		assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	}

	@Test
	public void testIssorted() {
		assertTrue(rf.isSorted(new int[] { 1, 2, 3 }));
		assertTrue(rf.isSorted(new int[] { 2, 2, 2 }));
		assertTrue(rf.isSorted(new int[] { 1 }));
		assertTrue(rf.isSorted(new int[] {}));
		assertFalse(rf.isSorted(new int[] { 2, 1 }));
		assertFalse(rf.isSorted(new int[] { 2, 3, 4, 5, 4 }));
	}

	@Test
	public void testFound() {
		String[] strs = { "Ttt", "Ccc", "Fff", "Ddd", "Hhh", "Aaa" };
		assertTrue(rf.found("Aaa", strs));
		assertTrue(rf.found("Hhh", strs));
		assertFalse(rf.found("Not Here", strs));
	}

	//////////////////////////////////////////////////////////
	// Test the two LinkedList methods in class LinkedList<E>
	// that started as incomplete. Other methods are recursive
	//////////////////////////////////////////////////////////

	@Test
	public void testLinkedlistGet() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
	}

	@Test
	public void testDuplicateallWhenEmpty() {
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(0, list.size());
		list.duplicateAll("B");
		assertEquals(0, list.size());
		list.addLast("B");
		list.duplicateAll("B");
		assertEquals("B", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals(2, list.size());
	}

	@Test
	public void testDuplicateAllWhenNotFound() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("X");
		assertEquals(2, list.size());
		list.duplicateAll("B");
		assertEquals("A", list.get(0));
		assertEquals("X", list.get(1));
		assertEquals(2, list.size());
	}

	@Test
	public void testDuplicateAllWhenThreeAtBegining() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("B");
		list.addLast("B");
		list.addLast("B");
		list.addLast("X");
		list.addLast("A");
		assertEquals(5, list.size());
		list.duplicateAll("B");
		assertEquals("B", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("B", list.get(3));
		assertEquals("B", list.get(4));
		assertEquals("B", list.get(5));
		assertEquals("X", list.get(6));
		assertEquals("A", list.get(7));
		assertEquals(8, list.size());
	}

	@Test
	public void testFindExitWithSmallGrid1() {
		char[][] grid = { { '+', '+', '+', '+' }, { '+', ' ', ' ', '+' }, { '+', ' ', ' ', '+' },
				{ '+', ' ', ' ', '+' }, { '+', ' ', '+', '+' } };
		ObstacleCourse top = new ObstacleCourse(2, 2, grid);
		assertEquals(2, top.getStartRow());
		assertEquals(2, top.getStartColumn());
		top.findTheExit();
		assertEquals(4, top.getExitRow());
		assertEquals(1, top.getExitColumn());
	}

	@Test
	public void testFindExitWithSmallGrid2() {
		char[][] grid = { { '+', '+', '+', '+' }, { ' ', ' ', ' ', '+' }, { '+', ' ', ' ', '+' },
				{ '+', ' ', ' ', '+' }, { '+', '+', '+', '+' } };
		ObstacleCourse top = new ObstacleCourse(2, 2, grid);
		assertEquals(2, top.getStartRow());
		assertEquals(2, top.getStartColumn());
		top.findTheExit();
		assertEquals(1, top.getExitRow());
		assertEquals(0, top.getExitColumn());
	}

	@Test
	public void testFindExitWithSmallGrid3() {
		char[][] grid = { { '+', '+', ' ', '+' }, { ' ', ' ', ' ', '+' }, { '+', ' ', ' ', '+' },
				{ '+', ' ', ' ', '+' }, { '+', '+', '+', '+' } };
		ObstacleCourse top = new ObstacleCourse(3, 1, grid);
		assertEquals(3, top.getStartRow());
		assertEquals(1, top.getStartColumn());
		top.findTheExit();
		assertEquals(0, top.getExitRow());
		assertEquals(2, top.getExitColumn());
	}

	@Test
	public void testFindExitWithSmallGrid4() {
		char[][] grid = { { '+', '+', '+', '+', '+' }, { '+', ' ', ' ', ' ', '+' }, { '+', ' ', '+', ' ', '+' },
				{ '+', '+', '+', ' ', ' ' }, { '+', '+', '+', '+', '+' } };
		ObstacleCourse top = new ObstacleCourse(1, 1, grid);
		assertEquals(1, top.getStartRow());
		assertEquals(1, top.getStartColumn());
		System.out.println(top.toString());
		top.findTheExit();
		assertEquals(3, top.getExitRow());
		assertEquals(4, top.getExitColumn());
		System.out.println(top.toString());
	}

	@Test
	public void testFindExitWithSmallGridNoExit() {
		char[][] grid = { { '+', '+', '+', '+', '+' }, { '+', ' ', ' ', ' ', '+' }, { '+', ' ', '+', ' ', '+' },
				{ '+', '+', '+', ' ', '+' }, { '+', '+', '+', '+', '+' } };
		ObstacleCourse top = new ObstacleCourse(1, 1, grid);
		assertEquals(1, top.getStartRow());
		assertEquals(1, top.getStartColumn());
		System.out.println(top.toString());
		top.findTheExit();
		assertEquals(-1, top.getExitRow());
		assertEquals(-1, top.getExitColumn());
		System.out.println(top.toString());
	}

}
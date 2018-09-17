
/*
 * This unit test has at least one @Test method for each of the 15 methods 
 * in ControlFun2.java. However, they are incomplete, and do not represent 
 * 100% code coverage. This is meant to encourage you to think of other 
 * needed test cases and add your own asserts. 
 * 
 * We will run a unit test that is much much larger than this starter unit test. 
 * 
 * We will also run your tests to see code coverage, which is part of your grade.
 * 
 * Think of as many test cases as you can
 * 
 * Programmers: Pratyush Singh
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class ControlFun2Test {

	private ControlFun2 myFun = new ControlFun2();

	@Test
	// Recommended: Run one @Test method at a time as you work on only
	// one method at a time.
	// 1. Highlight the method name
	// 2. Right click on that method name
	// 3. From the menu, select: Run As > JUnit Test
	public void testCombostring() {
		assertEquals("hiHellohi", myFun.comboString("Hello", "hi"));
		assertEquals("hiHellohi", myFun.comboString("hi", "Hello"));
		assertEquals("baaab", myFun.comboString("aaa", "b"));
		assertEquals("", myFun.comboString("aaa", "bbb"));
		assertEquals("b", myFun.comboString("", "b"));
		assertEquals("a", myFun.comboString("a", ""));
		assertEquals("", myFun.comboString("", ""));

	}

	@Test
	public void testSortasum() {
		assertEquals(7, myFun.sortaSum(3, 4));
		assertEquals(20, myFun.sortaSum(7, 4));
		assertEquals(21, myFun.sortaSum(10, 11));
		assertEquals(9, myFun.sortaSum(5, 4));
	}

	@Test
	public void testMincat() {
		assertEquals("123456", myFun.minCat("123", "456"));
		assertEquals("loHi", myFun.minCat("Hello", "Hi"));
		assertEquals("ellojava", myFun.minCat("Hello", "java"));
		assertEquals("javaello", myFun.minCat("java", "Hello"));
	}

	@Test
	public void testSalary() {
		assertEquals(1500.0, myFun.salary(9999.00), 0.01);
		assertEquals(1500.0, myFun.salary(10000.00), 0.01);
		assertEquals(1500.05, myFun.salary(10001.00), 0.01);
		assertEquals(2000, myFun.salary(20000.00), 0.01);
		assertEquals(2000.08, myFun.salary(20001.00), 0.01);
		assertEquals(2800, myFun.salary(30000.00), 0.01);
		assertEquals(2800.12, myFun.salary(30001.00), 0.01);
		assertEquals(4000.0, myFun.salary(40000.00), 0.01);
		assertEquals(0.0, myFun.salary(-5), 0.01);
	}

	@Test
	public void testFirstofthree() {
		assertEquals("Ma", myFun.firstOf3Strings("Ma", "ma", "ma"));
		assertEquals("Ma", myFun.firstOf3Strings("Ma", "ma", "mA"));
		assertEquals("a", myFun.firstOf3Strings("a", "b", "c"));
		assertEquals("a", myFun.firstOf3Strings("b", "a", "c"));
		assertEquals("a", myFun.firstOf3Strings("c", "b", "a"));

		assertEquals("X", myFun.firstOf3Strings("X", "b", "c"));
		assertEquals("X", myFun.firstOf3Strings("b", "X", "c"));
		assertEquals("X", myFun.firstOf3Strings("c", "b", "X"));
		assertEquals("123", myFun.firstOf3Strings("123", "1231", "123 0"));
		assertEquals("123", myFun.firstOf3Strings("1231", "123", "123 0"));
		assertEquals("123", myFun.firstOf3Strings("123 0", "1231", "123"));
		assertEquals(" ", myFun.firstOf3Strings("c", " ", "a"));
	}

	@Test
	public void testAnswerOrNot() {
		assertFalse(myFun.answerOrNot(true, true, true));
		assertFalse(myFun.answerOrNot(false, true, true));
		assertTrue(myFun.answerOrNot(true, true, false));
		assertFalse(myFun.answerOrNot(true, false, false));

		assertTrue(myFun.answerOrNot(false, false, false));
		assertTrue(myFun.answerOrNot(false, true, false));

		// TODO: Add more assertions
	}

	@Test
	public void testLettergrade() {
		assertEquals("A", myFun.letterGrade(94.0));
		assertEquals("A", myFun.letterGrade(93));
		assertEquals("A-", myFun.letterGrade(92.9));
		assertEquals("A-", myFun.letterGrade(90));
		assertEquals("B+", myFun.letterGrade(89.9));
		assertEquals("B+", myFun.letterGrade(87));
		assertEquals("B", myFun.letterGrade(86.9));
		assertEquals("B", myFun.letterGrade(83));
		assertEquals("B-", myFun.letterGrade(80));
		assertEquals("B-", myFun.letterGrade(82.9));
		assertEquals("C+", myFun.letterGrade(79.9));
		assertEquals("C+", myFun.letterGrade(77));
		assertEquals("C", myFun.letterGrade(70));
		assertEquals("C", myFun.letterGrade(76.9));
		assertEquals("D", myFun.letterGrade(69.9));
		assertEquals("D", myFun.letterGrade(60));
		assertEquals("E", myFun.letterGrade(59.9));
		assertEquals("E", myFun.letterGrade(10));
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("Fizz", myFun.fizzBuzz("f"));
		assertEquals("Fizz", myFun.fizzBuzz("fig"));
		assertEquals("Buzz", myFun.fizzBuzz("dib"));
		assertEquals("FizzBuzz", myFun.fizzBuzz("fib"));
		assertEquals("Buzz", myFun.fizzBuzz("b"));
		assertEquals("hello", myFun.fizzBuzz("hello"));
	}

	@Test
	public void testRomannumeralAllUpperCase() {
		assertEquals(1, myFun.romanNumeral('I'));
		assertEquals(1, myFun.romanNumeral('i'));
		assertEquals(5, myFun.romanNumeral('V'));
		assertEquals(5, myFun.romanNumeral('v'));
		assertEquals(10, myFun.romanNumeral('X'));
		assertEquals(10, myFun.romanNumeral('x'));
		assertEquals(50, myFun.romanNumeral('L'));
		assertEquals(50, myFun.romanNumeral('l'));
		assertEquals(100, myFun.romanNumeral('C'));
		assertEquals(100, myFun.romanNumeral('c'));
		assertEquals(500, myFun.romanNumeral('D'));
		assertEquals(500, myFun.romanNumeral('d'));
		assertEquals(1000, myFun.romanNumeral('M'));
		assertEquals(1000, myFun.romanNumeral('m'));
	}

	@Test
	public void testSeason12_1_2True() {

		assertEquals("Testing season", "Unknown", myFun.season(0, true));
		assertEquals("Testing season", "Unknown", myFun.season(13, false));

		assertEquals("Testing season", "Winter", myFun.season(12, true));
		assertEquals("Testing season", "Winter", myFun.season(1, true));
		assertEquals("Testing season", "Winter", myFun.season(2, true));

		assertEquals("Testing season", "Spring", myFun.season(3, true));
		assertEquals("Testing season", "Spring", myFun.season(4, true));
		assertEquals("Testing season", "Spring", myFun.season(5, true));

		assertEquals("Testing season", "Summer", myFun.season(6, true));
		assertEquals("Testing season", "Summer", myFun.season(7, true));
		assertEquals("Testing season", "Summer", myFun.season(8, true));

		assertEquals("Testing season", "Fall", myFun.season(9, true));
		assertEquals("Testing season", "Fall", myFun.season(10, true));
		assertEquals("Testing season", "Fall", myFun.season(11, true));

		// ==============================================================

		assertEquals("Testing season", "Summer", myFun.season(12, false));
		assertEquals("Testing season", "Summer", myFun.season(1, false));
		assertEquals("Testing season", "Summer", myFun.season(2, false));

		assertEquals("Testing season", "Fall", myFun.season(3, false));
		assertEquals("Testing season", "Fall", myFun.season(4, false));
		assertEquals("Testing season", "Fall", myFun.season(5, false));

		assertEquals("Testing season", "Winter", myFun.season(6, false));
		assertEquals("Testing season", "Winter", myFun.season(7, false));
		assertEquals("Testing season", "Winter", myFun.season(8, false));

		assertEquals("Testing season", "Spring", myFun.season(9, false));
		assertEquals("Testing season", "Spring", myFun.season(10, false));
		assertEquals("Testing season", "Spring", myFun.season(11, false));

	}

	@Test
	public void testThanksdate1() {
		assertEquals(25, myFun.thanksDate(1));
		assertEquals(24, myFun.thanksDate(2));
		assertEquals(23, myFun.thanksDate(3));
		assertEquals(22, myFun.thanksDate(4));
		assertEquals(28, myFun.thanksDate(5));
		assertEquals(27, myFun.thanksDate(6));
		assertEquals(26, myFun.thanksDate(7));
		assertEquals(0, myFun.thanksDate(0));
		assertEquals(0, myFun.thanksDate(8));
	}

	@Test
	public void testDaynumber1() {
		assertEquals(1, myFun.dayNumber("01/01/2018"));
		assertEquals(3, myFun.dayNumber("01/03/2016"));
		assertEquals(60, myFun.dayNumber("02/29/2000"));
		assertEquals(-1, myFun.dayNumber("02/29/2001"));
		assertEquals(365, myFun.dayNumber("12/31/2017"));
		assertEquals(366, myFun.dayNumber("12/31/2020"));
		assertEquals(326, myFun.dayNumber("11/21/2020"));
		assertEquals(-1, myFun.dayNumber("13/11/2020"));

	}

	@Test
	public void testDayofweek1() {
		assertEquals("Monday", myFun.dayOfWeek(1));
		assertEquals("Unknown", myFun.dayOfWeek(0));
		assertEquals("Tuesday", myFun.dayOfWeek(2));
		assertEquals("Wednesday", myFun.dayOfWeek(3));
		assertEquals("Thursday", myFun.dayOfWeek(4));
		assertEquals("Friday", myFun.dayOfWeek(5));
		assertEquals("Saturday", myFun.dayOfWeek(6));
		assertEquals("Sunday", myFun.dayOfWeek(7));
		assertEquals("Unknown", myFun.dayOfWeek(8));
	}

	@Test
	public void testDaysinmonthWhenNotALeapYear1() {
		assertEquals(31, myFun.daysInMonth(1, 2018));
		assertEquals(31, myFun.daysInMonth(1, 2020));
		assertEquals(28, myFun.daysInMonth(2, 2019));
		assertEquals(29, myFun.daysInMonth(2, 2016));
		assertEquals(0, myFun.daysInMonth(2, 1500));
		assertEquals(0, myFun.daysInMonth(13, 2016));
		assertEquals(0, myFun.daysInMonth(0, 2016));

		assertEquals(31, myFun.daysInMonth(1, 2018));
		assertEquals(28, myFun.daysInMonth(2, 2018));
		assertEquals(31, myFun.daysInMonth(3, 2018));
		assertEquals(30, myFun.daysInMonth(4, 2018));
		assertEquals(31, myFun.daysInMonth(5, 2018));
		assertEquals(30, myFun.daysInMonth(6, 2018));
		assertEquals(31, myFun.daysInMonth(7, 2018));
		assertEquals(31, myFun.daysInMonth(8, 2018));
		assertEquals(30, myFun.daysInMonth(9, 2018));
		assertEquals(31, myFun.daysInMonth(10, 2018));
		assertEquals(30, myFun.daysInMonth(11, 2018));
		assertEquals(31, myFun.daysInMonth(12, 2018));

	}

	@Test
	public void testValidDateWhenTheyAreAllValid1() {
		assertFalse(myFun.validDate("01/00/2017"));

	    assertFalse(myFun.validDate("03/00/2020"));
	    
		assertTrue(myFun.validDate("01/01/2018"));
		assertFalse(myFun.validDate("02/29/2100"));
		assertFalse(myFun.validDate("02/29/21000"));

		assertTrue(myFun.validDate("01/31/2016"));
		assertTrue(myFun.validDate("12/31/2017"));
		assertTrue(myFun.validDate("06/15/2018"));
		assertTrue(myFun.validDate("02/28/2019"));
		assertFalse(myFun.validDate("02/30/2000"));
		assertTrue(myFun.validDate("02/29/2000"));
		assertFalse(myFun.validDate("02/29/2019"));
		assertFalse(myFun.validDate("2019/06/06"));
		assertFalse(myFun.validDate("02/29/2100"));
		assertFalse(myFun.validDate("13/02/2019"));
		assertFalse(myFun.validDate("12/32/2019"));
		assertFalse(myFun.validDate("04/31/2000"));
		assertFalse(myFun.validDate("02/29/2100"));
		assertFalse(myFun.validDate("02/ 9/2100"));

		assertTrue(myFun.validDate("06/30/2016"));
		assertTrue(myFun.validDate("09/30/2016"));
		assertTrue(myFun.validDate("04/30/2016"));
		assertTrue(myFun.validDate("11/30/2016"));
		assertTrue(myFun.validDate("12/31/2016"));
	}
}
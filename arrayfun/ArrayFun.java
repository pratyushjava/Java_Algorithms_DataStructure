import java.util.Scanner;

/**
 * This class has 15 methods related by the fact that CSC 210 students are
 * learning the Java array object. The unit test has only a few @Test methods
 * that barely test methods in here. You will have to write your own @Test
 * methods with as many assertions as needed to ensure the methods here are
 * correct. Use EclEmma for code coverage to help in this endeaver.
 * 
 * There are several silly contrived methods and several possibly useful
 * methods.
 * 
 * @author Pratyush Singh
 */
public class ArrayFun {

	// Return the number of times a pair occurs in array. A pair is any two String
	// values that are equal (case sensitive) in consecutive array elements. The
	// array may be empty or have only one element, in these cases return 0.
	//
	// numberOfPairs( {"a", "b", "c" } ) returns 0
	// numberOfPairs( {"a", "a", "a"} ) returns 2
	// numberOfPairs( {"a", "a", "b", "b" } ) returns 2
	// numberOfPairs( { } ) returns 0
	// numberOfPairs( {"a"} ) returns 0
	//
	public int numberOfPairs(String[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	// Given a filled array of char array elements, return the number of vowels
	// which could be the letters 'a' , 'e', 'i', 'o', or 'u' in either upper case
	// or lower case. If the array is empty as in char[] chars = new char[0];,
	// return 0.
	//
	// numberOfVowels({'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) returns 10
	// numberOfVowels( {'y', 'Y' } ) returns 0
	// numberOfVowels( {'a', 'X', 'a' } ) returns 2
	// numberOfVowels( { } ) returns 0
	//
	public int numberOfVowels(char[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			char c = Character.toLowerCase(array[i]);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}
		}
		return count;
	}

	// Given a filled array of double array elements, return true if the sum of all
	// array elements is greater than sum. Return false if the array is empty. Sum
	// may be negative.
	//
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 4.0) returns true
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 6.6) returns false
	// sumGreaterThan( { }, -1.0) returns false
	//
	public boolean sumGreaterThan(double[] array, double sum) {
		if (array.length == 0) {
			return false;
		}
		int curSum = 0;
		for (int i = 0; i < array.length; i++) {
			curSum += array[i];
		}
		if (curSum > sum) {
			return true;
		}
		return false;
	}

	// Given a Scanner of double values, return an array of capacity three
	// that has the maximum value in the Scanner in result[0], the
	// minimum value as the second value in result[1], and the average as the third
	// value in result[2]. The following assertions given in the unit test
	// ArrayFunTest.java must pass:
	//
	// Scanner scanner = new Scanner("90.0 80.0 70.0 68.0");
	// double[] result = myFun.stats(scanner);
	// assertEquals(3, result.length); // The capacity is always 3
	// assertEquals(90.0, result[0], 0.1); // The maximum is at index 0
	// assertEquals(68.0, result[1], 0.1); // The minimum is at index 1
	// assertEquals(77.0, result[2], 0.1); // The average is at index 2
	//
	// Precondition: scanner has valid doubles only and there is at least one.
	//
	public double[] stats(Scanner scanner) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double sum = Double.MIN_VALUE;
		int count = 0;
		while (scanner.hasNextDouble()) {
			count++;
			double next = scanner.nextDouble();
			sum += next;
			if (next < min) {
				min = next;
			}
			if (next > max) {
				max = next;
			}
		}
		return new double[] { max, min, sum / count };
	}

	// Given a Scanner constructed with a String containing a stream of integers in
	// the range of 0..10 (like quiz scores), return an array of 11 integers where
	// the first value (at index 0) is the number of 0s in the Scanner, the second
	// value (at index 1) is the number of ones on the Scanner, and the 11th value
	// (at index 10) is the number of tens in the Scanner. The following assertions
	// must pass.
	//
	// Scanner scanner = new Scanner("5 0 1 2 1 5 2");
	// int[] result = myFun.frequency(scanner);
	// assertEquals(11, result.length);
	// assertEquals(1, result[0]); // There was 1 zero
	// assertEquals(2, result[1]);
	// assertEquals(2, result[2]);
	// assertEquals(0, result[3]);
	// assertEquals(0, result[4]);
	// assertEquals(2, result[5]); // There were 2 5s
	// for(int score = 6; score <= 10; score++) {
	// .. assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
	//
	// Precondition: scanner has only valid ints in the range of 0..10
	//
	public int[] frequency(Scanner scanner) {
		int[] array = new int[11];
		while (scanner.hasNextInt()) {
			int next = scanner.nextInt();
			if (next >= 0 && next <= 10) {
				array[next]++;
			}
		}
		return array;
	}

	// Complete method howMany to return the number of elements in an array of
	// Strings that equals valueToFind. The array may be empty.
	//
	// howMany( {"A", "a", "A", "a" }, "A" ) returns 2
	// howMany( {"And", "there", "goes", "another"}, "another" ) returns 1
	// howMany( {"And", "there", "goes", "another"}, "Not Here" ) returns 0
	// howMany( { }, "empty array" ) returns 0
	//
	public int howMany(String[] array, String valueToFind) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(valueToFind)) {
				count++;
			}
		}
		return count;
	}

	// Write method sortOfSort that modifies the parameter array to place the
	// largest integer at index n-1 and the smallest integer at array[0]. The other
	// elements must still be in the array, but not in any particular order. You
	// must modify the given array argument by changing array in method sortOfSort.
	// The order may differ except the first and last.
	//
	// Original Array . . . . . Modified Array (may differ in order)
	// { 4, 3, 2, 0, 1, 2 } . . { 0, 3, 2, 1, 2, 4 }
	// { 4, 3, 2, 1 } . . . . . { 1, 3, 2, 4 }
	// { -1, 3, 2, 4 } . . . . . { -1, 3, 2, 4 }
	//
	public void sortOfSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[array.length - 1]) {
				int temp = array[array.length - 1];
				array[array.length - 1] = array[i];
				array[i] = temp;
			}

			if (array[i] < array[0]) {
				int temp = array[0];
				array[0] = array[i];
				array[i] = temp;
			}
		}
	}

	// Modify the parameter array so it still contains the exact same numbers as the
	// given array, but rearranged so that all the even numbers come before all the
	// odd numbers. Other than that, the numbers can be in any order. You must
	// modify the array argument by changing array in method evensLeft. The array
	// may be empty or have only 1 element so no change should be made.
	//
	// Original Array. . . . . Modified Array
	// {1, 0, 1, 0, 0, 1, 1} . { 0, 0, 0, 1, 1, 1, 1 }
	// {3, 3, 2} . . . . . . . { 2, 3, 3 }
	// {2, 2, 2} . . . . . . . { 2, 2, 2}
	//
	public void evensLeft(int[] array) {
		int lastEven = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				int temp = array[lastEven];
				array[lastEven] = array[i];
				array[i] = temp;
				lastEven++;
			}
		}
	}

	// Modify array so it is "left shifted" n times -- so shiftNTimes({6, 2, 5, 3},
	// 1) changes the array argument to {2, 5, 3, 6} and shiftNTimes({6, 2, 5, 3},
	// 2) changes the array argument to {5, 3, 6, 2}. You must modify the array
	// argument by changing the parameter array inside method shiftNTimes. Remember,
	// a change to the parameter inside the method shiftNTimes changes the argument
	// inside the @Test method.
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 3 ) modifies
	// the array to { 4, 5, 6, 7, 1, 2, 3 }
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 0 ) does not modify the array
	// shiftNTimes( { 1, 2, 3 }, 5) modifies array to { 3, 1, 2 }
	// shiftNTimes( { 3 }, 5) modifies array to { 3 }
	//

	public void shiftNTimes(int[] array, int numShifts) {
		for (int i = 0; i < numShifts; i++) {
			int temp;
			temp = array[0];
			int j = 0;
			for (j = 0; j < array.length - 1; j++)
				array[j] = array[j + 1];
			array[j] = temp;
		}
	}

	// Return a new char[] that is a copy of array with all occurrences of oldChar
	// replaced by newChar. The original array argument must remain unchanged.
	// The returned array must have exactly the same capacity
	// as the array reference passed to the parameter referenced as array.
	//
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
	//
	public char[] replaced(char[] array, char oldChar, char newChar) {

		char[] newArray = new char[array.length];

		for (int i = 0; i < array.length; i++) {
			if (array[i] == oldChar) {
				newArray[i] = newChar;
			} else {
				newArray[i] = array[i];
			}
		}
		return newArray;
	}

	// Return the range of the numbers in an array[].
	// The range is the maximum value - minimum value
	//
	// range ({1, 2, 3, 4}) returns 4 - 1 or 3
	// range ({1, 2, -3, 4}) returns 4 - -3 or 7
	// range ({ 99 }) returns 0
	//
	// Precondition: x.length >= 1
	//
	public int range(int[] x) {

		if (x.length < 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < min) {
				min = x[i];
			}
			if (x[i] > max) {
				max = x[i];
			}
		}

		return max - min;
	}

	// Return true is search is found the array strs
	// or false if search is not found in the array.
	// This method is case-sensitive, the string must match exactly
	//
	// found( "A", {"A","B","C"} ) returns true
	// found( "a", {"A","B","C"} ) returns false
	// found( "x", {"a","b","c", "d"} ) returns false
	// found( "x", { } ) returns false
	//
	public boolean found(String search, String[] strs) {

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(search)) {
				return true;
			}
		}
		return false;
	}

	// Without using any Java methods that sort, complete method sort
	// such that strs element are in ascending order.
	//
	// sort({"B", "C", "A"}) modifies the argument to { "A", "B", "C"}
	// sort({"g", "a", "X"}) modifies the argument to { "X", "a", "g"}
	//
	public void sort(String[] strs) {

		for (int i = 0; i < strs.length - 1; i++) {

			for (int j = i + 1; j < strs.length; j++) {

				if (strs[i].compareTo(strs[j]) > 0) {

					String temp = strs[j];
					strs[j] = strs[i];
					strs[i] = temp;

				}
			}
		}
	}

	// Consider the series of numbers beginning at start and running up to but not
	// including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4.
	// Return a new String[] array containing the string form of these numbers,
	// except for multiples of 3, use "Fizz" instead of the number, for multiples
	// of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java,
	// String.valueOf(xxx) will make the String form of an int or other type.
	//
	// fizzBuzz(1, 6) returns ["1", "2", "Fizz", "4", "Buzz"]
	// fizzBuzz(1, 8) returns ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
	// fizzBuzz(14, 21) returns ["14", "FizzBuzz", "16", "17", "Fizz", "19"]
	//
	public String[] fizzBuzz(int start, int end) {

		String[] array = new String[Math.abs(end - start)];
		for (int i = start; i < end; i++) {
			String item = "";
			if (i % 3 == 0) {
				item += "Fizz";
			}
			if (i % 5 == 0) {
				item += "Buzz";
			}
			if (i % 3 != 0 && i % 5 != 0) {
				item = String.valueOf(i);
			}

			array[Math.abs(i - start)] = item;

		}
		return array;
	}

	// Consider the leftmost and righmost appearances of some value in an array.
	// We'll say that the "span" is the number of elements between the two
	// inclusive. A single value has a span of 1. Return the largest span found
	// in the given array.
	//
	// maxSpan({ 1, 2, 1, 1, 3 }) returns 4 (index 0 through index 3)
	// maxSpan({ 1, 4, 2, 1, 4, 1, 4 }) returns 6 (index 0 through index 5)
	// maxSpan({ 5, 5, 5, 5 }) returns 4 (index 0 through index 3)
	// maxSpan({ 99 }) returns 1 (index 0 through index 0)
	// maxSpan({ }) returns 0
	//
	public int maxSpan(int[] nums) {
		int largestSpan = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					if (largestSpan < (j - i + 1)) {
						largestSpan = j - i + 1;
					}
				}
			}
		}
		return largestSpan;
	}
}
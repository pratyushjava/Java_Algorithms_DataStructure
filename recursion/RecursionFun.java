/**
 * Complete the 12 methods in this using recursion, no loops. Also complete the
 * LinkedList methods E get(E) and void duplicateAll(E) using recursion. No
 * loops allowed
 * 
 * An important Negative and easy way to lose points:
 * 
 * -6 points If you use a loop instead of recursion in the method even though it
 * works
 *
 * Note: I believe the given unit test tests all methods. We will be using
 * RecursionFunTest.java for correctness of code.
 *
 * @author Pratyush Singh
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {

		if (k == 0) {
			return 1;
		}

		if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}

	}

	// Return n!
	//
	// factorial(0) returns 1
	// factorial(1) returns 1
	// factorial(2) returns 2
	// factorial(5) returns 5*4*3*2*1
	//
	public int factorial(int n) {
		int ret;
		if (n == 0 || n == 1)
			return 1;

		ret = factorial(n - 1) * n;
		return ret;
	}

	// Complete recursive method addReciprocals(int) that takes an integer as a
	// parameter and returns the sum of the first n reciprocals. Use recursion; do
	// not use a loop. addReciprocals(n) returns (1.0+1.0/2.0+1.0/3.0+ ... + 1.0/n).
	// The following assertions must pass:
	//
	// addReciprocals(1) returns 1.0
	// addReciprocals(2) returns 1.0 + 1.0/2.0 = 1.5
	// addReciprocals(3) returns 1.0 + 1.0/2.0 + 1/3.0 = 1.83333333333333
	//
	public double addReciprocals(int n) {
		double ret = 0.0;
		if (n == 1) {
			return 1;
		} else {
			ret += 1.0 / n;
			return ret + addReciprocals(n - 1);
		}
	}

	// Return true if str is a palindrome that is a string that reads the same
	// in reverse order in a case sensitive fashion.
	//
	// isPalindrome("racecar") returns true
	// isPalindrome("aBba") returns false
	// isPalindrome("") returns true
	//
	public boolean isPalindrome(String str) {
		int length = str.length();

		if (length <= 1)
			return true;

		if (str.charAt(0) != str.charAt(length - 1))
			return false;
		else
			return isPalindrome(str.substring(1, length - 1));
	}

	// Implement the Greatest Common Divisor algorithm as public recursive method
	// GCD that is defined as follows
	//
	// if n == 0, return m
	// if n > 0 return GCD (n, m % n)
	//
	// assertEquals(3, rf.GCD(24, 9));
	// assertEquals(3, rf.GCD(-24, 9));
	// assertEquals(3, rf.GCD(24, -9));
	//
	// Precondition m >= 0 and n >= 0. Also, m and n are not both zero
	public int GCD(int m, int n) {
		if (n == 0)
			return m;
		else
			return GCD(n, m % n);
	}

	// Place an underscore between any two characters that are == and next to each
	// other
	//
	// underScore("xxyy")) returns x_xy_y
	// underScore("aaaa") returns "a_a_a_a"
	//

	private String underScore(String str, int index) {
		String ret = "";
		if (index >= str.length()) {
			return ret;
		}
		if (index == 1) {
			ret = Character.toString(str.charAt(index - 1));
		}
		if (str.charAt(index - 1) == str.charAt(index)) {
			ret += "_" + Character.toString(str.charAt(index));
		} else {
			ret += Character.toString(str.charAt(index));
		}

		ret += underScore(str, index + 1);

		return ret;
	}

	public String underScore(String str) {

		if (str.length() <= 1) {
			return str;
		}

		return underScore(str, 1);

	}

	// Complete noAdjacents that when given a string, returns a string
	// where adjacent chars that are the same are reduced to a single char.
	//
	// noAdjacents ("yyzzza") returns "yza"
	// noAdjacents ("abbbcdd") returns "abcd"
	// noAdjacents ("Hello") returns "Helo"
	// noAdjacents ("tttttttt") returns "t"
	//

	private String noAdjacents(String str, int index) {
		String ret = "";
		if (index >= str.length()) {
			return ret;
		}
		if (index == 1) {
			ret = Character.toString(str.charAt(index - 1));
		}
		if (str.charAt(index - 1) == str.charAt(index)) {
			ret += noAdjacents(str, index + 1);
		} else {
			ret += Character.toString(str.charAt(index)) + noAdjacents(str, index + 1);
		}

		return ret;
	}

	public String noAdjacents(String str) {

		if (str.length() <= 1) {
			return str;
		}

		return noAdjacents(str, 1);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0

	private String intWithCommas(String str) {

		int pos = str.indexOf(",");

		if (pos < 0) {
			pos = str.length();
		}

		if (str.length() > 3 && pos > 3) {
			str = intWithCommas(new StringBuffer(str).insert(pos - 3, ",").toString());
		}

		return str;
	}

	public String intWithCommas(int n) {

		String num = Integer.toString(n);

		return intWithCommas(num);

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArr(x, 0, x.length - 1);
	}

	private void reverseArr(int[] x, int index, int len) {
		if (index < len) {
			int tmp = x[index];
			x[index] = x[len];
			x[len] = tmp;
			reverseArr(x, ++index, --len);
		}
	}

	// Write recursive method arrayRange that returns the maximum integer minus the
	// minimum integer in the filled array of ints. Use recursion; do not use a
	// loop. The following assertions must pass (note the shortcut way to pass a
	// reference to a new array--it saves your writing a bit of code:
	//
	// assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
	// assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
	// assertEquals(0, rf.arrayRange(new int[] { 3 }));
	// assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int max = arrMax(a, a.length);
		int min = arrMin(a, a.length);
		return max - min;
	}

	private int arrMax(int[] a, int index) {
		if (index == 1) {
			return a[0];
		}

		return Math.max(a[index - 1], arrMax(a, index - 1));
	}

	private int arrMin(int[] a, int index) {
		if (index == 1) {
			return a[0];
		}

		return Math.min(a[index - 1], arrMin(a, index - 1));
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return isSorted(nums.length, nums);
	}

	private boolean isSorted(int index, int[] nums) {
		if (index == 1 || index == 0)
			return true;

		if (nums[index - 1] < nums[index - 2])
			return false;

		return isSorted(index - 1, nums);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false.
	public boolean found(String search, String[] strs) {
		return found(search, strs, 0);
	}

	private boolean found(String search, String[] strs, int i) {

		if (i >= strs.length) {
			return false;
		}

		if (search.equals(strs[i])) {
			return true;
		} else {
			return found(search, strs, i + 1);
		}

	}
}
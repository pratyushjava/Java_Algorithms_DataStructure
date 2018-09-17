
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * A collection class that keeps unique String elements in their natural order
 *
 * @author Pratyush Singh
 */
public class SortedStringSet {

	private String[] stringCollection = null;
	private int n;

	// Construct an empty set that can store any number of String elements
	public SortedStringSet(int capacity) {
		stringCollection = new String[capacity];
		n = 0;
	}

	// Return true if there are 0 elements in this bag.
	public boolean isEmpty() {

		return n == 0;
	}

	// Return the number of unique String elements that are in this set
	public int size() {
		return n;
	}

	// If element exists, return false. Otherwise, place element into the index
	// that maintains natural ordering and return true.
	//
	// If there is no space, this method will grow the array by 20 elements
	public boolean insertInOrder(String element) {
		String[] stringNewCollection = null;
		if (n == stringCollection.length) {
			stringNewCollection = new String[stringCollection.length * 2];
		} else {
			stringNewCollection = new String[stringCollection.length];
		}

		for (int i = 0; i < n; i++) {
			if (stringCollection[i].compareTo(element) == 0) {
				return false;
			} else if (stringCollection[i].compareTo(element) < 0) {
				stringNewCollection[i] = stringCollection[i];
			} else if (stringCollection[i].compareTo(element) > 0) {
				stringNewCollection[i] = element;
				for (int j = i; j < n; j++) {
					stringNewCollection[j + 1] = stringCollection[j];
				}
				n++;
				stringCollection = stringNewCollection;
				return true;
			}
		}
		stringNewCollection[n] = element;
		n++;
		stringCollection = stringNewCollection;

		return true;
	}

	// Return true if element is in this SortedStringSet
	public boolean contains(String element) {
		for (int i = 0; i < n; i++) {
			if (stringCollection[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String ret = "[";
		for (int i = 0; i < n; i++) {
			ret += stringCollection[i];
			if (i == n - 1)
				break;
			ret += ", ";
		}
		ret += "]";
		return ret;
	}

	// Remove element if it is in this set, otherwise return false
	public boolean remove(String element) {
		int index = 0;
		boolean ret = false;
		for (int i = 0; i < n; i++) {
			if (!stringCollection[i].equals(element)) {
				stringCollection[index] = stringCollection[i];
				index++;
			} else {
				ret = true;
			}
		}

		if (ret) {
			n--;
			stringCollection[n] = null;
		}

		return ret;
	}

	// Return a SortedSet that is the union of this and other
	// Union of two sets. The union of two sets A and B is the set of elements which
	// are in A, in B, or in both A and B. For example, if
	// A = {"1", "3", "5", "7"} and B = {"1", "2", "4", "6"}
	// then A.union(B) = {"1", "2", "3", "4", "5", "6", "7"}.
	//
	// Feel free to research this.
	//
	public SortedStringSet union(SortedStringSet other) {
		// You may reference other.elements[0], other.elements[1], ...
		// other.elements[n-1] inside this method
		SortedStringSet newSortedStringSet = new SortedStringSet(n + other.size());

		StringTokenizer st = new StringTokenizer(other.toString().substring(1, other.toString().length() - 1));

		for (int i = 0; i < n; i++) {
			newSortedStringSet.insertInOrder(stringCollection[i]);
		}

		while (st.hasMoreTokens()) {
			newSortedStringSet.insertInOrder(st.nextToken(",").trim());
		}

		return newSortedStringSet;
	}
}
/**
 * This has only one method to make you think about how to compare two strings
 * because in Java, we can not write "A" < "B"
 * 
 * @author Pratyush Singh
 */
public class OneFun {

	// Complete method first to return the "lesser" of 2 strings.
	//
	// first("A", "B") returns "A"
	// first("Z", "a") returns "Z"
	// first("1", "2") returns "1"
	// first("abc", "abc ") returns "abc"
	//
	public String first(String a, String b) {

		if (a.compareTo(b) <= 0) {
			return a;
		}
		return b;
	}
}

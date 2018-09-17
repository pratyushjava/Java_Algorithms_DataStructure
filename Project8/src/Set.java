/**
 * This java interface represents a Set class as an Abstract Data Type (ADT).
 *
 * @author Pratyush Singh
 * 
 * @param <E>
 * 
 *            The type that any type implementing Set can store. Instances of
 *            the implementing class are type safe with Set<String> names = new
 *            ArraySet<String>();
 */
public interface Set<E> {
	/**
	 * How many elements currently in this Set
	 *
	 * 
	 * @return The number of unique elements
	 */
	public int size();

	/**
	 * 
	 * Add element to this set only if element does not equal another element
	 * already in this Set. Return false if element exists, this set does not
	 * change.
	 * 
	 * @param element
	 *            The element to add to this set
	 * @return True if the element was successfully added
	 */
	public boolean add(E element);

	/**
	 * Return true if element is in this Set
	 * 
	 * @param element
	 *            The element to search for
	 * @return True if element exists or false if not
	 */
	public boolean contains(E element);
}
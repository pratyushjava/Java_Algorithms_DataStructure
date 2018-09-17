
// @author Pratyush Singh

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySetTest {

	@Test
	public void testStringType() {
		Set<String> set = new ArraySet<String>();
		assertFalse(set.contains("hello"));
		assertEquals(0, set.size());
		set.add("hello");
		assertTrue(set.contains("hello"));
		assertTrue(set.add("world"));
		assertTrue(set.add("america"));
		assertFalse(set.add("america"));
		assertEquals(3, set.size());
		assertTrue(set.add("dfdsf"));
		assertTrue(set.add("dwef"));
		assertEquals(5, set.size());
		assertFalse(set.add("dwef"));

	}

	@Test
	public void testIntegerType() {
		Set<Integer> set = new ArraySet<Integer>();
		assertFalse(set.contains(1));
		assertEquals(0, set.size());
		set.add(1);
		assertTrue(set.contains(1));
		assertTrue(set.add(2));
		assertTrue(set.add(3));
		assertFalse(set.add(3));
		assertEquals(3, set.size());
		assertTrue(set.add(5));
		assertTrue(set.add(6));
		assertEquals(5, set.size());
		assertFalse(set.add(5));

	}
}

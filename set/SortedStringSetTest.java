
/**
  * A unit test for SortedSet
  *
  * @author Pratyush Singh
  */
import static org.junit.Assert.*;
import org.junit.Test;

public class SortedStringSetTest {

	@Test
	public void testGettersWhenEmpty() {
		SortedStringSet names = new SortedStringSet(4);
		assertTrue(names.isEmpty());
		assertEquals(0, names.size());
		assertEquals("[]", names.toString());
		for (int i = 3; i >= 0; i--) {
			names.insertInOrder("name" + String.valueOf(i * 2));
		}
		assertEquals("[name0, name2, name4, name6]", names.toString());
		assertFalse(names.isEmpty());
		assertEquals(4, names.size());
		assertTrue(names.contains("name2"));
		assertFalse(names.contains("nam2"));
		assertTrue(names.remove("name2"));
		assertFalse(names.remove("name2"));

		for (int i = 3; i >= 0; i--) {
			names.insertInOrder("name" + String.valueOf(i * 2 + 1));
		}

		assertEquals("[name0, name1, name3, name4, name5, name6, name7]", names.toString());
		assertFalse(names.isEmpty());
		assertEquals(7, names.size());
		assertTrue(names.contains("name5"));
		assertFalse(names.contains("name8"));

		assertTrue(names.remove("name5"));
		assertFalse(names.remove("name5"));

		names.insertInOrder("name9");
		assertEquals("[name0, name1, name3, name4, name6, name7, name9]", names.toString());
		assertFalse(names.isEmpty());
		assertEquals(7, names.size());
		assertTrue(names.contains("name9"));
		assertFalse(names.contains("name5"));
		assertFalse(names.contains("name2"));

		SortedStringSet names1 = new SortedStringSet(4);
		for (int i = 3; i >= 0; i--) {
			names1.insertInOrder("name" + String.valueOf(i * 2));
		}

		SortedStringSet names2 = new SortedStringSet(4);
		for (int i = 3; i >= 0; i--) {
			names2.insertInOrder("name" + String.valueOf(i * 2 + 1));
		}

		names2.insertInOrder("name2");
		names2.insertInOrder("name4");

		SortedStringSet names3 = names1.union(names2);

		assertEquals("[name0, name1, name2, name3, name4, name5, name6, name7]", names3.toString());

	}

	// Many more @Test methods with assertions go here . . .

}

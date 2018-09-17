
// Pratyush Singh

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OdereredSetTest {

	// You must add many, many, many more @Tests and assertions!
	// This @Test is here to ensure insert, subset, and toStringInorder work
	@Test
	public void testSubSet() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		assertTrue(bst.insert(50));
		assertTrue(bst.insert(25));
		assertTrue(bst.insert(12));
		assertTrue(bst.insert(75));
		assertTrue(bst.insert(65));
		assertTrue(bst.insert(90));

		assertFalse(bst.insert(12));
		assertFalse(bst.insert(75));
		assertFalse(bst.insert(65));
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals(90, (int) bst.max());
		assertEquals(6, bst.size());
		assertTrue(bst.contains(75));
		assertFalse(bst.contains(72));

		assertEquals(1, bst.nodesAtLevel(0));
		assertEquals(2, bst.nodesAtLevel(1));
		assertEquals(3, bst.nodesAtLevel(2));

		assertEquals("12 25", bst.subset(1, 49).toStringInorder());
		assertEquals("25 50 65", bst.subset(25, 75).toStringInorder());
		assertEquals("", bst.subset(12, 12).toStringInorder());

	}

	@Test
	public void testIntersection() {
		OrderedSet<Integer> bst1 = new OrderedSet<Integer>();
		assertTrue(bst1.insert(2));
		assertTrue(bst1.insert(4));
		assertTrue(bst1.insert(5));
		assertTrue(bst1.insert(6));
		OrderedSet<Integer> bst2 = new OrderedSet<Integer>();

		assertTrue(bst2.insert(2));
		assertTrue(bst2.insert(5));

		assertTrue(bst2.insert(6));
		assertTrue(bst2.insert(9));

		OrderedSet<Integer> bst3 = bst1.intersection(bst2);
		assertEquals("2 5 6", bst3.toStringInorder());

		assertEquals(6, (int) bst3.max());
		assertEquals(3, bst3.size());
		assertTrue(bst3.contains(2));
		assertFalse(bst3.contains(4));

		assertEquals(1, bst3.nodesAtLevel(0));
		assertEquals(1, bst3.nodesAtLevel(1));
		assertEquals(1, bst3.nodesAtLevel(2));

	}

	@Test
	public void testUnioun() {
		OrderedSet<Integer> bst1 = new OrderedSet<Integer>();
		assertTrue(bst1.insert(4));
		assertTrue(bst1.insert(2));
		assertTrue(bst1.insert(6));
		OrderedSet<Integer> bst2 = new OrderedSet<Integer>();

		assertTrue(bst2.insert(5));
		assertTrue(bst2.insert(2));

		assertTrue(bst2.insert(9));

		OrderedSet<Integer> bst3 = bst1.union(bst2);
		assertEquals("2 4 5 6 9", bst3.toStringInorder());

		assertEquals(9, (int) bst3.max());
		assertEquals(5, bst3.size());
		assertTrue(bst3.contains(2));
		assertFalse(bst3.contains(1));

		assertEquals(1, bst3.nodesAtLevel(0));
		assertEquals(2, bst3.nodesAtLevel(1));
		assertEquals(1, bst3.nodesAtLevel(2));
		
		

	}

	@Test
	public void testSameStructureFalse() {
		OrderedSet<Integer> bst1 = new OrderedSet<Integer>();

		assertTrue(bst1.insert(50));
		assertTrue(bst1.insert(25));
		assertTrue(bst1.insert(65));
		assertTrue(bst1.insert(35));
		assertTrue(bst1.insert(55));
		assertTrue(bst1.insert(75));
		OrderedSet<Integer> bst2 = new OrderedSet<Integer>();

		assertTrue(bst2.insert(60));
		assertTrue(bst2.insert(30));
		assertTrue(bst2.insert(80));
		assertTrue(bst2.insert(20));
		assertTrue(bst2.insert(70));
		assertTrue(bst2.insert(90));

		assertFalse(bst1.sameStructure(bst2));

	}

	@Test
	public void testSameStructureTrue() {
		OrderedSet<Integer> bst1 = new OrderedSet<Integer>();

		assertTrue(bst1.insert(50));
		assertTrue(bst1.insert(25));
		assertTrue(bst1.insert(65));
		assertTrue(bst1.insert(10));
		assertTrue(bst1.insert(55));
		assertTrue(bst1.insert(75));
		OrderedSet<Integer> bst2 = new OrderedSet<Integer>();

		assertTrue(bst2.insert(60));
		assertTrue(bst2.insert(30));
		assertTrue(bst2.insert(80));
		assertTrue(bst2.insert(20));
		assertTrue(bst2.insert(70));
		assertTrue(bst2.insert(90));

		assertTrue(bst1.sameStructure(bst2));

	}
	
	
	@Test
	public void testremove() {
		OrderedSet<Integer> bst1 = new OrderedSet<Integer>();

		assertTrue(bst1.insert(50));
		assertTrue(bst1.insert(25));
		assertTrue(bst1.insert(65));
		assertTrue(bst1.insert(10));
		assertTrue(bst1.insert(55));
		assertTrue(bst1.insert(75));
		assertTrue(bst1.remove(75));
		assertFalse(bst1.remove(715));
		

	}

}
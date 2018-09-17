package tests;

// A unit test for class DiceTray
//
// authors: Pratyush Singh
//
import static org.junit.Assert.*;
import org.junit.Test;
import model.DiceTray;

public class DiceTrayTest {

	private static char[][] tray = { // Always use upper case letters in the dice tray
			{ 'A', 'B', 'C', 'D' },

			{ 'E', 'F', 'G', 'H' },

			{ 'I', 'J', 'K', 'L' },

			{ 'M', 'N', 'O', 'P' } };

	private static char[][] tray1 = { // Always use upper case letters in the dice tray
			{ 'A', 'B', 'C', 'Q' },

			{ 'T', 'G', 'I', 'X' },

			{ 'D', 'E', 'H', 'J' },

			{ 'K', 'L', 'M', 'N' } };

	private static char[][] tray2 = { // Always use upper case letters in the dice tray
			{ 'A', 'B', 'C', 'Q' },

			{ 'T', 'G', 'I', 'U' },

			{ 'D', 'E', 'H', 'U' },

			{ 'K', 'L', 'M', 'N' } };

	@Test
	public void testStringFindWhenThereStartingInUpperLeftCorner() {
		DiceTray bt = new DiceTray(tray);
		assertTrue(bt.found("ABC"));
		assertTrue(bt.found("AbC")); // Must be case insensitive
		assertTrue(bt.found("abE"));
		assertTrue(bt.found("abF"));
		assertTrue(bt.found("abG"));
		assertTrue(bt.found("ABCD"));
		assertTrue(bt.found("FKP"));

		assertFalse(bt.found("ABD"));
		assertFalse(bt.found("ABA"));
		assertFalse(bt.found("ACE"));
		assertFalse(bt.found("Afl"));
		assertFalse(bt.found("FKM"));
		// ...
		assertTrue(bt.found("ABFEJINM"));
		assertTrue(bt.found("AbCdHgFeIjKLpONm"));
		assertTrue(bt.found("ABCDHLPOKJNMIEFG"));

		// =======================================================Test Q

		DiceTray bt1 = new DiceTray(tray1);
		assertTrue(bt1.found("Quiet"));
		assertTrue(bt1.found("gbi")); // Must be case insensitive
		assertTrue(bt1.found("Gat"));
		assertTrue(bt1.found("Gcx"));
		assertTrue(bt1.found("giq"));
		assertTrue(bt1.found("ghie"));
		assertTrue(bt1.found("GeMj"));
		assertTrue(bt1.found("gdeic"));
		assertTrue(bt1.found("gteiba"));

		assertFalse(bt1.found("lmhl"));
		assertFalse(bt1.found("giheg"));
		assertFalse(bt1.found("atghg"));
		assertFalse(bt1.found("gg"));
		assertFalse(bt1.found("atdka"));

		DiceTray bt2 = new DiceTray(tray2);
		assertTrue(bt2.found("quu"));

		// ============================================

		DiceTray bt3 = new DiceTray();

	}

}
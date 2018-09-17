
// Pratyush Singh
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class WoodChuckTest {

	@Test
	public void runIt() {
		List<String> list = new ArrayList<String>();
		list.add("how");
		list.add("much");
		list.add("wood");
		list.add("a");
		list.add("woodchuck");
		list.add("chuck");
		list.add("a");
		list.add("woodchuck");
		list.add("chuck");

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		for (int i = 0; i < list.size(); i++) {
			if (!wordCount.containsKey(list.get(i))) {
				wordCount.put(list.get(i), 1);
			} else {
				int count = wordCount.get(list.get(i));
				wordCount.put(list.get(i), count + 1);
			}
		}

		// There are should be 6 mappings
		assertEquals(6, wordCount.size());
		assertEquals(1, (int) wordCount.get("how"));
		assertEquals(1, (int) wordCount.get("much"));
		assertEquals(1, (int) wordCount.get("wood"));
		assertEquals(2, (int) wordCount.get("a"));
		assertEquals(2, (int) wordCount.get("woodchuck"));
		assertEquals(2, (int) wordCount.get("chuck"));
		assertNull(wordCount.get("NotHere"));
	}
}
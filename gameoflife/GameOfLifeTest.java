
// @author Pratyush Singh

import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTest {
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);
		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
		assertFalse(society.cellAt(13, 3));
	}

	@Test
	public void testNeighborsNoWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
		assertEquals(0, society.neighborCount(22, 4));

		GameOfLife society1 = new GameOfLife(6, 5);
		society1.growCellAt(0, 0);
		society1.growCellAt(0, 1);
		society1.growCellAt(1, 0);
		society1.growCellAt(1, 1);
		society1.growCellAt(0, 4);
		society1.growCellAt(1, 4);
		society1.growCellAt(5, 0);
		society1.growCellAt(5, 1);
		society1.growCellAt(5, 4);

		assertEquals(8, society1.neighborCount(0, 0));
		assertEquals(5, society1.neighborCount(0, 4));
		assertEquals(3, society1.neighborCount(5, 4));
		assertEquals(5, society1.neighborCount(5, 0));
		assertEquals(2, society1.neighborCount(2, 4));

	}

	@Test
	public void testUpdate() {
		GameOfLife society2 = new GameOfLife(5, 7);
		society2.growCellAt(1, 2);
		society2.growCellAt(1, 4);
		society2.growCellAt(2, 2);
		society2.growCellAt(2, 3);
		society2.growCellAt(2, 4);

		society2.update();

		assertEquals(2, society2.neighborCount(3, 3));

		society2.update();

		assertEquals(1, society2.neighborCount(1, 2));
		society2.update();
		assertFalse(society2.cellAt(2, 2));
		assertEquals(1, society2.neighborCount(2, 3));

		GameOfLife society3 = new GameOfLife(5, 7);
		society3.growCellAt(2, 2);
		society3.growCellAt(2, 3);
		society3.growCellAt(2, 4);

		assertEquals(1, society3.neighborCount(2, 2));
		society3.update();
		assertEquals(3, society3.neighborCount(2, 2));

	}
}

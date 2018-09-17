
/**
 * A type that represents a Matrix of integers.
 *
 * Methods include:
 *
 * 1) Matrix(int[][])
 * 2) int get(int, int)
 * 3) int rows()
 * 4) int columns()
 * 5) void scalarMultiply(int inc)
 * 6) Matrix add(Matrix)
 * 7) void transpose()
 * 
 * @author Pratyush Singh
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void testRowsOrColumns() {
		int[][] a1 = { { 1, 2, 3 }, { -1, -2, -3 } }; // two rows, three columns
		int[][] a2 = { { 4, 5, 6 }, { 7, 8, 9 } }; // three rows, two columns

		Matrix m1 = new Matrix(a1);
		Matrix m2 = new Matrix(a2);

		assertEquals(2, m1.rows());
		assertEquals(3, m1.columns());
		assertEquals(2, m2.rows());
		assertEquals(3, m2.columns());

		int[][] a3 = new int[5][3];
		int count = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				a3[i][j] = count++;
			}
		}

		Matrix m3 = new Matrix(a3);
		assertEquals(5, m3.rows());
		assertEquals(3, m3.columns());
		count = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(count++, m3.get(i, j));
			}
		}

		assertEquals(Integer.MIN_VALUE, m3.get(10, 10));

		count--;
		int sum = (count * (count + 1)) / 2;
		assertEquals(sum, m3.sumOfAllElements());

		count = 1;
		m3.scalarMultiply(3);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				assertEquals(3 * count++, m3.get(i, j));
			}
		}

		Matrix testMatrix = m1.add(m2);
		assertEquals(5, testMatrix.get(0, 0));
		assertEquals(7, testMatrix.get(0, 1));
		assertEquals(9, testMatrix.get(0, 2));
		assertEquals(6, testMatrix.get(1, 0));
		assertEquals(6, testMatrix.get(1, 1));
		assertEquals(6, testMatrix.get(1, 2));

		assertEquals(5, m3.rows());
		assertEquals(3, m3.columns());

		m3.transpose();

		assertEquals(3, m3.rows());
		assertEquals(5, m3.columns());

		assertEquals(3, m3.get(0, 0));
		assertEquals(12, m3.get(0, 1));
		assertEquals(21, m3.get(0, 2));
		assertEquals(30, m3.get(0, 3));
		assertEquals(39, m3.get(0, 4));

		assertEquals(6, m3.get(1, 0));
		assertEquals(15, m3.get(1, 1));
		assertEquals(24, m3.get(1, 2));
		assertEquals(33, m3.get(1, 3));
		assertEquals(42, m3.get(1, 4));

		assertEquals(9, m3.get(2, 0));
		assertEquals(18, m3.get(2, 1));
		assertEquals(27, m3.get(2, 2));
		assertEquals(36, m3.get(2, 3));
		assertEquals(45, m3.get(2, 4));

		assertEquals(null, m1.add(m3));

	}

	// Add many more @Test methods and assertions and get 100% code coverage

}

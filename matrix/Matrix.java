import java.util.Arrays;

/**
 * This class Matrix represents a mathematical Matrix. It uses an int[][] to
 * store the elements of the Matrix.
 * 
 * @author Pratyush Singh
 */
public class Matrix {

	private int[][] elements;
	private int rows;
	private int columns;

	// Construct a Matrix object that has the same elements as the argument
	public Matrix(int[][] table) {
		elements = new int[table.length][table[0].length];
		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table[0].length; col++) {
				elements[row][col] = table[row][col];
			}
		}
		rows = table.length;
		columns = table[0].length;
	}

	// Return the number of rows in this Matrix
	public int rows() {
		// TODO: Complete this method
		return elements.length;
	}

	// Return the number of columns in this Matrix
	public int columns() {
		// TODO: Complete this method
		return elements[0].length;
	}

	// Return the value of the element at the given row and column
	public int get(int row, int column) {
		// TODO: Complete this method

		if (row < elements.length && column < elements[0].length) {
			return elements[row][column];
		}
		return Integer.MIN_VALUE;
	}

	//
	// Multiply every element in this matrix by factor
	// BTW: the extra ----s are needed since the default editor
	// would treat 20 spaces as one space (like in a Web Page)
	//
	// 1 2 3 scalarMultiply(2) -> 2 4 6
	// 4 5 6 -------------------> 8 10 12
	//
	public void scalarMultiply(int factor) {
		for (int row = 0; row < elements.length; row++) {
			for (int col = 0; col < elements[0].length; col++) {
				elements[row][col] = factor * elements[row][col];
			}
		}
	}

	//
	// Return the sum of all integers in this Matrix
	// 1 2 3 sumOfAllElements() returns 1+2+3+4+5+6 = 21
	// 4 5 6
	//
	public int sumOfAllElements() {
		int sum = 0;
		for (int row = 0; row < elements.length; row++) {
			for (int col = 0; col < elements[0].length; col++) {
				sum += elements[row][col];
			}
		}
		return sum;
	}

	//
	// Return a new Matrix the is sum of this Matrix and the other Matrix.
	//
	// Sample usage: Matrix c = matrix.add(other);
	//
	// Example:
	// | 4 3 | | 5 4 | | 9 7 |
	// | 2 7 |+| 6 8 |=| 8 15|
	// | 3 1 | | 1 -4| | 4 -3|
	//
	// Precondition: Both this Matrix and the other Matrix
	// have the same number of rows and columns.
	//
	public Matrix add(Matrix other) {

		if (other.rows() == rows && other.columns() == columns) {

			int[][] newMatrix = new int[elements.length][elements[0].length];

			for (int row = 0; row < elements.length; row++) {
				for (int col = 0; col < elements[0].length; col++) {
					newMatrix[row][col] = elements[row][col] + other.get(row, col);
				}
			}

			return new Matrix(newMatrix);
		}

		return null;
	}

	//
	// Change this Matrix to its transpose. Explained at
	// https://en.wikipedia.org/wiki/Transpose
	//
	// 1 2 3 transpose() -> 1 4
	// 4 5 6 -------------> 2 5
	// -------------------> 3 6
	//
	// You will need to declare a temporary array.
	// Don't forget to assign the temporary array back to this.elements
	// elements = temp;
	//
	// The rows become columns and columns becomes row.
	// Don't forget to swap rows and columns.
	//
	public void transpose() {

		int[][] trasposedMatrix = new int[elements[0].length][elements.length];

		for (int i = 0; i < elements[0].length; i++) {
			for (int j = 0; j < elements.length; j++) {
				trasposedMatrix[i][j] = elements[j][i];
			}
		}

		this.elements = trasposedMatrix;
		int temp = rows;
		rows = columns;
		columns = temp;
	}

}

//@author: Pratyush Singh

package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

// Represent a major piece of Boggle. 
//
// authors: Rick Mercer and Shivansh Singh Chauhan 
//
public class DiceTray {

	private char diceTray[][];
	private Random rand;
	private Dice dice;

	// Constructor takes a 2D array of characters that represents the
	// Boggle DiceTray with 16 dice already rolled in a known fixed state.
	public DiceTray(char[][] array) {
		diceTray = new char[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				diceTray[i][j] = array[i][j];
			}

		}

	}

	public char[][] getDiceTray() {
		return diceTray;
	}

	// This constructor creates a a DiceTray that simulates the rolling of the 16
	// Boggle dice to begin a game of Boggle. The same die must not always appear
	// in the same location. Here are the letters of each of the 16 six-sided dice
	// where six consecutive letters represent one die. L R Y T T E are the letters
	// on one Boggle die-the one in the upper left corner-for example:
	//
	// L R Y T T E ... V T H R W E ... E G H W N E ... S E O T I S
	// A N A E E G ... I D S Y T T ... O A T T O W ... M T O I C U
	// A F P K F S ... X L D E R I ... H C P O A S ... E N S I E U
	// Y L D E V R ... Z N R N H L ... N M I H U Qu .. O B B A O J
	//
	public DiceTray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		diceTray = new char[4][4];
		rand = new Random();
		dice = new Dice();
		for (int i = 0; i < 16; i++) {
			list.add(i);
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int diceIndex = list.get(rand.nextInt(list.size()));
				diceTray[i][j] = dice.rollDice(diceIndex);
				list.remove(new Integer(diceIndex));
			}
		}
	}

	/*
	 * @Override public String toString() { String ret = ""; for (int i = 0; i < 4;
	 * i++) { for (int j = 0; j < 4; j++) { ret +=
	 * Character.toString(diceTray[i][j]) + " "; } ret += "\n"; }
	 * 
	 * return ret; }
	 */

	// Return true if str is found in the this DiceTray according to Boggle
	// rules. Note: This method does NOT check to see if the word is in the
	// list of words.
	//
	// Precondition: str.length() >= 3
	public boolean found(String str) {
		boolean[][] visited = new boolean[diceTray.length][diceTray[0].length];

		for (int i = 0; i < diceTray.length; i++) {
			for (int j = 0; j < diceTray[i].length; j++) {
				if (backtrack(diceTray, i, j, str, 0, visited, false))
					return true;
			}
		}

		return false;

	}

	private boolean backtrack(char[][] dicetray, int row, int col, String str, int cur, boolean[][] visited,
			boolean lastQ) {

		if (row < 0 || col < 0 || row >= dicetray.length || col >= dicetray[0].length || cur >= str.length())
			return false;

		if (lastQ && Character.toLowerCase(str.charAt(cur)) == 'u') {
			cur++;
			if (cur >= str.length())
				return false;

			lastQ = false;
		}

		if (visited[row][col] || Character.toLowerCase(dicetray[row][col]) != Character.toLowerCase(str.charAt(cur)))
			return false;
		if (cur == str.length() - 1) {
			return true;
		}

		if (Character.toLowerCase(str.charAt(cur)) == 'q') {
			lastQ = true;
		}

		boolean ret = false;
		visited[row][col] = true;

		if (backtrack(dicetray, row - 1, col, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row + 1, col, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row, col - 1, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row, col + 1, str, cur + 1, visited, lastQ)

				|| backtrack(dicetray, row - 1, col - 1, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row - 1, col + 1, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row + 1, col + 1, str, cur + 1, visited, lastQ)
				|| backtrack(dicetray, row + 1, col - 1, str, cur + 1, visited, lastQ)) {
			ret = true;
		}

		visited[row][col] = false;

		return ret;

	}
}

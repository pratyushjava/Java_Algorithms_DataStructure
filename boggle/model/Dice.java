//@author: Pratyush Singh

package model;

import java.util.*;

import com.sun.javafx.collections.MappingChange.Map;

public class Dice {

	private HashMap<Integer, ArrayList<Character>> dices;
	private Random r;

	public Dice() {
		dices = new HashMap<Integer, ArrayList<Character>>();
		ArrayList<Character> list;
		r = new Random();
		/*
		 * String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; for (int i = 0; i < 16 ; i++) {
		 * list = new ArrayList<Character>(); for (int j = 0 ; j < 6; j++) {
		 * list.add(chars.charAt(r.nextInt(26))); dices.put(i, list); } }
		 */
		list = new ArrayList<Character>();
		list.add('O');
		list.add('B');
		list.add('B');
		list.add('A');
		list.add('O');
		list.add('J');
		dices.put(0, list);

		list = new ArrayList<Character>();
		list.add('L');
		list.add('R');
		list.add('Y');
		list.add('T');
		list.add('T');
		list.add('E');
		dices.put(1, list);

		list = new ArrayList<Character>();
		list.add('A');
		list.add('N');
		list.add('A');
		list.add('E');
		list.add('E');
		list.add('G');
		dices.put(2, list);

		list = new ArrayList<Character>();
		list.add('A');
		list.add('F');
		list.add('P');
		list.add('K');
		list.add('F');
		list.add('S');
		dices.put(3, list);

		list = new ArrayList<Character>();
		list.add('Y');
		list.add('L');
		list.add('D');
		list.add('E');
		list.add('V');
		list.add('R');
		dices.put(4, list);

		list = new ArrayList<Character>();
		list.add('V');
		list.add('T');
		list.add('H');
		list.add('R');
		list.add('W');
		list.add('E');
		dices.put(5, list);

		list = new ArrayList<Character>();
		list.add('I');
		list.add('D');
		list.add('S');
		list.add('Y');
		list.add('T');
		list.add('T');
		dices.put(6, list);

		list = new ArrayList<Character>();
		list.add('X');
		list.add('L');
		list.add('D');
		list.add('E');
		list.add('R');
		list.add('I');
		dices.put(7, list);

		list = new ArrayList<Character>();
		list.add('Z');
		list.add('N');
		list.add('R');
		list.add('N');
		list.add('H');
		list.add('L');
		dices.put(8, list);

		list = new ArrayList<Character>();
		list.add('E');
		list.add('G');
		list.add('H');
		list.add('W');
		list.add('N');
		list.add('E');
		dices.put(9, list);

		list = new ArrayList<Character>();
		list.add('O');
		list.add('A');
		list.add('T');
		list.add('T');
		list.add('O');
		list.add('W');
		dices.put(10, list);

		list = new ArrayList<Character>();
		list.add('H');
		list.add('C');
		list.add('P');
		list.add('O');
		list.add('A');
		list.add('S');
		dices.put(11, list);

		// L R Y T T E ... V T H R W E ... E G H W N E ... S E O T I S
		// A N A E E G ... I D S Y T T ... O A T T O W ... M T O I C U
		// A F P K F S ... X L D E R I ... H C P O A S ... E N S I E U
		// Y L D E V R ... Z N R N H L ... N M I H U Qu .. O B B A O J

		list = new ArrayList<Character>();
		list.add('N');
		list.add('M');
		list.add('I');
		list.add('H');
		list.add('U');
		list.add('Q');
		dices.put(12, list);

		list = new ArrayList<Character>();
		list.add('S');
		list.add('E');
		list.add('O');
		list.add('T');
		list.add('I');
		list.add('S');
		dices.put(13, list);

		list = new ArrayList<Character>();
		list.add('M');
		list.add('T');
		list.add('O');
		list.add('I');
		list.add('C');
		list.add('U');
		dices.put(14, list);

		list = new ArrayList<Character>();
		list.add('E');
		list.add('N');
		list.add('S');
		list.add('I');
		list.add('E');
		list.add('U');
		dices.put(15, list);

	}

	public char rollDice(int index) {
		return dices.get(index).get(r.nextInt(6));
	}

}

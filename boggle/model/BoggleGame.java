//take a list of words and compute the score
//@author: Pratyush Singh
package model;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class BoggleGame {

	private DiceTray tray;
	private Dictionary dict;
	Set<String> wrongWords;
	Set<String> correctWords;

	public BoggleGame(DiceTray tray) {
		this.tray = tray;
		dict = new Dictionary(tray);
		wrongWords = new TreeSet<String>();
		correctWords = new TreeSet<String>();
	}

	public int computeScore(Set<String> words) {
		int score = 0;
		for (String word : words) {
			boolean contain = dict.contains(word);
			boolean found = tray.found(word);
			if (contain && found) {
				int len = word.length();
				if (len >= 3 && len <= 4) {
					score += 1;
				} else if (len == 5) {
					score += 2;
				} else if (len == 6) {
					score += 3;
				} else if (len == 7) {
					score += 5;
				} else if (len >= 8 && len <= 16) {
					score += 11;
				}

				correctWords.add(word);
			} else {
				wrongWords.add(word);
			}
		}

		return score;
	}

	public Set<String> getCorrectWord() {
		return correctWords;
	}

	public Set<String> getWrongWord() {
		return wrongWords;
	}

	public LinkedList<String> getPossibleWords() {
		return dict.getPossibleWords();

	}

}

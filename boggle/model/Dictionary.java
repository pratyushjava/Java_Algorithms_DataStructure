//Checks if the word exists, which means it has a collection of words
//@author: Pratyush Singh
package model;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Dictionary {
	private final int TABLE_SIZE = 200000;
	private LinkedList<String>[] lists;
	private LinkedList<String> completeLists;
	private LinkedList<String> possibleWords;
	private int n;
	private StringBuilder fileText;
	private TreeNode root;
	private DiceTray tray;

	class TreeNode {
		char content;
		boolean isWord;
		int count;
		LinkedList<TreeNode> children;

		public TreeNode(char ch) {
			children = new LinkedList<TreeNode>();
			isWord = false;
			content = ch;
			count = 0;
		}

		public TreeNode subNode(char ch) {
			if (children != null)
				for (TreeNode child : children)
					if (child.content == ch)
						return child;
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Dictionary(DiceTray tray) {
		n = 0;
		this.tray = tray;
		root = new TreeNode(' ');
		possibleWords = new LinkedList<String>();
		lists = new LinkedList[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			lists[i] = new LinkedList<String>();

		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no file");
		}
	}

	public void insert(String word) {
		TreeNode current = root;
		for (char ch : word.toCharArray()) {
			TreeNode child = current.subNode(ch);
			if (child != null)
				current = child;
			else {
				current.children.add(new TreeNode(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isWord = true;
	}

	public void wordsInDiceTray(TreeNode root, String word) {
		TreeNode current = root;
		LinkedList<TreeNode> children = current.children;
		for (TreeNode node : children) {
			char ch = node.content;
			String newWord = new String(word);
			newWord += Character.toString(ch);
			if (tray.found(newWord)) {
				if (node.isWord && newWord.length() > 2) {
					possibleWords.add(newWord);
				}
				wordsInDiceTray(node, newWord);
			}
		}

	}

	public LinkedList<String> getPossibleWords() {
		if (possibleWords.size() == 0) {
			wordsInDiceTray(root, "");
		}

		return possibleWords;
	}

	private int hashCode(String key) {
		// String's hashCode can have arithmetic overflow so it can be negative
		return Math.abs(key.hashCode()) % TABLE_SIZE;
	}

	private String readFile() throws IOException {
		completeLists = new LinkedList<String>();
		File file = new File("BoggleWords.txt");
		fileText = new StringBuilder((int) file.length());
		Scanner scanner = new Scanner(file);
		String separtr = " ";

		try {
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine();
				fileText.append(str.toLowerCase() + separtr);
				int listIndex = hashCode(str);
				LinkedList<String> list = lists[listIndex];
				list.addFirst(str);
				completeLists.add(str);
				insert(str);
				n++;
			}
			return fileText.toString();
		} finally {
			scanner.close();
		}
	}

	// Return true if the mapping already exists in this Map.
	public boolean contains(String key) {
		if (key == null) {
			return false;
		}
		int listIndex = hashCode(key);
		LinkedList<String> list = lists[listIndex];
		if (list.size() > 0) {
			for (String str : list) {
				if (str.equals(key)) {
					return true;
				}
			}
		}

		return false;
	}

	public void binarySearch(LinkedList<String> words) {
		LinkedList<String> list = new LinkedList<String>();

	}

}

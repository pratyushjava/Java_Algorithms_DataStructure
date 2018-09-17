package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

// A model for the game of 20 questions. This type can be used to build a 
// console based game of 20 questions or a GUI based game.
//
// @author Pratyush Singh
//
public class GameTree {

	// BinaryTreeNode inner class used to create new nodes in the GameTree.
	private class TreeNode {

		// Instance variables
		private String data;
		private TreeNode left;
		private TreeNode right;

		// You might find this constructor useful, maybe not. If you are losing code
		// coverage with a working object and never used this, feel free to delete this
		// to improve code coverage percentage.
		TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		// You might find this constructor useful, maybe not. If you are losing code
		// coverage with a working object and never used this, feel free to delete this
		// to improve code coverage percentage.
		TreeNode(String theData, TreeNode leftLink, TreeNode rightLink) {
			data = theData;
			left = leftLink;
			right = rightLink;
		}
	}

	// Instance variables
	private TreeNode root;
	private Scanner inFile;
	private String currentFileName;
	private TreeNode currentNode;
	private String strOutput;
	private FileWriter outputStream;
	// Hint: You will also need a Scanner and a reference to the current.

	// Constructor needed to create the game. It should open the input file and call
	// the recursive method build(). The String parameter name is the name of the
	// file from which we need to read the game questions and answers from.
	//
	public GameTree(String name) {
		currentFileName = name;
		try {
			inFile = new Scanner(new File(currentFileName));
			root = build();
			currentNode = root;
			inFile.close();
		} catch (FileNotFoundException e) {
		}

	}

	private TreeNode build() {
		if (!inFile.hasNextLine()) {
			return null;
		}
		String token = inFile.nextLine().trim();
		if (isAnswer(token)) {
			return new TreeNode(token);
		} else {
			TreeNode left = build();
			TreeNode right = build();
			return new TreeNode(token, left, right);
		}
	}

	private boolean isAnswer(String token) {
		return !token.endsWith("?");
	}

	// Add a new question and answer to the currentNode. If the current node is
	// Feathers?, theGame.add("Does it swim?", "goose"); should change a node
	// like this:
	//
	// ----- Feathers? ----------------- Feathers? ----
	// ----- / ---- \ ------------------ / ------ \ ---
	// - duck --- horse ------ Does it swim? ---- horse
	// --------------------------- / ---- \ -----------
	// ----------------------- goose --- duck ---------
	//
	// @param newQuestion: The question to add where the old answer was.
	// @param newAnswer: The new Yes answer for the new question.
	//
	public void add(String newQuestion, String newAnswer) {
		String temp = currentNode.data;
		currentNode.data = newQuestion;
		currentNode.left = new TreeNode(newAnswer);
		currentNode.right = new TreeNode(temp);
	}

	// Return true if getCurrent() returns an answer rather than a question. Return
	// False
	// if the current node is an internal node rather than an answer at a leaf.
	public boolean foundAnswer() {

		return currentNode.left == null && currentNode.right == null;
	}

	// Return the data for the current node, which could be a question or an answer.
	public String getCurrent() {
		if (currentNode == null) {
			return null;
		} else {
			return currentNode.data;
		}
	}

	// Ask the game to update the current node in the tree by going left for
	// Choice.yes or right for Choice.no Example code:
	// theGame.playerSelected(Choice.Yes);
	//
	public void playerSelected(Choice yesOrNo) {
		if (currentNode != null) {
			if (yesOrNo == Choice.YES) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
	}

	// Begin a game at the root of the tree. getCurrent should return the question
	// at the root of this GameTree.
	public void reStart() {
		currentNode = root;
	}

	// Overwrite the old file for this gameTree with the current state that may have
	// new questions added since the game started.
	private void serialize(TreeNode node) throws IOException {
		if (node == null)
			return;

		outputStream.write(node.data + "\n");
		serialize(node.left);
		serialize(node.right);
	}

	public void saveGame() {
		// TODO: Complete this method
		// Hint: Call a private helper method with a root argument to do
		// a preorder traversal pver the current state of this GameTree

		try {
			outputStream = new FileWriter(new File(currentFileName));
			serialize(root);
			outputStream.close();
		} catch (IOException e) {
		}
	}

	private void toString(TreeNode node, int level) {
		if (node != null) {
			toString(node.right, level + 1);
			for (int i = 1; i <= level; i++) {
				strOutput += "- ";
			}
			strOutput = strOutput + node.data + " \n";
			toString(node.left, level + 1);
		}
	}

	// Method used to print out a text version of the game file.
	@Override
	public String toString() {
		if (root == null) {
			return "Empty Tree";
		} else {
			strOutput = "\n";
			toString(root, 0);
			return strOutput.trim();
		}
	}

}
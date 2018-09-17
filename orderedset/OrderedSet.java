/**
 * This collection class maintains a set of values in their natural order as
 * defined by compareTo. The only type that can be stored in this collection
 * must implement interface Comparable<T>
 * 
 * @author Pratyush Singh
 * 
 * @param <E>
 *            The type argument when constructed can be any type that implements
 *            Comparable or another interface that extends Comparable
 */
public class OrderedSet<E extends Comparable<E>> {

	// A private class that stores one node in a Binary Search Tree
	private class TreeNode {

		private TreeNode right;
		private E data;
		private TreeNode left;

		public TreeNode(E element) {
			left = null;
			data = element;
			right = null;
		}
	} // end class TreeNode

	private TreeNode root;

	// Create an empty OrderedSet
	public OrderedSet() {
		root = null;
	}

	// 1) Insert element into this OrderedSet and return true keeping this an
	// OrderedSet. If element exists, do not change this OrderedSet, return false.
	// A set must have unique elements. This algorithm should be O(log n)
	private boolean wasInserted;
	private int n;

	public boolean insert(E el) {
		wasInserted = false;
		root = insert(root, el);
		return wasInserted;
	}

	private TreeNode insert(TreeNode t, E el) {
		if (t == null) {
			t = new TreeNode(el);
			wasInserted = true;
			n++;
		} else if (el.compareTo(t.data) < 0)
			t.left = insert(t.left, el);
		else if (el.compareTo(t.data) > 0)
			t.right = insert(t.right, el);
		return t;
	}

	// 2) The number of elements in this OrderedSet, which should be 0 when first
	// constructed. This may run O(n) or O(1)--your choice.
	public int size() {
		return n;
	}

	// 3) Return one string that concatenates all elements in this OrderedSet as
	// they are visited in order. Elements are separated by spaces as in "1 4 9"
	// from this OrderedSet.
	// ___ 4
	// _ / _ \
	// _1 ___ 9
	// This algorithm may run O(n)
	public String toStringInorder() {
		// TODO: Implement this method
		return toStringInorder(root).trim();
	}

	public String toStringInorder(TreeNode t) {
		if (t == null) {
			return "";
		} else {
			return toStringInorder(t.left) + t.data + " " + toStringInorder(t.right);
		}

	}

	// 4) Return true is search equals an element in this OrderedSet.
	public boolean contains(E search) {

		return !(contains(root, search) == null);
	}

	public E contains(TreeNode t, E search) {
		if (t == null)
			return null;
		if (search.compareTo(t.data) < 0)
			return contains(t.left, search);
		else if (search.compareTo(t.data) > 0)
			return contains(t.right, search);
		else
			return t.data;

	}

	// 5) Return the element in this OrderedSet that is greater than all other
	// elements using the comapreTo method of E. If this is empty, return null.
	public E max() {

		return max(root);
	}

	private E max(TreeNode t) {
		if (t == null) {
			return null;
		}
		if (t.right == null) {
			return t.data;
		} else {
			return max(t.right);
		}
	}

	// 6) Return how many nodes are at the given level. If level > the height of the
	// tree, return 0. Remember that an empty tree has a height of -1 (page 252).
	//
	// ____ 4 _ There is 1 node on level 0
	// ___ / \
	// __ 3 __ 9 _ There are 2 nodes on level 1
	// _ / \ __ \
	// 1 __ 5 __ 11 _ There are 3 nodes in level 2 and 0 nodes on levels >= 3)
	public int nodesAtLevel(int level) {
		// TODO: Implement this method
		nodeAtLevel = 0;
		nodesAtLevel(root, level);
		return nodeAtLevel;
	}

	private int nodeAtLevel;

	void nodesAtLevel(TreeNode node, int level) {
		if (node == null)
			return;
		if (level == 0) {
			nodeAtLevel++;
			return;
		} else {
			nodesAtLevel(node.left, level - 1);
			nodesAtLevel(node.right, level - 1);
		}
	}

	// 7) Return the intersection of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The intersection of two sets is the set of elements that are in both sets.
	// The intersection of {2, 4, 5, 6} and {2, 5, 6, 9} is {2, 5, 6}
	private OrderedSet<E> temp;

	public void intersectionHelper(TreeNode node) {

		if (root == null || node == null) {
			return;
		}

		if (contains(node.data)) {
			temp.insert(node.data);
			intersectionHelper(node.left);
			intersectionHelper(node.right);
		}

	}

	public OrderedSet<E> intersection(OrderedSet<E> other) {
		temp = new OrderedSet<E>();
		intersectionHelper(other.root);
		return temp;
	}

	// 8) Return the union of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The union of two sets is the set all distinct elements in the collection.[
	// The union of {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}

	public void uniounHelper(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return;
		}

		if (node1 != null && node2 != null) {
			temp.insert(node1.data);
			temp.insert(node2.data);
			uniounHelper(node1.left, node2.left);
			uniounHelper(node1.right, node2.right);
			return;
		} else if (node1 != null) {
			temp.insert(node1.data);
			uniounHelper(node1.left, null);
			uniounHelper(node1.right, null);
			return;
		} else if (node2 != null) {
			temp.insert(node2.data);
			uniounHelper(null, node2.left);
			uniounHelper(null, node2.right);
			return;
		}

	}

	public OrderedSet<E> union(OrderedSet<E> other) {
		temp = new OrderedSet<E>();
		uniounHelper(root, other.root);
		return temp;
	}

	// 9) Return an OrderedSet that contains all elements that are greater than or
	// equal to the first parameter inclusive and strictly less than the second
	// parameter exclusive.
	void subsetHelper(TreeNode node, E inclusive, E exclusive) {
		if (node == null)
			return;

		subsetHelper(node.left, inclusive, exclusive);
		if (inclusive.compareTo(node.data) <= 0 && exclusive.compareTo(node.data) > 0) {
			temp.insert(node.data);
		}
		subsetHelper(node.right, inclusive, exclusive);
	}

	public OrderedSet<E> subset(E inclusive, E exclusive) {
		temp = new OrderedSet<E>();
		subsetHelper(root, inclusive, exclusive);
		return temp;
	}

	// 10) Return true if two different OrderedSet objects have the same exact
	// structure. Each node must have the same number of nodes on every level,
	// the same height, the same size, the same number of leaves, and the same
	// number of internal nodes. Each corresponding node must also have the same
	// number of children (0, 1, or 2) in the same place. The data need NOT be the
	// same. Do not compare corresponding elements.
	//
	// Please see the specification for morey examples
	// Here is one example that must return true:
	//
	// ... M ......... P
	// ../...\ ..... /...\
	// .B ... R ... F.....Q
	// ..\ ... \.....\ ....\
	// ...F.... Z ....J.....R
	//
	// Here is one example that must return false
	// ....M...........M
	// ../...\ ..... /...\
	// .B.....R.....B.....R
	// ..\.....\ ...\..../
	// ...F.....Z....F..Z
	// Precondition: E is the same for both OrderedSets

	public boolean sameStructureHelper(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		return sameStructureHelper(node1.left, node2.left) && sameStructureHelper(node1.right, node2.right);
	}

	public boolean sameStructure(OrderedSet<E> other) {
		return sameStructureHelper(root, other.root);
	}

	// 11) If element equals an element in this OrderedSet, remove it and return
	// true. Return false whenever element is not found. In all cases, this
	// OrderedSet must remain a true OrderedSet. Here is one recommended algorithm
	// http://www.cs.arizona.edu/~mercer/Projects/BSTRemoveGeneric.pdf
	//
	// This algorithm should be O(log n)
	//

	public boolean remove(E element) {
		if (contains(element))
			return true;
		return false;
	}
}
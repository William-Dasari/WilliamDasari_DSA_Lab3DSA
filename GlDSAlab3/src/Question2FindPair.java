//Question 2) Find a pair with a given sum in Binary Search Tree

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

//Skeleton of a binary Tree
class Node {
	int key;
	Node leftnode, rightnode;

//Constructor
	public Node(int key) {
		this.key = key;
		leftnode = rightnode = null;
	}
}

public class Question2FindPair {
	Node rootnode;

	public static void main(String[] args) {
		Question2FindPair tree = new Question2FindPair();
		// Inserting nodes
		tree.rootnode = tree.insert(tree.rootnode, 4);
		tree.insert(tree.rootnode, 2);
		tree.insert(tree.rootnode, 6);
		tree.insert(tree.rootnode, 1);
		tree.insert(tree.rootnode, 3);
		tree.insert(tree.rootnode, 5);
		tree.insert(tree.rootnode, 7);

		// Calling inorder traversal to sort the tree
		tree.inOrderTraverse(tree.rootnode);
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Sum = ");
		int sum = scanner.nextInt();

		tree.findPairWithGivenSum(tree.rootnode, sum);

	}

	private void findPairWithGivenSum(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		if (!findPairUntil(root, sum, set)) {
			System.out.print("Nodes are not found" + "\n");
		}

	}

	private boolean findPairUntil(Node node, int sum, Set<Integer> set) {
		if (node == null) {
			return false;
		}
		if (findPairUntil(node.leftnode, sum, set))
			return true;
		int diff = sum - node.key;
		if (set.contains(diff)) {
			System.out.println("Given Pair (" + node.key + "," + diff + ")\n Nodes Found");
			return true;
		} else {
			set.add(node.key);
		}
		return findPairUntil(node.rightnode, sum, set);
	}

	private void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.leftnode);
		System.out.print(node.key + " ");
		inOrderTraverse(node.rightnode);
	}

	// insert a new node with given key in BST
	private Node insert(Node node, int key) {
		// is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}

		if (key < node.key) {
			node.leftnode = insert(node.leftnode, key);
		} else if (key > node.key) {
			node.rightnode = insert(node.rightnode, key);
		}
		return node;
	}

}

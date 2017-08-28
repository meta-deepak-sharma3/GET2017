/**
 * The class CompleteBinaryTree is an implementation of complete binary tree data structure.
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree<T> {
	private Node<T> root;
	private String preOrder = "";
	private String postOrder = "";
	private String inOrder = "";

	/**
	 * This method will add node to the tree.
	 * 
	 * @param data
	 */
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		if (root == null) {
			root = node;
		} else {
			Node<T> currentNode;
			Queue<Node<T>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				currentNode = queue.poll();
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(node);
					break;
				} else if (currentNode.getRight() == null) {
					currentNode.setRight(node);
					break;
				} else {
					queue.add(currentNode.getLeft());
					queue.add(currentNode.getRight());
				}
			}
		}
	}

	/**
	 * This method returns in order of the tree.
	 * 
	 * @return String: InOrder of Tree
	 */
	public String inOrder() {
		inOrder(root);
		return inOrder;
	}

	/**
	 * This method runs recursively for each node to calculate in order of the
	 * tree.
	 * 
	 * @param node
	 */
	private void inOrder(Node<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			inOrder += node.getData() + ",";
			inOrder(node.getRight());
		}
	}

	/**
	 * This method returns pre order of the tree.
	 * 
	 * @return String: preorder of the tree
	 */
	public String preOrder() {
		preOrder(root);
		return preOrder;
	}

	/**
	 * This method runs recursively for each node to calculate pre order of the
	 * tree.
	 * 
	 * @param node
	 */
	private void preOrder(Node<T> node) {
		if (node != null) {
			preOrder += node.getData() + ",";
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	/**
	 * This method returns post order of the tree.
	 * 
	 * @return String: Postorder of tree
	 */
	public String postOrder() {
		postOrder(root);
		return postOrder;
	}

	/**
	 * This method runs recursively for each node to calculate post order of the
	 * tree.
	 * 
	 * @param node
	 */
	private void postOrder(Node<T> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			postOrder += node.getData() + ",";
		}
	}

	/**
	 * This method returns root of the tree.
	 * 
	 * @return Node: Root of the tree
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * This method calculates if trees are mirror tree or not
	 * 
	 * @param secondTree
	 * @return boolean
	 */
	public boolean isMirror(CompleteBinaryTree<T> secondTree) {
		return isMirror(root, secondTree.getRoot());
	}

	/**
	 * This method runs recursively for each node of both trees to check if
	 * trees are mirror trees or not.
	 * 
	 * @param node1
	 * @param node2
	 * @return boolean
	 */
	private boolean isMirror(Node<T> node1, Node<T> node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return node1.getData() == node2.getData()
				&& isMirror(node1.getLeft(), node2.getRight())
				&& isMirror(node1.getRight(), node2.getLeft());
	}
}
/**
 * The class Node represents node of the tree. This is a POJO class.
 */
package tree;

public class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node() {
		data = null;
		left = null;
		right = null;
	}

	public Node(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	// Getters and setters method.
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
}
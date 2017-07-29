package Assignments;

public class Connection {

	private Node nodeOne, nodeTwo;

	/**
	 * This is constructor 
	 * @param nodeOne is first node
	 * @param nodeTwo is second node
	 */
	public Connection(Node nodeOne, Node nodeTwo) {

		this.nodeOne = (nodeOne.getEntity().getName()
				.compareTo(nodeTwo.getEntity().getName()) <= 0) ? nodeOne
				: nodeTwo;
		
		this.nodeTwo = (this.nodeOne == nodeOne) ? nodeTwo : nodeOne;
	}

	// Get the current node
	public Node getConnection(Node current) {
		if (!(current.equals(nodeOne) || current.equals(nodeTwo))) {
			return null;
		}

		return (current.equals(nodeOne)) ? nodeTwo : nodeOne;
	}

	//get node one
	public Node getOne() {
		return this.nodeOne;
	}

	// get node two
	public Node getTwo() {
		return this.nodeTwo;
	}

	//return the connection 
	public String toString() {
		return  nodeOne + "-->" + nodeTwo ;
	}

	// return the hash code of connection
	public int hashCode() {
		return (nodeOne.getEntity().getName() + nodeTwo.getEntity().getName())
				.hashCode();
	}

	// Checking that if node one is equal to node two
	public boolean equals(Object other) {
		if (!(other instanceof Connection)) {
			return false;
		}

		Connection e = (Connection) other;

		return e.nodeOne.equals(this.nodeOne) && e.nodeTwo.equals(this.nodeTwo);
	}
}

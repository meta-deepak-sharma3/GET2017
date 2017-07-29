package Assignments;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
	// It maps names of entity to the one nodes
	private HashMap<String, Node> vertices;
	private HashMap<Integer, Connection> edges;

	//Contructor
	public Graph() {
		this.vertices = new HashMap<String, Node>();
		this.edges = new HashMap<Integer, Connection>();
	}
	
	// Adding Edges to the two nodes 
	public boolean addEdge(Node one, Node two) {
		if (one.equals(two)) {
			return false;
		}
		Connection connection = new Connection(one, two);
		if (edges.containsKey(connection.hashCode())) {
			return false;
		}
		else if (one.containsFriend(connection)
				|| two.containsFriend(connection)) {
			return false;
		}

		edges.put(connection.hashCode(), connection);
		one.addFriend(connection);
		two.addFriend(connection);
		return true;
	}

	// It checks that two nodes contains Connection or not
	public boolean containsEdge(Connection connection) {
		if (connection.getOne() == null || connection.getTwo() == null) {
			return false;
		}
		return this.edges.containsKey(connection.hashCode());
	}

	// It remove the Connection
	public Connection removeEdge(Connection connection) {
		connection.getOne().removeFriend(connection);
		connection.getTwo().removeFriend(connection);
		return this.edges.remove(connection.hashCode());
	}

	// It Contains node type vertex or not
	public boolean containsVertex(Node vertex) {
		return this.vertices.get(vertex.getEntity()) != null;
	}

	// It returns Node type Object of an entity by name
	public Node getVertex(String name){
		return vertices.get(name);
	}
	
	//Its adding a Node to a graph
	public boolean addVertex(Node vertex, boolean overwriteExisting) {
		Node current = this.vertices.get(vertex.getEntity());
		if (current != null) {
			if (!overwriteExisting) {
				return false;
			}
			while (current.getFriendsCount() > 0) {
				this.removeEdge(current.getFriends(0));
			}
		}
		vertices.put(vertex.getEntity().getName(), vertex);
		return true;
	}

	// To remove node
	public Node removeVertex(String label) {
		Node v = vertices.remove(label);
		while (v.getFriendsCount() > 0) {
			this.removeEdge(v.getFriends(0));
		}
		return v;
	}
	
	// To return keys of connection
	public Set<String> vertexKeys() {
		return this.vertices.keySet();
	}

	// To set hash code of connections
	public Set<Connection> getEdges() {
		return new HashSet<Connection>(this.edges.values());
	}
}

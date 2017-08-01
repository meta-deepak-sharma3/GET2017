package assignment1;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 *
 */
public class SocialNetwork {

	/**
	 * @param args
	 * 
	 * Entry method of program
	 */
	public static void main(String[] args) {
		// creating object of graph to create a new graph
		Graph graph = new Graph();
		// console operation object for input-output reading
		ConsoleOperations consoleOperations = new ConsoleOperations();
		// creating a social network object
		SocialNetwork socialNetwork = new SocialNetwork();
		// list of type nodes is initialized by calling build graph method
		List <Node> nodeList = socialNetwork.buildGraph(graph);
		// print social network
		socialNetwork.printSocialNetwork(nodeList);
		// char variable to continue the loop
		char userPermission = '\0';
		do{
			// user input for searching entity in network
			String userInput = consoleOperations.getString("Enter name to search in network");
			// getting a node by user input
			Node userNode = graph.getVertex(userInput);
			// getting entity from node 
			Entity entity = userNode.getEntity();
			// printing the entity data
			System.out.println("Name: "+entity.getName());
			System.out.println("Contact Number: "+entity.getContactNumber());
			System.out.println("Email ID: "+entity.getEmailID());
			// taking user permission
			userPermission = consoleOperations.getString("Do You Want to Continue ? "+
					 "Press Y for Yes || press any key to exit").charAt(0);
		}while(userPermission == 'y' || userPermission == 'Y' );
		System.out.println("Program Ended");
	}
	
	/**
	 * @param nodeList
	 * 
	 * printing the complete social network 
	 */
	public void printSocialNetwork(List<Node> nodeList) {
		System.out.println("Social Network: ");
		for (int i = 0; i < nodeList.size(); ++i) {
			System.out.println("Connections of: " + nodeList.get(i).toString()
					+ "\n");
			for (int j = 0; j < nodeList.get(i).getFriendsCount(); ++j) {
				System.out.println(nodeList.get(i).getFriends(j));
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param graph
	 * @return list of nodes
	 * 
	 * this method builds the graph
	 */
	public List<Node> buildGraph(Graph graph) {
		FileOperations fileOperations = new FileOperations();
		// reading entity data from file
		List<Entity> entityList = fileOperations
				.readDataFromFile("Network_Information.txt");
		// reading relations data from file
		List<String> connectionList = fileOperations
				.readConnectionsFromFile("Network_Relations.txt");
		// creating a node list 
		List<Node> nodeList = new ArrayList<Node>();
		Node node = null;
		// creating a node for each entity. Adding node to nodeList. Adding node to graph 
		for (Entity entity : entityList) {
			node = new Node(entity);
			nodeList.add(node);
			graph.addVertex(node, true);
		}
		// creating a connection from given file . Adding connections to graph
		for (String string : connectionList) {
			String[] personNames = string.split(",");
			Node nodeOne = graph.getVertex(personNames[0]);
			for (int i = 1; i < personNames.length; i++) {
				Node nodeTwo = graph.getVertex(personNames[i]);
				graph.addEdge(nodeOne, nodeTwo);
			}
		}
		return nodeList;
	}
}

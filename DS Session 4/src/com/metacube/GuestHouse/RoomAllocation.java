package com.metacube.com;

public class RoomAllocation {
	

	MyHashTable<Integer, Customer> roomMapping;
	
	/**
	 * Constructor for {@link RoomAllocation}
	 */
	public RoomAllocation() {
		roomMapping = new MyHashTable<Integer, Customer>();
	}
	
	/**
	 * Allocating the Rooms to customer 
	 * @param scan is Scanner object to take input
	 * @param room is {@link RoomAllocation} object 
	 */
	public void insertCust(Scanner scan , RoomAllocation room){
		System.out.println("Enter your name");
		String name = scan.nextLine();
		System.out.println("Enter your age");
		int age = scan.nextInt();
		scan.nextLine();
		Customer cust = new Customer(name, age);
		room.roomMapping.insertCustInfo(age, cust);
	}
	
	/**
	 * Getting information of the Customers
	 * @param scan is Scanner object to take input
	 * @param room is {@link RoomAllocation} object
	 */
	public void getCustInfo(Scanner scan , RoomAllocation room){
		System.out.println("Enter the Customer age");
		int age = scan.nextInt();
		scan.nextLine();
		Customer cust = room.roomMapping.getValue(age);
		System.out.println("Customer Name : "+cust.getCustName());
		System.out.println("Customer Age : "+cust.getCustAge());
	}
	
	public static void main(String args[]){
		System.out.println("*********Welcome to The Guest House**********");
		RoomAllocation room = new RoomAllocation();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Enter your choice");
			System.out.println("1: Insert Customer");
			System.out.println("2: Get Customer Info");
			System.out.println("3: exit");
			int choice =  getIntegerInput();
			if(choice == 1){
				room.insertCust(scan, room);
			}else if(choice == 2){
				room.getCustInfo(scan, room);
			}else if(choice == 3){
				break;
			}else{
				System.out.println("\nEnter Correct Choice\n");
			}
		}while(true);
	}
	
	private static int getIntegerInput() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int number=-1;
		
		do {
			try{
				number = sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Please enter valid input");
				flag = false;
			}
		}while(!flag || number<=0);
		return number;
	}
	
}

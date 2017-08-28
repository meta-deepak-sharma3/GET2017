package com.metacube.GuestHouse;

import java.util.*;

/**
 * Class to allocate rooms to guests
 * 
 */
public class RoomAllocation {
	

	MyHashTable<Integer, Customer> roomMapping;
	
	/**
	 * Constructor for {@link RoomAllocation}
	 */
	public RoomAllocation(int totalRooms) {
		roomMapping = new MyHashTable<Integer, Customer>(totalRooms);
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
		room.roomMapping.insertValue(age, cust);
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
		System.out.println("**********");
		System.out.println("Customer Name : "+cust.getCustName()+" Customer Age : "+cust.getCustAge()+" Room No: "+room.roomMapping.getKey(age));
		System.out.println("**********");
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("*********Welcome to The Guest House**********");
		System.out.println("Enter the number of rooms in the guest room:");
		int totalRooms = getIntegerInput(scan);
		RoomAllocation room = new RoomAllocation(totalRooms);
		boolean flag = true;
		do{
			System.out.println("Enter your choice");
			System.out.println("1: Insert Customer");
			System.out.println("2: Get Customer Info");
			System.out.println("3: exit");
			int choice =  getIntegerInput(scan);
			switch(choice) {
				case 1:
					room.insertCust(scan,  room);
					break;
				case 2:
					room.getCustInfo(scan,  room);
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("\nEnter Correct Choice\n");
			}
		}while(flag);
	}
	
	/**
	 * getting integer input from the user
	 * @return integer value.
	 */
	private static int getIntegerInput(Scanner scan) {
		boolean flag = true;
		int number=-1;
		
		do {
			try{
				number = scan.nextInt();
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

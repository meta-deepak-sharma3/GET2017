package com.metacube.GuestHouse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomAllocationTest {
	private RoomAllocation room;
	private String firstName, secondName;
	private int firstAge, secondAge;
	
	/**
	 * Initial creation of room allotment process in guest house.
	 * execution: before all the test methods. 
	 */
	@Before
	public void setUp() throws Exception {
		int totalRooms = 12;
		room = new RoomAllocation(totalRooms);
		firstName = "Vijay";
		firstAge = 23;
		Customer firstCust = new Customer(firstName, firstAge);
		room.roomMapping.insertValue(firstAge, firstCust);
		
		secondName = "Vijay";
		secondAge = 23;
		Customer secondCust = new Customer(secondName, secondAge);
		room.roomMapping.insertValue(secondAge, secondCust);
	}
	
	/**
	 * test method to test guest age from room allotment process
	 */
	@Test
	public void testGuestAge() {
		
		Customer fActualFirstCust = room.roomMapping.getValue(firstAge);
		
		assertEquals(fActualFirstCust.getCustAge(), firstAge);
	}
	
	/**
	 * test method to test guest name from room allotment process
	 */
	@Test
	public void testGuestName() {
		
		Customer fActualFirstCust = room.roomMapping.getValue(firstAge);
		
		assertEquals(fActualFirstCust.getCustName(), firstName);
	}
}

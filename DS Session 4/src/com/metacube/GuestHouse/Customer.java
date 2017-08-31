package com.metacube.GuestHouse;

/*
 * Value Object class for customer
 */
public class Customer {
	private String custName;
	private int custAge;
	/**
	 * constructor setting the customer name and its age
	 */
	public Customer(String name , int age) {
		this.custName = name;
		this.custAge = age;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @return the custAge
	 */
	public int getCustAge() {
		return custAge;
	}
	
}

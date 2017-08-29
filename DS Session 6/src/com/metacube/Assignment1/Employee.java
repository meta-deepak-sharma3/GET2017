package com.metacube.Assignment1;

/**
 * Employee object class
 * @author Deepak
 *
 */
public class Employee implements Comparable<Object>{
	private int empId;
	private String name, address;
	
	/**
	 * Parameterized Constructor override
	 * @param empId
	 * @param name
	 * @param address
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * returns id of the employee.
	 * @return
	 */
	public int getId() {
		return empId;
	}
	
	/**
	 * returns name of the employee
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns address of the employee.
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	@Override
	public int hashCode() {
		return empId;
	}
	
	/**
	 * returns the equality between two objects.
	 */
	@Override
	public boolean equals(Object obj) {
		Employee otherEmployee = (Employee)obj;
		return (this.empId == otherEmployee.getId());
	}
	
	/**
	 * implemented method of Comparable interface 
	 */
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Employee otherEmployee = (Employee)arg0; 
		return this.toString().compareTo(otherEmployee.toString());
	}
	
	@Override
	public String toString() {
		return("Employee:Id= "+this.empId+"|"+"Name= "+this.name+"|"+"Address= "+this.address);
	}
}

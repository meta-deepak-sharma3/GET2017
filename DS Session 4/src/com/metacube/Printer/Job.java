package com.metacube.Printer;
/**
 * class for job, with job name and priority as parameters
 *
 */
public class Job {
	String name ;
	int priority;
	
	public Job(String name , int priority){
		this.name = name;
		this.priority = priority;
	}
	
	/*
	 * get the job name
	 */
	public String getName(){
		return this.name;
	}
	
	/*
	 * get the job priority
	 */
	public int getPriority(){
		return this.priority;
	}
}

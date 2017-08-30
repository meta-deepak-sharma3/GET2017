package com.Webservice;

public class Temperature {
	
	public double convertToCelsius(int fahrenheit) {
		double celsius = (5.0/9.0) * (fahrenheit-32);
		return Math.round(celsius*100.0)/100.0;
	}
}

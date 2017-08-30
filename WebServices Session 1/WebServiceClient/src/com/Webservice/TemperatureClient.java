package com.Webservice;
import java.util.Scanner;
public class TemperatureClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in );;
		int temperature;
		TemperatureServiceLocator locatorObj = new TemperatureServiceLocator();
		locatorObj.setTemperatureEndpointAddress("http://localhost:10103/WebService/services/Temperature");
			try{
				Temperature tempObj = locatorObj.getTemperature();
				System.out.println("Enter temperature in Fahrenheit: ");
				temperature = scan.nextInt();
				System.out.println("Temperature in celsius is: " + tempObj.convertToCelsius(temperature));	
			}
			catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
			finally{
				scan.close();
			}
		
	}
}

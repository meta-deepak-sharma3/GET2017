package DefaultNamespace;
import java.util.Scanner;
public class TemperatureClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in );;
		double temperature;
		TemperatureServiceLocator locatorObj = new TemperatureServiceLocator();
		locatorObj.setTemperatureEndpointAddress("http://localhost:10133/WS1/services/Temperature");
			try{
				Temperature tempObj = locatorObj.getTemperature();
				System.out.println("Enter temperature in Fahrenheit: ");
				temperature = scan.nextDouble();
				System.out.println("Temperature in celsius is: " + tempObj.convertToCelsius(temperature));
				System.out.println("Check another temperature: (y/n)");	
			}
			catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
			finally{
				scan.close();
			}
		
	}
}

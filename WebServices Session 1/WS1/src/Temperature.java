import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public class Temperature {
	@WebMethod
	public static double convertToCelsius(double tempFahrenheit){		
		double tempCelsius = 0;		
		try{			
			tempCelsius = ((tempFahrenheit - 32)/(1.8));
		}catch(Exception e){			
			e.printStackTrace();
		}		
		return tempCelsius;
	}
}

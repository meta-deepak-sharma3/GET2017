package Assignments;

import java.util.HashMap;
import java.util.Map;

public class Order {
	int[] productCodes;
	Map<Integer, Integer> productCodeWithQuantity;
	double orderAmount;
	
	Order(int[] productCodes, int[] quantity){
		productCodeWithQuantity = new HashMap<Integer, Integer>();
		this.productCodes = productCodes;
		int i = 0;
		while(i<productCodes.length){
			this.productCodeWithQuantity.put(productCodes[i], new Integer(quantity[i]));
			i++;
		}
	}

	public void setOrderAmount(double orderAmount) {
		// TODO Auto-generated method stub
		this.orderAmount = orderAmount;
	}
}

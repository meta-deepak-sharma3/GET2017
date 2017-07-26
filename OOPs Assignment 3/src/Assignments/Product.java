package Assignments;

public class Product {
	
	int productCode;
	String productName;
	double productPrice;
	
	void setAttributes(int productCode, String productName, double productPrice){
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public int getProductCode() {
		// TODO Auto-generated method stub
		return this.productCode;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.productName;
	}
	
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.productPrice;
	}
	
}

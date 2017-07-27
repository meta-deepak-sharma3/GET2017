package Assignments;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//User Class 
public class ShoppingStore{
	public static void main(String[] args) throws UnsupportedEncodingException{
		//Map for maintaining 
		//print all available products to user
		CsvProductList csvProductsFile = new CsvProductList();
		Product[] products = csvProductsFile.getProducts();
		System.out.println("PRODUCT ID\tPRODUCT NAME\tPRODUCT PRICE");
		for(Product product: products){
			System.out.println(product.getProductCode()+"\t"+product.getName()+"\t"+product.getPrice());
		}
		//print available promotion ----> To Do
		
		System.out.println("Enter the number of products to buy");
		Scanner sc = new Scanner(System.in);
		int n=0;
		do{
			try{
				n = sc.nextInt(); 
			}catch(InputMismatchException e){
				System.out.println("Not a valid input");
			}
		}while(n<0 || n>products.length);	
		int[] productCodes = new int[n];
		int[] quantities = new int[n];
		int count = 0;
		double orderAmount = 0.00;
		for(int i=0;i<n;i++){
			System.out.println("Enter the valid product Code");
			int productCode = sc.nextInt();
			System.out.println("Enter the quantity for this product");
			int quantity = sc.nextInt();
			if(isValidProductCode(productCode) && isValidQuantity(quantity)){
				// to do- check if product code already exist or not
				if(!Check.contains(productCodes, productCode)){
					productCodes[count] = productCode;
					quantities[count++] = quantity;
					for(Product product: products){
						if(product.productCode==productCode){
							orderAmount = orderAmount+product.productPrice*quantity;
							break;
						}
					}
				}else{
					System.out.println("Duplicate Product Entry");
					i--;
				}
			}
		}
		sc.close();
		Order order = new Order(productCodes, quantities);
		order.setOrderAmount(orderAmount);
		//Generate Billing Amount with the help of Promotions
		BillDisplay billDisplay = new BillDisplay(order);
		// for printing of Bill on Console
		billDisplay.display();
		// for writing the output file with the bill
		billDisplay.report();
		
	}

	private static boolean isValidQuantity(int quantity) {
		boolean flag = true;
		if(quantity<0){
			flag = false;
		}
		return flag;
	}
	private static boolean isValidProductCode(int productCode){
		CsvProductList csvProductList = new CsvProductList();
		Product[] products = csvProductList.getProducts();
		boolean isPresent = false;
		for(Product product: products){
			if(product.productCode == productCode){
				isPresent = true;
			}
		}
		return isPresent;
	}
	
}


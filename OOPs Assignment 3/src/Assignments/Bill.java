package Assignments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//class to handle final bill Amount
public class Bill{
	double subTotal;
	double total;
	double productLevelDiscount;
	double orderLevelDiscount;
	//Constructor
	public Bill(Order order){
		//getting initial orderAmount as Sub Total
		subTotal = order.orderAmount;
		// Add proper discounts on order based on each product and order
		//apply FixedAmountDiscount and FixedPercentDiscount for order as well as product.
		
		//1. First Product Level Discount
		this.productLevelDiscount = 0.00;
		//get all product Codes in order
		int[] productCodes = order.productCodes;
		// get Product List
		CsvProductList csvProductList = new CsvProductList();
		Product[] products = csvProductList.getProducts();
		//getting all product promotion list
		CsvProductPromoList csvProductPromoList = new CsvProductPromoList();
		ProductPromotion[] productPromoList = csvProductPromoList.getProductsPromotionList();
		//checking for each order product codes to be present in productPromotion
		for(int i=0;i<productCodes.length;i++){
			double productPrice = 0.00;
			for(ProductPromotion productPromotion: productPromoList){
				int[] productCodesFromProductPromotion = productPromotion.productCodes;
				if(Check.contains(productCodesFromProductPromotion, productCodes[i])){
					if(productPromotion.productPromotionType.equals("ProductFixedAmountPromotion")){
						productLevelDiscount = productLevelDiscount + order.productCodeWithQuantity.get(productCodes[i])*productPromotion.discountAmount;
					}else{
						//getting product price from product Code
						for(Product product: products){
							if(product.productCode == productCodes[i]){
								productPrice = product.productPrice;
								break;
							}
						}
						productLevelDiscount = productLevelDiscount + order.productCodeWithQuantity.get(productCodes[i])*(productPromotion.discountPercent/100)*productPrice;
					}
				}
				
			}
		}
		order.orderAmount = order.orderAmount - productLevelDiscount;
		//2. Second Order Level Discount
		this.orderLevelDiscount = 0.00;
		CsvOrderPromoList csvOrderPromoList = new CsvOrderPromoList();
		OrderPromotion[] orderPromoList = csvOrderPromoList.geOrderPromotionsList();
		double maxThreshold = 0.00;
		double orderAmount = order.orderAmount;
		// checking for each order promotion entity
		for(OrderPromotion orderPromotion: orderPromoList){
			if(orderPromotion.threshold > maxThreshold && orderAmount>=orderPromotion.threshold){
				this.orderLevelDiscount = 0.00;
				orderAmount = order.orderAmount;
				// Applying Order Discount according to type
				if(orderPromotion.orderPromotionType.equals("OrderFixedAmountPromotion")){
					this.orderLevelDiscount = this.orderLevelDiscount + orderPromotion.discountAmount;
					orderAmount = orderAmount - orderPromotion.discountAmount;
				}else{
					this.orderLevelDiscount = this.orderLevelDiscount + orderAmount*(orderPromotion.discountPercent/100);
					orderAmount = orderAmount - orderAmount*(orderPromotion.discountPercent/100);
				}
				maxThreshold = orderPromotion.threshold;
			}
		}
		order.orderAmount = orderAmount;
		total = order.orderAmount;
	}

}

//class to display Billing Amount
// Getting subTotal, Total, Order Level Discount, Product Level Discount from parent class
class BillDisplay extends Bill{
	Order order;
	String resultString;
	public BillDisplay(Order order){
		super(order);
		this.resultString = "";
		this.order = order;
		total = order.orderAmount;
	}

	public void display() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		this.resultString = this.resultString + "###########################\n";
		this.resultString = this.resultString + "Your Order\n";
		this.resultString = this.resultString + "###########################\n";
		this.resultString = this.resultString + "Purchased Products: \n";
		// get Product List
		CsvProductList csvProductList = new CsvProductList();
		Product[] products = csvProductList.getProducts();
		// Display Purchased Product 
		int[] productCodesFromOrder = order.productCodes;
		
		for(int i=0;i<productCodesFromOrder.length;i++){
			for(Product product: products){
				if(product.productCode == productCodesFromOrder[i]){
					this.resultString = this.resultString + "Product : "+productCodesFromOrder[i]+" - "+product.productName+"\n";
					this.resultString = this.resultString + "Cost : "+order.productCodeWithQuantity.get(productCodesFromOrder[i])*product.productPrice+"("+order.productCodeWithQuantity.get(productCodesFromOrder[i])+" X " + formatRupees()+product.productPrice+")\n";
					this.resultString = this.resultString + "\n";
					break;
				}
			}
			
		}
		//Printing all the available promotions for Order Products;
		this.resultString = this.resultString + "SubTotal : " + formatRupees() + subTotal+"\n";
		this.resultString = this.resultString + "Product Level Discounts : " + formatRupees() + productLevelDiscount+"\n";
		this.resultString = this.resultString + "Order Level Discounts : " + formatRupees() + orderLevelDiscount+"\n";
		this.resultString = this.resultString + "Total Discounts : " + formatRupees() + (productLevelDiscount+orderLevelDiscount)+"\n";
		this.resultString = this.resultString + "Total : " + formatRupees() + total+"\n";
		
		System.out.println(this.resultString);
	}

	public void report() {
		// TODO Auto-generated method stub
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter("Report2.txt"));
			writer.write(this.resultString);
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(writer !=null)
					writer.close();
			}catch(IOException e){
				
			}
		}	
		
	}
	String formatRupees() throws UnsupportedEncodingException{
		String string = "\u20B9";
	    byte[] utf8 = string.getBytes("UTF-8");

	    string = new String(utf8, "UTF-8");
	    return string;
	}
}
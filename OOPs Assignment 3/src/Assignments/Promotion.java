package Assignments;

public abstract class Promotion {
	String promotionType;
	double discountAmount;
	double discountPercent;
}

class ProductPromotion extends Promotion{
	int[] productCodes;
	String productPromotionType;
	ProductPromotion(){
		promotionType = "ProductPromotion";
		discountAmount = 0.00;
		discountPercent = 0.00;
	}
	public void setAttributes(int[] productCodes, String productPromotionType,
			double discountAmount, double discountPercent) {
		// TODO Auto-generated method stub
		this.productCodes = productCodes;
		this.productPromotionType = productPromotionType;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
	}
}

class OrderPromotion extends Promotion{
	String orderPromotionType;
	double threshold;
	OrderPromotion(){
		promotionType = "OrderPromotion";
		discountAmount = 0.00;
		discountPercent = 0.00;
	}
	public void setAttributes(String orderPromotionType,
			double discountAmount, double discountPercent, double threshold) {
		// TODO Auto-generated method stub
		this.orderPromotionType = orderPromotionType;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
		this.threshold = threshold;
	}
}
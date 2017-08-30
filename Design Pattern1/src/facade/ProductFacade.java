package facade;

import model.CartVo;
import model.ProductVo;
import dao.BaseDao;
import dao.InMemoryProductDao;

/**
 * Facade Layer will interact between the dao and view layer.
 */
public class ProductFacade {
	BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
	
	/**
	 * Check if the input product is in the store or not.
	 * 
	 * @param input    Product type input.
	 * @return true if input is in the product map otherwise false.
	 */
	public boolean isValid(ProductVo input) {
		boolean result = false;
		if(InMemoryProductDao.productMap.containsKey(input.getProductId())) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Calculates the total price of the input product.
	 * 
	 * @param input    Product type input.
	 * @return total price of the input product bought.
	 */
	public double getPrice(ProductVo input) {
		double totalPrice;
		ProductVo prod = (ProductVo) daoObject.getProduct(input.getProductId());
		double price = prod.getProductPrice(); 
		totalPrice = input.getProductQuantity() * price;
		return totalPrice;
	}
	
	/**
	 * Adds the product to the cart including its id, quantity and total price.
	 * 
	 * @param input    Product type input.
	 */
	public void addToCart(ProductVo input){
		CartVo cart = new CartVo();
		cart.setProductId(input.getProductId());
		cart.setProductQuantity(input.getProductQuantity());
		cart.setTotalPrice(getPrice(input));

		((InMemoryProductDao)daoObject).addToCartItems(cart);
		System.out.println("Product added successfully to the cart.");
	}

}

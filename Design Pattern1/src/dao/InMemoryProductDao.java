package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.BaseEntity;
import model.CartVo;
import model.ProductVo;

/**
 * Used when the database is in the memory.
 */
public class InMemoryProductDao implements BaseDao, ProductDao {
	public static HashMap<Integer, ProductVo> productMap = new HashMap<Integer, ProductVo>();
	static List<CartVo> cartItems = new ArrayList<CartVo>();

	@Override
	public ProductVo getProduct(int productId) {
		// TODO Auto-generated method stub
		return InMemoryProductDao.productMap.get(productId);
	}

	@Override
	public void addProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		productMap.put(((ProductVo)product).getProductId(), (ProductVo)product);
	}

	@Override
	public void updateProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		productMap.put(((ProductVo)product).getProductId(), (ProductVo)product);
	}

	@Override
	public void deleteProduct(BaseEntity product) {
		// TODO Auto-generated method stub	
	}

	@Override
	public HashMap<Integer, ProductVo> getAllProducts() {
		// TODO Auto-generated method stub
		return productMap;
	}
	
	public void addToCartItems(CartVo cart) {
		cartItems.add(cart);
	}

	public static List<CartVo> getCartItems() {
		return cartItems;
	}
	
	/**
	 * Removes the product from the cart.
	 * 
	 * @param productId    ID of the product to be removed.
	 */
	public static void removeFromCart(int productId) {
		boolean flag = true;
		// Iterates over the list of products in cart.
		for (CartVo item : cartItems) {
			// Deletes the product from cart if available.
			if (item.getProductId() == productId) {
				cartItems.remove(item);
				flag = false;
				System.out.println("Product is successfully removed from the cart.");
				break;
			}
		}
	}
}

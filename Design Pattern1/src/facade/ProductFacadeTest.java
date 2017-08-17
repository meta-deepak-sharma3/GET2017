package facade;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ProductVo;

public class ProductFacadeTest {
	
	//Positive Test Case
	@Test
	public void getPricePositiveTest() {
		ProductVo product = new ProductVo();
		product.setProductId(1);
		product.setProductName("Product 1");
		product.setProductPrice(23.00);
		product.setProductQuantity(3);
		
		ProductFacade productFacade = new ProductFacade();
		assertEquals(23.00, productFacade.getPrice(product), 0.001);  //epsilon used here
	
	}

	//Negative Test Case
		@Test
		public void getPriceNegativeTest() {
			ProductVo product = new ProductVo();
			product.setProductId(2);
			product.setProductName("Product 2");
			product.setProductPrice(22.00);
			product.setProductQuantity(1);
			
			ProductFacade productFacade = new ProductFacade();
			assertEquals(23.00, productFacade.getPrice(product), 0.001);  //epsilon used here
		
		}
}

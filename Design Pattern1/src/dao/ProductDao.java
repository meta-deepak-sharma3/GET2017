package dao;

import java.util.HashMap;
import model.ProductVo;

/**
 * Interface which contains the list of all the products.
 */
public interface ProductDao extends BaseDao{
	public HashMap<Integer, ProductVo> getAllProducts();
}

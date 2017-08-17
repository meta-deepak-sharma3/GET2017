package dao;

import java.util.HashMap;
import java.util.List;

import model.BaseEntity;
import model.ProductVo;

/**
 * For future use if the database is in MySQL.
 */
public class MySQLDao implements BaseDao, ProductDao {

	@Override
	public ProductVo getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, ProductVo> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}

package dao;
import model.BaseEntity;
import model.ProductVo;

/**
 * Interface to Add, Delete, Update and Get products.
 */
public interface BaseDao {
	public ProductVo getProduct(int productId);
	public void addProduct(BaseEntity product);
	public void updateProduct(BaseEntity product);
	public void deleteProduct(BaseEntity product);
	public BaseDao getInstance();
}

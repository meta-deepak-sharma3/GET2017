package facade;

import dao.BaseDao;
import dao.FileDao;
import dao.InMemoryProductDao;
import dao.MySQLDao;

/**
 * Generates the object of the required class.
 */
public class ProductFactory {
	
	/**
	 * Returns the object of required class to the facade layer. 
	 * 
	 * @param instance    Type of object to obtain from the factory.
	 * @return the object of the required class.
	 */
	public static BaseDao getInstance(String instance){
		switch(instance){
		case "InMemoryProductDao":
			return (InMemoryProductDao)InMemoryProductDao.getInstance();
		case "MySQLDao":
			return (MySQLDao)MySQLDao.getInstance();
		case "FileDao":
			return (FileDao)FileDao.getInstance();
		default:
			return null;
		}
	}
}

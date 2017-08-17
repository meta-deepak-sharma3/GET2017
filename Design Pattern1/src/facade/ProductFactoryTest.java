package facade;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.InMemoryProductDao;

public class ProductFactoryTest {

	@Test
	public void getInstanceTest() {
		InMemoryProductDao productDao = (InMemoryProductDao) ProductFactory.getInstance("InMemoryProductDao");
		assertEquals("InMemoryProductDao", String.valueOf(productDao.getClass()));
	}

}

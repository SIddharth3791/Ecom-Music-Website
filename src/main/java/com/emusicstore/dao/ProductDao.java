package com.emusicstore.dao;
import java.util.ArrayList;
import java.util.List;

import com.emusicstore.model.*;

public class ProductDao {
	
	private List<Product> productList;
	
	public List<Product> getProductList()
	{
		productList = new ArrayList<Product>();
		
		Product product1 = new Product();
		product1.setProductName("Guitar 1");
		product1.setProductCategory("Instrument");
		product1.setProductDescription("This is fender strat guitar");
		product1.setProductPrice(1200);
		product1.setProductCondition("New");
		product1.setProductStatus("Active");
		product1.setUnitInStrock(10);
		product1.setProductManufacturer("Fender");
		
		Product product2 = new Product();
		product2.setProductName("Trumpet ");
		product2.setProductCategory("Instrument");
		product2.setProductDescription("LJ Hutcheon BB Trumpet ");
		product2.setProductPrice(650);
		product2.setProductCondition("Used");
		product2.setProductStatus("Active");
		product2.setUnitInStrock(23);
		product2.setProductManufacturer("Hutcheon");
		
		Product product3 = new Product();
		product3.setProductName("Speaker");
		product3.setProductCategory("Accessory");
		product3.setProductDescription("This is a Polk Shelf Speaker");
		product3.setProductPrice(355);
		product3.setProductCondition("New");
		product3.setProductStatus("Active");
		product3.setUnitInStrock(5);
		product3.setProductManufacturer("Polk");
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
	}

}

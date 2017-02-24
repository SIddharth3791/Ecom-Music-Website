package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	public void addProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		
	}

	public Product getProductById(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		return product;
	}

	public List<Product> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> product = query.list();
		session.flush();
		return product;
	}

	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}

}

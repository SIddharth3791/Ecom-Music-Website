package com.emusicstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Controller 
public class HomeController {
	
	private ProductDao productDao = new ProductDao();
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getproducts(Model model)
	{
		List<Product> products = productDao.getProductList();
		
		model.addAttribute("products", products);
		
		return "productList";
	}

}

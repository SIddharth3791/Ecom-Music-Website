
package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Controller 
public class HomeController {
	
	private Path path;
	
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getproducts(Model model)
	{
		List<Product> products = productDao.getAllProduct();
		
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model) throws IOException
	{
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	

	@RequestMapping("/admin")
	public String adminPage()
	{
		return "admin";
	}
	
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model)
	{
		List<Product> products = productDao.getAllProduct();
		model.addAttribute("products", products);
		
		return "productInventory";
		
	}
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model)
	{
		Product product = new Product();
		product.setProductCategory("Instrument");
		product.setProductCondition("New");
		product.setProductStatus("Active");
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request)
	{
		productDao.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		
		String rootDirectory = "/Users/sid/Spring Java Application/eMusicStore/src/main/webapp";
		
		path = Paths.get(rootDirectory+"//WEB-INF//resources//images//"+product.getProductId()+".png");
		
		if(productImage != null && !productImage.isEmpty())
		{
			try{
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
				
			}
		}
		
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model, HttpServletRequest request)
	{
		
		String rootDirectory = "/Users/sid/Spring Java Application/eMusicStore/src/main/webapp";
		path = Paths.get(rootDirectory+"//WEB-INF//resources//images//"+id+".png");
		
		
		if (Files.exists(path))
		{
			try{
				Files.delete(path);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		productDao.deleteProduct(id);
		
		return "redirect:/admin/productInventory";
	}

}


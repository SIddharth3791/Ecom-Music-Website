package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
		
	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	private Cart()
	{
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}
	
	public Cart(String cartId){
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void addCartItem(CartItem item)
	{
		String productId = item.getProduct().getProductId();
		
		if (cartItems.containsKey(productId))
		{
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productId, existingCartItem);
		}else
		{
			cartItems.put(productId, item);
		}
		updateGrandTotal();
	}
	
	
	public void removeCartItem(CartItem item)
	{
		String productID = item.getProduct().getProductId();
		cartItems.remove(productID);
		updateGrandTotal();
	}
	
	public void updateGrandTotal(){
		grandTotal = 0;
		for(CartItem item: cartItems.values())
		{
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}
}

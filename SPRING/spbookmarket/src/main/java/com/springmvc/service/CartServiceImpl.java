package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
import com.springmvc.exception.CartException;
import com.springmvc.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartRepository cartRepository;
	
	public Cart create(Cart cart)
	{
		return cartRepository.create(cart);
	}
	
	public Cart read(String cartId)
	{
		return cartRepository.read(cartId);
	}
	
	public void update(String cartId, Cart cart)
	{
		cartRepository.update(cartId, cart);
	}
	
	public void delete(String cartId)
	{
		cartRepository.delete(cartId);
	}
	
	public Cart validateCart(String cartId)
	{
		Cart cart = cartRepository.read(cartId);
		if(cart == null || cart.getCartItems().size() == 0)
		{
			throw new CartException(cartId);
		}
		
		return cart;
	}
}

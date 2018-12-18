package com.Kristen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Kristen.dao.CartoonDao;
import com.Kristen.model.CartoonCharacter;

@Component("CartoonServ")
public class CartoonServiceImpl implements CartoonService {
	public static int counter = 0;

	// this is the old way without dependency injection
	// private CartoonDao cartDao = new CartoonDaoImpl();

	// this is with DI
	@Autowired // usingautowired here tells spring to attempt byName then
	// by type Autowiring.
	private CartoonDao cartDao;

	public CartoonServiceImpl() {
		System.out.println("In service layer: no args constructor-" + ++counter);

	}

	@Autowired
	public CartoonServiceImpl(CartoonDao cartDao) {
		this.cartDao = cartDao;

		System.out.println("In service layer: first constructor-" + ++counter);

	}

	public CartoonServiceImp(CartoonDao cartDao, double i ) {
		this.cartDao = cartDao;
		System.out.println("in service layer:third constructor-" + ++counter);
		System.out.println("this is our second parameter:"+i);
		
	}

	public CartoonServiceImpl(CartoonDao cartDao, int i) {
		this.cartDao = cartDao;
		System.out.println("In service layer:second constructor- " + ++counter);
		System.out.println("this is our second parameter: " + i);
	}

	@Override
	public List<CartoonCharacter> getAllCartoons() {
		return cartDao.selectAll();
	}

	public CartoonDao getCartDao() {
		return cartDao;

	}
	@Autowired
	public void setCartDao (CartoonDao cartDao) {
		System.out.println("inside of the setter");
		this.cartDao=cartDao;
		
	}
}

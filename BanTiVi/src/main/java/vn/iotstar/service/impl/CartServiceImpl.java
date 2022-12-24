package vn.iotstar.service.impl;

import java.util.List;
import vn.iotstar.dao.CartDao;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.model.CartModel;
import vn.iotstar.service.CartService;
public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<CartModel> search(String name) {
		return cartDao.search(name);
	}

	@Override
	public void insert(CartModel cart) {
		cartDao.insert(cart);

	}

	@Override
	public List<CartModel> getAll() {
		return cartDao.getAll();
	}

	@Override
	public CartModel get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(CartModel newCart) {
		CartModel oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}



}

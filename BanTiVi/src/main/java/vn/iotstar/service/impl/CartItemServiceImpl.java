package vn.iotstar.service.impl;

import java.util.List;
import vn.iotstar.dao.CartItemDao;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.service.CartItemService;
public class CartItemServiceImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItemModel newCartItem) {
		CartItemModel oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItemModel get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItemModel> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}

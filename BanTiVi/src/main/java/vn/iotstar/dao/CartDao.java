package vn.iotstar.dao;

import java.util.List;
import vn.iotstar.model.CartModel;

public interface CartDao {
	void insert(CartModel cart);

	void edit(CartModel cart);

	void delete(int id);

	CartModel get(String name);

	CartModel get(int id);

	List<CartModel> getAll();

	List<CartModel> search(String name);
}

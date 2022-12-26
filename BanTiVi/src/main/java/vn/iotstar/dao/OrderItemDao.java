package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.OrderItemModel;

public interface OrderItemDao {
	void insert(OrderItemModel orderitem);
	void delete(int id);

	List<OrderItemModel> getAllByID(int id);
}

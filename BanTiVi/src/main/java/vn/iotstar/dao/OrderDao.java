package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.OrderModel;

public interface OrderDao {
	void insert(OrderModel order);
	
	List<OrderModel> getAll();
	void delete(int id);
	void ShipSuccess(int id);

}
package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.OrderModel;

public interface OrderService {
	void insert(OrderModel order);
	void delete(int id);
	
	List<OrderModel> getAll();

	List<OrderModel> getAllByIdUser(int id);

	void ShipSuccess(int id,String status);

}
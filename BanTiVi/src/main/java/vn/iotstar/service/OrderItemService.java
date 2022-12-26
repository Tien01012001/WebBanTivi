package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.OrderItemModel;

public interface OrderItemService {
	void insert(OrderItemModel orderItem);

	void delete(int id);

	List<OrderItemModel> getAllByID(int id);
}


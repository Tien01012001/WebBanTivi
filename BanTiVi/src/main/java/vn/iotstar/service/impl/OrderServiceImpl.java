package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.OrderDao;
import vn.iotstar.dao.impl.OrderDaoImpl;
import vn.iotstar.model.OrderModel;
import vn.iotstar.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderdao = new OrderDaoImpl();

	@Override
	public void insert(OrderModel order) {
		// TODO Auto-generated method stub
		orderdao.insert(order);
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		return orderdao.getAll();
	}
}
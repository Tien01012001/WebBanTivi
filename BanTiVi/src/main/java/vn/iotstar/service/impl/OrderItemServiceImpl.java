package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.OrderItemDao;
import vn.iotstar.dao.impl.OrderItemDaoImpl;
import vn.iotstar.model.OrderItemModel;
import vn.iotstar.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDao orderitemdao = new  OrderItemDaoImpl();
	@Override
	public void insert(OrderItemModel orderItem) {
		// TODO Auto-generated method stub
		orderitemdao.insert(orderItem);
	}
	@Override
	public List<OrderItemModel> getAll() {
		// TODO Auto-generated method stub
		return orderitemdao.getAll();
	}
	
}

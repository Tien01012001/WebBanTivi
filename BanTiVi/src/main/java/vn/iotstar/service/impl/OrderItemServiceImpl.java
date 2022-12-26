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

	public void delete(int id) {
		orderitemdao.delete(id);
	}

	public List<OrderItemModel> getAllByID(int id){
		return orderitemdao.getAllByID(id);
	}

}

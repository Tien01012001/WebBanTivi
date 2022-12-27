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
	public void delete(int id) {
		orderdao.delete(id);
	}

	public void ShipSuccess(int id,String status){
		orderdao.ShipSuccess(id,status);
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		return orderdao.getAll();
	}

	public List<OrderModel> getAllByIdUser(int id){
		return orderdao.getAllByIdUser(id);
	}


}
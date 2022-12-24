package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.OrderItemDao;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.OrderItemModel;
import vn.iotstar.model.OrderModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CartService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

public class OrderItemDaoImpl implements OrderItemDao {
	CartService cartService = new CartServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(OrderItemModel orderitem) {
		String sql = "INSERT INTO [OrderItem](quantity, unitPrice, pro_id, order_id) VALUES (?,?,?,?)";
		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderitem.getQuantity());
			ps.setDouble(2, orderitem.getUintprice());
			ps.setInt(3, orderitem.getProduct().getId());
			ps.setInt(4, orderitem.getOrder_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
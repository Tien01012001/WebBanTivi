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
		String sql = "INSERT INTO OrderItem VALUES (?,?,?,?,?)";
		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderitem.getId());
			ps.setInt(2, orderitem.getQuantity());
			ps.setDouble(3, orderitem.getUintprice());
			ps.setInt(4, orderitem.getProduct().getId());
			ps.setInt(5, orderitem.getOrder().getID());		
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItemModel> getAll() {
		// TODO Auto-generated method stub
		List<OrderItemModel> orderItemList = new ArrayList<OrderItemModel>();
		String sql = "SELECT OrderItem.id, OrderItem.quantity, OrderItem.unitPrice, Orders.u_id, Orders.phuong_thuc_thanh_toan, Orders.dia_chi_nhan, Orders.ngay_mua, Product.ProductName, Product.price FROM OrderItem INNER JOIN Orders ON OrderItem.order_id = Orders.id INNER JOIN Product ON OrderItem.pro_id = Product.ProductID";
	
		try {
			Connection con = new DBConnect().getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.get(rs.getInt("u_id"));
				OrderModel order = new OrderModel();
				order.setNguoiMua(user);
				order.setPhuongThucThanhToan("phuong_thuc_thanh_toan");
				order.setDiaChiNhan("dia_chi_nhan");
				order.setNgayMua(rs.getDate("ngay_mua"));
				ProductModel product = new ProductModel();
				product.setName(rs.getString("ProductName"));
				product.setPrice(rs.getInt("price"));
				OrderItemModel orderItem = new OrderItemModel();
				orderItem.setId(rs.getInt("id"));
				orderItem.setOrder(order);;
				orderItem.setProduct(product);
				orderItem.setQuantity(rs.getInt("quantity"));
				orderItem.setUintprice(rs.getLong("unitPrice"));
				orderItemList.add(orderItem);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}
}
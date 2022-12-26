package vn.iotstar.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.OrderDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.OrderModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

public class OrderDaoImpl implements OrderDao {
	UserService userS = new UserServiceImpl();

	@Override
	public void insert(OrderModel order) {
		String sql = "INSERT INTO Orders VALUES (?,?,?,?,?,?,?,?)";
		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getID());
			ps.setInt(2, order.getNguoiMua().getUid());
			ps.setDouble(3, order.getTotal());
			ps.setString(4, order.getPhuongThucThanhToan());
			ps.setString(5, order.getSodienthoai());
			ps.setString(6, order.getDiaChiNhan());
			ps.setDate(7, new java.sql.Date(order.getNgayMua().getTime()));
			ps.setString(8, order.getTrangThai());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT * from Orders";
		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.get(rs.getInt(2));
				orderList.add(new OrderModel(rs.getInt(1),
						user,
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getDate(7),
						rs.getString(8)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	public void delete(int id) {
		String sql = "DELETE FROM Orders WHERE id = ?";

		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ShipSuccess(int id){
		String sql = "UPDATE Orders SET trang_thai = ? WHERE id = ?";

		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"Đã giao");
			ps.setInt(2, id);
			ps.executeUpdate();
			// Lấy ResultSet

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
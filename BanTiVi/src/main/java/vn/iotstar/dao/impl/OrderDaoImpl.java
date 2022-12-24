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
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

public class OrderDaoImpl implements OrderDao {
	UserService userS = new UserServiceImpl();

	@Override
	public void insert(OrderModel order) {
		String sql = "INSERT INTO Orders VALUES (?,?,?,?,?,?,?)";
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
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		String sql = "SELECT Orders.id, Users.username, Orders.phuong_thuc_thanh_toan, Orders.dia_chi_nhan, Orders.ngay_mua, Users.UserID AS user_id \r\n" + 
				"				FROM Orders INNER JOIN Users ON Orders.u_id = Users.UserID";
		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.get(rs.getInt("user_id"));
				OrderModel order = new OrderModel();
				order.setID(rs.getInt("id"));
				order.setNguoiMua(user);
				order.setPhuongThucThanhToan("phuong_thuc_thanh_toan");
				order.setDiaChiNhan("dia_chi_nhan");
				order.setNgayMua(rs.getDate("ngay_mua"));
				orderList.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}



}
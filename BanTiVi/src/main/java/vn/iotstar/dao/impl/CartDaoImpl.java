package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.dao.CartDao;
import vn.iotstar.connection.DBConnect;
import vn.iotstar.model.CartModel;
import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

public class CartDaoImpl extends DBConnect implements CartDao {
	UserService userS = new UserServiceImpl();

	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Cart(id,u_id, buyDate) VALUES (?,?,?)";
		
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart.getId());
			ps.setInt(2, cart.getBuyer().getUid());
			ps.setDate(3, new Date(cart.getBuyDate().getTime()));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartModel cart) {
		String sql = "UPDATE cart SET id_user = ?, buyDate = ? WHERE id = ?";
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getBuyer().getUid());
			ps.setDate(2, new Date(cart.getBuyDate().getTime()));
			ps.setString(3, cart.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM cart WHERE id = ?";
			try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CartModel get(int id) {
		String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
				+ "FROM cart INNER JOIN user " + "ON cart.id_user = user.id WHERE cart.id=?";
	
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AccountModel user = userS.get(rs.getInt("user_id"));

				CartModel cart = new CartModel();
				cart.setId(rs.getString("id"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setBuyer(user);
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartModel> getAll() {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
				+ "FROM cart INNER JOIN user " + "ON cart.id_user = user.id";
	
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AccountModel user = userS.get(rs.getInt("user_id"));

				CartModel cart = new CartModel();
				cart.setId(rs.getString("id"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setBuyer(user);

				cartList.add(cart);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	public List<CartModel> search(String name) {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
				+ "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
	
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.get(rs.getInt("user_id"));
				CartModel cart = new CartModel();
				cart.setId(rs.getString("id"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setBuyer(user);
				cartList.add(cart);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public CartModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}

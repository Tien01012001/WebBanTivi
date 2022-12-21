package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public void insert(AccountModel user) {
		String sql = "INSERT INTO [Users](username, password, isAdmin) VALUES (?,?,?)";
	
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			ps.setInt(3,user.getIsAdmin());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public AccountModel get(int id) {
		String sql = "SELECT * FROM [Users] WHERE UserID = ? ";
	
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setUid(rs.getInt("UserID"));
				user.setUser(rs.getString("Username"));
				user.setPass(rs.getString("Password"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<AccountModel> getAllAccount() {
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "SELECT * FROM [Users]";
		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public AccountModel ExistAcount(String user) {
		String sql = "select * from Users where Username=? ;";
		try {
			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1,user);

			rs = ps.executeQuery();

			while (rs.next())

			{

				return new AccountModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}



	public void delete(int uid) {
		String sql = "DELETE FROM Users WHERE UserID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public AccountModel edit(AccountModel account) {
		String sql = "UPDATE Users SET Username = ?, Password=?, isAdmin=? WHERE UserID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUser());
			ps.setString(2, account.getPass());
			ps.setInt(3, account.getIsAdmin());
			ps.setInt(4, account.getUid());
			ps.executeUpdate();
			// Lấy ResultSet

			while (rs.next()) {
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

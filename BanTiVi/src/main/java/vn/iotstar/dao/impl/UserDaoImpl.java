package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public void insert(AccountModel user) {
		String sql = "INSERT INTO [User](username, password, isSeller,isAdmin) VALUES (?,?,?,?)";
	
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			
			ps.setInt(3,user.getIsSell());
			ps.setInt(4,user.getIsAdmin());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public AccountModel get(int id) {
		String sql = "SELECT * FROM [User] WHERE userid = ? ";
	
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setUid(rs.getInt("userid"));
				user.setUser(rs.getString("username"));
				user.setPass(rs.getString("password"));
				user.setIsSell(Integer.parseInt(rs.getString("isSeller")));
				user.setIsAdmin(rs.getInt("isAdmin"));
				
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

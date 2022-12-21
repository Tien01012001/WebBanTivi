package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.model.AccountModel;

public class LoginDAO {
	Connection conn =null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	public AccountModel login(String user, String pass) {
		String sql = "select * from users where Username=? and Password=?;";
		try {
			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);		
			ps.setString(1,user);
			ps.setString(2,pass);
			rs = ps.executeQuery();

			while (rs.next())

			{

				return new AccountModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getInt(4));

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
}

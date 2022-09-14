package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.CategoryModel;

public class CategoryDaoimpl implements CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CategoryModel> getALLCategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			// mở kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<CategoryModel> getALLCategoryByID(String cid) {
		List<CategoryModel> list = new ArrayList<CategoryModel>();

		// Khai báo chuỗi truy vấn

		String sql = "select * from Category where CategoryID = ?";

		try {

			// mở kết nối

			conn = new DBConnect().getConnection();

			// Ném câu query qua sql

			ps = conn.prepareStatement(sql);

			// gán giá trị cho dấu ?

			ps.setString(1, cid);

			// Chạy câu query và nhận kq

			rs = ps.executeQuery();

			// Lấy ResultSet

			while (rs.next()) {

				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}

		} catch (Exception e) {

		}

		return list;

	}

	@Override
	public CategoryModel insert(CategoryModel category) {
		String sql = "INSERT INTO category(CategoryName,icon) VALUES (?,?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.executeUpdate();
			// Lấy ResultSet

			while (rs.next()) {

				return new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel edit(CategoryModel category) {
		String sql = "UPDATE category SET CategoryName = ?, icon=? WHERE CategoryID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getIcon());
			ps.setInt(3, category.getId());
			ps.executeUpdate();
			// Lấy ResultSet

			while (rs.next()) {

				return new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE CategoryID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CategoryModel get(int id) {
		// Khai báo chuỗi truy vấn

		String sql = "select * from Category where CategoryID = ?";

		try {

			// mở kết nối

			conn = new DBConnect().getConnection();

			// Ném câu query qua sql

			ps = conn.prepareStatement(sql);

			// gán giá trị cho dấu ?

			ps.setInt(1, id);

			// Chạy câu query và nhận kq

			rs = ps.executeQuery();

			// Lấy ResultSet

			while (rs.next()) {

				return new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3));

			}

		} catch (Exception e) {

		}

		return null;
	}

	

}

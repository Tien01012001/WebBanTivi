package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

public class ProductDaoImpl implements ProductDao {
	Connection conn =null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	
	//Hiển thị tất cả sản phẩm
	public List<ProductModel> getAllProduct(){
			//Khai báo List để lưu danh sách sp
			List<ProductModel> list = new ArrayList<ProductModel>();
			//Khai báo chuỗi truy vấn
			String sql = "select * from Product \r\n"
					+ "order by price ASC";
			try {
				//mở kết nối database
				conn = new DBConnect().getConnection();
				//Ném câu query qua sql
				ps = conn.prepareStatement(sql);
				//chạy query và nhận kết quả
				rs=ps.executeQuery();
				//lấy ResultSet đổ vào List
				while (rs.next()) {
					list.add(new ProductModel(rs.getInt(1), 
							rs.getString(2),
							rs.getString(3),
							rs.getDouble(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getInt(7),
							rs.getInt(8)));
				}
					
			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
			
		}
		//Hiển thị tất cả sản phẩm theo category
	public List<ProductModel> getAllProductByCID(String cid){
					//Khai báo List để lưu danh sách sp
					List<ProductModel> list = new ArrayList<ProductModel>();
					//Khai báo chuỗi truy vấn
					String sql = "select * from product\r\n"
							+ "where CategoryID = ?";
					try {
						//mở kết nối database
						conn = new DBConnect().getConnection();
						//Ném câu query qua sql
						ps = conn.prepareStatement(sql);
						//gán giá trị cho dấu hỏi
						ps.setString(1, cid);
						//chạy query và nhận kết quả
						
						rs=ps.executeQuery();
						//lấy ResultSet đổ vào List
						while (rs.next()) {
							list.add(new ProductModel(rs.getInt(1), 
									rs.getString(2),
									rs.getString(3),
									rs.getDouble(4),
									rs.getString(5),
									rs.getInt(6),
									rs.getInt(7),
									rs.getInt(8)));
						}
							
					} catch (Exception e) {
						// TODO: handle exception
					}
					return list;
					
				}
	//Hiển thị 04 sản phẩm mới nhất
	public List<ProductModel> getTop4Product(){
		//Khai báo List để lưu danh sách sp
		List<ProductModel> list = new ArrayList<>();
		//Khai báo chuỗi truy vấn
		String sql = "select TOP 4 * from Product \r\n"
				+ "order by ProductID DESC";
		try {
			//mở kết nối database
			conn = new DBConnect().getConnection();
			//Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			//lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	//Hiển thị 03 sản phẩm mới nhất
		public List<ProductModel> getTop3Product(){
			//Khai báo List để lưu danh sách sp
			List<ProductModel> list = new ArrayList<>();
			//Khai báo chuỗi truy vấn
			String sql = "select TOP 6 * from Product \r\n"
					+ "order by ProductID DESC";
			try {
				//mở kết nối database
				conn = new DBConnect().getConnection();
				//Ném câu query qua sql
				ps = conn.prepareStatement(sql);
				//chạy query và nhận kết quả
				rs=ps.executeQuery();
				//lấy ResultSet đổ vào List
				while (rs.next()) {
					list.add(new ProductModel(rs.getInt(1), 
							rs.getString(2),
							rs.getString(3),
							rs.getDouble(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getInt(7),
							rs.getInt(8)));
				}
					
			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
			
		}
	public List<ProductModel> getTop4BestSeller() {

		// Khai báo List

		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn

		String sql = "select top 4 * from Product order by Amount Desc";

		try {

			// mở kết nối

			conn = new DBConnect().getConnection();

			// Ném câu query qua sql

			ps = conn.prepareStatement(sql);

			// Chạy câu query và nhận kq

			rs = ps.executeQuery();

			// Lấy ResultSet đổ vào List

			while (rs.next()) {

				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));

			}

		} catch (Exception e) {

		}

		return list;

	}
	public ProductModel getTopProduct(){

		ProductModel pro = null;

		String sql = "select Top 1 * from Product order by Amount Desc";

		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);		

			rs = ps.executeQuery();

			while (rs.next())

			{

				pro = new ProductModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getDouble(4), rs.getString(5),

						rs.getInt(6), rs.getInt(7), rs.getInt(8));

			}

		} catch (Exception e) {

			System.out.println(e);

		}

		return pro;

	}
	public List<ProductModel> getTop1BestSellerAndNew() {

		// Khai báo List

		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn

		String sql = "select top 1 * from Product order by Amount Desc, ProductID Desc";

		try {

			// mở kết nối

			conn = new DBConnect().getConnection();

			// Ném câu query qua sql

			ps = conn.prepareStatement(sql);

			// Chạy câu query và nhận kq

			rs = ps.executeQuery();

			// Lấy ResultSet đổ vào List

			while (rs.next()) {

				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));

			}

		} catch (Exception e) {

		}

		return list;

	}
	
	
	//lấy 1 sản phẩn theo productID
	public ProductModel getProductByID(int id) {
		
		String sql ="select * from product\r\n"
				+ "where ProductID = ?";
		try {
			
			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);	
			
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next())

			{

				return new ProductModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getDouble(4), rs.getString(5),

						rs.getInt(6), rs.getInt(7), rs.getInt(8));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public List<ProductModel> getTop3() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "select top 3 * from product";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getDouble(4), rs.getString(5),

						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}
	public List<ProductModel> getNext3Product(int amount) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "SELECT *  FROM product ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			// set vị trí của product
			ps.setInt(1, amount);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getDouble(4), rs.getString(5),

						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	public List<ProductModel> searchByProductName(String txtSearch){
		List<ProductModel> list = new ArrayList<ProductModel>();
		String query = "select * from Product where ProductName like ?";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			// set vị trí của product
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), 

						rs.getString(2), rs.getString(3),

						rs.getDouble(4), rs.getString(5),

						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list;
		
	}
	
	@Override
	public int countALL() {
		String query ="SELECT count(*)\r\n"
				+ "  FROM Product";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public int countCid(int cid) {
		String query ="SELECT count(*) FROM Product where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public List<ProductModel> pagingProduct(int index) {
		//Khai báo List để lưu danh sách sp
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql ="SELECT * FROM Product order by ProductID OFFSET ? ROW fetch next 3 rows only";
		
		try {
			//mở kết nối database
			conn = new DBConnect().getConnection();
			//Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// truyền (index-1)*3 vào ? trên sql vì 1-offset từ 0, 2-offset từ 3, 3 - offset từ 6
			ps.setInt(1, (index-1)*3);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			//lấy ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//Hiển thị tất cả sản phẩm theo category
		public List<ProductModel> pagingProductByCID(String cid, int index){
			// Khai báo List để lưu danh sách sp
			List<ProductModel> list = new ArrayList<ProductModel>();
			// Khai báo chuỗi truy vấn
			String sql = "select * from product  where CategoryID = ? order by ProductID OFFSET ? ROW fetch next 3 rows only ";
			try {
				// mở kết nối database
				conn = new DBConnect().getConnection();
				// Ném câu query qua sql
				ps = conn.prepareStatement(sql);
				// gán giá trị cho dấu hỏi
				ps.setString(1, cid);
				ps.setInt(2, (index - 1) * 3);
				// chạy query và nhận kết quả

				rs = ps.executeQuery();
				// lấy ResultSet đổ vào List
				while (rs.next()) {
					list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;

		}

		public void delete(int id){
			String sql = "DELETE FROM Product WHERE ProductID = ?";

			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public void deleteByCID(int cid){
		String sql = "DELETE FROM Product WHERE CategoryID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(ProductModel product) {
		String sql = "UPDATE Product SET ProductName = ?, Description=?, Price=?, imageLink=?, CategoryID=?, Amount=?,Stoke=? WHERE ProductID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategoryID());
			ps.setInt(6,product.getAmount());
			ps.setInt(7,product.getStoke());
			ps.setInt(8,product.getId());
			ps.executeUpdate();



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(ProductModel product) {
		String sql = "INSERT INTO [Product](ProductName, Description,Price,imageLink,CategoryID,Amount,Stoke) VALUES (?,?,?,?,?,?,?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2,product.getDescription());
			ps.setDouble(3,product.getPrice());
			ps.setString(4,product.getImage());
			ps.setInt(5,product.getCategoryID());
			ps.setInt(6,product.getAmount());
			ps.setInt(7,product.getStoke());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAmountAndStoke(int amount,int stoke,int id){
		String sql = "UPDATE Product SET Amount=?,Stoke = ? WHERE ProductID = ?";

		try {
			Connection con = new DBConnect().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,amount);
			ps.setInt(2,stoke);
			ps.setInt(3, id);
			ps.executeUpdate();
			// Lấy ResultSet

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

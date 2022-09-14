package vn.iotstar.api.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/api-admin-cate"})
public class CategoryAPIGsonController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	private static final long serialVersionUID = -6295181305559978276L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//định dạng chuỗi dạng json
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				List<CategoryModel> list = new ArrayList<CategoryModel>();
				//gọi hàm lấy toàn bộ category trong Service
				list =  categoryService.getALLCategory();
				//Khởi tạo đối tượng Gson
				Gson gson = new Gson();
				//Gọi hàm toJson để chuyển Object thành String Json
				String cateJson = gson.toJson(list);
				//hiển thị kết quả
				PrintWriter out = resp.getWriter();
				out.write(cateJson);
				out.close();

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//String json = "{'name':'Trung','icon':'category/687f3967b7c2fe6a134a2c11894eea4b_tn.png'}";
		Gson gson = new Gson();	 //Khởi tạo đối tượng Gson
		//gọi hàm fromJson để chuyển từ String sang Object
		CategoryModel cateJson = gson.fromJson(req.getReader(), CategoryModel.class);
		//gọi hàm insert trong Service để thêm dữ liệu đối tượng vào database 
		cateJson=  categoryService.insert(cateJson);
		//Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã thêm thành công");
		out.close();

	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//String json = "{'name':'Trung','icon':'category/687f3967b7c2fe6a134a2c11894eea4b_tn.png'}";
		Gson gson = new Gson();	 //Khởi tạo đối tượng Gson
		//gọi hàm fromJson để chuyển từ String sang Object
		CategoryModel cateJson = gson.fromJson(req.getReader(), CategoryModel.class);
		//gọi hàm edit trong Service để cập nhật dữ liệu đối tượng vào database 
		cateJson=  categoryService.edit(cateJson);
		//Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã sửa thành công");
		out.close();

	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		//String json = "{'name':'Trung','icon':'category/687f3967b7c2fe6a134a2c11894eea4b_tn.png'}";
		Gson gson = new Gson();	 //Khởi tạo đối tượng Gson
		//gọi hàm fromJson để chuyển từ String sang Object
		CategoryModel cateJson = gson.fromJson(req.getReader(), CategoryModel.class);
		//gọi hàm insert trong Service để thêm dữ liệu đối tượng vào database 
		categoryService.delete(cateJson.getId());
		//Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã xóa thành công");
		out.close();

	}
}

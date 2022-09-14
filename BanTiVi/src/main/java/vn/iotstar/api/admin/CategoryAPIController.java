package vn.iotstar.api.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.util.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-category"})
public class CategoryAPIController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	private static final long serialVersionUID = -2543933433199922718L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<CategoryModel> cateModel =  HttpUtil.of(req.getReader()).listModel(CategoryModel.class);
		cateModel = categoryService.getALLCategory();
		mapper.writeValue(resp.getOutputStream(), cateModel);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		cateModel = categoryService.insert(cateModel);
		mapper.writeValue(resp.getOutputStream(), "{Đã thêm thành công}");

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		cateModel = categoryService.edit(cateModel);
		mapper.writeValue(resp.getOutputStream(), "{Đã cập nhật thành công}");

		
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel =  HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.delete(cateModel.getId());
		mapper.writeValue(resp.getOutputStream(), "{Đã xóa}");
		

	}

}

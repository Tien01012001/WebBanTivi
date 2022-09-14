package vn.iotstar.controller.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/member/cart" })
public class CartController extends HttpServlet implements Serializable {
	//bước 1: Kh�?i tạo Service
		CategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<CategoryModel> listC = cateService.getALLCategory();
		req.setAttribute("listcate", listC);
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/cart-list.jsp");
		dispatcher.forward(req, resp);
	}
}

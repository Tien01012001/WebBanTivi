package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDaoimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
	
	
	private static final long serialVersionUID = 4916110328503874794L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Thiết lập tiếng viết
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//bước 1: Kh�?i tạo DAO
		ProductDaoImpl productDao = new ProductDaoImpl();
		CategoryDaoimpl cateDao = new CategoryDaoimpl();
		//Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO
		List<ProductModel> list = productDao.getTop4Product();
		List<ProductModel> list1 = productDao.getTop1BestSellerAndNew();
		List<ProductModel> list2 = productDao.getTop4BestSeller();
		List<CategoryModel> listC = cateDao.getALLCategory();
		//bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("list4product", list);
		req.setAttribute("list1BestSellerAndNew", list1);
		req.setAttribute("list4BestSeller", list2);
		req.setAttribute("listcate", listC);
		//bước 4: Trả v�? trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDaoimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 2663367006258617424L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String txt1 = req.getParameter("txt").trim();
		
		String cid = req.getParameter("cid");
		//bước 1: Kh�?i tạo DAO
				ProductDaoImpl productDao = new ProductDaoImpl();
				CategoryDaoimpl cateDao = new CategoryDaoimpl();
				//Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO
				
				//List<ProductModel> list = productDao.getAllProduct();
				ProductModel list1 = productDao.getTopProduct();
				List<ProductModel> list2 = productDao.getTop4BestSeller();
				List<CategoryModel> listC = cateDao.getALLCategory();
				List<ProductModel> list = productDao.searchByProductName(txt1);
				//bước 3: Thiết lập dữ liệu lên JSP
				
					req.setAttribute("listAllproduct", list);
				    req.setAttribute("listcate", listC);
				    req.setAttribute("txtS", txt1);

				
				req.setAttribute("list1BestSellerAndNew", list1);
				req.setAttribute("list4BestSeller", list2);
				req.setAttribute("listcate1", listC);
				req.setAttribute("tagactive", cid);
				//bước 4: Trả v�? trang JSP nào
		
		req.getRequestDispatcher("/views/product.jsp").forward(req, resp);
		
	}
	
}

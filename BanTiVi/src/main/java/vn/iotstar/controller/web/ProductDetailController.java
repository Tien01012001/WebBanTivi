package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = -3678957517597630468L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Thiết lập tiếng viết
				resp.setContentType("text/htm");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				//lấy tham số từ JSP
				String pid = req.getParameter("pid");
				 String cid = req.getParameter("cid");
				
				//Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO
				
				ProductModel list1 = productService.getProductByID(pid);
				
				List<ProductModel> list2 = productService.getTop4BestSeller();
				List<CategoryModel> listC = cateService.getALLCategory();
				
				List<CategoryModel> cateByID = cateService.getALLCategoryByID(cid);
			
			    req.setAttribute("cdetail", cateByID.get(0));

			    
				req.setAttribute("pdetail", list1);
				
				req.setAttribute("list4BestSeller", list2);
				req.setAttribute("listcate", listC);
				
				//bước 4: Trả v�? trang JSP nào
				RequestDispatcher rq = req.getRequestDispatcher("/views/productdetail.jsp");
				rq.forward(req, resp);

		
		
		
	}
	
}

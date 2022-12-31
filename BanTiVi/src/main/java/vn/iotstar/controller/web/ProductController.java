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

@WebServlet(urlPatterns = { "/product", "/san-pham" })
public class ProductController extends HttpServlet {

	// bước 1: Kh�?i tạo DAO
	ProductService productSerive = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	private static final long serialVersionUID = -2212772586067881194L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng viết
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lấy tham số từ JSP
		String cid = req.getParameter("cid");
		String indexPage = req.getParameter("index");
		// khởi tạo trang đầu
		System.out.println(indexPage);
		if (indexPage == null || indexPage == "") {
			indexPage = "1";
		}
		
		int index = Integer.parseInt(indexPage);
		int cid1 = Integer.parseInt(cid);
		// Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO

		// List<ProductModel> list = productSerive.getAllProduct();
		ProductModel list1 = productSerive.getTopProduct();
		List<ProductModel> list2 = productSerive.getTop4BestSeller();
		List<CategoryModel> listC = categoryService.getALLCategory();
		// List<CategoryModel> cateByID = categoryService.getALLCategoryByID(cid);

		// bước 3: Thiết lập dữ liệu lên JSP
		if ("0".equals(cid)) { // All product
			int count = productSerive.countAll();
			// chia trang cho count
			int endPage = count / 3;
			if (count % 3 != 0) {
				endPage++;
			}
			List<ProductModel> list = productSerive.pagingProduct(index);
			req.setAttribute("endP", endPage);
			req.setAttribute("listAllproduct", list);
		} else {
			req.setAttribute("tag", index);
			if ("1".equals(index)) {
				index = 1;
				int count = productSerive.countCid(cid1);

				int endPage = count / 3;
				if (count % 3 != 0) {
					endPage++;
				}
				List<ProductModel> listPC = productSerive.pagingProductByCID(cid, index);
				req.setAttribute("listAllproduct", listPC);
				req.setAttribute("endP", endPage);
			} else {
				int count = productSerive.countCid(cid1);

				int endPage = count / 3;
				if (count % 3 != 0) {
					endPage++;
				}
				List<ProductModel> listPC = productSerive.pagingProductByCID(cid, index);
				req.setAttribute("listAllproduct", listPC);
				req.setAttribute("endP", endPage);
			}
		}
		// if("0".equals(cid)) {

		req.setAttribute("listcate", listC);

		// }else {
		// req.setAttribute("listcate", cateByID);
		// }

		req.setAttribute("list1BestSellerAndNew", list1);
		req.setAttribute("list4BestSeller", list2);
		req.setAttribute("listcate1", listC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		// bước 4: Trả v�? trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}

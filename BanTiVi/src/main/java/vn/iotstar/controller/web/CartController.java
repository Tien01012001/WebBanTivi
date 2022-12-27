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
import vn.iotstar.model.ShipModel;
import vn.iotstar.service.CartService;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ShipService;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ShipServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet implements Serializable {
	//bước 1: Kh�?i tạo Service
		ShipService shipService = new ShipServiceImpl();
		CategoryService cateService = new CategoryServiceImpl();


		//CartService cartService = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		List<CategoryModel> listC = cateService.getALLCategory();
		List<ShipModel> listS = shipService.getAllShip();
		Integer priceShip = shipService.getShipFirst();

		req.setAttribute("priceShip", priceShip);
		req.setAttribute("listcate", listC);
		req.setAttribute("listship", listS);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/cart-list.jsp");
		dispatcher.forward(req, resp);
	}
}

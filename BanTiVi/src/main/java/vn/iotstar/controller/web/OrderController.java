package vn.iotstar.controller.web;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.*;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.OrderService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.ShipService;
import vn.iotstar.service.impl.OrderItemServiceImpl;
import vn.iotstar.service.impl.OrderServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.ShipServiceImpl;

@WebServlet(urlPatterns = { "/order" })
public class OrderController extends HttpServlet {

	OrderService orderservice = new OrderServiceImpl();
	OrderItemService orderItemservice = new OrderItemServiceImpl();
	ProductService productService = new ProductServiceImpl();

	ShipService shipService = new ShipServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<ShipModel> listS = shipService.getAllShip();
		req.setAttribute("lists", listS);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/order.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String phuongthuc = req.getParameter("phuongthuc");
		String diachinhan = req.getParameter("diachinhan");
		String diachidetail = req.getParameter("dc1");
		String phone = req.getParameter("sdt");

		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AccountModel user = (AccountModel) httpSession.getAttribute("acc");


		Object obj = httpSession.getAttribute("cart");
		Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) obj;
		Set<Integer> set = map.keySet();

		Double total = 0.0;
		try {
			List<OrderModel> listorder = orderservice.getAll();
			int id = 0;

			if (listorder.size() == 0) {
				id = 1;
			} else {
				id = listorder.get(listorder.size() - 1).getID() + 1;
			}
			Date current = Date.valueOf(LocalDate.now());
			String diachifull = diachidetail + "," + diachinhan;

			for (Integer key : set) {
				CartItemModel cartItem = map.get(key);
				total = total + cartItem.getUnitPrice();
			}
			total = total + shipService.getShip(diachinhan);

			String status = "Đang chuẩn bị";
			OrderModel order = new OrderModel(id,user, total,phuongthuc,phone, diachifull, current,status);

			orderservice.insert(order);

			for (Integer key : set) {
				CartItemModel cartItem = map.get(key);
				total = total + cartItem.getUnitPrice();
				OrderItemModel orderItem = new OrderItemModel(cartItem.getQuantity(), cartItem.getUnitPrice(),
						cartItem.getProduct(), id);
				orderItemservice.insert(orderItem);

				productService.updateAmountAndStoke((cartItem.getProduct().getAmount()+cartItem.getQuantity()),(cartItem.getProduct().getStoke()-cartItem.getQuantity()),cartItem.getProduct().getId());
			}


			map.clear();
			httpSession.setAttribute("cart", map);


			resp.sendRedirect(req.getContextPath() + "/cart");

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}


}

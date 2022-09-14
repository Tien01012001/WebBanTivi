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

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CartItemModel;
import vn.iotstar.model.OrderItemModel;
import vn.iotstar.model.OrderModel;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.OrderService;
import vn.iotstar.service.impl.OrderItemServiceImpl;
import vn.iotstar.service.impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/order" })
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

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

		HttpSession httpSession = req.getSession();
		Object cart = httpSession.getAttribute("cart");
		AccountModel user = (AccountModel) httpSession.getAttribute("acc");

		OrderService orderservice = new OrderServiceImpl();
		List<OrderModel> listorder = orderservice.getAll();

		int id = 0;

		if (listorder.size() == 0) {
			id = 1;
		} else {
			id = listorder.get(listorder.size() - 1).getID() + 1;
		}

		Date current = Date.valueOf(LocalDate.now());
		OrderModel order = new OrderModel(id, user, phuongthuc, diachinhan, current);

		orderservice.insert(order);

		OrderItemService orderItemservice = new OrderItemServiceImpl();

		Map<Integer, CartItemModel> map = extracted(cart);

		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			List<OrderItemModel> listorderitem = orderItemservice.getAll();

			int idorderitem = 0;

			if (listorderitem.size() == 0) {
				idorderitem = 1;

			} else {
				idorderitem = listorderitem.get(listorderitem.size() - 1).getId() + 1;
			}
			CartItemModel cartItem = map.get(key);
			OrderItemModel orderItem = new OrderItemModel(idorderitem, cartItem.getQuantity(), cartItem.getUnitPrice(),
					cartItem.getProduct(), order);
			orderItemservice.insert(orderItem);
			map.remove(key);
		}

		httpSession.setAttribute("cart", map);

		resp.sendRedirect(req.getContextPath() + "/member/cart");
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}

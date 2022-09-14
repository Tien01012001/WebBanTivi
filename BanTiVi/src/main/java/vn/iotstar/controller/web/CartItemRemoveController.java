package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.CartItemModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/member/cart-remove" }) // ?pId=?123
public class CartItemRemoveController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
		
		String pId = req.getParameter("pId");
		
		if (obj != null) {
			@SuppressWarnings("unchecked")
			Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) obj; // ep ve kieu cua no
			// Xoa san pham trong map
			map.remove(Integer.parseInt(pId));

			// Cap nhat lai Session
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/member/cart");
	}
}

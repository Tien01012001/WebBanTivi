package vn.iotstar.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.LoginDAO;
import vn.iotstar.model.AccountModel;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4304463338799699183L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		LoginDAO loginDao = new LoginDAO();
		AccountModel account = loginDao.login(username, password);
		
		if (account == null) {
			req.setAttribute("mess", "Sai tài khoản và mật khẩu");
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}else if(account.getIsAdmin() == 1){
			HttpSession session = req.getSession();
			session.setAttribute("acc",account);
			//session.setMaxInactiveInterval(1000);
			resp.sendRedirect("admin/home");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("acc",account);
			//session.setMaxInactiveInterval(1000);
			resp.sendRedirect("home");
		}

	}

}

package vn.iotstar.controller.admin;

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/account/edit" })
public class AccountEditController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        AccountModel account = userService.get(Integer.parseInt(id));
        req.setAttribute("account", account);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-account.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        AccountModel account = new AccountModel();


        Integer uid = Integer.parseInt(req.getParameter("uid"));
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));

        account.setUid(uid);
        account.setUser(username);
        account.setPass(password);
        account.setIsAdmin(isAdmin);
        userService.edit(account);
        resp.sendRedirect(req.getContextPath() + "/admin/account/list");



    }
}

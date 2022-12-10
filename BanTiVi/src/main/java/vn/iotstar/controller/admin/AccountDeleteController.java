package vn.iotstar.controller.admin;

import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/account/delete" })
public class AccountDeleteController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("id");
        userService.delete(Integer.parseInt(uid));
        System.out.println(uid);
        resp.sendRedirect(req.getContextPath() + "/admin/account/list");

    }
}

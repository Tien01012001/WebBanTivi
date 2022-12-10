package vn.iotstar.controller.admin;

import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/account/list" })


public class AccountListController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AccountModel> accountList = userService.getAllAccount();
        req.setAttribute("acc", accountList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-account.jsp");
        dispatcher.forward(req, resp);
    }
}

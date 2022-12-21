package vn.iotstar.controller.web;

import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        Integer isAdmin = 0;

        AccountModel accountModel = new AccountModel();


        if(userService.ExistAcount(username) != null){
            req.setAttribute("mess", "tai khoan da ton tai");
            req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
        }
        else{
            accountModel.setUser(username);
            accountModel.setPass(password);
            accountModel.setIsAdmin(isAdmin);
            userService.insert(accountModel);
            System.out.println(accountModel);
            resp.sendRedirect(req.getContextPath() + "/login");
        }





    }
}

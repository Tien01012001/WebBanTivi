package vn.iotstar.controller.web;

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.OrderModel;
import vn.iotstar.service.OrderService;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.OrderServiceImpl;
import vn.iotstar.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/list-order" })
public class OrderListUser extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        AccountModel user = (AccountModel) httpSession.getAttribute("acc");

        List<OrderModel> orderList = orderService.getAllByIdUser(user.getUid());
        req.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-order-user.jsp");
        dispatcher.forward(req, resp);
    }
}

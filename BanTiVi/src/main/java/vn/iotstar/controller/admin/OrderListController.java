package vn.iotstar.controller.admin;

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
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/order/list" })
public class OrderListController extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        List<OrderModel> orderList = orderService.getAll();
        

        req.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-order.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

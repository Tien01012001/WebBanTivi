package vn.iotstar.controller.admin;

import vn.iotstar.service.OrderService;
import vn.iotstar.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/order/shipping" })
public class ShippingController extends HttpServlet {
    OrderService orderService  = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        orderService.ShipSuccess(Integer.parseInt(id),"Đang giao");
        resp.sendRedirect(req.getContextPath() + "/admin/order/list");
    }
}

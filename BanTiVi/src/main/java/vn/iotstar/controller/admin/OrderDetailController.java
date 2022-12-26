package vn.iotstar.controller.admin;

import vn.iotstar.model.OrderItemModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.impl.OrderItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/order/view" })
public class OrderDetailController extends HttpServlet {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<OrderItemModel> orderItemList = orderItemService.getAllByID(Integer.parseInt(id));
        System.out.println(orderItemService.getAllByID(Integer.parseInt(id)));

        req.setAttribute("orderItemList", orderItemList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-order-detail.jsp");
        dispatcher.forward(req, resp);
    }
}

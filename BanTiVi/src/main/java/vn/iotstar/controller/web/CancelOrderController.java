package vn.iotstar.controller.web;

import vn.iotstar.model.OrderItemModel;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.OrderService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.OrderItemServiceImpl;
import vn.iotstar.service.impl.OrderServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/delete-order" })
public class CancelOrderController extends HttpServlet {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<OrderItemModel> listOrderItem = orderItemService.getAllByID(Integer.parseInt(id));
        for(OrderItemModel list:listOrderItem) {
            productService.updateAmountAndStoke((list.getProduct().getAmount()-list.getQuantity()),(list.getProduct().getStoke()+list.getQuantity()),list.getProduct().getId());
            System.out.println(list.getQuantity() + "and" + list.getProduct().getId());
        }
        //productService.
        orderItemService.delete(Integer.parseInt(id));
        orderService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/list-order");
    }
}

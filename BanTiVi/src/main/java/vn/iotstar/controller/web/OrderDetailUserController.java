package vn.iotstar.controller.web;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.OrderItemModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.OrderItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/orderdetail" })
public class OrderDetailUserController extends HttpServlet {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<OrderItemModel> orderItemList = orderItemService.getAllByID(Integer.parseInt(id));
        List<CategoryModel> listC = cateService.getALLCategory();

        req.setAttribute("orderItemList", orderItemList);
        req.setAttribute("listcate", listC);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-order-detail-user.jsp");
        dispatcher.forward(req, resp);
    }
}

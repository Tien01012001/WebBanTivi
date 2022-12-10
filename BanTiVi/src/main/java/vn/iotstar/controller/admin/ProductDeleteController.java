package vn.iotstar.controller.admin;

import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/product/delete" })
public class ProductDeleteController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        productService.delete(Integer.parseInt(id));
        System.out.println(id);
        resp.sendRedirect(req.getContextPath() + "/admin/product/list");

    }
}

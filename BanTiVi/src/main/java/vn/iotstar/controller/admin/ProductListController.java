package vn.iotstar.controller.admin;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductModel> proList = productService.getAllProduct();
        req.setAttribute("proList", proList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-product.jsp");
        dispatcher.forward(req, resp);
    }
}

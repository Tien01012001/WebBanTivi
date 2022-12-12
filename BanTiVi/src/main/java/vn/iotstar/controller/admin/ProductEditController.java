package vn.iotstar.controller.admin;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.AccountModel;
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

@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProductModel product = productService.getProductByID(Integer.parseInt(id));
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-product.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ProductModel productModel = new ProductModel();

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        Integer categoryID = Integer.parseInt(req.getParameter("categoryID"));
        Integer sellerID = Integer.parseInt(req.getParameter("sellerID"));
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Integer stoke = Integer.parseInt(req.getParameter("stoke"));


        productModel.setId(id);
        productModel.setName(name);
        productModel.setDescription(description);
        productModel.setPrice(price);
        productModel.setImage(image);
        productModel.setCategoryID(categoryID);
        productModel.setSellerID(sellerID);
        productModel.setAmount(amount);
        productModel.setStoke(stoke);

        productService.edit(productModel);

        resp.sendRedirect(req.getContextPath() + "/admin/product/list");






    }
}

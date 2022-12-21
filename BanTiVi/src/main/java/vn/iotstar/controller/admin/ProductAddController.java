package vn.iotstar.controller.admin;

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/product/add" })
public class ProductAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryModel> cateList = categoryService.getALLCategory();
        req.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-product.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ProductModel productModel = new ProductModel();


        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        Integer categoryID = Integer.parseInt(req.getParameter("categoryID"));
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Integer stoke = Integer.parseInt(req.getParameter("stoke"));



        productModel.setName(name);
        productModel.setDescription(description);
        productModel.setPrice(price);
        productModel.setImage(image);
        productModel.setCategoryID(categoryID);
        productModel.setAmount(amount);
        productModel.setStoke(stoke);

        productService.insert(productModel);

        resp.sendRedirect(req.getContextPath() + "/admin/product/list");
    }
}

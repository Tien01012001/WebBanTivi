package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {

	private static final long serialVersionUID = 7733410118831220208L;
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("cname")) {
					category.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("imagelink")) {
					category.setIcon(item.getString());
				} else if (item.getFieldName().equals("icons")) {
					String originalFileName = item.getName();
					System.out.println(originalFileName);
					int index = originalFileName.lastIndexOf(".");
					System.out.println(index);
					String ext = originalFileName.substring(index + 1);
					System.out.println(ext);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					category.setIcon("category/" + fileName);
				}
			}

			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

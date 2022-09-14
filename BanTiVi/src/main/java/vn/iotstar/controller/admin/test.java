package vn.iotstar.controller.admin;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

public class test {
	
	public static void main(String[] args) {
		CategoryService cateService = new CategoryServiceImpl();
		try {
			
			CategoryModel cate = cateService.get(1);
			System.out.println(cate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

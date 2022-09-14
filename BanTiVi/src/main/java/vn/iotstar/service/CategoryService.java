package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryService {
	List<CategoryModel> getALLCategory();
	List<CategoryModel> getALLCategoryByID(String cid);
	CategoryModel insert(CategoryModel category);
	CategoryModel edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	
	

}

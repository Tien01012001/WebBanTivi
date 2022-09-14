package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryDao {
	List<CategoryModel> getALLCategory();
	List<CategoryModel> getALLCategoryByID(String cid);
	CategoryModel insert(CategoryModel category);
	CategoryModel edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	

}

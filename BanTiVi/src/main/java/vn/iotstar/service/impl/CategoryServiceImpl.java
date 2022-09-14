package vn.iotstar.service.impl;

import java.io.File;
import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDaoimpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoimpl();
	@Override
	public List<CategoryModel> getALLCategory() {
		
		return categoryDao.getALLCategory();
	}

	@Override
	public List<CategoryModel> getALLCategoryByID(String cid) {
		// TODO Auto-generated method stub
		return categoryDao.getALLCategoryByID(cid);
	}

	@Override
	public CategoryModel insert(CategoryModel category) {
		return categoryDao.insert(category);
		
	}

	@Override
	public CategoryModel edit(CategoryModel newCategory) {
		CategoryModel oldCategory = categoryDao.get(newCategory.getId());
		oldCategory.setName(newCategory.getName());
		if (newCategory.getIcon() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getIcon();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category/" + fileName);
			
			if (file.exists()) {
				
				file.delete();
			}

			oldCategory.setIcon(newCategory.getIcon());
		}

		return categoryDao.edit(oldCategory);

	}


	@Override
	public void delete(int id) {
		categoryDao.delete(id);
		
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);
	}

	
	

}

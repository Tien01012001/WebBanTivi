package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public int countAll() {
		
		return productDao.countALL();
	}
	@Override
	public int countCid(int cid) {
		
		return productDao.countCid(cid);
	}

	public void delete(int id) {
		productDao.delete(id);
	}
	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public ProductModel getTopProduct() {
		// TODO Auto-generated method stub
		return productDao.getTopProduct();
	}

	@Override
	public List<ProductModel> getTop4BestSeller() {
		// TODO Auto-generated method stub
		return productDao.getTop4BestSeller();
	}

	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByCID(cid);
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}
	@Override
	public List<ProductModel> pagingProductByCID(String cid, int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProductByCID(cid, index);
	}
	@Override
	public List<ProductModel> getTop3Product() {
		// TODO Auto-generated method stub
		return productDao.getTop3Product();
	}
	@Override
	public List<ProductModel> getNext3Product(int amount) {
		// TODO Auto-generated method stub
		return productDao.getNext3Product(amount);
	}
	@Override
	public ProductModel getProductByID(String pid) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(pid);
	}
	@Override
	public List<ProductModel> getTop4Product() {
		// TODO Auto-generated method stub
		return productDao.getTop4Product();
	}
	@Override
	public List<ProductModel> getTop1BestSellerAndNew() {
		// TODO Auto-generated method stub
		return productDao.getTop1BestSellerAndNew();
	}

}

package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.ProductModel;

public interface ProductService {
	int countAll();
	int countCid(int cid);
	void delete(int id);
	List<ProductModel> getAllProduct();
	ProductModel getTopProduct();
	ProductModel getProductByID(String pid);
	List<ProductModel> getTop4BestSeller();
	List<ProductModel> getTop4Product();
	List<ProductModel> getTop1BestSellerAndNew();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> pagingProductByCID(String cid, int index);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);
}

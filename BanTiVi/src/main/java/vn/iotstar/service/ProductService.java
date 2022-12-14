package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.ProductModel;

public interface ProductService {
	int countAll();
	int countCid(int cid);

	void insert(ProductModel product);
	void edit(ProductModel product);
	void delete(int id);
	void deleteByCID(int cid);
	List<ProductModel> getAllProduct();
	ProductModel getTopProduct();
	ProductModel getProductByID(int pid);
	List<ProductModel> getTop4BestSeller();
	List<ProductModel> getTop4Product();
	List<ProductModel> getTop1BestSellerAndNew();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> pagingProductByCID(String cid, int index);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);

	void updateAmountAndStoke(int amount,int stoke,int id);
}

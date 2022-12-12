package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.ProductModel;

public interface ProductDao {
	void delete(int id);

	void insert(ProductModel product);
	void edit(ProductModel product);
	int countALL();
	int countCid(int cid);
	List<ProductModel> getAllProduct();
	ProductModel getTopProduct();
	ProductModel getProductByID(int pid);
	List<ProductModel> getTop4BestSeller();
	List<ProductModel> getTop4Product();
	List<ProductModel> getTop1BestSellerAndNew();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByCID(String cid, int index);
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);
}

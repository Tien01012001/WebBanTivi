package vn.iotstar.model;

public class OrderItemModel {
	private int id;
	private int Quantity;
	private double uintprice;
	private ProductModel product;
	private int order_id;

	public OrderItemModel() {
		super();
	}


	public OrderItemModel(int quantity, double uintprice, ProductModel product, int order_id) {
		super();
		this.Quantity = quantity;
		this.uintprice = uintprice;
		this.product = product;
		this.order_id = order_id;
	}



	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.id=int1;
	}

	public void setProduct(ProductModel product2) {
		// TODO Auto-generated method stub
		this.product=product2;
	}

	public void setOrder(int order2) {
		// TODO Auto-generated method stub
		this.order_id=order2;
	}

	public void setQuantity(int int1) {
		// TODO Auto-generated method stub
		this.Quantity=int1;
	}

	public void setUintprice(long long1) {
		// TODO Auto-generated method stub
		this.uintprice=long1;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return Quantity;
	}

	public double getUintprice() {
		// TODO Auto-generated method stub
		return uintprice;
	}


	public int getOrder_id() {
		return order_id;
	}

	public ProductModel getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}

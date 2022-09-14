package vn.iotstar.model;

public class OrderItemModel {
	private int id;
	private int Quantity;
	private double uintprice;
	private ProductModel product;
	private OrderModel order;

	public OrderItemModel() {
		super();
	}
	
	public OrderItemModel(int quantity, double uintprice, ProductModel product, OrderModel order) {
		super();
		this.Quantity = quantity;
		this.uintprice = uintprice;
		this.product = product;
		this.order = order;
	}


	public OrderItemModel(int id,int quantity, double uintprice, ProductModel product, OrderModel order) {
		super();
		this.id = id;
		this.Quantity = quantity;
		this.uintprice = uintprice;
		this.product = product;
		this.order = order;
	}

	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.id=int1;
	}

	public void setProduct(ProductModel product2) {
		// TODO Auto-generated method stub
		this.product=product2;
	}

	public void setOrder(OrderModel order2) {
		// TODO Auto-generated method stub
		this.order=order2;
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

	public OrderModel getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	public ProductModel getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

}

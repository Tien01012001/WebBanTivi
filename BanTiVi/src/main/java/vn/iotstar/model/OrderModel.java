package vn.iotstar.model;

import java.util.Date;

public class OrderModel {
	private int ID;
	private AccountModel nguoiMua;

	private double total;
	private String phuongThucThanhToan;
	private String sodienthoai;
	private String diaChiNhan;
	private Date ngayMua;
	public OrderModel() {
		super();
	}


	@Override
	public String toString() {
		return "OrderModel{" +
				"ID=" + ID +
				", nguoiMua=" + nguoiMua +
				", total=" + total +
				", phuongThucThanhToan='" + phuongThucThanhToan + '\'' +
				", diaChiNhan='" + diaChiNhan + '\'' +
				", ngayMua=" + ngayMua +
				'}';
	}

	public OrderModel(int ID, AccountModel nguoiMua, double total, String phuongThucThanhToan, String sodienthoai, String diaChiNhan, Date ngayMua) {
		this.ID = ID;
		this.nguoiMua = nguoiMua;
		this.total = total;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.sodienthoai = sodienthoai;
		this.diaChiNhan = diaChiNhan;
		this.ngayMua = ngayMua;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	public AccountModel getNguoiMua() {
		return nguoiMua;
	}
	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public String getDiaChiNhan() {
		return diaChiNhan;
	}
	public Date  getNgayMua() {
		return ngayMua;
	}
	public void setID(int int1) {
		// TODO Auto-generated method stub
		this.ID=int1;

	}
	public void setNguoiMua(AccountModel user) {
		// TODO Auto-generated method stub
		this.nguoiMua=user;

	}
	public void setPhuongThucThanhToan(String string) {
		// TODO Auto-generated method stub
		this.phuongThucThanhToan=string;
	}
	public void setDiaChiNhan(String string) {
		// TODO Auto-generated method stub
		this.diaChiNhan=string;
	}
	public void setNgayMua(Date date) {
		// TODO Auto-generated method stub
		this.ngayMua=date;
	}

}
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
	private String trangThai;
	public OrderModel() {
		super();
	}


	public OrderModel(int ID, AccountModel nguoiMua, double total, String phuongThucThanhToan, String sodienthoai, String diaChiNhan, Date ngayMua, String trangThai) {
		this.ID = ID;
		this.nguoiMua = nguoiMua;
		this.total = total;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.sodienthoai = sodienthoai;
		this.diaChiNhan = diaChiNhan;
		this.ngayMua = ngayMua;
		this.trangThai = trangThai;
	}

	public int getID() {
		return ID;
	}

	public AccountModel getNguoiMua() {
		return nguoiMua;
	}

	public double getTotal() {
		return total;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public String getDiaChiNhan() {
		return diaChiNhan;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setNguoiMua(AccountModel nguoiMua) {
		this.nguoiMua = nguoiMua;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
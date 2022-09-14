package vn.iotstar.model;

import java.util.Date;

public class OrderModel {
	private int ID;
	private AccountModel nguoiMua;
	private String phuongThucThanhToan;
	private String diaChiNhan;
	private Date ngayMua;
	public OrderModel() {
		super();
	}
	
	public OrderModel(AccountModel nguoiMua, Date ngayMua) {
		super();
		this.nguoiMua = nguoiMua;
		this.ngayMua = ngayMua;
	}

	public OrderModel(int iD, AccountModel nguoimua, String phuongThucThanhToan, String diaChiNhan, Date ngayMua) {
		super();
		ID = iD;
		this.nguoiMua = nguoiMua;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.diaChiNhan = diaChiNhan;
		this.ngayMua = ngayMua;
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
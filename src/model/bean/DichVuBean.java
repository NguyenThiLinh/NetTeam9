package model.bean;

public class DichVuBean {
	private String iDDV;
	private String tenDV;
	private float gia;
	private String iDLoaiDV;
	private String donViTinh;
	
	public String getiDDV() {
		return iDDV;
	}
	public void setiDDV(String iDDV) {
		this.iDDV = iDDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	public String getiDLoaiDV() {
		return iDLoaiDV;
	}
	public void setiDLoaiDV(String iDLoaiDV) {
		this.iDLoaiDV = iDLoaiDV;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	
	public DichVuBean(String iDDV, String tenDV, float gia, String iDLoaiDV, String donViTinh) {
		super();
		this.iDDV = iDDV;
		this.tenDV = tenDV;
		this.gia = gia;
		this.iDLoaiDV = iDLoaiDV;
		this.donViTinh = donViTinh;
	}
	
	
}

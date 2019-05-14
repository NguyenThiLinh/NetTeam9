package model.bean;

public class PhongBean {
	private String iDPhong;
	private String diaChi;
	private int soLuong;
	public String getiDPhong() {
		return iDPhong;
	}
	public void setiDPhong(String iDPhong) {
		this.iDPhong = iDPhong;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public PhongBean() {
		super();
	}
	public PhongBean(String iDPhong, String diaChi, int soLuong) {
		super();
		this.iDPhong = iDPhong;
		this.diaChi = diaChi;
		this.soLuong = soLuong;
	}
	
}

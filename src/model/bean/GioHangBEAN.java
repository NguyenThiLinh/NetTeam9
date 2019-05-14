package model.bean;

public class GioHangBEAN {
	private String iDDichVu;
	private String tenDV;
	private float gia;
	private String donViTinh;
	private int soLuongDat;
	private float thanhTien;
	/**
	 * @return the iDDichVu
	 */
	public String getiDDichVu() {
		return iDDichVu;
	}
	/**
	 * @param iDDichVu the iDDichVu to set
	 */
	public void setiDDichVu(String iDDichVu) {
		this.iDDichVu = iDDichVu;
	}
	/**
	 * @return the tenDV
	 */
	public String getTenDV() {
		return tenDV;
	}
	/**
	 * @param tenDV the tenDV to set
	 */
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	/**
	 * @return the donViTinh
	 */
	public String getDonViTinh() {
		return donViTinh;
	}
	/**
	 * @param donViTinh the donViTinh to set
	 */
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	/**
	 * @return the soLuongDat
	 */
	public int getSoLuongDat() {
		return soLuongDat;
	}
	/**
	 * @param soLuongDat the soLuongDat to set
	 */
	public void setSoLuongDat(int soLuongDat) {
		this.soLuongDat = soLuongDat;
	}
	
	/**
	 * @return the thanhTien
	 */
	public float getThanhTien() {
		return thanhTien;
	}
	/**
	 * @param thanhTien the thanhTien to set
	 */
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	/**
	 * @return the gia
	 */
	public float getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	/**
	 * @param iDDichVu
	 * @param tenDV
	 * @param gia
	 * @param donViTinh
	 * @param soLuongDat
	 */
	public GioHangBEAN(String iDDichVu, String tenDV, float gia, String donViTinh, int soLuongDat) {
		super();
		this.iDDichVu = iDDichVu;
		this.tenDV = tenDV;
		this.gia = gia;
		this.donViTinh = donViTinh;
		this.soLuongDat = soLuongDat;
		this.thanhTien = gia * soLuongDat;
	}
	/**
	 * 
	 */
	public GioHangBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

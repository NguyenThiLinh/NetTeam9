package model.bean;

public class ChiTietDonHangBEAN {
	private long idDonHang;
	private String idDV;
	private String tenDV;
	private float gia;
	private String donViTinh;
	private int soLuong;
	private float thanhTien;
	/**
	 * @return the idDonHang
	 */
	public long getIdDonHang() {
		return idDonHang;
	}
	/**
	 * @param idDonHang the idDonHang to set
	 */
	public void setIdDonHang(long idDonHang) {
		this.idDonHang = idDonHang;
	}
	/**
	 * @return the idDV
	 */
	public String getIdDV() {
		return idDV;
	}
	/**
	 * @param idDV the idDV to set
	 */
	public void setIdDV(String idDV) {
		this.idDV = idDV;
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
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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
	 * @param idDonHang
	 * @param idDV
	 * @param tenDV
	 * @param gia
	 * @param donViTinh
	 * @param soLuong
	 * @param thanhTien
	 */
	public ChiTietDonHangBEAN(long idDonHang, String idDV, String tenDV, float gia, String donViTinh, int soLuong,
			float thanhTien) {
		super();
		this.idDonHang = idDonHang;
		this.idDV = idDV;
		this.tenDV = tenDV;
		this.gia = gia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	/**
	 * 
	 */
	public ChiTietDonHangBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package model.bean;

import java.util.ArrayList;

public class ThanhToanBEAN {
	private long idDonHang;
	private String hoTenKh;
	private float tongTien;
	private int trangThaiXuLy;
	private String iDKhach;
	private ArrayList<ChiTietDonHangBEAN> list;
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
	 * @return the hoTenKh
	 */
	public String getHoTenKh() {
		return hoTenKh;
	}
	/**
	 * @param hoTenKh the hoTenKh to set
	 */
	public void setHoTenKh(String hoTenKh) {
		this.hoTenKh = hoTenKh;
	}
	/**
	 * @return the tongTien
	 */
	public float getTongTien() {
		return tongTien;
	}
	/**
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	/**
	 * @return the list
	 */
	public ArrayList<ChiTietDonHangBEAN> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	
	public void setList(ArrayList<ChiTietDonHangBEAN> list) {
		this.list = list;
	}
	/**
	 * @return the trangThaiXuLy
	 */
	public int getTrangThaiXuLy() {
		return trangThaiXuLy;
	}
	/**
	 * @param trangThaiXuLy the trangThaiXuLy to set
	 */
	public void setTrangThaiXuLy(int trangThaiXuLy) {
		this.trangThaiXuLy = trangThaiXuLy;
	}
	
	
	/**
	 * @return the iDKhach
	 */
	public String getiDKhach() {
		return iDKhach;
	}
	/**
	 * @param iDKhach the iDKhach to set
	 */
	public void setiDKhach(String iDKhach) {
		this.iDKhach = iDKhach;
	}
	/**
	 * 
	 */
	public ThanhToanBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idDonHang
	 * @param hoTenKh
	 * @param tongTien
	 * @param trangThaiXuLy
	 * @param iDKhach
	 * @param list
	 */
	public ThanhToanBEAN(long idDonHang, String hoTenKh, float tongTien, int trangThaiXuLy, String iDKhach,
			ArrayList<ChiTietDonHangBEAN> list) {
		super();
		this.idDonHang = idDonHang;
		this.hoTenKh = hoTenKh;
		this.tongTien = tongTien;
		this.trangThaiXuLy = trangThaiXuLy;
		this.iDKhach = iDKhach;
		this.list = list;
	}
	
}

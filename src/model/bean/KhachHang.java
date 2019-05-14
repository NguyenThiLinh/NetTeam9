/*
* @Author HCD-Fresher183
* @Date Feb 25, 2019
*/

package model.bean;

public class KhachHang {
	private String idKhach;
	private String hoTen;
	private String userName;
	private String password;
	private float taiKhoan;
	public KhachHang() {
		super();
	}
	public String getIdKhach() {
		return idKhach;
	}
	public void setIdKhach(String idKhach) {
		this.idKhach = idKhach;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(float taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	
}

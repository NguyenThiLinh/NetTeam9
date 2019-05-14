package model.bean;

public class NhanVienBEAN {
	private String iDNV;
	private String hoTen;
	private String iDPhong;
	private float luong;
	private String sdt;
	private String diaChi;
	private String taiKhoan;
	private String matKhau;
	
	public String getiDNV() {
		return iDNV;
	}
	public void setiDNV(String iDNV) {
		this.iDNV = iDNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getiDPhong() {
		return iDPhong;
	}
	public void setiDPhong(String iDPhong) {
		this.iDPhong = iDPhong;
	}
	public float getLuong() {
		return luong;
	}
	public void setLuong(float luong) {
		this.luong = luong;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public NhanVienBEAN() {
		super();
	}
	
	public NhanVienBEAN(String iDNV, String hoTen, String iDPhong, float luong, String sdt, String diaChi,
			String taiKhoan, String matKhau) {
		super();
		this.iDNV = iDNV;
		this.hoTen = hoTen;
		this.iDPhong = iDPhong;
		this.luong = luong;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	
	
}

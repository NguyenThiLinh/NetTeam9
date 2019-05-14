package model.bean;

public class LoaiDichVuBean {
	private String idLoaiDV;
	private String tenLoaiDV;
	/**
	 * @return the idLoaiDV
	 */
	public String getIdLoaiDV() {
		return idLoaiDV;
	}
	/**
	 * @param idLoaiDV the idLoaiDV to set
	 */
	public void setIdLoaiDV(String idLoaiDV) {
		this.idLoaiDV = idLoaiDV;
	}
	/**
	 * @return the tenLoaiDV
	 */
	public String getTenLoaiDV() {
		return tenLoaiDV;
	}
	/**
	 * @param tenLoaiDV the tenLoaiDV to set
	 */
	public void setTenLoaiDV(String tenLoaiDV) {
		this.tenLoaiDV = tenLoaiDV;
	}
	/**
	 * @param idLoaiDV
	 * @param tenLoaiDV
	 * @param idDV
	 */
	public LoaiDichVuBean(String idLoaiDV, String tenLoaiDV) {
		super();
		this.idLoaiDV = idLoaiDV;
		this.tenLoaiDV = tenLoaiDV;
	}
	/**
	 * 
	 */
	public LoaiDichVuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

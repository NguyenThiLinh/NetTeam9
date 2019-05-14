/*
* @Author HCD-Fresher183
* @Date Feb 27, 2019
*/

package model.bean;

import java.util.Date;

public class SuDungMay {
	private String iDMay;
	private String iDKhach;
	private Date gioBatDau;
	private Date gioKetThuc;
	private float soGio;
	public SuDungMay() {
		super();
	}
	public String getiDMay() {
		return iDMay;
	}
	public void setiDMay(String iDMay) {
		this.iDMay = iDMay;
	}
	public String getiDKhach() {
		return iDKhach;
	}
	public void setiDKhach(String iDKhach) {
		this.iDKhach = iDKhach;
	}
	public Date getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public Date getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public float getSoGio() {
		return soGio;
	}
	public void setSoGio(float soGio) {
		this.soGio = soGio;
	}
	
	
}

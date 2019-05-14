package model.bo;

import java.util.ArrayList;

import model.bean.GioHangBEAN;

public class GioHangBO {
	public ArrayList<GioHangBEAN> dshang = new ArrayList<GioHangBEAN>();
	public ArrayList<GioHangBEAN> getgh(){
		return dshang;
	}
	public int kiemtra(String idDichVu) {
		int n = dshang.size();
		for(int i =0; i< n; i++) {
			if(dshang.get(i).getiDDichVu().equals(idDichVu)) {
				return i;
			}
		}
		return -1;
	}
	public void them(String iDDichVu, String tenDV, float gia, String donViTinh, int soLuongDat) {
		int index = kiemtra(iDDichVu);
		if(index != -1) {
			int sl = dshang.get(index).getSoLuongDat()+1;
			float tt = dshang.get(index).getGia() * sl;
			System.out.println(sl);
			System.out.println(tt);
			dshang.get(index).setSoLuongDat(sl);
			dshang.get(index).setThanhTien(tt);
		}
		else {
			dshang.add(new GioHangBEAN(iDDichVu, tenDV, gia, donViTinh, soLuongDat));
		}
	}
	public void xoahet() {
		dshang.clear();
	}
	public void giam(String maDV) {
		int n = dshang.size();
		for(int i=0; i<n ; i++) {
			if(maDV.equals(dshang.get(i).getiDDichVu())) {
				if(dshang.get(i).getSoLuongDat()>=1) {
					int sl = dshang.get(i).getSoLuongDat() - 1;
					dshang.get(i).setSoLuongDat(sl);
					dshang.get(i).setThanhTien(sl * dshang.get(i).getGia());
				}
				if(dshang.get(i).getSoLuongDat()==0) {
					dshang.remove(i);
				}
			}
		}
	}
	public void tang(String maDV) {
		int n = dshang.size();
		for(int i =0; i<n; i++) {
			if(maDV.equals(dshang.get(i).getiDDichVu())) {
				int sl = dshang.get(i).getSoLuongDat() + 1;
				dshang.get(i).setSoLuongDat(sl);
				dshang.get(i).setThanhTien(sl * dshang.get(i).getGia());
			}
		}
	}
	public void xoa(String masach) {
		int n = dshang.size();
		for(int i =0; i <n; i++) {
			if(dshang.get(i).getiDDichVu().equals(masach)) {
				dshang.remove(i);
				thanhtien();
				return ;
			}
		}
	}
	public float thanhtien() {
		float tongthanhtien = (float)0;
		for(GioHangBEAN g : dshang) {
			tongthanhtien += g.getThanhTien();
		}
		return tongthanhtien;
	}
	public long tongslhang() {
		if(dshang == null) {
			return 0;
		}
		else {
			long tong =0;
			for(GioHangBEAN g : dshang) {
				tong += g.getSoLuongDat();
			}
			return tong;
		}
	}
}

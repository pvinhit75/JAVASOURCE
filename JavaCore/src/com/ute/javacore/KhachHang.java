package com.ute.javacore;

public class KhachHang {
	private String ma, ten, diaChi;
	private int tuoi;
	
	public KhachHang() {
		super();
	}

	public KhachHang(String ma, String ten, String diaChi, int tuoi) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	@Override
	public String toString() {
		return "KhachHang [ma=" + ma + ", ten=" + ten + ", diaChi=" + diaChi + ", tuoi=" + tuoi + "]";
	}
	
	
}

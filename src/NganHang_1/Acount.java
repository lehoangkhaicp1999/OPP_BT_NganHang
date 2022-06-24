package NganHang_1;

import java.text.DecimalFormat;

public class Acount {
	private long sotaikhoan;
	private String tentaikhoan;
	private double sodu;
	final double LAISUAT = 0.035;
	final double PHIRUT = 1000;
	public long getSotaikhoan() {
		return sotaikhoan;
	}
	public void setSotaikhoan(long sotaikhoan) {
		this.sotaikhoan = sotaikhoan;
	}
	public String getTentaikhoan() {
		return tentaikhoan;
	}
	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}
	public double getSodu() {
		return sodu;
	}
	public void setSodu(double sodu) {
		this.sodu = sodu;
	}
	public Acount(long sotaikhoan, String tentaikhoan, double sodu) {
		super();
		this.sotaikhoan = sotaikhoan;
		this.tentaikhoan = tentaikhoan;
		this.sodu = sodu;
	}
	public Acount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String str = " ";
		DecimalFormat df = new DecimalFormat("###,000");
		str += str.format("%10d %-5s %15s",sotaikhoan,tentaikhoan,df.format(getSodu()));
		return str;
	}
	public void napTien(double tenNap) 
	{
		double tienCon = this.getSodu();
		tienCon += tenNap;
		this.setSodu(tienCon);
	}
	public void rutTien(double tienRut) 
	{
		
		double tiencon = this.getSodu();
		if( tienRut >0 && tiencon>= (tienRut+PHIRUT+50000))
		{
			tiencon= tiencon-(tienRut+PHIRUT);
			 this.setSodu(tiencon);
			
		}
		
	}
	
	public Acount(long sotaikhoan, String tentaikhoan) {
		super();
		this.sotaikhoan = sotaikhoan=50000;
		this.tentaikhoan = tentaikhoan;
	}
	public void daohan()
	{
		double tiencon=this.getSodu();
		double tienloi=tiencon*LAISUAT;
		double tien=tiencon+tienloi;
		this.setSodu(tien);
	}
	
	
}

package NganHang_1;

import java.util.Scanner;


public class Test {
	static DanhSachAccount abc;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	    abc= new DanhSachAccount(10);
		Menu();
		int chon =-1;
		chon= sc.nextInt();
		if(chon==0)
		{
			System.out.println("Xin Cam on!!!");
		}
		while(chon!=0) {
			switch(chon)
			{
			case 1:
				xuatThongTin();
				nhapcung(abc);
				xuatdanhsach(abc.getAllacc(), abc.spt);
				break;
			case 2:
				giaodiennap();
				break;
			case 3:
				giaodienrut();
				break;
			case 4:
				giaodienchuyen();
				break;
			case 5:
				giaodiendaohan();
				break;
			case 6:
				giaodientimtaikhoan();
				break;
			case 7:
				giaodienxoa();
				break;
			case 8:
				giaodienthemtaikhoan(abc);
				break;
			case 9:
				giaodienchinhsua();
				break;
			default:
				System.out.println("Lua chon sai");
				break;
			}
			Menu();
			chon = sc.nextInt();
			if(chon==0)
			{
				System.out.println("Xin cam on!!!");
				break;
			}		
			
		}
//		xuatThongTin();
//		nhapcung(abc);
//		xuatdanhsach(abc.getAllacc(), abc.spt);
//		giaodiennap();
//		System.out.println("số tiền sau khi nạp: \t");
//		xuatdanhsach(abc.getAllacc(), abc.spt);
//		giaodienrut();
//		System.out.println("số tiền sau khi rút: \t");
//		xuatdanhsach(abc.getAllacc(),abc. spt);
//		giaodienchuyen();
//		System.out.println("so tien chuyen la");
//		xuatdanhsach(abc.getAllacc(),abc. spt);
//		giaodiendaohan();
//		System.out.println("số tiền đáo hạn sao một tháng là");
//		xuatdanhsach(abc.getAllacc(),abc. spt);
	//	giaodientimtaikhoan();
		
		
		
	}
	static void xuatThongTin()
	{
		String s= String.format("%15s %-5s %15s","sotaikhoan","tentaikhoan","sodu");
		System.out.println(s);
		
	}
	static double nhaptiennap()
	{
		double addmoney;
		do {
			Scanner input =new Scanner(System.in);
			System.out.println("nhập số tiền muốn nạp:\t ");
			addmoney= input.nextDouble();
			if(addmoney<0)
				System.out.println("bạn phai nhập số tiền > 0");
		}while(addmoney<0);
		return addmoney;
	}
	static void giaodiennap() {
		long sotaikhoan=0;
		double sotiennap;
		Scanner input = new Scanner(System.in);
		System.out.println("nhập số tài khoản cần nạp: \t");
		sotaikhoan= input.nextLong();
		Acount accTim= abc.timAcc(sotaikhoan);
		if(accTim!=null) // tìm thấy
		{
			sotiennap=nhaptiennap();
			accTim.napTien(sotiennap);;
		}
		else
			System.out.println("tài khoản không hợp lệ");
	}
	static void xuatdanhsach(Acount [] ds,int spt)
	{
		int i;
		for (i=0;i<spt;i++) {
			System.out.println(ds[i]);
		}
	}
	public static void nhapcung(DanhSachAccount dsAccount)
	{
		Acount acc;
		acc = new Acount(101,"\t nguyễn văn A",3000000);
		dsAccount.themAcc(acc);
		acc = new Acount(102,"\t nguyễn văn B",4000000);
		dsAccount.themAcc(acc);
		acc = new Acount(103,"\t nguyễn văn C",5000000);
		dsAccount.themAcc(acc);
	}
	static double nhaptienrut()
	{
		
		double rutmoney;
		do {
			Scanner input =new Scanner(System.in);
			System.out.println("nhập số tiền muốn rút:\t ");
			rutmoney= input.nextDouble();
			if(rutmoney<0 )
				System.out.println("bạn phai nhập số tiền > 0");
				
		}while(rutmoney<0);
		return rutmoney;
		
	}
	static void giaodienrut()  {
		long sotaikhoan=0;
		double sotienrut;
		Scanner input = new Scanner(System.in);
		System.out.println("nhập số tài khoản cần rút: \t");
		sotaikhoan= input.nextLong();
		Acount accTimtk= abc.timAcc(sotaikhoan);
		if(accTimtk!=null) // tìm thấy
		{
			sotienrut=nhaptienrut();
			accTimtk.rutTien(sotienrut);
		}
		else
			System.out.println("tài khoản không hợp lệ");
	}
	static void giaodiendaohan() {
		long sotaikhoan=0;
		Scanner input = new Scanner(System.in);
		System.out.println("nhập số tài khoản can dao han: \t");
		sotaikhoan= input.nextLong();
		Acount accTim= abc.timAcc(sotaikhoan);
		if(accTim!=null) // tìm thấy
		{
			
			accTim.daohan();
		}
		else
			System.out.println("tài khoản không hợp lệ");
	}
	static void giaodienchinhsua()
	{
		long sotaikhoan =0;
		System.out.println("Nhập tài khoản muốn chỉnh sửa:");
		Scanner input= new Scanner(System.in);
		sotaikhoan = input.nextLong();
		Acount accTim= abc.timAcc(sotaikhoan);
		if( accTim!=null)//tim thay
		{
			System.out.println("Thông tin tài khoản trước khi sửa:");
			System.out.println(accTim.toString());	
			System.out.println("Nhập thông tin mới");

			Scanner scn = new Scanner(System.in);
			System.out.println("Tên tài khoản:");
			String tentaikhoan = scn.nextLine();

			System.out.println("Số tiền trong tài khoản:");
			double sodu = scn.nextDouble();

			abc.suaThongTin(accTim.getSotaikhoan(), tentaikhoan, sodu);
		}		
		else
			System.out.println("Tài khoản không tồn tại");
	}
	static void giaodientimtaikhoan() {
		long soTaiKhoan=0;
		System.out.println("Nhập số tài khoản cần tìm");
		Scanner input = new Scanner(System.in);
		soTaiKhoan = input.nextLong();
		Acount accTim = abc.timAcc(soTaiKhoan);
		xuatThongTin();
		System.out.println(accTim);
	}
	static void giaodienthemtaikhoan(DanhSachAccount dsAccount)
	{		
		long sTK =0;
		System.out.println("Nhập số tài khoản muốn them:");
		Scanner input = new Scanner(System.in);
		sTK = input.nextLong();
		Acount accTim = abc.timAcc(sTK);
	if(accTim==null) {
		Acount acc;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập lai số tài khoản muốn them:");
		 sTK = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhập ten tài khoản muốn them:");
		String tTk =sc.nextLine();
		System.out.println("Nhập số du cua tài khoản muốn them:");
		double soDu =sc.nextDouble();
		acc = new Acount(sTK,"\t"+tTk,soDu);
		dsAccount.themAcc(acc);
		}
	else
		System.err.println("Tài khoản  tồn tại");
	
	}
		
		
		
	static void giaodienxoa()
	{
		long soTaiKhoan =0;
		String choice="";
		System.out.println("Nhập số tài khoản muốn xóa:");
		Scanner input = new Scanner(System.in);
		soTaiKhoan = input.nextLong();
		Acount accTim = abc.timAcc(soTaiKhoan);
		Scanner scn = new Scanner(System.in);
		if( accTim!=null)//tim thay
		{
			System.out.println("Bạn  muốn xóa tài khoản này?");
			System.out.println("Nhấn y để xóa ");
			choice = scn.nextLine();
			if(choice.equals("y")==true)
			{
				abc.xoaAcc(accTim);
				
			}
		}
		else
			System.out.println("Tài khoản không tồn tại");
		
		
		
		
	}
	static void giaodienchuyen() 

	{ 
		long sotaikhoanchuyen=0;
		double sotienchuyen = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("nhập số tài khoản cần chuyen: \t");
		sotaikhoanchuyen= input.nextLong();
		Acount accTim= abc.timAcc(sotaikhoanchuyen);
		if(accTim!=null) // tìm thấy
		{
			sotienchuyen=nhaptienrut();
			accTim.rutTien(sotienchuyen);
		}
		else
		{	System.out.println("tài khoản không hợp lệ");}
		long sotaikhoannhan =0;
		Scanner in = new Scanner(System.in);
		System.out.println("nhập số tài khoản nhan: \t");
		sotaikhoannhan= in.nextLong();
		Acount accT= abc.timAcc(sotaikhoannhan);
		if(accTim!=null) // tìm thấy
		{
			accT.napTien(sotienchuyen);
		}
		else
		{	System.out.println("tài khoản không hợp lệ");}
		
	}
	static void Menu()
	{
		System.out.println("CHUONG TRINH QUAN LY NGAN HANG");
		System.out.println("1. Xuất Danh Sách");
		System.out.println("2. Nạp tiền");
		System.out.println("3. Rút tiền");
		System.out.println("4. Chuyển tiền");
		System.out.println("5. Tài Khoản Đáo Hạn");
		System.out.println("6. Tìm Tài Khoản ");
		System.out.println("7. Xóa tài khoản");
		System.out.println("8. them tài khoản");
		System.out.println("9. sua tài khoản");
		System.out.println("0. Thoát chương trình");
		System.out.println("Lựa chọn của bạn:");
	}	
}

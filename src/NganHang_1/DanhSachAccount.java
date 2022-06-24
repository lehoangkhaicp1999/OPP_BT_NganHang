package NganHang_1;



public class DanhSachAccount {
	public int spt;
	Acount dsAcc [];
	public  DanhSachAccount(int spt)
	{
		dsAcc = new Acount[spt];
	}
	private void TangKichThuoc()
	{
		Acount [] Temp = new Acount[(int) dsAcc.length*2];
		for(int i=0; i<dsAcc.length;i++)
		Temp [i]= dsAcc[i];
		dsAcc = Temp;
	}
	public Acount timAcc (long sotaikhoan)
	{
		for(int i=0 ; i< spt; i++)
		{
			if(dsAcc[i].getSotaikhoan()==sotaikhoan)
				return dsAcc[i];
		}
		return null;
	}
	public boolean themAcc(Acount htp)
	{
		if(timAcc(htp.getSotaikhoan())!=null)// tim thay trung ma
			return false;
		else
		{
			if(spt==dsAcc.length)
				TangKichThuoc();
			else
				dsAcc[spt]=htp;
			spt++;
			return true;
		}
		
	}
public int timvitri(long sotaikhoan)
{
	int i;
	for( i=0;i<spt;i++)
	{
		if(dsAcc[i].getSotaikhoan()==sotaikhoan)
			break;
	}
	return i;
}

	public void xoaAcc(Acount acc)
	{
		
		int i;
		int vitri= timvitri(acc.getSotaikhoan());
		if(vitri <0)
		{vitri = 0;}
		else if(vitri>=spt)
		{
			vitri = spt-1;
		}
		for ( i= vitri; i<spt-1;i++)
		{
			dsAcc[i]=dsAcc[i+1];
			
		}
		spt--;
	
		
		
	}
	public void suaAcc(Acount acc)
	{
		for(int i=0;i<spt;i++)
		{
			if(dsAcc[i].getSotaikhoan()==acc.getSotaikhoan())
			{
				dsAcc[i]=acc;
				break;
			}
		}
		
	}
		public boolean suaThongTin(long sotaikhoan,String tentaikhoan,double sodu)
		{
			int index = timvitri(sotaikhoan);
			dsAcc[index].setTentaikhoan(tentaikhoan);
			dsAcc[index].setSodu(sodu);
			return true;
		}
		public Acount [] getAllacc()
	{
		return dsAcc;
	}
	
	
	
}

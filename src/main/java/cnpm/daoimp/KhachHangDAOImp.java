package cnpm.daoimp;

import java.util.List;

import cnpm.entity.KhachHang;

public interface KhachHangDAOImp {
	
	public List<KhachHang> getDSKhachHang();
	
	public KhachHang getByMaKH(String maKH);
	
	public Boolean them(KhachHang khachHang);
	
	public Boolean sua(KhachHang khachHang);
	
	public Boolean xoa(KhachHang khachHang);
	
}

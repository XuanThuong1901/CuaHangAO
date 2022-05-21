package cnpm.daoimp;

import java.util.List;

import cnpm.entity.TaiKhoan;

public interface TaiKhoanDAOImp {
	public boolean kiemTraDangNhap(String email, String matkhau);
	
	public TaiKhoan getByEmail(String email);
	
	public TaiKhoan getByMaTK(String maTK);
	
	public List<TaiKhoan> getDSTaiKhoan();
	
	public Boolean them(TaiKhoan taikhoan);
	
	public Boolean sua(TaiKhoan taikhoan);
	
	public Boolean xoa(TaiKhoan taikhoan);
	
}

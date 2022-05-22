package cnpm.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.TaiKhoanDAO;
import cnpm.daoimp.TaiKhoanDAOImp;
import cnpm.entity.TaiKhoan;

@Service
public class TaiKhoanService {
	@Autowired
	TaiKhoanDAO taiKhoanDAO;
	
	
	public boolean kiemTraDangNhap(String email, String matkhau) {
		// TODO Auto-generated method stub
		String pwHash = hashPass(matkhau);
		return taiKhoanDAO.kiemTraDangNhap(email, pwHash);
	}

	public TaiKhoan getByEmail(String email) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getByEmail(email);
	}
	
	public Boolean emailDaCo(String email) {
		if(this.getByEmail(email) != null) {
			return true;
		}
		return false;
			
	}
	
	public Boolean emailSua(String emailCu, String emailMoi) {
//		return taiKhoanDAO.checkEmailExcept(email);
		return true;
	}
	
	public Boolean resetMK(TaiKhoan taikhoan) {
		taikhoan.setMatKhau(hashPass("123456"));
		return taiKhoanDAO.sua(taikhoan);
	}
	
	public Boolean thayDoiMK(TaiKhoan taiKhoan, String mk) {
		taiKhoan.setMatKhau(hashPass(mk));
		return taiKhoanDAO.sua(taiKhoan);
	}
	
	public Boolean xoaTK(TaiKhoan taikhoan) {
		return taiKhoanDAO.xoa(taikhoan);
	}

	public String taoMaTKMoi() {
		int index = this.getDSTaiKhoan().size() + 1;
		while(this.maTKDaCo("TK"+Integer.toString(index))) {
			index++;
		}
		
		String maTK = "TK" + Integer.toString(index);
		
		return maTK;
	}

	public List<TaiKhoan> getDSTaiKhoan() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getDSTaiKhoan();
	}

	public TaiKhoan getByMaTK(String maTK) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getByMaTK(maTK);
	}
	
	public TaiKhoan setTK(String email, String matKhau) {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setEmail(email);
		taiKhoan.setMatKhau(hashPass(matKhau));
		taiKhoan.setMaTK(taoMaTKMoi());
		
		return taiKhoan;
	}
	
	public Boolean setTrangThaiTK(TaiKhoan taiKhoan, Boolean trangThai) {
		taiKhoan.setTrangThai(trangThai);
		return taiKhoanDAO.sua(taiKhoan);
	}
	
	public Boolean maTKDaCo(String maTK) {
		if(this.getByMaTK(maTK) != null) {
			return true;
		}
		return false;
	}
	
	public String hashPass(String matKhau) {
		String hashpw = DigestUtils.md5Hex(matKhau).toUpperCase();
		return hashpw;
	}

	public Boolean themKH(TaiKhoan taikhoan) {
		taikhoan.setTrangThai(true);
		taikhoan.setVaiTro("KH");
		
		return taiKhoanDAO.them(taikhoan);
	}
	
	
	public Boolean themNV(TaiKhoan taikhoan) {
		taikhoan.setTrangThai(true);
		taikhoan.setVaiTro("NV");
		
		return taiKhoanDAO.them(taikhoan);
	}
	
}

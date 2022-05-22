package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.DonHangDAO;
import cnpm.entity.DonHang;
import cnpm.entity.NhanVien;

@Service
public class DonHangService {
	@Autowired
	DonHangDAO donHangDAO;
	
	public Integer maPNCuoiCung() {
		List<DonHang> phieuNhap = this.getDSDonHang();
		Integer index = phieuNhap.get(phieuNhap.size()-1).getMaDH();
		return index;
	}
	
	public List<DonHang> getDSDonHang(){
		return donHangDAO.getDSDonHang();
	}
	
	public DonHang getByMaDH(Integer maDH) {
		return donHangDAO.getByMaDH(maDH);
	}
	
	public Boolean themDH(DonHang donhang) {
		return donHangDAO.them(donhang);
	}
	
	public Boolean suaDH(DonHang donhang) {
		return donHangDAO.sua(donhang);
	}
}

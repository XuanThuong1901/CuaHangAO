package cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.GioHangDAO;
import cnpm.entity.GioHang;
import cnpm.entity.GioHangPK;

@Service
public class GioHangService {
	@Autowired
	GioHangDAO gioHangDAO;
	
	public Boolean them(String maKH, Integer MaCTSP, Integer soLuong) {
		
		GioHangPK pk = new GioHangPK(maKH, MaCTSP);
		GioHang giohang = new GioHang();
		giohang.setGioHangPK(pk);
		giohang.setSoLuong(soLuong);
		
		return gioHangDAO.them(giohang);
	}
}

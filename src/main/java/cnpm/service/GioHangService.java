package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.GioHangDAO;
import cnpm.entity.GioHang;
import cnpm.entity.GioHangPK;

@Service
public class GioHangService {
	@Autowired
	GioHangDAO gioHangDAO;
	
	public List<GioHang> getDSGioHang(String makh){
		return gioHangDAO.getDSGioHang(makh);
	}
	
	public GioHang get1GioHang(String makh, Integer mattsp){
		return gioHangDAO.get1GioHang(makh, mattsp);
	}
	
	public Boolean themGH(GioHang giohang) {

		return gioHangDAO.them(giohang);
	}
	
	public Boolean xoaGH(GioHang gioHang) {
		return gioHangDAO.xoa(gioHang);
	}
	
	public Boolean suaGH(GioHang gioHang) {
		return gioHangDAO.sua(gioHang);
	}
}

package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.GioHangDAO;
import cnpm.dao.HinhThucThanhToanDAO;
import cnpm.entity.GioHang;
import cnpm.entity.GioHangPK;
import cnpm.entity.HinhThucThanhToan;

@Service
public class HinhThucThanhToanServie {
	@Autowired
	HinhThucThanhToanDAO hinhThucThanhToanDAO;
	
	public List<HinhThucThanhToan> getDSHinhThucThanhToan(){
		return hinhThucThanhToanDAO.getDSHinhThucThanhToan();
	}
	
	public HinhThucThanhToan getByMaHinhThucThanhToan(Integer maTT){
		return hinhThucThanhToanDAO.getByMaHinhThucThanhToan(maTT);
	}
	
}

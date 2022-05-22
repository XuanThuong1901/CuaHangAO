package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.GioHangDAO;
import cnpm.dao.HinhThucThanhToanDAO;
import cnpm.dao.TrangThaiDonHangDAO;
import cnpm.entity.GioHang;
import cnpm.entity.GioHangPK;
import cnpm.entity.HinhThucThanhToan;
import cnpm.entity.TrangThaiDonHang;

@Service
public class TrangThaiDonHangService {
	@Autowired
	TrangThaiDonHangDAO TrangThaiDonHangDAO;
	
	public List<TrangThaiDonHang> getDSHinhThucThanhToan(){
		return TrangThaiDonHangDAO.getDSTrangThaiDonHang();
	}
	
	public TrangThaiDonHang getByMaTrangThaiDonHangService(Integer maTT){
		return TrangThaiDonHangDAO.getByMaTrangThaiDonHang(maTT);
	}
	
}

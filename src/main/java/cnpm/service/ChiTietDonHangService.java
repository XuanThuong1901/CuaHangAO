package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cnpm.dao.ChiTietDonHangDAO;
import cnpm.entity.ChiTietDonHang;

@Service
public class ChiTietDonHangService {
	@Autowired
	ChiTietDonHangDAO chiTietDonHangDAO;
	
	public List<ChiTietDonHang> getDSByMaDH(Integer MaDH){
		return chiTietDonHangDAO.getDSByMaDH(MaDH);
	}
}

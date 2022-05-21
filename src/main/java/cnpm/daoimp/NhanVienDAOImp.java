package cnpm.daoimp;

import cnpm.entity.NhanVien;

public interface NhanVienDAOImp {
	
	public NhanVien getByMaTK(String maTK);
	
	public NhanVien getByMaNV(String maNV);
}

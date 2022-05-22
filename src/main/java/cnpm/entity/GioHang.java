
package cnpm.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private GioHangPK gioHangPK;
	
	
	@ManyToOne
	@JoinColumn(name="MaKH", insertable=false, updatable=false)
	private KhachHang khachHang;
	
	
	@ManyToOne
	@JoinColumn(name="MaChiTietSP" , insertable=false, updatable=false)
	private ChiTietSanPham chiTietSP;

	@Column(name = "SoLuong")
	private int soLuong;

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public GioHangPK getGioHangPK() {
		return gioHangPK;
	}

	public void setGioHangPK(GioHangPK gioHangPK) {
		this.gioHangPK = gioHangPK;
	}

	public KhachHang getKhangHang() {
		return khachHang;
	}

	public void setKhangHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ChiTietSanPham getChiTietSP() {
		return chiTietSP;
	}

	public void setChiTietSP(ChiTietSanPham chiTietSP) {
		this.chiTietSP = chiTietSP;
	}

	
}

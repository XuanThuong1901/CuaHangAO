package cnpm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDonHangPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="MaCTSP")
	private int maCTSP;
	
	@Column(name="MaDH")
	private int maDH;

	public int getMaCTSP() {
		return maCTSP;
	}

	public void setMaCTSP(int maCTSP) {
		this.maCTSP = maCTSP;
	}

	public int getMaDH() {
		return maDH;
	}

	public void setMaDH(int maKH) {
		this.maDH = maKH;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maCTSP;
		result = prime * result + maDH;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHangPK other = (ChiTietDonHangPK) obj;
		if (maCTSP != other.maCTSP)
			return false;
		if (maDH != other.maDH)
			return false;
		return true;
	}
	
	
}

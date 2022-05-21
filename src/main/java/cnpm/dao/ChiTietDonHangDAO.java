package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.ChiTietDonHang;

@Transactional
@Repository
public class ChiTietDonHangDAO {
	@Autowired
	SessionFactory factory;
	
	public List<ChiTietDonHang> getDSByMaDH(Integer MaDH){
		Session session = factory.getCurrentSession();
		String hql = "from ChiTietDonHang where MaDH = :MaDH";
		Query query = session.createQuery(hql);
		query.setParameter("MaDH", MaDH);
		List<ChiTietDonHang> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res;
	}
}

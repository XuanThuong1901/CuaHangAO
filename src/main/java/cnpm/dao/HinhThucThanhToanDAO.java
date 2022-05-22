package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.DonHang;
import cnpm.entity.GioHang;
import cnpm.entity.HinhThucThanhToan;

@Transactional
@Repository
public class HinhThucThanhToanDAO {
	@Autowired
	SessionFactory factory;
	
	public List<HinhThucThanhToan> getDSHinhThucThanhToan(){
		Session session = factory.getCurrentSession();
		String hql = "from  HinhThucThanhToan";
		Query query = session.createQuery(hql);
		
		List< HinhThucThanhToan> list = query.list();
		if(list.size() == 0) {
			return null;
		}
		
		return list;
	}
	
	public HinhThucThanhToan getByMaHinhThucThanhToan(Integer maHTTT) {
		Session session = factory.getCurrentSession();
		String hql = "from HinhThucThanhToan where maHTTT = :maHTTT";
		Query query = session.createQuery(hql);
		query.setParameter("maHTTT", maHTTT);
		List<HinhThucThanhToan> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res.get(0);
	}
}

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

@Transactional
@Repository
public class GioHangDAO {
	@Autowired
	SessionFactory factory;
	
	public List<GioHang> getDSGioHang(String maKH){
		Session session = factory.getCurrentSession();
		String hql = "from  GioHang where maKH = :maKH";
		Query query = session.createQuery(hql);
		query.setParameter("maKH", maKH);
		
		List< GioHang> list = query.list();
		if(list.size() == 0) {
			return null;
		}
		
		return list;
	}
	
	public GioHang get1GioHang(String maKH, Integer maCTSP){
		Session session = factory.getCurrentSession();
		String hql = "from  DonHang where maKH = :maKH and maCTSP = :maCTSP";
		Query query = session.createQuery(hql);
		query.setParameter("maKH", maKH);
		query.setParameter("maCTSP", maCTSP);
		
		List< GioHang> list = query.list();
		if(list.size() == 0) {
			return null;
		}
		
		GioHang res = list.get(0);
		
		return res;
	}
	
	public Boolean them(GioHang gioHang){
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(gioHang);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		return isSuccess;
	}
	
	public Boolean sua(GioHang gioHang){
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(gioHang);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		return isSuccess;
	}
	
	public Boolean xoa(GioHang gioHang){
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(gioHang);
			t.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			t.rollback();
			isSuccess = false;
		}
		finally {
			session.close();
		}
		return isSuccess;
	}
}

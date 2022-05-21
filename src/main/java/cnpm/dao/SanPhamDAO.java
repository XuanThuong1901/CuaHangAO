package cnpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cnpm.entity.DanhMucSanPham;
import cnpm.entity.KhachHang;
import cnpm.entity.SanPham;

@Transactional
@Repository
public class SanPhamDAO {
	@Autowired
	SessionFactory factory;
	
	public List<SanPham> getDSSanPham(){
		Session session = factory.getCurrentSession();
		String hql = "from SanPham";
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		
		return list;
	}
	
	public SanPham getByMaSP(Integer maSP) {
		Session session = factory.getCurrentSession();
		String hql = "from SanPham where maSP = :maSP";
		Query query = session.createQuery(hql);
		

		query.setParameter("maSP", maSP);
		List<SanPham> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
	
		return res.get(0);
	}
	
	public Boolean them(SanPham sanPham) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(sanPham);
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
	
	public Boolean sua(SanPham sanPham) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(sanPham);
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

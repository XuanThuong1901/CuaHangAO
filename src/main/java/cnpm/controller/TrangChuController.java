package cnpm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cnpm.entity.DanhMucSanPham;
import cnpm.entity.MauSanPham;
import cnpm.entity.SanPham;
import cnpm.entity.SizeSanPham;
import cnpm.service.DanhMucSanPhamService;
import cnpm.service.MauService;
import cnpm.service.NhanVienService;
import cnpm.service.SanPhamService;
import cnpm.service.SizeService;

@Transactional
@Controller
public class TrangChuController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	NhanVienService nhanVienService;
	
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	SizeService sizeService;
	
	@Autowired
	MauService mauService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	
	  @ModelAttribute("danhSachDanhMucSanPham") public List<DanhMucSanPham>
	  dsDanhMucSanPham(){ List<DanhMucSanPham> list =
	  danhMucSanPhamService.getDSDanhMuc(); return list; }
	  
	  @ModelAttribute("danhSachMau") public List<MauSanPham> getDSMau() {
	  List<MauSanPham> list = mauService.getDSMau(); return list; }
	  
	  @ModelAttribute("danhSachSize") public List<SizeSanPham> getDSSize() {
	  List<SizeSanPham> list = sizeService.getDSSize(); return list; }
	  
	  @ModelAttribute("thongTinDM") public DanhMucSanPham thongtinDm(ModelMap
	  model) {
	  
	  return new DanhMucSanPham(); }
	 
	
	/*
	 * @ModelAttribute("danhSachSanPham") public List<SanPham> getDsSP(){
	 * 
	 * return sanPhamService.getDSSanPham(); }
	 */
	
	@RequestMapping("")
	public String reView404() {
		return "redirect:/404";
	}
	
	@RequestMapping("404")
	public String getView404() {
		return "loi/404";
	}
	
	@RequestMapping("/403")
	public String getView403() {
		return "loi/403";
	}
	
	@RequestMapping(value={"/", "trangchu", "index"})
	public String index(ModelMap model) {
		
		
		return "shop/trangchu";
	}
	
	@RequestMapping(value="/sanpham")
	public String getViewProduct(ModelMap model, HttpServletRequest request) {
		List<SanPham> list = sanPhamService.getDSSanPham();
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
	
		pagedListHolder.setPageSize(12);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "shop/sanpham";
	}
	
	@RequestMapping(value="/chitietsanpham")
	public String getViewChitietSanpham() {
		
		return "shop/chitietsanpham";
	}
	
	@RequestMapping(value="/lienhe")
	public String getViewLienHe() {
		
		return "shop/lienhe";
	}
	


}

package cnpm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cnpm.entity.ChiTietSanPham;
import cnpm.entity.DanhMucSanPham;
import cnpm.entity.DonHang;
import cnpm.entity.KhachHang;
import cnpm.entity.MauSanPham;
import cnpm.entity.NhanVien;
import cnpm.entity.SanPham;
import cnpm.entity.SizeSanPham;
import cnpm.service.ChiTietDonHangService;
import cnpm.service.ChiTietSanPhamService;
import cnpm.service.DanhMucSanPhamService;
import cnpm.service.DonHangService;
import cnpm.service.KhachHangService;
import cnpm.service.MauService;
import cnpm.service.NhanVienService;
import cnpm.service.SanPhamService;
import cnpm.service.SizeService;
import cnpm.service.TaiKhoanService;
import cnpm.service.UtilsService;

@Transactional
@Controller
public class TrangChuController {
	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	@Autowired
	ChiTietSanPhamService chiTietSanPhamService;

	@Autowired
	ChiTietDonHangService chiTietDonHangService;

	@Autowired
	SizeService sizeService;

	@Autowired
	MauService mauService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	DonHangService donHangService;

	@Autowired
	UtilsService utilService;

// ============= LIST =================
	List<SanPham> dsSanPhamTheoDM = new ArrayList<SanPham>();

//	============== Model - Attribute ==============

	@ModelAttribute("danhSachSanPhamTheoDanhMuc")
	public List<SanPham> getDSSanPhamTheoDM() {
		return dsSanPhamTheoDM;
	}

	@ModelAttribute("danhSachDonHang")
	public List<DonHang> getDSDH() {
		return donHangService.getDSDonHang();
	}

	@ModelAttribute("danhSachSanPham")
	public List<SanPham> getDSSanPham() {
		List<SanPham> list = sanPhamService.getDSSanPham();
		return list;
	}

	@ModelAttribute("danhSachDanhMucSanPham")
	public List<DanhMucSanPham> dsDanhMucSanPham() {
		List<DanhMucSanPham> list = danhMucSanPhamService.getDSDanhMuc();
		return list;
	}

	@ModelAttribute("danhSachMau")
	public List<MauSanPham> getDSMau() {
		List<MauSanPham> list = mauService.getDSMau();
		return list;
	}

	@ModelAttribute("danhSachSize")
	public List<SizeSanPham> getDSSize() {
		List<SizeSanPham> list = sizeService.getDSSize();
		return list;
	}

	@ModelAttribute("thongTinDM")
	public DanhMucSanPham thongtinDm(ModelMap model) {

		return new DanhMucSanPham();
	}

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

	@RequestMapping(value = { "/", "trangchu", "index" })
	public String index(ModelMap model) {

		return "shop/trangchu";
	}

	@RequestMapping(value = "sanpham")
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

	@RequestMapping(value = "chitietsanpham/{maSP}",  params = "ctsp", method = RequestMethod.GET )
	public String getViewChitietSanpham(ModelMap model, HttpSession ss, @PathVariable("maSP") Integer masp) {

		SanPham sanpham = sanPhamService.getByMaSP(masp);
		ss.setAttribute("ctsanpham", sanpham);
		
		return "shop/chitietsanpham";
	}

	@RequestMapping(value = "/lienhe")
	public String getViewLienHe() {

		return "shop/lienhe";
	}
	

	@RequestMapping(value = "danhmuc/{maDM}", params = "ds", method = RequestMethod.GET)
	public String postSuaKhachHang(ModelMap model, HttpServletRequest request, @PathVariable("maDM") Integer maDM) {

//		dsSanPhamTheoDM.clear();

		List<SanPham> list = sanPhamService.getDSSanPhamTheoDM(maDM);
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(12);
		model.addAttribute("pagedListHolder", pagedListHolder);

//		for(int i=0; i<sanpham.size(); i++) {
//			
//			if(sanpham.get(i).getDanhMuc().getMaDM() == maDM) {
//				dsSanPhamTheoDM.add(sanpham.get(i));
//			}
//		}

		return "shop/sanphamtheodanhmuc";
	}
}

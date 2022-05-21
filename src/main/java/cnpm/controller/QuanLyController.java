package cnpm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cnpm.entity.*;

import cnpm.service.*;

@Controller
@RequestMapping("/quanly/")
public class QuanLyController {
	@Autowired
	NhanVienService nhanVienService;

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

//	============== Model - Attribute ==============
	@ModelAttribute("thongTinCaNhan")
	public NhanVien thongTinCaNhan() {
		return new NhanVien();
	}

	@ModelAttribute("danhSachDonHang")
	public List<DonHang> getDSDH() {
		return donHangService.getDSDonHang();
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

	@ModelAttribute("danhSachSanPham")
	public List<SanPham> getDSSanPham() {
		List<SanPham> list = sanPhamService.getDSSanPham();
		return list;
	}

	@ModelAttribute("danhSachNhanVien")
	public List<NhanVien> getDSNhanVien() {
		List<NhanVien> list = nhanVienService.getDSNhanVien();
		return list;
	}

	@ModelAttribute("danhSachKhachHang")
	public List<KhachHang> getDSKhachHang() {
		List<KhachHang> list = khachHangService.getDSKhachHang();
		return list;
	}

	@ModelAttribute("thongTinSP")
	public SanPham thongTinSP() {
		return new SanPham();
	}

	@ModelAttribute("sanPhamMoi")
	public SanPham sanPhamMoi() {
		return new SanPham();
	}
	
	@ModelAttribute("chiTietShanPhamMoi")
	public ChiTietSanPham chiTietSanPhamMoi() {
		return new ChiTietSanPham();
	}

	@ModelAttribute("thongTinDH")
	public DonHang thongTinDH() {
		return new DonHang();
	}

	@ModelAttribute("CTSP")
	public ChiTietSanPham ctSPMoi() {
		return new ChiTietSanPham();
	}

	@ModelAttribute("nhanVienMoi")
	public NhanVien thongTinNV() {
		NhanVien thongTinNV = new NhanVien();
		return thongTinNV;
	}

	@ModelAttribute("thongTinNV")
	public NhanVien thongtinNv(ModelMap model) {

		return new NhanVien();
	}

	@ModelAttribute("khachHangMoi")
	public KhachHang thongTinKH() {
		KhachHang thongTinKH = new KhachHang();
		return thongTinKH;
	}

	@ModelAttribute("thongTinKH")
	public KhachHang thongtinKh(ModelMap model) {

		return new KhachHang();
	}

	// danh muc

	@ModelAttribute("danhSachDanhMucSanPham")
	public List<DanhMucSanPham> dsDanhMucSanPham() {
		List<DanhMucSanPham> list = danhMucSanPhamService.getDSDanhMuc();
		return list;
	}

	@ModelAttribute("danhMucMoi")
	public DanhMucSanPham thongtinDM() {
		DanhMucSanPham thongTinDM = new DanhMucSanPham();
		return thongTinDM;
	}

	@ModelAttribute("thongTinDM")
	public DanhMucSanPham thongtinDm(ModelMap model) {

		return new DanhMucSanPham();
	}


	@RequestMapping(value = "tongquan", method = RequestMethod.GET)
	public String getViewTongQuan() {

		return "quantri/quanly/tongquan";
	}

	@RequestMapping(value = "nhanvien", method = RequestMethod.GET)
	public String getViewNhanVien(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "danhmucsp", method = RequestMethod.GET)
	public String getViewDanhMuc(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "nhacungcap", method = RequestMethod.GET)
	public String getViewNhaCungCap(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/nhacungcap";
	}

	@RequestMapping(value = "nhanvien", params = "themNV", method = RequestMethod.POST)
	public String themMoiNhanVien(ModelMap model, @ModelAttribute("nhanVienMoi") NhanVien nhanvien,
			@RequestParam("anhMoi") MultipartFile anh, BindingResult errors) {
		if (nhanvien.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "nhanVienMoi", "Họ không được để trống");
		}

		if (nhanvien.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "nhanVienMoi", "Tên không được để trống");
		}

		if (nhanvien.getTaiKhoan().getEmail().trim().isEmpty() || !nhanvien.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "nhanVienMoi", "Email không hợp lệ hoặc bị trống");
		}

		if (nhanvien.getTaiKhoan().getMatKhau().trim().isEmpty()) {
			errors.rejectValue("taiKhoan.matKhau", "nhanVienMoi", "Mật khẩu không được để trống");
		}

		if (nhanvien.getPhai() != true && nhanvien.getPhai() != false) {
			errors.rejectValue("phai", "nhanVienMoi", "???");
		}

		if (nhanvien.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "nhanVienMoi", "Ngày sinh không được để trống");
		}

		if (nhanvien.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "nhanVienMoi", "Địa chỉ không được để trống");
		}

		if (nhanvien.getCccd().trim().isEmpty()) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không được để trống");
		} else if (!nhanvien.getCccd().trim().matches("^[0-9]*$")) {
			errors.rejectValue("cccd", "nhanVienMoi", "Cccd không hợp lệ");
		}

		if (nhanvien.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không được để trống");
		} else if (!nhanvien.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (taiKhoanService.emailDaCo(nhanvien.getTaiKhoan().getEmail())) {
			errors.rejectValue("email", "nhanVienMoi", "Email đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		if (nhanVienService.getBySdt(nhanvien.getSdt()) != null) {
			errors.rejectValue("sdt", "nhanVienMoi", "Số điện thoại đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/nhanvien";
		}

		String hinh = "";

		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
			if (!hinh.isEmpty()) {
				nhanvien.setAnh(hinh);
			}
		}

		TaiKhoan taiKhoan = taiKhoanService.setTK(nhanvien.getTaiKhoan().getEmail(),
				nhanvien.getTaiKhoan().getMatKhau());
		taiKhoanService.themNV(taiKhoan);

		nhanvien.setMaNV(nhanVienService.taoMaNVMoi());
		nhanvien.setTaiKhoan(taiKhoan);

		if (nhanVienService.themNV(nhanvien)) {
//			model.addAttribute("thongTinNV", new ThongTinCaNhan());
			model.addAttribute("nhanVienMoi", new NhanVien());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm tài khoản thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
		} else {
			taiKhoanService.xoaTK(taiKhoan);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm tài khoản thất bại");
		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1NhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
		if (nhanvien != null) {
			model.addAttribute("thongTinNV", nhanvien);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaNhanVien(ModelMap model, @PathVariable("maNV") String maNV) {

		NhanVien nhanvien = nhanVienService.getByMaNV(maNV);

		if (nhanvien != null) {
			model.addAttribute("thongTinNV", nhanvien);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "suaNV", method = RequestMethod.POST)
	public String postSuaNhanVien(ModelMap model, @ModelAttribute("thongTinNV") NhanVien nhanvien,
			@RequestParam("anhMoi") MultipartFile anh, @PathVariable("maNV") String maNV, BindingResult errors) {

		if (nhanvien.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "thongTinNV", "Họ không được để trống");
		}

		if (nhanvien.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "thongTinNV", "Tên không được để trống");
		}

		if (nhanvien.getTaiKhoan().getEmail().trim().isEmpty() || !nhanvien.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không hợp lệ hoặc bị trống");
		}

		if (nhanvien.getPhai() != true && nhanvien.getPhai() != false) {
			errors.rejectValue("phai", "thongTinNV", "???");
		}

		if (nhanvien.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "thongTinNV", "Ngày sinh không được để trống");
		}

		if (nhanvien.getCccd().trim().isEmpty()) {
			errors.rejectValue("cccd", "thongTinNV", "Cccd không được để trống");
		} else if (!nhanvien.getCccd().trim().matches("^[0-9]*$")) {
			errors.rejectValue("cccd", "thongTinNV", "Cccd không hợp lệ");
		}

		if (nhanvien.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không được để trống");
		} else if (!nhanvien.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			return "quantri/quanly/nhanvien";
		}

		NhanVien nhanviencu = nhanVienService.getByMaNV(maNV);
		if (nhanviencu != null) {
			if (!nhanviencu.getHo().equals(nhanvien.getHo()))
				nhanviencu.setHo(nhanvien.getHo());
			if (!nhanviencu.getTen().equals(nhanvien.getTen())) {
				nhanviencu.setTen(nhanvien.getTen());
			}
			if (!nhanviencu.getNgaySinh().equals(nhanvien.getNgaySinh())) {
				nhanviencu.setNgaySinh(nhanvien.getNgaySinh());
			}
			if (!nhanviencu.getCccd().equals(nhanvien.getCccd())) {
				nhanviencu.setCccd(nhanvien.getCccd());
			}
			if (!nhanviencu.getDiaChi().equals(nhanvien.getDiaChi())) {
				nhanviencu.setDiaChi(nhanvien.getDiaChi());
			}

			if (!nhanviencu.getSdt().equals(nhanvien.getSdt())) {
				if (nhanVienService.getBySdt(nhanvien.getSdt()) != null) {
					errors.rejectValue("sdt", "thongTinNV", "Số điện thoại đã được sử dụng");
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
				} else {
					nhanviencu.setSdt(nhanvien.getSdt());
				}
			}

			if (nhanviencu.getPhai() != nhanvien.getPhai()) {
				nhanviencu.setPhai(nhanvien.getPhai());
			}
			if (!nhanviencu.getTaiKhoan().getEmail().equals(nhanvien.getTaiKhoan().getEmail())) {
				errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không được thay đổi");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/nhanvien";
			}

			if (nhanviencu.getTaiKhoan().getTrangThai() != nhanvien.getTaiKhoan().getTrangThai()) {
				nhanviencu.getTaiKhoan().setTrangThai(nhanvien.getTaiKhoan().getTrangThai());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					nhanviencu.setAnh(hinh);
				}
			}

			if (nhanVienService.suaNV(nhanviencu)) {
				model.addAttribute("thongTinNV", new NhanVien());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa nhân viên thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachNhanVien", nhanVienService.getDSNhanVien());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa nhân viên thất bại");
		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{maNV}", params = "resetmatkhau", method = RequestMethod.POST)
	public String resetMatKhau(ModelMap model, @PathVariable("maNV") String maNV) {
		if (maNV.trim().isEmpty()) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Reset mật khẩu thất bại");
		} else {
			NhanVien nhanvien = nhanVienService.getByMaNV(maNV);
			if (nhanvien != null) {
				taiKhoanService.resetMK(nhanvien.getTaiKhoan());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Reset mật khẩu thành công");
			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Reset mật khẩu thất bại");
			}
		}

		return "quantri/quanly/nhanvien";
	}

	@RequestMapping(value = "khachhang", method = RequestMethod.GET)
	public String getViewKhachHang(ModelMap model) {
		model.addAttribute("isOpenModalInfo", false);

		return "quantri/quanly/khachhang";
	}

	/// Khách hàng

	@RequestMapping(value = "khachhang", params = "themKH", method = RequestMethod.POST)
	public String themMoiNhanVien(ModelMap model, @ModelAttribute("khachHangMoi") KhachHang khachhang,
			@RequestParam("anhMoi") MultipartFile anh, BindingResult errors) {
		if (khachhang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "khachHangMoi", "Họ không được để trống");
		}

		if (khachhang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "khachHangMoi", "Tên không được để trống");
		}

		if (khachhang.getTaiKhoan().getEmail().trim().isEmpty() || !khachhang.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "khachHangMoi", "Email không hợp lệ hoặc bị trống");
		}

		if (khachhang.getTaiKhoan().getMatKhau().trim().isEmpty()) {
			errors.rejectValue("taiKhoan.matKhau", "khachHangMoi", "Mật khẩu không được để trống");
		}

		if (khachhang.getPhai() != true && khachhang.getPhai() != false) {
			errors.rejectValue("phai", "khachHangMoi", "???");
		}

		if (khachhang.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "khachHangMoi", "Ngày sinh không được để trống");
		}

		if (khachhang.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "khachHangMoi", "Địa chỉ không được để trống");
		}

		if (khachhang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại không được để trống");
		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại không hợp lệ");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		if (taiKhoanService.emailDaCo(khachhang.getTaiKhoan().getEmail())) {
			errors.rejectValue("email", "khachHangMoi", "Email đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		if (nhanVienService.getBySdt(khachhang.getSdt()) != null) {
			errors.rejectValue("sdt", "khachHangMoi", "Số điện thoại đã được sử dụng");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/khachhang";
		}

		String hinh = "";
		System.out.println("anh " + anh);
		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
			if (!hinh.isEmpty()) {
				khachhang.setAnh(hinh);
			}
		}

		TaiKhoan taiKhoan = taiKhoanService.setTK(khachhang.getTaiKhoan().getEmail(),
				khachhang.getTaiKhoan().getMatKhau());
		taiKhoanService.themKH(taiKhoan);

		khachhang.setMaKH(khachHangService.taoMaKHMoi());
		khachhang.setTaiKhoan(taiKhoan);

		if (khachHangService.themKH(khachhang)) {
//			model.addAttribute("thongTinNV", new ThongTinCaNhan());
			model.addAttribute("khachHangMoi", new KhachHang());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm tài khoản thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachKhachHang", khachHangService.getDSKhachHang());
		} else {
			taiKhoanService.xoaTK(taiKhoan);
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm tài khoản thất bại");
		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1KhachHang(ModelMap model, @PathVariable("maKH") String maKH) {

		KhachHang khachhang = khachHangService.getByMaKH(maKH);
		if (khachhang != null) {
			model.addAttribute("thongTinKH", khachhang);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaKhachHang(ModelMap model, @PathVariable("maKH") String maKH) {

		KhachHang khachhang = khachHangService.getByMaKH(maKH);

		if (khachhang != null) {
			model.addAttribute("thongTinKH", khachhang);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{maKH}", params = "suaKH", method = RequestMethod.POST)
	public String postSuaKhachHang(ModelMap model, @ModelAttribute("thongTinKH") KhachHang khachhang,
			@RequestParam("anhMoi") MultipartFile anh, @PathVariable("maKH") String maKH, BindingResult errors) {

		if (khachhang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "thongTinNV", "Họ không được để trống");
		}

		if (khachhang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "thongTinNV", "Tên không được để trống");
		}

		if (khachhang.getTaiKhoan().getEmail().trim().isEmpty() || !khachhang.getTaiKhoan().getEmail().trim().matches(
				"^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không hợp lệ hoặc bị trống");
		}

		if (khachhang.getPhai() != true && khachhang.getPhai() != false) {
			errors.rejectValue("phai", "thongTinNV", "???");
		}

		if (khachhang.getNgaySinh() == null) {
			errors.rejectValue("ngaySinh", "thongTinNV", "Ngày sinh không được để trống");
		}

		if (khachhang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không được để trống");
		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "thongTinNV", "Số điện thoại không hợp lệ");
		}
		

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			return "quantri/quanly/nhanvien";
		}

		KhachHang khachhangcu = khachHangService.getByMaKH(maKH);
		
		if (!khachhangcu.getTaiKhoan().getEmail().equals(khachhang.getTaiKhoan().getEmail())) {
			errors.rejectValue("taiKhoan.email", "thongTinNV", "Email không được thay đổi");
			model.addAttribute("isOpenModalEdit", true);
			return "quantri/quanly/nhanvien";
		}
		
		if (khachhangcu != null) {
			if (!khachhangcu.getHo().equals(khachhang.getHo()))
				khachhangcu.setHo(khachhang.getHo());
			if (!khachhangcu.getTen().equals(khachhang.getTen())) {
				khachhangcu.setTen(khachhang.getTen());
			}
			if (!khachhangcu.getNgaySinh().equals(khachhang.getNgaySinh())) {
				khachhangcu.setNgaySinh(khachhang.getNgaySinh());
			}
			if (!khachhangcu.getDiaChi().equals(khachhang.getDiaChi())) {
				khachhangcu.setDiaChi(khachhang.getDiaChi());
			}

			if (!khachhangcu.getSdt().equals(khachhang.getSdt())) {
				if (nhanVienService.getBySdt(khachhang.getSdt()) != null) {
					errors.rejectValue("sdt", "thongTinNV", "Số điện thoại đã được sử dụng");
					model.addAttribute("isOpenModalEdit", true);
					return "quantri/quanly/nhanvien";
				} else {
					khachhangcu.setSdt(khachhang.getSdt());
				}
			}

			if (khachhangcu.getPhai() != khachhang.getPhai()) {
				khachhangcu.setPhai(khachhang.getPhai());
			}
			

			System.out.println(khachhangcu.getTaiKhoan().getTrangThai());
			System.out.println(khachhang.getTaiKhoan().getTrangThai());
			System.out.println(1);

			if (khachhangcu.getTaiKhoan().getTrangThai() != khachhang.getTaiKhoan().getTrangThai()) {
				khachhangcu.getTaiKhoan().setTrangThai(khachhang.getTaiKhoan().getTrangThai());
				System.out.println(2);
				System.out.println(khachhangcu.getTaiKhoan().getTrangThai());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					khachhangcu.setAnh(hinh);
				}
			}

			if (khachHangService.suaKH(khachhangcu)) {
				model.addAttribute("thongTinKH", new KhachHang());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa khách hàng thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachKhachHang", khachHangService.getDSKhachHang());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa khachhang thất bại");
		}

		return "quantri/quanly/khachhang";
	}

	/// Danh mục

	@RequestMapping(value = "danhmucsp", params = "themDM", method = RequestMethod.POST)
	public String themMoiDanhMuc(ModelMap model, @ModelAttribute("danhMucMoi") DanhMucSanPham danhmucsp,
			BindingResult errors) {
		if (danhmucsp.getTenDM().trim().isEmpty()) {
			errors.rejectValue("tenDM", "danhMucMoi", "Tên danh mục không được trống");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/danhmucsp";
		}

		if (danhMucSanPhamService.themDM(danhmucsp)) {

			model.addAttribute("danhmucMoi", new DanhMucSanPham());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());
		} else {
			model.addAttribute("alertMessage", "Thêm danh mục thất bại");
		}

		return "quantri/quanly/danhmucsp";
	}

	// Sửa thông tin Danh mục

	@RequestMapping(value = "danhmucsp/{maDM}", params = "thongtin", method = RequestMethod.GET)
	public String getThongtin1DanhMuc(ModelMap model, @PathVariable("maDM") Integer maDM) {

		DanhMucSanPham danhmuc = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmuc != null) {
			model.addAttribute("thongTinDM", danhmuc);
			model.addAttribute("isOpenModalInfo", true);

		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp/{maDM}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaDanhMuc(ModelMap model, @PathVariable("maDM") Integer maDM) {

		DanhMucSanPham danhMucsp = danhMucSanPhamService.getByMaDM(maDM);

		if (danhMucsp != null) {
			model.addAttribute("thongTinDM", danhMucsp);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp/{maDM}", params = "suaThongtin", method = RequestMethod.POST)
	public String postSuaDanhMuc(ModelMap model, @ModelAttribute("thongTinDM") DanhMucSanPham danhmucsp,
			@PathVariable("maDM") Integer maDM, BindingResult errors) {

		if (danhmucsp.getTenDM().trim().isEmpty()) {
			errors.rejectValue("tenDM", "thongTinDM", "Tên danh mục không được trống");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/danhmucsp";
		}

		DanhMucSanPham danhmuccu = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmuccu != null) {
			System.out.println(1);
			if (!danhmuccu.getTenDM().equals(danhmucsp.getTenDM()))
				danhmuccu.setTenDM(danhmucsp.getTenDM());
		}
		if (danhMucSanPhamService.suaDM(danhmuccu)) {
			model.addAttribute("thongTinDM", new DanhMucSanPham());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Sửa danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa danh mục thất bại");
			System.out.println(3);
		}

		return "quantri/quanly/danhmucsp";
	}

	@RequestMapping(value = "danhmucsp", params = "xoadm", method = RequestMethod.POST)
	public String postXoaDanhMuc(ModelMap model, @RequestParam("maDM") Integer maDM) {

		// System.out.println(danhmucsp.getMaDM());
		DanhMucSanPham danhmucsp = danhMucSanPhamService.getByMaDM(maDM);
		if (danhmucsp == null) {
			if (danhmucsp.getSanPhams() != null) {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Xóa danh mục thất bại");
			}
		}
		if (danhmucsp.getSanPhams().size() == 0) {
			danhMucSanPhamService.xoaDM(danhmucsp);
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Xóa danh mục thành công");
			model.addAttribute("danhSachDanhMucSanPham", danhMucSanPhamService.getDSDanhMuc());

		}
		if (danhmucsp.getSanPhams().size() > 0) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Xóa danh mục thất bại");
		}

		return "quantri/quanly/danhmucsp";
	}
	
	
	// Đơn hàng
	@RequestMapping(value = "donhang", method = RequestMethod.GET)
	public String getViewDonHang() {
		return "quantri/quanly/donhang";
	}

	@RequestMapping(value = "donhang/{maDH}", params = "thongtin", method = RequestMethod.GET)
	public String getThongTinDonHang(ModelMap model, @PathVariable("maDH") Integer maDH) {

		if (maDH != null) {
			DonHang donhang = donHangService.getByMaDH(maDH);

			if (donhang != null) {
				List<ChiTietDonHang> chitietdonhang = chiTietDonHangService.getDSByMaDH(maDH);
				if (chitietdonhang.size() > 0) {
					model.addAttribute("chitietdonhang", chitietdonhang);
				} else {
					model.addAttribute("chitietdonhang", new ArrayList<ChiTietDonHang>());
				}

				model.addAttribute("thongTinDH", donhang);
				model.addAttribute("isOpenModalInfo", true);
			}
		}

		return "quantri/quanly/donhang";
	}

	@RequestMapping(value = "donhang/{maDH}", params = "suaTrangthai", method = RequestMethod.GET)
	public String getTrangThaiNhanVien(ModelMap model, @PathVariable("maDH") Integer maDH) {

		DonHang donhang = donHangService.getByMaDH(maDH);

		System.out.println(donhang.getTrangThaiDH().getMaTTDH());

		if (donhang != null) {
			model.addAttribute("thongTinDH", donhang);
			model.addAttribute("isOpenModalEdit", true);

			System.out.println(2);
		}
		return "quantri/quanly/donhang";
	}

	@RequestMapping(value = "donhang/{maDH}", params = "suaDH", method = RequestMethod.POST)
	public String postTrangThaiDonHang(ModelMap model, @PathVariable("maDH") Integer maDH,
			@ModelAttribute("thongTinDH") DonHang donhang, BindingResult errors) {

		DonHang donhangcu = donHangService.getByMaDH(maDH);
		if (donhangcu != null) {
			if (donhangcu.getTrangThaiDH().getMaTTDH() == 3 && donhang.getTrangThaiDH().getMaTTDH() != 3) {

				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng đã bị hủy trươc đó");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}
			if (donhangcu.getTrangThaiDH().getMaTTDH() == 1 && donhang.getTrangThaiDH().getMaTTDH() == 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng chưa được xác nhận");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}

			if (donhangcu.getTrangThaiDH().getMaTTDH() == 2 && donhang.getTrangThaiDH().getMaTTDH() != 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng không thể hủy hoặc chuyển thành đơn mới");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}

			if (donhangcu.getTrangThaiDH().getMaTTDH() == 4 && donhang.getTrangThaiDH().getMaTTDH() != 4) {
				errors.rejectValue("trangThaiDH", "thongTinDH", "Đơn hàng đã giao thành công trước đó");
				model.addAttribute("isOpenModalEdit", true);
				return "quantri/quanly/donhang";
			}

//			if (donhangcu.getTrangThaiDH().getMaTTDH() == 1 && donhang.getTrangThaiDH().getMaTTDH() == 2) {
//				List<ChiTietDonHang> ctdh = chiTietDonHangService.getDSByMaDH(maDH);
//				for(int i=0; i<ctdh.size(); i++) {
//					
//				}
//			}
			
			donhangcu.getTrangThaiDH().setMaTTDH(donhang.getTrangThaiDH().getMaTTDH());

			if (donHangService.suaDH(donhangcu)) {
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Thay đổi trạng thái thành công");
				model.addAttribute("danhSachDonHang", donHangService.getDSDonHang());
			} else {
				model.addAttribute("isSuccess", false);
				model.addAttribute("alertMessage", "Thay đổi trạng thía thất bại");
			}

		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thay đổi trạng thía thất bại");
		}

		return "quantri/quanly/donhang";
	}

	// san pham
	@RequestMapping(value = "sanpham", method = RequestMethod.GET)
	public String getViewSanpham() {
		return "quantri/quanly/sanpham";
	}

	@RequestMapping(value = "sanpham/{maSP}", params = "thongtin", method = RequestMethod.GET)
	public String thongTin1SanPham(ModelMap model, @PathVariable("maSP") Integer maSP) {
		SanPham sanpham = sanPhamService.getByMaSP(maSP);
		if (sanpham != null) {
			model.addAttribute("thongTinSP", sanpham);
			model.addAttribute("isOpenModalInfo", true);
		}
		return "quantri/quanly/sanpham";
	}

//	@RequestParam("anhMoi") MultipartFile anh,
	@RequestMapping(value = "sanpham", params = "themSP", method = RequestMethod.POST)
	public String themMoiSanPham(ModelMap model, @ModelAttribute("sanPhamMoi") SanPham sanpham,
			@RequestParam("anhMoi") MultipartFile anh,
			@RequestParam(name = "size", required = false) List<Integer> listsize, BindingResult errors) {

		if (sanpham.getTenSP().trim().isEmpty()) {
			errors.rejectValue("tenSP", "sanPhamMoi", "Tên sản phẩm không được để trống");
		}

		if (sanpham.getGia() == 0) {
			errors.rejectValue("gia", "sanPhamMoi", "Giá không được để trống");
		}

		if (listsize == null) {
			model.addAttribute("size", "Phải chọn ít nhất 1 size sản phẩm");
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/sanpham";
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/sanpham";
		}

		if (anh == null) {
			model.addAttribute("anhMoi", "Hình ảnh không thể để trống");
			return "quantri/quanly/sanpham";
		}

		String hinh = "";
		System.out.println("anh " + anh);
		if (!anh.isEmpty()) {
			hinh = utilService.luuFile(anh);
			if (!hinh.isEmpty()) {
				sanpham.setHinhAnh(hinh);
			}
		}

		if (sanPhamService.themSP(sanpham)) {

			int masp = sanPhamService.maSPCuoiCung();
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			System.out.println(1);

			for (int i = 0; i < listsize.size(); i++) {
				System.out.println(2);
				SizeSanPham sizesanpham = sizeService.getByMaSize(listsize.get(i));
				chiTietSanPham.setSanPham(sanPhamService.getByMaSP(masp));
				chiTietSanPham.setSizeSanPham(sizesanpham);
				chiTietSanPham.setSoLuong(0);

				chiTietSanPhamService.themCTSP(chiTietSanPham);
				System.out.println(3);
			}
			model.addAttribute("sanPhamMoi", new SanPham());
			model.addAttribute("isSuccess", true);
			model.addAttribute("alertMessage", "Thêm sản phẩm thành công");
			model.addAttribute("hinh", "");
			model.addAttribute("danhSachSanPham", sanPhamService.getDSSanPham());
		} else {

			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Thêm tài khoản thất bại");
		}

		return "quantri/quanly/sanpham";
	}

	@RequestMapping(value = "sanpham/{maSP}", params = "suaThongtin", method = RequestMethod.GET)
	public String getSuaSanPham(ModelMap model, @PathVariable("maSP") Integer maSP) {

		SanPham sanpham = sanPhamService.getByMaSP(maSP);

		if (sanpham != null) {
			model.addAttribute("thongTinSP", sanpham);
			model.addAttribute("isOpenModalEdit", true);

		}

		return "quantri/quanly/sanpham";
	}

	@RequestMapping(value = "sanpham/{maSP}", params = "suaSP", method = RequestMethod.POST)
	public String postSuaSanPham(ModelMap model, @ModelAttribute("thongTinSP") SanPham sanpham,
			@RequestParam("anhMoi") MultipartFile anh, @PathVariable("maSP") Integer maSP, BindingResult errors) {

		if (sanpham.getTenSP().trim().isEmpty()) {
			errors.rejectValue("tenSP", "sanPhamMoi", "Tên sản phẩm không được để trống");
		}

		if (sanpham.getGia() == 0) {
			errors.rejectValue("gia", "sanPhamMoi", "Giá không được để trống");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isShowModalAddNew", true);
			return "quantri/quanly/sanpham";
		}

		SanPham sanphamcu = sanPhamService.getByMaSP(maSP);
		if (sanphamcu != null) {
			if (!sanphamcu.getTenSP().equals(sanpham.getTenSP()))
				sanphamcu.setTenSP(sanpham.getTenSP());
			if (sanphamcu.getDanhMuc() != sanpham.getDanhMuc()) {
				sanphamcu.setDanhMuc(sanpham.getDanhMuc());
			}
			if (sanphamcu.getPhai() != sanpham.getPhai()) {
				sanphamcu.setPhai(sanpham.getPhai());
			}
			if (!sanphamcu.getMoTa().equals(sanpham.getMoTa())) {
				sanphamcu.setMoTa(sanpham.getMoTa());
			}
			if (sanphamcu.getGia() != sanpham.getGia()) {
				sanphamcu.setGia(sanpham.getGia());
			}
			if (sanphamcu.getGiamGia() != sanpham.getGiamGia()) {
				sanphamcu.setGiamGia(sanpham.getGiamGia());
			}
			if (sanphamcu.getMauSanPham() != sanpham.getMauSanPham()) {
				sanphamcu.setMauSanPham(sanpham.getMauSanPham());
			}

			if (!anh.isEmpty()) {
				String hinh = "";
				hinh = utilService.luuFile(anh);
				if (!hinh.isEmpty()) {
					sanphamcu.setHinhAnh(hinh);
				}
			}

			if (sanPhamService.suaSP(sanphamcu)) {
				model.addAttribute("thongTinNV", new NhanVien());
				model.addAttribute("isSuccess", true);
				model.addAttribute("alertMessage", "Sửa sản phẩm thành công");
				model.addAttribute("hinh", "");
				model.addAttribute("danhSachSanPham", sanPhamService.getDSSanPham());
			}
		}

		else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("alertMessage", "Sửa sản phẩm thất bại");
		}

		return "quantri/quanly/sanpham";
	}
}

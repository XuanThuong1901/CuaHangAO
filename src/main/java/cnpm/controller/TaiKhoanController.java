package cnpm.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.KhachHangService;
import cnpm.service.NhanVienService;
import cnpm.service.TaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	NhanVienService nhanVienService;
	
	@RequestMapping(value="dangxuat")
	public String dangXuat(HttpSession ss) {
		if(ss.getAttribute("user") != null) {
			ss.removeAttribute("user");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = {"dangnhap" }, method = RequestMethod.GET)
	public String getDangNhap(ModelMap model) {
		model.addAttribute("taikhoan", new TaiKhoan());
		return "taikhoan/dangnhap";
	}
	
	@RequestMapping(value = {"dangky" }, method = RequestMethod.GET)
	public String getDangKy(ModelMap model) {
		model.addAttribute("tkdangky", new KhachHang());
		return "taikhoan/dangky";
	}

	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	public String postDangNhap(ModelMap model, HttpSession ss, @ModelAttribute("taikhoan") TaiKhoan taikhoan,BindingResult errors) {

		if (taikhoan.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "taikhoan", "Email không được để trống");
		}

		if (taikhoan.getMatKhau().trim().isEmpty()) {
			errors.rejectValue("matKhau", "taikhoan", "Mật khẩu không được để trống");
		}
		if (errors.hasErrors()) {
			return "taikhoan/dangnhap";
		}
		
		
		if (taiKhoanService.kiemTraDangNhap(taikhoan.getEmail(), taikhoan.getMatKhau())) {
			TaiKhoan thongtinTk = taiKhoanService.getByEmail(taikhoan.getEmail());
			
			if(!thongtinTk.getTrangThai()) {
				model.addAttribute("message", "Tài khoản chưa được kích hoạt hoặc đã bị khóa, vui lòng liên hệ với bộ phận hỗ trợ của chúng tôi!");
				return "taikhoan/dangnhap";
			}

			if (thongtinTk.getVaiTro().equals("KH")) {
				if(thongtinTk.getKhachHang() == null) {
					model.addAttribute("message", "Thông tin đăng nhập không hợp lệ");
					return "taikhoan/dangnhap";
				}
				ss.setAttribute("user", thongtinTk);
				return "redirect:/trangchu";
			}
			else if (thongtinTk.getVaiTro().equals("QL")) {
				if(thongtinTk.getNhanVien() == null) {
					model.addAttribute("message", "Thông tin đăng nhập không hợp lệ");
					return "taikhoan/dangnhap";
				}
				ss.setAttribute("user", thongtinTk);
				return "redirect:/quanly/tongquan";
			}


			return "redirect:/quanly/tongquan";
		}
		model.addAttribute("message", "Sai thông tin tài khoản hoặc mật khẩu");

		return "taikhoan/dangnhap";
	}
	
	@RequestMapping(value="dangky", method=RequestMethod.POST)
	public String postDangKy(ModelMap model, @ModelAttribute("tkdangky") KhachHang khachHang, BindingResult errors,
			@RequestParam("email-register") String email, 
			@RequestParam("password-register") String matKhau, 
			@RequestParam("confirm-password-register") String xnMatKhau) {

		
		if(khachHang.getHo().trim().isEmpty()) {
			errors.rejectValue("ho", "tkdangky", "Họ không được để trống");
		}
		
		if(khachHang.getTen().trim().isEmpty()) {
			errors.rejectValue("ten", "tkdangky", "Tên không được để trống");
		}
		
		if(email == "") {
			model.addAttribute("email", "Email không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(matKhau == "") {
			model.addAttribute("password", "Mật khẩu không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(xnMatKhau == "") {
			model.addAttribute("confirmPassword", "Mật khẩu xác nhận không thể để trống");
			return "taikhoan/dangky";
		}
		
		if(matKhau!="" && xnMatKhau!="" && !xnMatKhau.equals(matKhau)) {
			model.addAttribute("confirmPassword", "Mật khẩu và mật khẩu xác nhận không trùng nhau");
			return "taikhoan/dangky";
		}
		

		if(khachHang.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "tkdangky", "Số điện thoại không được để trống");
		}
		
		if(khachHang.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "tkdangky", "Địa chỉ không được để trống");
		}
		if (errors.hasErrors()) {
			return "taikhoan/dangky";
		}
		
//		System.out.println("khahchang " + khachhang.getHo());
//		
//		System.out.println("email " + email);
		
		if(taiKhoanService.emailDaCo(email) ) {
			model.addAttribute("email", "Email đã được sử dụng");
			return "taikhoan/dangky";
		}
		
		if(khachHangService.getBySdt(khachHang.getSdt()) != null) {
			errors.rejectValue("sdt", "tkdangky", "Số điện thoại đã được sử dụng");
			return "taikhoan/dangky";
		}
		
		
			TaiKhoan taiKhoan = taiKhoanService.setTK(email, matKhau);			
			taiKhoanService.themKH(taiKhoan);
			
			khachHang.setMaKH(khachHangService.taoMaKHMoi());
			khachHang.setTaiKhoan(taiKhoan);
			if(khachHangService.themKH(khachHang)) {
				model.addAttribute("tkdangky", new KhachHang());
				model.addAttribute("message", "Tạo tài khoản thành công");
			}else {
				model.addAttribute("message", "Tạo tài khoản thất bại");
			}
			
		
		
		return "taikhoan/dangky";
	}

}

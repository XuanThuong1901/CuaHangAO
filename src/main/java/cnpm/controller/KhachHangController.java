package cnpm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cnpm.entity.KhachHang;
import cnpm.entity.NhanVien;
import cnpm.entity.TaiKhoan;
import cnpm.service.GioHangService;
import cnpm.service.KhachHangService;

@Controller

public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	GioHangService gioHangService;

	/*
	 * @ModelAttribute("taikhoan") public KhachHang getKhdangnhap(HttpSession ss) {
	 * TaiKhoan tk = (TaiKhoan) ss.getAttribute("user"); KhachHang khachhang =
	 * tk.getKhachHang();
	 * 
	 * return khachhang; }
	 */

	@RequestMapping("taikhoan")
	public String getViewTaiKhoan(ModelMap model) {

		return "shop/taikhoan";
	}

	@RequestMapping("thanhtoan")
	public String getViewThanhToan(ModelMap model) {

		return "shop/thanhtoan";
	}

	@RequestMapping("giohang")
	public String getViewGioHang(ModelMap model) {

		return "shop/giohang";
	}

	@RequestMapping(value = "giohang/them/{maSP}", method = RequestMethod.GET)
	public String themGioHang(ModelMap model, HttpServletRequest request, @PathVariable("maSP") Integer maSP,
			@RequestParam("size") Integer size, @RequestParam("number") Integer soLuong,
			@RequestParam("ctsp") Integer ctsp, HttpSession ss) {
		/// check chi cho khach hang dc them 
		
		if(maSP == null || size == null || soLuong == null || ss.getAttribute("user") == null) {
			
			return "redirect:/";
		}
		
		TaiKhoan tk = (TaiKhoan) ss.getAttribute("user");
		
		
		System.out.println("number " + size + " numer" + soLuong + " " + maSP + " " + ctsp);
		
		gioHangService.them(tk.getKhachHang().getMaKH(), ctsp, soLuong);

		String referer = request.getHeader("Referer");
		System.out.println("number " + referer);
		return "redirect:" + referer;
		
	}

	
}

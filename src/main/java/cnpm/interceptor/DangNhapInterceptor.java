package cnpm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cnpm.entity.TaiKhoan;

public class DangNhapInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("user");
			if (taikhoan.getVaiTro().equals("KH")) {

				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}

			else if (taikhoan.getVaiTro().equals("QL")) {

				response.sendRedirect(request.getContextPath() + "/quanly/tongquan");
				return false;
			}
			
		} 

		return true;
	}
}

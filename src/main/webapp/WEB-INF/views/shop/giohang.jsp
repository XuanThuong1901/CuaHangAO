<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->
<style>
table tr img {
	width: 150px;
}
</style>


<main>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Home</a> <a
						class="breadcrumb-item text-dark" href="#">Shop</a> <span
						class="breadcrumb-item active">Giỏ hàng</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<section class="content"></section>
	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Tên sản phẩm</th>
							<th>Hình ảnh</th>
							<th>Giá</th>
							<th>Số lượng</th>
							<th></th>
						</tr>
					</thead>

					<tbody class="">
						<c:forEach var="giohang" items="${danhSachGioHang }">
							<tr>
								<td>${giohang.getChiTietSP().getSanPham().getTenSP() }</td>
								<td class="text-center"><a
									href="resources/file/${ giohang.getChiTietSP().getSanPham().getHinhAnh()}"
									data-toggle="lightbox"><img
										src="resources/file/${ giohang.getChiTietSP().getSanPham().getHinhAnh()}"
										alt="Hinh anh" class="img-size-50" /></a></td>
								<td>${giohang.getChiTietSP().getSanPham().getGia() }VNĐ</td>
								<%-- <td>${giohang.getSoLuong() }</td> --%>

								<td class="align-middle">
									<div class="input-group quantity mx-auto" style="width: 100px;">
										<!-- <div class="input-group-btn">
											<form action="" method="post">
												<button class="btn btn-sm btn-primary btn-minus" name="update">
													<i class="fa fa-minus"></i>
												</button>
											</form>
										</div> -->
										<input type="text" name="soluong"
											class="form-control form-control-sm bg-secondary border-0 text-center"
											value="${giohang.getSoLuong() }" />

										<!-- <div class="input-group-btn">
											<form action="" method="post">
												<button class="btn btn-sm btn-primary btn-plus" name="update">
													<i class="fa fa-plus"></i>
												</button>
											</form>
										</div> -->
									</div>
								</td>
								<td class="align-middle">
									<form method="post">
										<button class="btn btn-sm btn-danger" name="xoagiohang"
											value="${giohang.getChiTietSP().getMaChiTietSP() }">
											<i class="fa fa-times"></i>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
			<div class="col-lg-4">

				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">Thông tin thanh toán</span>
				</h5>
				<div class="bg-light p-30 mb-5">
					<div class="border-bottom pb-2">
						<div class="d-flex justify-content-between mb-3">
							<h6>Tổng tiền sản phẩm</h6>
							<h6>${tongtien }VNĐ</h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Phí ship</h6>
							<h6 class="font-weight-medium">21.000.00 VNĐ</h6>
						</div>
					</div>
					<div class="pt-2">
						<div class="d-flex justify-content-between mt-2">
							<h5>Tổng đơn thanh toán</h5>
							<h5>${tongdon }VNĐ</h5>
						</div>


					</div>
					<form method="post">
						<div>
							<label for="" class="d-flex justify-content-between mt-2">Hình
								Thức thanh toán</label> <select name="httt"
								class="form-control form-select select2bs4">
								<c:forEach var="httt" items="${danhSachHinhThucThanhToan}">
									<option value="${httt.getMaHTTT()}">${httt.getKieuTT()}</option>
								</c:forEach>
							</select>
						</div>
						<div>
							<label for="" class="d-flex justify-content-between mt-2">Ghi chú</label>
							<input type="text" class="form-control form-select select2bs4" name="ghichu">
							<!-- <span class="input-group-text" name="ghichu"></span> -->
						</div>

						<button name="thanhtoan"
							class="btn btn-block btn-primary font-weight-bold my-3 py-3">Thanh
							Toán</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->
</main>
<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>

<!-- Footer -->
<%@include file="/WEB-INF/views/shop/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/shop/include/jsLib.jsp"%>
<!-- JS Lib End -->
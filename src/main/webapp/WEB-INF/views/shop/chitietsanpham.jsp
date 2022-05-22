<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->
<main>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Home</a> <a
						class="breadcrumb-item text-dark" href="#">Shop</a> <span
						class="breadcrumb-item active">Chi tiết sản phẩm</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Shop Detail Start -->
	<div class="container-fluid pb-5">
		<div class="row px-xl-5">


			<form method="post" style="display: flex;">
				<div class="col-lg-5 mb-30">

					<div class="product-item">
						<img class="w-70 h-70"
							src="resources/file/${ctsanpham.getHinhAnh() }" alt="Image">
					</div>
				</div>
				<div class="col-lg-7 h-auto mb-30">
					<div class="h-100 bg-light p-30">
						<h3>${ctsanpham.getTenSP() }</h3>

						<h3 class="font-weight-semi-bold mb-4">
							<fmt:setLocale value="vi_VN" />
							<fmt:formatNumber maxFractionDigits="0"
								value="${ctsanpham.getGia()}" type="currency"
								currencySymbol="vnđ" />
						</h3>
						<p class="mb-4">${ctsanpham.getMoTa() }</p>
						<div class="d-flex mb-3">
							<strong class="text-dark mr-3">Sizes:</strong>
							<c:forEach var="s" items="${ctsanpham.getChiTietSanPhams()}">
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" name="size"
										value="${s.getSizeSanPham().getMaSize() }"
										class="custom-control-input"
										id="size-${s.getSizeSanPham().getMaSize() }"> <label
										class="custom-control-label"
										for="size-${s.getSizeSanPham().getMaSize() }">${s.getSizeSanPham().getTenSize()}
									</label>
								</div>
							</c:forEach>


						</div>

						<div class="d-flex align-items-center mb-4 pt-2">
							<div class="input-group quantity mr-3" style="width: 130px;">
								<div class="input-group-btn">
									<button type="button" class="btn btn-primary btn-minus" data-dismiss="modal">
										<i class="fa fa-minus"></i>
									</button>
								</div>
								<input type="text" id="number-product" name="soluong"
									class="form-control bg-secondary border-0 text-center"
									value="1">

								<div class="input-group-btn">
									<button type="button" class="btn btn-primary btn-plus" data-dismiss="modal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
								<p class="text-danger">${soluong }</p>
							</div>

							<%-- <a href="giohang/them/${ctsanpham.getMaSP()}" id="add-card-btn" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Thêm vào giỏ hàng</a> --%>
						</div>
						<button class="btn btn-primary px-3" name="themvaogio">
							<i class="fa fa-shopping-cart mr-1"> </i> Thêm vào giỏ hàng
						</button>

					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="bg-light p-30">
				<div class="nav nav-tabs mb-4">
					<a class="nav-item nav-link text-dark active" data-toggle="tab"
						href="#tab-pane-1">Description</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Product Description</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<p>Dolore magna est eirmod sanctus dolor, amet diam et eirmod
							et ipsum. Amet dolore tempor consetetur sed lorem dolor sit lorem
							tempor. Gubergren amet amet labore sadipscing clita clita diam
							clita. Sea amet et sed ipsum lorem elitr et, amet et labore
							voluptua sit rebum. Ea erat sed et diam takimata sed justo. Magna
							takimata justo et amet magna et.</p>
					</div>

					Shop Detail End Products Start
					<div class="container-fluid py-5">
						<h2
							class="section-title position-relative text-uppercase mx-xl-5 mb-4">
							<span class="bg-secondary pr-3">You May Also Like</span>
						</h2>
						<div class="row px-xl-5">
							<div class="col">
								<div class="owl-carousel related-carousel">
									<div class="product-item bg-light">
										<div class="product-img position-relative overflow-hidden">
											<img class="img-fluid w-100" src="img/product-1.jpg" alt="">
											<div class="product-action">
												<a class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-shopping-cart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="far fa-heart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-sync-alt"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="text-center py-4">
											<a class="h6 text-decoration-none text-truncate" href="">Product
												Name Goes Here</a>
											<div
												class="d-flex align-items-center justify-content-center mt-2">
												<h5>$123.00</h5>
												<h6 class="text-muted ml-2">
													<del>$123.00</del>
												</h6>
											</div>
											<div
												class="d-flex align-items-center justify-content-center mb-1">
												<small class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
											</div>
										</div>
									</div>
									<div class="product-item bg-light">
										<div class="product-img position-relative overflow-hidden">
											<img class="img-fluid w-100" src="img/product-2.jpg" alt="">
											<div class="product-action">
												<a class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-shopping-cart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="far fa-heart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-sync-alt"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="text-center py-4">
											<a class="h6 text-decoration-none text-truncate" href="">Product
												Name Goes Here</a>
											<div
												class="d-flex align-items-center justify-content-center mt-2">
												<h5>$123.00</h5>
												<h6 class="text-muted ml-2">
													<del>$123.00</del>
												</h6>
											</div>
											<div
												class="d-flex align-items-center justify-content-center mb-1">
												<small class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
											</div>
										</div>
									</div>
									<div class="product-item bg-light">
										<div class="product-img position-relative overflow-hidden">
											<img class="img-fluid w-100" src="img/product-3.jpg" alt="">
											<div class="product-action">
												<a class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-shopping-cart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="far fa-heart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-sync-alt"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="text-center py-4">
											<a class="h6 text-decoration-none text-truncate" href="">Product
												Name Goes Here</a>
											<div
												class="d-flex align-items-center justify-content-center mt-2">
												<h5>$123.00</h5>
												<h6 class="text-muted ml-2">
													<del>$123.00</del>
												</h6>
											</div>
											<div
												class="d-flex align-items-center justify-content-center mb-1">
												<small class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
											</div>
										</div>
									</div>
									<div class="product-item bg-light">
										<div class="product-img position-relative overflow-hidden">
											<img class="img-fluid w-100" src="img/product-4.jpg" alt="">
											<div class="product-action">
												<a class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-shopping-cart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="far fa-heart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-sync-alt"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="text-center py-4">
											<a class="h6 text-decoration-none text-truncate" href="">Product
												Name Goes Here</a>
											<div
												class="d-flex align-items-center justify-content-center mt-2">
												<h5>$123.00</h5>
												<h6 class="text-muted ml-2">
													<del>$123.00</del>
												</h6>
											</div>
											<div
												class="d-flex align-items-center justify-content-center mb-1">
												<small class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
											</div>
										</div>
									</div>
									<div class="product-item bg-light">
										<div class="product-img position-relative overflow-hidden">
											<img class="img-fluid w-100" src="img/product-5.jpg" alt="">
											<div class="product-action">
												<a class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-shopping-cart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="far fa-heart"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-sync-alt"></i></a> <a
													class="btn btn-outline-dark btn-square" href=""><i
													class="fa fa-search"></i></a>
											</div>
										</div>
										<div class="text-center py-4">
											<a class="h6 text-decoration-none text-truncate" href="">Product
												Name Goes Here</a>
											<div
												class="d-flex align-items-center justify-content-center mt-2">
												<h5>$123.00</h5>
												<h6 class="text-muted ml-2">
													<del>$123.00</del>
												</h6>
											</div>
											<div
												class="d-flex align-items-center justify-content-center mb-1">
												<small class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small
													class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Products End -->
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

<script>
	$(document).ready(
			function() {
				let addCardBtn = $("#add-card-btn")
				addCardBtn.click(function(e) {
					e.preventDefault()
					let number = $("#number-product").attr("value")
					let size = $("input[name='size']:checked").val()
					let detailNumber = $("input[name='size']:checked").data(
							"ctsp")
					console.log('number', number, size)

					let queryParams = "?size=" + size + "&number=" + number
							+ "&ctsp=" + detailNumber
					console.log(queryParams)
					addCardBtn.attr("href", addCardBtn.attr("href").concat(
							queryParams))
					addCardBtn.unbind("click")
					addCardBtn[0].click()
					console.log(addCardBtn.attr("href").concat(queryParams))
				})
			})
</script>
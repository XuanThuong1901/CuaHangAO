<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->
<main>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Trang chủ</a> <span
						class="breadcrumb-item active">Mua sắm</span>
					${danhSachSanPham.size() }
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Shop Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-4">
				<!-- Categories Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseCategories" role="button"
					aria-expanded="true" aria-controls="collapseCategories">
					<span class="bg-secondary pr-3">Danh mục <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseCategories">
					<div class="bg-light p-4 mb-30">
						<form>
							<!-- <div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-all" checked> <label
									class="custom-control-label" for="category-all">Tất cả</label> <span
									class="badge border font-weight-normal">145</span>
							</div> -->
							<c:forEach var="dm" items="${danhSachDanhMucSanPham }">

								<%-- <li><a href="/san-pham/${ dm.getMaDM()}"><span
										class="icon-ctrele-blank"></span>${ dm.getTenDM()}
										<span class="badge border font-weight-normal">${dm.getSanPhams().size() }</span>
										</a></li> --%>

								<div
									class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
									<input type="checkbox" class="custom-control-input"
										alt="checkbox"> <label class="custom-control-label"
										for="category-nike">${dm.getTenDM() }</label> <span
										class="badge border font-weight-normal">${dm.getSanPhams().size() }</span>
								</div>
							</c:forEach>

						</form>
					</div>
				</div>
				<!-- Categories End -->



				<!-- Size Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseSize" role="button"
					aria-expanded="true" aria-controls="collapseSize">
					<span class="bg-secondary pr-3">size <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseSize">
					<div class="bg-light p-4 mb-30">
						<div class="d-flex flex-wrap g-2">
							<c:forEach var="s" items="${danhSachSize }">
								<button data-masize="${s.getMaSize() }"
									class="btn border m-1 btn-filter-size"
									id="btn-size--${s.getTenSize() }">${s.getTenSize() }</button>

							</c:forEach>
						</div>


					</div>
				</div>

				<!-- Size End -->

			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			<div class="col-lg-9 col-md-8">
				<div class="row pb-3">
					<div class="col-12"></div>
					<jsp:useBean id="pagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="/sanpham" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
					<%-- <c:forEach var="sp" items="${danhSachSanPham }"> --%>
					<c:forEach var="sp" items="${pagedListHolder.pageList}">
						<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
							<div class="product-item bg-light mb-4">
								<div class="product-img position-relative overflow-hidden"
									style="height: 320px;">
									<!-- <span class="badge bg-warning">NEW</span>  -->
									<img class="img-fluid w-100"
										src="resources/file/${sp.getHinhAnh() }" alt="">
									<!-- src="resources/user/img/product-1.jpg" src="resources/file/${sp.getHinhAnh() }" -->
									<div class="product-action d-flex">
										<div class="d-flex flex-row">
											<a class="btn btn-outline-dark btn-square"
												href="chitietsanpham/${sp.getMaSP() }?ctsp"><i
												class="fa fa-shopping-cart"></i></a>
											<!-- <a
											class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-sync-alt"></i></a> <a
											class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-search"></i></a> -->
										</div>

										<button data-id="${sp.getMaSP() }" name="ctsp"											class="btn text-uppercase btn-product-buynow"
											style="display: inline-block;">mua ngay</button>
									</div>



								</div>
								<div class="text-center py-4 text-pd"
									style="overflow-wrap: break-word;">
									<a class="h6 text-decoration-none text-truncate"
										style="word-wrap: break-word"
										href="chitietsanpham/${sp.getMaSP() }?ctsp">${sp.getTenSP() }</a>
									<div
										class="d-flex align-items-center justify-content-center mt-2">
										<h5>${sp.getGia()}VNĐ</h5>

									</div>

								</div>
							</div>
						</div>
					</c:forEach>




				</div>
			</div>
			<div class="col-12">
				<div>
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />
				</div>

			</div>
		</div>
	</div>
	<!-- Shop Product End -->
	</div>
	</div>
	<!-- Shop End -->
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

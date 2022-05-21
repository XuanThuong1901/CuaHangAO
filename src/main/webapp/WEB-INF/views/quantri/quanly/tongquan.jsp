<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
   <%@include file="/WEB-INF/views/quantri/include/header.jsp" %>
<!-- Header end -->

<!-- Sidebar -->
   <%@include file="/WEB-INF/views/quantri/include/sidebar-ql.jsp" %>
<!-- Sidebar end -->

        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            
            <div class="col-sm-12">
              <ol class="breadcrumb mt-1">
                <li class="breadcrumb-item"><a href="quanly/tongquan">Quản lý</a></li>
                <li class="breadcrumb-item active">Tổng quan</li>
              </ol>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">

        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachKhachHang.size() }</h3>

                <p>Khách hàng</p>
              </div>
              <div class="icon">
                <i class=" fas fa-users text-info"></i>
              </div>
              <a href="quanly/khachhang" class="small-box-footer bg-info">Chi tiết <i
                  class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachNhanVien.size() }</h3>

                <p>Nhân viên</p>
              </div>
              <div class="icon">
                <i class="fas fa-user-tie text-info"></i>
              </div>
              <a href="quanly/nhanvien" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachDanhMucSanPham.size() }</h3>

                <p>Danh mục sản phẩm</p>
              </div>
              <div class="icon">
               <i class="nav-icon "></i>
                <i class="fab fa-elementor text-info"></i>
              </div>
              <a href="quanly/danhmucsp" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachSanPham.size() }</h3>

                <p>Sản phẩm</p>
              </div>
              <div class="icon">
                <i class="fas fa-box-open text-info"></i>
              </div>
              <a href="quanly/sanpham" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachDonHang.size()}</h3>

                <p>Đơn hàng</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag text-info"></i>
              </div>
              <a href="quanly/donhang" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
        </div>
        <!-- /.row -->

      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

<!-- Footer -->
   <%@include file="/WEB-INF/views/quantri/include/footer.jsp" %>
<!-- Footer end -->

 

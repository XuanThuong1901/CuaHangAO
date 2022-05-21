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
                    <a class="breadcrumb-item text-dark" href="#">Trang chủ</a>
                    <span class="breadcrumb-item active">Tài khoản</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Start -->
    <div class="container-fluid">
        <div class="row px-xl-5 ">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-3 tab-space">
                        <ul class="nav nav-pills mb-3 flex-column" id="pills-tab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-profile"
                                    role="tab" aria-controls="pills-home" aria-selected="true">TÀI KHOẢN CỦA TÔI</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-change-password"
                                    role="tab" aria-controls="pills-profile" aria-selected="false">ĐỔI MẬT KHẨU</a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-status"
                                    role="tab" aria-controls="pills-profile" aria-selected="false">TÌNH TRẠNG ĐƠN HÀNG</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-history"
                                    role="tab" aria-controls="pills-contact" aria-selected="false">LỊCH SỬ MUA HÀNG</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-logout"
                                    role="tab" aria-controls="pills-contact" aria-selected="false">ĐĂNG XUẤT</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-profile" role="tabpanel"
                                aria-labelledby="pills-profile-tab">
                                <div class="container rounded bg-white mb-2">
                                    <div class="row">
                                        <div class="col-md-5 border-right">
                                            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://i.pinimg.com/564x/a7/29/b9/a729b9585cbd8e692ec81c0e9495e7c3.jpg" width="250px"><span class="font-weight-bold">Amelly</span><span class="text-black-50">amelly12@bbb.com</span><span> </span></div>
                                        </div>
                                        <div class="col-md-7">
                                            <div class="p-3 py-5 tab-space">
                                               <p class="h5 font-weight-bold mb-5 text-center">CÀI ĐẶT TÀI KHOẢN</p>
                                                <div class="row mt-2">
                                                    <div class="col-md-6"><label class="labels">HỌ</label><input type="text" class="form-control" placeholder="Họ" value=""></div>
                                                    <div class="col-md-6"><label class="labels">TÊN</label><input type="text" class="form-control" value="" placeholder="Tên"></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12"><label class="labels">SỐ ĐIỆN THOẠI</label><input type="text" class="form-control" placeholder="Số điện thoại" value=""></div>
                                                    <div class="col-md-12"><label class="labels">ĐỊA CHỈ</label><input type="text" class="form-control" placeholder="Địa chỉ" value=""></div>
                                                    <div class="col-md-12"><label class="labels">EMAIL</label><input type="text" class="form-control" placeholder="Email" value=""></div>
                                                    <div class="col-md-12"><label class="labels">TÀI KHOẢN THANH TOÁN</label><input type="text" class="form-control" placeholder="Tài khoản" value=""></div>
                                                </div>
                                                
                                                <div class="mt-2 text-center"><button class="btn btn-primary profile-button h5 w-100" type="button">LƯU THAY ĐỔI</button></div>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                             <div class="tab-pane fade" id="pills-change-password" role="tabpanel"
                                aria-labelledby="pills-logout-tab">
                                <div class="card text-center w-50 offset-lg-3">
                                    <div class="card-header h5 bg-warning text-white">
                                        Bạn muốn đăng xuất tài khoản?
                                    </div>
                                    <div class="card-body d-flex justify-content-around">
                                        <a class="btn btn-success w-25" href="">Có</a>
                                        <a class="btn bg-danger w-25 text-white" href="">Không</a>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="tab-pane fade" id="pills-status" role="tabpanel"
                                aria-labelledby="pills-status-tab">
                                <div class="container">
                                    <article class="card">
                                        <div class="card-body">
                                            
                                                <div class="dropdown mb-3">
                                                    <button class="btn btn-warning h5 dropdown-toggle text-white" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                      XEM TÌNH TRẠNG ĐƠN HÀNG
                                                    </button>
                                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                      <a class="dropdown-item" href="#">OD45345345435</a>
                                                      <a class="dropdown-item" href="#">OD45345345436</a>
                                                      <a class="dropdown-item" href="#">OD45345345437</a>
                                                    </div>
                                                </div>
                                                <hr>
                                            
                                            <h6>MÃ ĐƠN HÀNG: OD45345345435</h6>
                                            <article class="card">
                                                <div class="card-body row text-center">
                                                    <div class="col"> <strong>Dự kiến giao hàng:</strong> <br>Thứ 5, 17/03/2022</div>
                                                    <div class="col"> <strong>Đơn vị vận chuyển:</strong> <br> BLUEDART, | <i class="fa fa-phone"></i> +1598675986 </div>
                                                    <div class="col"> <strong>Trạng thái:</strong> <br>Bàn giao cho đơn vị vận chuyển</div>
                                                    
                                                </div>
                                            </article>
                                            <div class="track">
                                                <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Nhận đơn hàng</span> </div>
                                                <div class="step active"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text">Bàn giao cho đơn vị vận chuyển</span> </div>
                                                <div class="step"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text">Đang giao hàng</span> </div>
                                                <div class="step"> <span class="icon"> <i class="fa fa-box"></i> </span> <span class="text"></span>Đã giao hàng</div>
                                            </div>
                                            
                                            <hr> <a href="#" class="btn btn-warning text-white float-right my-3" data-abc="true"> Chi tiết đơn hàng</a>
                                        </div>
                                    </article>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="pills-history" role="tabpanel"
                                aria-labelledby="pills-history-tab">
                                <div class="container bootdey  bg-white">
                                    <div class="panel panel-default panel-order">
                                        <div class="panel-heading pt-3 mb-5">
                                            <span class="h5 font-weight-bold">LỊCH SỬ</span>
                                            <div class="btn-group float-right">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">Lọc<i class="fa fa-filter"></i></button>
                                                    <ul class="px-3 dropdown-menu dropdown-menu-right">
                                                        <li><a class="text-black" href="#">Đang xác nhận</a></li>
                                                        <li><a class="text-black" href="#">Đang bàn giao</a></li>
                                                        <li><a class="text-black" href="#">Đang giao hàng</a></li>
                                                        <li><a class="text-black" href="#">Đã giao</a></li>
                                                        <li><a class="text-black" href="#">Đã hủy</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-2"><img src="https://images.unsplash.com/photo-1561909848-977d0617f275?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c2hvZXxlbnwwfDJ8MHx8&auto=format&fit=crop&w=500&q=60" class="media-object img-thumbnail" /></div>
                                                <div class="col-md-10">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="float-right"><label class="badge badge-pills badge-danger">Đã hủy</label></div>
                                                            <span><strong>MÃ ĐƠN: OD45345345435</strong></span><br/>
                                                            Tổng sản phẩm : 2<br />
                                                            <span>Giá: $323.13 </span><br>
                                                            
                                                        </div>
                                                        <div class="col-md-12">Ngày đặt: 17/03/2022</div>
                                                    </div>
                                                </div>
                                            </div>
                                
                                            <div class="row">
                                                <div class="col-md-2"><img src="https://images.unsplash.com/photo-1500063925588-751f924d7c80?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHNob2V8ZW58MHwyfDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" class="media-object img-thumbnail" /></div>
                                                <div class="col-md-10">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="float-right"><label class="badge badge-secondary">Đang xác nhận</label></div>
                                                            <span><strong>MÃ ĐƠN: OD45345345435</strong></span><br/>
                                                            Tổng sản phẩm : 2<br />
                                                            <span>Giá: $323.13 </span><br>
                                                        </div>
                                                        <div class="col-md-12">Ngày đặt: 17/03/2022</div>
                                                    </div>
                                                </div>
                                            </div>
                                
                                            <div class="row">
                                                <div class="col-md-2"><img src="https://images.unsplash.com/photo-1529810313688-44ea1c2d81d3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8c2hvZXxlbnwwfDJ8MHx8&auto=format&fit=crop&w=500&q=60" class="media-object img-thumbnail" /></div>
                                                <div class="col-md-10">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="float-right"><label class="badge badge-warning">Đang giao</label></div>
                                                            <span><strong>MÃ ĐƠN: OD45345345435</strong></span><br/>
                                                            Tổng sản phẩm : 2<br />
                                                            <span>Giá: $323.13 </span><br>
                                                        </div>
                                                        <div class="col-md-12">Ngày đặt: 17/03/2022</div>
                                                    </div>
                                                </div>
                                            </div>
                                
                                            <div class="row">
                                                <div class="col-md-2"><img src="https://images.unsplash.com/photo-1580813162079-12db984b0952?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fHNob2V8ZW58MHwyfDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" class="media-object img-thumbnail" /></div>
                                                <div class="col-md-10">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="float-right"><label class="badge badge-success">Đã giao</label></div>
                                                            <span><strong>MÃ ĐƠN: OD45345345435</strong></span><br/>
                                                            Tổng sản phẩm : 2<br />
                                                            <span>Giá: $323.13 </span><br>
                                                        </div>
                                                        <div class="col-md-12">Ngày đặt: 17/03/2022</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                       
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="pills-logout" role="tabpanel"
                                aria-labelledby="pills-logout-tab">
                                <div class="card text-center w-50 offset-lg-3">
                                    <div class="card-header h5 bg-warning text-white">
                                        Bạn muốn đăng xuất tài khoản?
                                    </div>
                                    <div class="card-body d-flex justify-content-around">
                                        <a class="btn btn-success w-25" href="">Có</a>
                                        <a class="btn bg-danger w-25 text-white" href="">Không</a>
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
    <!-- Shop End -->
</main>

 <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

<!-- Footer -->
<%@include file="/WEB-INF/views/shop/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/shop/include/jsLib.jsp"%>
<!-- JS Lib End -->

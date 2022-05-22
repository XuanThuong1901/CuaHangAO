<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->

<main>
<!-- Carousel Start -->
    <div class="container-fluid mb-3">
        <div class="row px-xl-5">
            <div class="col-lg">
                <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#header-carousel" data-slide-to="1"></li>
                        <li data-target="#header-carousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item position-relative active" style="height: 430px;">
                            <img class="position-absolute w-100 h-100" src="https://stefano.vn/wp-content/uploads/2020/04/vest-nam-v69k4-01.jpg"
                                style="object-fit: cover;">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h1 class="text-uppercase display-4 text-white mb-3 animate__animated animate__fadeInDown">Nam</h1>
                                    <p class="mx-md-5 px-5 animate__animated animate__bounceIn"></p>
                                    <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                        href="sanpham">MUA NGAY</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item position-relative" style="height: 430px;">
                            <img class="position-absolute w-100 h-100" src="https://thoitrangteenthienphuc.vn/upload/sanpham/o-hoodie-ni-ngoai-in-ufo,-mac-mua-he-bao-mat-7808.jpg"
                                style="object-fit: cover;">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h1 class="text-uppercase display-4 text-white mb-3 animate__animated animate__fadeInDown">Nữ</h1>
                                    <p class="mx-md-5 px-5 animate__animated animate__bounceIn"></p>
                                    <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                        href="sanpham">MUA NGAY</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item position-relative" style="height: 430px;">
                            <img class="position-absolute w-100 h-100" src="https://salt.tikicdn.com/cache/400x400/ts/product/38/df/17/a9dbcb90ede74cc86a994d2f13ab8d0d.jpg"
                                style="object-fit: cover;">
                            <div class=" carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    <h1 class="text-uppercase display-4 text-white mb-3 animate__animated animate__fadeInDown">MISSOUT</h1>
                                    <p class="mx-md-5 px-5 animate__animated animate__bounceIn"></p>
                                    <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                        href="sanpham">MUA NGAY</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>
    </div>
    <!-- Carousel End -->

        <!-- Offer Start -->
        <div class="container-fluid pt-5 pb-3">
            <div class="row px-xl-5">
                <div class="col-md-6">
                    <div class="product-offer mb-30" style="height: 300px;">
                        <img class="img-fluid" src="https://cf.shopee.vn/file/f80f7a3482757e099911e1e067d920d2" alt="">
                        <div class="offer-text">
                            <h5 class="text-white text-uppercase">Tiết kiệm 20%</h5>
                            <h1 class="text-white mb-3">Mua từ 2 sản phẩm</h1>
                            <a href="sanpham" class="btn btn-danger">MUA NGAY</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="product-offer mb-30" style="height: 300px;">
                        <img class="img-fluid" src="https://bizweb.dktcdn.net/100/287/440/products/ao-hoodie-co-non-mau-xam-nu.jpg?v=1609755827503" alt="">
                        <div class="offer-text">
                            <h5 class="text-white text-uppercase">ƯU ĐÃI ĐẶC BIỆT</h5>
                            <h1 class="text-white text-center mb-3"><span>Áp dụng đối với</span><br><span>tài khoản mới</span></h1>
                            <a href="sanpham" class="btn btn-danger">MUA NGAY</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Offer End -->

    <!-- Featured Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-dark mb-4" style="padding: 30px; border-radius: 10px;">
                    <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0 text-white">Sản phẩm chất lượng</h5>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-dark mb-4" style="padding: 30px; border-radius: 10px;">
                    <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                    <h5 class="font-weight-semi-bold m-0 text-white">Vận chuyển nhanh chóng</h5>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                <div class="d-flex align-items-center bg-dark mb-4" style="padding: 30px; border-radius: 10px;">
                    <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                    <h5 class="font-weight-semi-bold m-0 text-white">Trợ giúp 24/7</h5>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured End -->


   
    <div class="container-fluid bg-primary p-5">
        <h3 class="text-dark text-center">ĐĂNG KÝ NGAY ĐỂ NHẬN THÔNG BÁO MỚI NHẤT</h3>
        <form action="url" class="d-flex justify-content-center">
            <input class="border-0 col-md-6 p-2 text-dark" type="text" name="number" value="email@gmail.com">
            <input class="bg-dark border-0 px-3 text-white" type="submit" value="ĐĂNG KÝ">
        </form>
    </div>

    <!-- Vendor Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel vendor-carousel">
                    <div class="bg-light p-4">
                        <img src="https://play-lh.googleusercontent.com/eLqKK4MkDoXXbD_F3A_2rs-othxTESxbocvyOGyhAmbNCydgnYKczItIY2-HLYJmhr6Q" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://cdn.freebiesupply.com/logos/large/2x/vans-3-logo-png-transparent.png" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="http://assets.stickpng.com/images/5a314c97cb9a85480a628f80.png" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://cdn-icons-png.flaticon.com/512/731/731962.png" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://www.daihoabinhduong.com/gallery_gen/81715b136d71136f634849c37205a00b_250x250.png" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://cdn.freebiesupply.com/logos/large/2x/new-balance-2-logo-png-transparent.png" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://i.pinimg.com/originals/81/6a/dc/816adc875959202114a14701cd78b434.jpg" alt="">
                    </div>
                    <div class="bg-light p-4">
                        <img src="https://images-na.ssl-images-amazon.com/images/S/abs-image-upload-na/0/AmazonStores/A1F83G8C2ARO7P/ad2d117171af36589e9fba34c36367ed.w400.h400.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Vendor End -->

 
</main>

 <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

<!-- Footer -->
<%@include file="/WEB-INF/views/shop/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/shop/include/jsLib.jsp"%>
<!-- JS Lib End -->

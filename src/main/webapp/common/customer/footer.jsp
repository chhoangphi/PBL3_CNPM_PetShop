<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">PETSHOP</span></h1>
                </a>
                <p></p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>57 Nguyễn Lương Bằng, Hòa Khánh Bắc, Liên Chiểu, Đà Nẵng</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>petshop.hpp@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>0788339999</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5" style=" padding-left:100px;">
                        <h5 class="font-weight-bold text-dark mb-4">Danh mục mua sắm</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href='<c:url value="/san-pham?shop=item01"/>'><i class="fa fa-angle-right mr-2"></i>Shop cho Chó</a>
                            <a class="text-dark mb-2" href="<c:url value="/san-pham?shop=item02"/>"><i class="fa fa-angle-right mr-2"></i>Shop cho Mèo</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5" style=" padding-left:100px;">
                        <h5 class="font-weight-bold text-dark mb-4">Thông tin PetShop</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href='<c:url value="/gioi-thieu"/>'><i class="fa fa-angle-right mr-2"></i>Về chúng tôi</a>
                            <a class="text-dark mb-2" href="https://zalo.me/84377382067"><i class="fa fa-angle-right mr-2"></i>Liên hệ</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5" style=" padding-left:100px;">
                        <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                        <form action="">
                            <div class="form-group">
                                <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                    required="required" />
                            </div>
                            <div>
                                <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->
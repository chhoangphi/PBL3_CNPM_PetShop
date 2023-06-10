<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Về chúng tôi</title>
<style>
/* body {
    font-family: 'Roboto';font-size: 16px;
} */

.aboutus-section {
    padding: 90px 0;
}
.aboutus-title {
    font-size: 30px;
    letter-spacing: 0;
    line-height: 32px;
    margin: 0 0 39px;
    padding: 0 0 11px;
    position: relative;
    text-transform: uppercase;
    color: #000;
}
.aboutus-title::after {
    background: #fdb801 none repeat scroll 0 0;
    bottom: 0;
    content: "";
    height: 2px;
    left: 0;
    position: absolute;
    width: 54px;
}
.aboutus-text {
    color: #606060;
    font-size: 13px;
    line-height: 22px;
    margin: 0 0 35px;
}

a:hover, a:active {
    color: #ffb901;
    text-decoration: none;
    outline: 0;
}
.aboutus-more {
    border: 1px solid #fdb801;
    border-radius: 25px;
    color: #fdb801;
    display: inline-block;
    font-size: 14px;
    font-weight: 700;
    letter-spacing: 0;
    padding: 7px 20px;
    text-transform: uppercase;
}
.feature .feature-box .iconset {
    background: #fff none repeat scroll 0 0;
    float: left;
    position: relative;
    width: 18%;
}
.feature .feature-box .iconset::after {
    background: #fdb801 none repeat scroll 0 0;
    content: "";
    height: 150%;
    left: 43%;
    position: absolute;
    top: 100%;
    width: 1px;
}

.feature .feature-box .feature-content h4 {
    color: #0f0f0f;
    font-size: 18px;
    letter-spacing: 0;
    line-height: 22px;
    margin: 0 0 5px;
}


.feature .feature-box .feature-content {
    float: left;
    padding-left: 28px;
    width: 78%;
}
.feature .feature-box .feature-content h4 {
    color: #0f0f0f;
    font-size: 18px;
    letter-spacing: 0;
    line-height: 22px;
    margin: 0 0 5px;
}
.feature .feature-box .feature-content p {
    color: #606060;
    font-size: 13px;
    line-height: 22px;
}
.icon {
    color : #f4b841;
    padding:0px;
    font-size:40px;
    border: 1px solid #fdb801;
    border-radius: 100px;
    color: #fdb801;
    font-size: 28px;
    height: 70px;
    line-height: 70px;
    text-align: center;
    width: 70px;
}
}
</style>
</head>
<body>

<div class="aboutus-section">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="aboutus">
                        <h2 class="aboutus-title">About Us</h2>
                        <p class="aboutus-text">Chào mừng bạn đến với PetShop! Chúng tôi tự hào giới thiệu đội ngũ nhân viên và quản lý của chúng tôi.</p>
                        <p class="aboutus-text">Tại PetShop, chúng tôi cam kết mang đến những trải nghiệm tuyệt vời cho bạn và thú cưng của bạn. Chúng tôi cung cấp các sản phẩm chất lượng cao, dịch vụ chăm sóc tận tâm và tư vấn chuyên nghiệp. Hãy đến với chúng tôi và trải nghiệm một môi trường thân thiện và chuyên nghiệp dành cho thú cưng của bạn.</p>
                        <a class="aboutus-more" href="#">read more</a>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="aboutus-banner">
                        <img src="https://i.imgur.com/UHGzsC4.png" alt="">
                    </div>
                </div>
                <div class="col-md-5 col-sm-6 col-xs-12" style="padding-left: 240px">
                    <div class="feature">
                        <div class="feature-box">
                            <div class="clearfix">
                                <div class="iconset">
                                    <span class="glyphicon glyphicon-cog icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h4>Hoàng Phi</h4>
                                    <p>Hoàng Phi là một người đam mê yêu thú và đã có hơn 2 năm kinh nghiệm làm việc trong lĩnh vực chăm sóc thú cưng. Với kiến thức sâu rộng và tình yêu vô bờ bến dành cho các loài vật, Phi luôn đảm bảo rằng PetShop cung cấp những sản phẩm và dịch vụ tốt nhất cho thú cưng của bạn.</p>
                                </div>
                            </div>
                        </div>
                        <div class="feature-box">
                            <div class="clearfix">
                                <div class="iconset">
                                    <span class="glyphicon glyphicon-cog icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h4>Trọng Hiếu</h4>
                                    <p>Trọng Hiếu là một nhân viên bán hàng nhiệt tình và am hiểu về thú cưng. Với niềm đam mê chăm sóc và tư vấn cho khách hàng, Hiếu sẽ luôn đưa ra những lời khuyên tận tâm để bạn có thể chăm sóc thú cưng một cách tốt nhất.</p>
                                </div>
                            </div>
                        </div>
                        <div class="feature-box">
                            <div class="clearfix">
                                <div class="iconset">
                                    <span class="glyphicon glyphicon-cog icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h4>Phú Phước</h4>
                                    <p>Phú Phước có tình yêu mãnh liệt đối với thú cưng và có kinh nghiệm rộng lớn trong việc chăm sóc các loài vật. Với sự am hiểu và tận hưởng thời gian cùng thú cưng, Phước sẽ đảm bảo rằng các loài vật được chăm sóc một cách chu đáo và an lành trong môi trường PetShop.
									</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <link rel="stylesheet" href="assets/css/movie.css">
   <!-- Link Swiper's CSS -->
   <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
 
<style type="text/css">
.cgv_ad_top {
position: relative;
width: 980px;
height: 80px;
margin: 0 auto;
}




</style>




<title>Insert title here</title>
</head>
<body>

<div class="cgv_ad_top" align="center">
        <a href="http://ad.cgv.co.kr/click/CGV/CGV_201401/main@TopBar_EX?ads_id=46534&amp;creative_id=66053&amp;click_id=86349&amp;content_series=&amp;maid=&amp;event=" target="_blank">
            <!--배너이미지 경로-->
            <img  src="https://adimg.cgv.co.kr/images/202202/THEPEOPLE/980x80.jpg" alt="인민을 위해 복무하라" border="0">
        </a>
        <a href="#" class="btn_ad_close" id="btn_ad_close" onclick="parent.closeBanner()">
            <!--배너 닫기 이미지 경로-->
            <img src="https://img.cgv.co.kr/sample/2015/ad_main_top/btn_ad_close.png" alt="닫기" border="0">
        </a>
    </div>
    
<!-- 로고 헤더 -->
<div class="header">

	<div class="header_content">
	<div class="contents" >
	<h1>
		<a href="/main.do">
		<img width="200" height="80" alt="movie" src="${contextPath}/assets/img/logo.jpeg">
		</a>	
		<span>&nbsp;&nbsp;MOVIE</span>
	</h1>
	
	<ul class="memberInfo_wrap">
	
<c:choose>
    
    <c:when test="${sessionScope.login == null}">
	<li>
	<a href="/login.do">
	<img src="${contextPath}/assets/img/loginPassword.png" alt="로그인">
	<span>로그인</span>
	</a>
	</li>
	</c:when>
	
	<c:otherwise>
	<li>
      <div class="btn_logout" align="right">
        <strong> ${sessionScope.memberName} </strong>님이 로그인중입니다.
    	</div>
	<li>
	<li>
    	<a href="/logout.do">
	<img src="${contextPath}/assets/img/로그아웃.png" alt="로그아웃">
	<span>로그아웃</span>
	</a>
	</li>
    </c:otherwise>
    
</c:choose>
	
	
	
	
	<li>
	<a href="">
	<img src="${contextPath}/assets/img/loginJoin.png" alt="회원가입">
	<span>회원가입</span>
	</a>
	</li>
	
	<li>
	<a href="">
	<img src="${contextPath}/assets/img/loginMember.png" alt="My movie">
	<span>My movie</span>
	</a>
	</li>
	
	<li>
	<a href="">
	<img src="${contextPath}/assets/img/loginCustomer.png" alt="고객 센터">
	<span>고객 센터</span>
	</a>
	</li>
	</ul>
	
	
	
	</div>
</div>
</div>




</body>
</html>
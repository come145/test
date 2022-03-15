<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="assets/css/movie.css">
  <link rel="stylesheet" href="assets/css/login.css">

 <script type="text/javascript" src="assets/js/jquery-1.10.2.min.js"></script>

</head>
<body>


<div id="contaniner" class=""><!-- 벽돌 배경이미지 사용 시 class="bg-bricks" 적용 / 배경이미지가 없을 경우 class 삭제  -->
        

		<!-- Contents Area -->
		 <div id="contents" class="">
        
            <!-- Contents Start -->
  <div class="parent clearfix" >
    <div class="bg-illustration"  >

      <div class="burger-btn">
        <span></span>
        <span></span>
        <span></span>
      </div>

    </div>
    
    <div class="login">
      <div class="container" align="center">
        <h1>로그인<br />(Login)</h1>
    
        <div class="login-form">
          <form action="/loginCheck.do" method="post">
            <input type="text"  name="memberId" placeholder="아이디를 입력해주세요.">
            <input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요.">
			
			<br>
			
            <div class="remember-form" align="left">
              <input type="checkbox">
              <span>Remember me</span>
            </div>

            <button type="submit">LOG-IN</button>

         </form>
        </div>
    
      </div>
      </div>
  </div>
            
            <!--/ Contents End -->
		 </div>
		<!-- /Contents Area -->
	</div>


<script src="/assets/js/login.js"></script>


</body>
</html>
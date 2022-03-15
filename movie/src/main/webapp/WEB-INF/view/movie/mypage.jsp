         <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head> 
    
    <script src="assets/js/main.js"></script>
    <meta id="ctl00_og_image" property="og:image" content="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84949/84949_185.jpg"></meta>
    <link rel="alternate" href="http://m.cgv.co.kr" />
    <link rel="shortcut icon" href="https://img.cgv.co.kr/theater_img/favicon.ico" type="image/x-icon" />
    <title id="ctl00_headerTitle">[스파이더맨-노 웨이 홈]&lt;</title>
    <link rel="shortcut icon" type="image/x-icon" href="https://img.cgv.co.kr/R2014/images/favicon.ico" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/webfont.css" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/reset.css" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/layout.css" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/module.css?20211209" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/content.css" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/common.css" />
    
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/eggupdate.css" />
    <link rel="stylesheet" media="print" type="text/css" href="https://img.cgv.co.kr/R2014/css/print.css" />    
    <link rel="stylesheet" type="text/css" href="https://img.cgv.co.kr/R2014/js/jquery.ui/smoothness/jquery-ui-1.10.4.custom.min.css" />
    
  
   
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/phototicket/phototicket.css" />
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/slick.css" />
	<link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/slick-theme-custom.css" />

    <link rel="stylesheet" type="text/css" href="https://img.cgv.co.kr/R2014/js/icheck/iCheck.css" />

    <!-- 2020.05.07 감정지수/프리에그 프로젝트 추가 -->
    <link rel="stylesheet" media="all" type="text/css" href="https://img.cgv.co.kr/R2014/css/preegg.css" />


<style>

button{
	width:120px;
	height: 40px;
	color:#fff;
	background: #004fff;
	font-size: 16px;
	border:none;
	border-radius: 20px;
	box-shadow: 0 4px 16px rgba(0,79,255,0.3);
	transition:0.3s;
	position: absolute;
	left:90%;
	transform: translate(-50%,-50%);
}
button:focus {
	outline:0;
}
button:hover{
	background: #FF0000;
	cursor: pointer;
	box-shadow: 0 2px 4px rgba(0,79,255,0.6);
}


</style>


<script>

function deleted(){

		  if (confirm("예매를 취소하시겠습니까?")) {

				location.href="delete.do";
	            alert("예매가 취소되었습니다");
	      
				  } else {
  
	        }
		} 


</script>



</head>
<body>

	<!-- E Header -->

	<!-- Contaniner -->
	<div id="contaniner"  class=""><!-- 벽돌 배경이미지 사용 시 class="bg-bricks" 적용 / 배경이미지가 없을 경우 class 삭제  -->
        

		<!-- Contents Area -->
		 <div id="contents" class="">
        
            
            <!-- Contents Start -->
			
<div class="tit-heading-wrap">
    <h3>예매가 완료되었습니다</h3>
</div>

<br></br>
<div class="sect-base-movie">
    <h3><strong>${movie.title}</strong>기본정보</h3>
    <div class="box-image">
            <span class="thumb-image"> 
                <img src="${img}" alt="스파이더맨-노 웨이 홈 포스터 새창" onerror="errorImage(this)"/>
                <span class="ico-grade grade-12">${movie.movieAge} 세 이상</span>
            </span> 
    </div>
  
    <div class="box-contents">
        <div class="title"> 
            <strong>${movie.title} (${movie.runningTime}) <img src="/assets/img/${movie.movieAge}.png" alt="12세 이상세"></img></strong> 
                 <div align="right"><button id="btn1" onclick="deleted()">예 매 취 소</button> </div>
     
                                          
 <!--             <em class="round lightblue"><span>현재상영중</span></em> -->
 <!-- 
 
 	티겟번호,
 	영화이름,
 	예매한 자리,
 	예매한 영화 시작 시간,
 	예매한 영화관
 	예매한 사람 이름
 	예매한 사람 아이디
 	예매한 영화 연령제한
 	영화 결제비용,
	결제시간,
 	
  -->           
            
            <p>예 매 번 호 : ${movie.ticketNumber}</p>
        </div>
        <div class="score"> 
            <strong class="percent">결 제 금 액&nbsp;&nbsp;&nbsp;<span style="color: red; font-size: 20px; font-weight: bold " >${movie.payMoney} 원</span></strong>
         
        </div>
    
        <!-- 떨어지는 얘 이전 요소에 class=on을 넣는다 -->
        <div class="spec">
            <dl>
                <dt><strong>극 장 :</strong>&nbsp;&nbsp;&nbsp;</dt>
                <dd>
                        ${movie.selectedTheater}                    
                </dd>
              </dl> 
               
       		<dl>  
                <dt ><strong>좌 석 정 보 :</strong>&nbsp;&nbsp;&nbsp;</dt>
                <dd>
                    <div>${movie.selectedSeat} 번</div>                    
                </dd>
            </dl>
            
            <dl>  
                <dt ><strong> 인 원 :</strong>&nbsp;&nbsp;&nbsp;</dt>
                <dd>
                    <div>${movie.moviePeople} 명</div>                    
                </dd>
            </dl>
            
            <dl>  
                <dt ><strong>상 영 시 간 :</strong>&nbsp;&nbsp;&nbsp;</dt>
                <dd>
                  <div> <fmt:formatDate pattern="yy-MM-dd hh:mm" 
                  value="${movie.reserveDate}"/>  ~  ${today} &nbsp; </div>        
                </dd>
            </dl>
            
            
            
            <dl>  
                <dt ><strong>결 제 시 간 :</strong>&nbsp;&nbsp;&nbsp;</dt>
                <dd>
                  <div> <fmt:formatDate pattern="yyyy년 MM월 dd일 hh:mm:ss" 
                  value="${movie.payDate}"/> &nbsp; </div>        
                </dd>
            </dl>
             
             
        </div>
            
        
        </div>
        </div>
        </div>
        </div>
        
</body>
</html>
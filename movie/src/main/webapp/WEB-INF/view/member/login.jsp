<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

.tab-menu-round {
clear: both;
background: url('../img/bg_tabmenu_grade.gif') 0 bottom repeat-x;
}

.tab-menu-round > li {
line-height: 37px;
color: #fdfcf0;
text-align: center;
}

.tab-menu-round > li > a {
display: block;
color: #ffffff;
font-size: 13px;
font-weight: 500;
}


</style>





<script type="text/javascript">



const date = new Date();
//console.log(date.getFullYear());
const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
const reserveDate = document.querySelector('.reserve-date'); //날짜
const theaterPlace = document.querySelectorAll('.theater-place'); // 지역
const reserveTimeWant = document.querySelectorAll('.reserve-time-want'); // 시간
const inputTitle = document.querySelector('.title'); // 영화제목
const inputSelectedTheater = document.querySelector('.selectedTheater'); //선택 좌석
const inputReserveDate = document.querySelector('.reserveDate'); //영화시작시간
const inputRunningTime = document.querySelector('.runningTime'); //영화상영시간
const moveSeatForm = document.querySelector('.moveSeatForm'); // hidden(title, movieAge, selectedTheater, movieDate, runningTime)
const moveSeatButton = document.querySelector('.moveSeatButton');  //예약하기
const movieAge = document.querySelector('.movieAge'); // 영화관람나이

let movieListAge = '';
let year = 0;
let month = 0;
add();
		// addEventLisnet = 이벤트 등록(여러개의 이벤트 핸들러를 등록가능)
document.addEventListener('DOMContentLoaded', () => {
 add();
 addDate();
});

//데이터 가져오기
function add() {
 $.ajax({
     url: 'crawling.do',
     type: 'get',
     success: function(data) {
         crawlingData = setData(data);
         // console.log(crawlingData);
         // document.querySelector('.movie-list-wrapper').append(crawlingData);
         //            poster.setAttribute('src', crawlingData[randomNumber].img)crawlingData;
         setList(data);
         movieListAge = document.querySelectorAll('.movie-list-age');
			//querySelectorAll =  선택자를 선택하여 비슷한 객체인 nodeList를 반환함
         	//					  반환 객체가 nodeList이기에 for문 또는 forEach문을 사용함
         	//					  해당 요소를 배열로 가져옴
         movieListAge.forEach(li => {
             if (li.innerHTML === '15세 이상') {
                 li.classList.add('fifteen');
             } else if (li.innerHTML === '청소년 관람불가') {
                 li.classList.add('eighteen');
                 li.innerHTML = '청불';
             } else if (li.innerHTML === '전체') {
                 li.classList.add('all');
             }
         });
         if (crawlingData.length === 0) {
             location.href = 'moveReserve.do';
         }
         document.querySelectorAll('.movie-list-title').forEach(li => {
             li.addEventListener('click', function() {
                 const movieListTitleActvie = document.querySelectorAll(
                     '.movie-list-title-active'
                 );
                 movieListTitleActvie.forEach(li => {
                     li.classList.remove('movie-list-title-active');
                 });
                 li.parentNode.classList.add('movie-list-title-active');
                 console.log(li.innerHTML);
                 console.log(li.parentElement);
                 console.log(li.parentElement.childNodes[1].innerHTML);
                 //form에 넘기기 위한
                 movieAge.value = li.parentElement.childNodes[1].innerHTML;
                 inputTitle.value = li.innerHTML;
             });
         });
     },
     error: function() {
         document.querySelector('.movie-list-wrapper').innerHTML =
             '데이터가없습니다 새로고침해주세요';
     },
 });
}


// 받은 날짜를 객체로 변환시키는 함수
function setData(data) {
	data = JSON.parse(data);
		   // json.parse = 인수받은 문자열을 객체로 변환시킴
 return data;
}

function setList(data) {
											// InnerHTML = html에 접근하여 출력문을 바꿈
 document.querySelector('.movie-list-wrapper').innerHTML = JSON.parse(
     data
 ).reduce((html = '', item, index = 0) => {
     html += getMovieList(item);

     
     return html;
 }, ' ');
}

function getMovieList(item) {
 console.log(item);
 return `<div class="movie-list">
 <div class="movie-list-age">${item.movieAge}</div>
 <button class="movie-list-title">${item.movieTitle}</button>
</div>`;
}

function addDate() {
 const weekOfDay = ['일', '월', '화', '수', '목', '금', '토'];
 year = date.getFullYear();  //현재 년도 가져오는 메소드
 month = date.getMonth();    
 reserveDate.append(year + '/' + month);
 for (i = date.getDate(); i <= lastDay.getDate(); i++) {
     const button = document.createElement('button');
     const spanWeekOfDay = document.createElement('span');
     const spanDay = document.createElement('span');

     //class넣기
     button.classList = 'movie-date-wrapper';
     spanWeekOfDay.classList = 'movie-week-of-day';
     spanDay.classList = 'movie-day';

     //weekOfDay[new Date(2020-03-날짜)]
     const dayOfWeek =
         weekOfDay[new Date(year + '-' + month + '-' + i).getDay()];

     //요일 넣기
     if (dayOfWeek === '토') {
         spanWeekOfDay.classList.add('saturday');
         spanDay.classList.add('saturday');
     } else if (dayOfWeek === '일') {
         spanWeekOfDay.classList.add('sunday');
         spanDay.classList.add('sunday');
     }
     spanWeekOfDay.innerHTML = dayOfWeek;
     button.append(spanWeekOfDay);
     //날짜 넣기
     spanDay.innerHTML = i;
     button.append(spanDay);
     //button.append(i);

     reserveDate.append(button);

     dayClickEvent(button);
 }
}

function dayClickEvent(button) {
 button.addEventListener('click', function() {
     const movieDateWrapperActive = document.querySelectorAll(
         '.movie-date-wrapper-active'
     );
     movieDateWrapperActive.forEach(list => {
         list.classList.remove('movie-date-wrapper-active');
     });
     button.classList.add('movie-date-wrapper-active');
     console.log(button.childNodes[1].innerHTML);
     inputReserveDate.value =
         year +
         '.' +
         month +
         '.' +
         button.childNodes[1].innerHTML +
         '(' +
         button.childNodes[0].innerHTML +
         ')';
     console.log(inputReserveDate.value);
 });
}

theaterPlace.forEach(list => {
 list.addEventListener('click', function() {
     const theaterPlaceWrapper = document.querySelectorAll(
         '.theater-place-active'
     );
     theaterPlaceWrapper.forEach(li => {
         li.classList.remove('theater-place-active');
     });
     list.classList.add('theater-place-active');
     console.log(list.innerHTML);
     inputSelectedTheater.value = list.innerHTML;
 });
});

reserveTimeWant.forEach(list => {
 list.addEventListener('click', function() {
     const reserveTimeActive = document.querySelectorAll('.reserve-time-active');
     reserveTimeActive.forEach(li => {
         li.classList.remove('reserve-time-active');
     });
     list.classList.add('reserve-time-active');
     console.log(list.innerHTML);
     inputRunningTime.value = list.innerHTML;
 });
});

moveSeatButton.addEventListener('click', function() {
 if (!!inputTitle.value &&
     !!inputSelectedTheater.value &&
     !!inputReserveDate.value &&
     !!inputRunningTime.value
 ) {
     moveSeatForm.submit();
 } else {
     toastr.options = {
         positionClass: 'toast-top-full-width',
         progressBar: true,
         timeOut: 1000,
     };
     toastr.error(
         '<div style="color:white">모든 항목을 체크해 주세요</div>',
         '<div style="color:white">경고</div>', {
             timeOut: 3000,
         }
     );
 }
});






</script>







<title>Insert title here</title>
</head>
<body>

<ul class="tab-menu-round">
            <li class="on">
                <a href="/user/login/">로그인</a>
            </li>
            <li>
                <a href="/user/guest/login-agreement.aspx">비회원 예매</a>
            </li>
            <li>
                <a href="/user/guest/login.aspx">비회원 예매확인</a>
            </li>
</ul>

</body>
</html>
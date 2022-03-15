<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
    
    
    <div style="text-align: left;"> 
     
        <a href="${path}/board/list.action">게시판</a>
        <a href="${path}/list.do">업로드</a>
        <a href="${path}/list.do">업로드(ajax)</a>
        <a href="${path}/shop/cart/list.do">장바구니</a>
        <a href="${path}/shop/list.do">상품목록</a>
	<br>
   	<br>

<!-- 관리자 권한일 경우 -->
<c:if test="${sessionScope.adminId != null }">
    <a href="${path}/shop/product/write.do">상품등록</a> |
</c:if>

<!-- 로그인, 로그아웃 -->
<c:choose>
    <c:when test="${sessionScope.userId == null}">
        <a href="${path}/login.do">로그인</a> |
        <a href="${path}/admin/login.do">관리자 로그인</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.userName}님이 로그인중입니다.
        <a href="${path}/logout.do">로그아웃</a> |
    </c:otherwise>
</c:choose>    
    
    </div>
  
  
   
    <hr>
   
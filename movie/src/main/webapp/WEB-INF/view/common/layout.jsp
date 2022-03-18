<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.movie.vo.MemberVO"%>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");

MemberVO login = (MemberVO)session.getAttribute("login");
if(login!= null) System.out.println(login.toString());

%>

<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width">
<script>
	
</script>
	<title><tiles:insertAttribute name="title" /></title>
	
</head>
<body>
	<div id="outer_wrap">
		<div id="wrap">
			<header>
				   <tiles:insertAttribute name="header" />
			</header>
			
			
	   		<article>
			 	<tiles:insertAttribute name="body" />
			</article>
			
			<footer>
				 	<tiles:insertAttribute name="footer" />
				
			</footer>
	
		</div>
	</div>        	
</body>      
        
        
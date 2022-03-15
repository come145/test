<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <% 
 	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
 %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../view/include/header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%=cp%>/board/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/board/css/list.css" type="text/css" />
<script type="text/javascript">

	function searchData(){
		
		var f = document.searchForm;
		
		f.action = "<%=cp%>/board/list.action";
		f.submit();
		
	}

	


</script>


</head>
<body>
<%@ include file="../view/include/menu.jsp" %>

<div id="bbsList">
	<div id="bbsList_title">
	게시판(Spring2.5)
	</div>
	<div id="bbslist_header">
		<div id="leftHeader">
		
		
		   <form name="form1" method="post" action="${path}/board/list.action">
        <select name="searchOption">
            <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
            <option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >제목+이름+제목</option>
            <option value="writer" <c:out value="${map.searchOption == 'writer'?'selected':''}"/> >이름</option>
            <option value="content" <c:out value="${map.searchOption == 'content'?'selected':''}"/> >내용</option>
            <option value="subject" <c:out value="${map.searchOption == 'subject'?'selected':''}"/> >제목</option>
        </select>
        <input name="keyword" value="${map.keyword}">
		
		        <input type="submit" class = btn2 value="검색">
		
		</form>
		</div>
		<div id="rightHeader" align="right">
			<input type="button" value= " 글올리기 " class="btn2" onclick="javascript:location.href='<%=cp%>/board/created.action';"/>
		</div>
	</div>

	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="writer">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div>
	<div id="lists">
	<c:forEach var="dto" items="${map.list }">
			<dl>
				<dd class="num">${dto.num }</dd>
				<dd class="subject">
				<a href="${urlArticle}/board/article.action?num=${dto.num}">
				
				${dto.subject }</a></dd>
				<dd class="writer">${dto.writer }</dd>
				<dd class="created">${dto.created}</dd>
				<dd class="hitCount">${dto.hitCount }</dd>
			</dl>
	</c:forEach>
		</div>
		<div id="footer">
			<c:if test="${totalDataCount!=0 }">
				${pageIndexList }
			</c:if>	
			<c:if test="${totalDataCount==0 }">
				등록된 게시물이 없습니다
			</c:if>
		</div>	
	</div>
</div>

</body>
</html>
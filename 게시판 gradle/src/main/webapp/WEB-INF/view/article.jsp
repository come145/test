<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <% request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%=cp%>/board/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/board/css/article.css" type="text/css" />
<script type="text/javascript">



	

</script>

</head>
<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판(Spring2.5)
	</div>
	<div id="bbsArticle">
		<div id="bbsArticle_header">
		${dto.subject }
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>				
				<dd>
				${dto.writer }
				<c:if test="${!empty dto.email }">
				(<a href="mailto:${dto.email }">${dto.email }</a>)
				</c:if>
				</dd>
				<dt>아이디</dt>
				<dd></dd>
			</dl>
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${dto.created }</dd>
				<dt>조회수</dt>
				<dd>${dto.hitCount }</dd>
			</dl>
		</div>
		<div id="bbs_article_content">
			<table width="600" border="0">
			<tr>
			
			<td style="padding-left: 20px 80px 20px 62px;" valign="top" height="200">
			${dto.content }
			</td>
			</table>		
		</div>
		<div class="bbsArticle_bottomLine">
		이전글:
		<c:if test="${!empty preSubject }">
		<a href="<%=cp%>/sbbs/article.action?${params}&boardNum=${preBoardNum}">
		${preSubject }
		</a>
		</c:if>
		</div>
		
		<div class="bbsArticle_bottomLine">
		다음글:
		<c:if test="${!empty nextSubject }">
		<a href="<%=cp%>/sbbs/article.action?${params}&boardNum=${nextBoardNum}">
		${nextSubject }
		</a>
		</c:if>
		</div>
		
	</div>

	<div id="bbsArticle_footer">
			<div id="leftFooter">
				<input type="button" value=" 수정 " class="btn2" onclick="javascript:location.href='<%=cp%>/board/updated.action?num=${dto.num}'"/>
				<input type="button" value=" 삭제 " class="btn2" 	onclick="javascript:location.href='<%=cp%>/board/deleted.action?num=${dto.num}'"/>

			</div>
			<div id="rightFooter">
				<input type="button" value=" 리스트 " class="btn2" onclick="javascript:location.href='<%=cp%>/board/list.action?${params }';"/>
			</div>
		</div>
	</div>


</body>
</html>
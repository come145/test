<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%=cp%>/board/css/style.css"
	type="text/css" />
<link rel="stylesheet" href="<%=cp%>/board/css/created.css"
	type="text/css" />

<script type="text/javascript" src="<%=cp%>/board/js/util.js"></script>

<script type="text/javascript">


	function sendIt(){
		
		f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		
		if(!str){
			
			alert("\n제목을 입력하세요.");
			f.subject.focus();
			return;	
		}	
		f.subject.value = str;
		
		
		
		
	
	str = f.name.value;
	str = str.trim();
	
	if(!str){
		
		alert("\n이름을 입력하세요.");
		f.name.focus();
		return;	
	}	
	f.name.value = str;
	
	/* if(!isValidKorean(str)){
		alert("\n이름을 정확히 입력하세요.");
		f.name.focus();
		return;
	} */
	
	
	
	
	if(f.email.value){
		
		if(!isValidEmail(f.email.value)){
			alert("\n정상적인 이메일을 입력하세요.");
			f.email.focus();
			return;
		}
		
		
	}
	
	str = f.content.value;
	str = str.trim();
	
	if(!str){
		
		alert("\n내용을 입력하세요.");
		f.content.focus();
		return;	
	}	
	f.content.value = str;
	
	
	


	str = f.pwd.value;
	str = str.trim();

	if(!str){
	
		alert("\n패스워드을 입력하세요.");
		f.pwd.focus();
		return;	
}	
	f.pwd.value = str;

	if(f.mode.value=="insert")
		f.action = "<%=cp%>/sbbs/created.action";
	else
		f.action = "<%=cp%>/sbbs/updated.action";
	f.submit();
	


}

</script>



</head>
<body>


<div id="bbs">
	<div id="bbs_title">
	게시판	
	</div>

	<form action=""method="post" name="myForm">
		<div id="bbsCreated">
			<div class="bbsCreated_bottomLine">
				<dl>
					<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
					<dd>
						<input type="text" name ="subject" size="74" value="${dto.subject }" maxlength="100" class="boxTF"/>
					</dd>
				</dl>
		    </div>
			
			<div class="bbsCreated_bottomLine">
				<dl>
					<dt>작성자</dt>
					<dd>
						<input type="text" name ="name" size="35" value="${dto.name }" maxlength="20" class="boxTF"/>
					</dd>
				</dl>
		    </div>
		    
		    <div class="bbsCreated_bottomLine">
				<dl>
					<dt>E-Mail</dt>
					<dd>
						<input type="text" name ="email" size="35" value="${dto.email }" maxlength="50" class="boxTF"/>
					</dd>
				</dl>
		    </div>
		
		<div id="bbsCreated_content">
				<dl>
					<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
					<dd>
						<textarea rows="12" cols="63" name="content" class="boxTA">${dto.content}</textarea>
					</dd>
				</dl>
		    </div>
		
	
		<div class="bbsCreated_noLine">
				<dl>
					<dt>패스워드</dt>
					<dd>
						<input type="password" name ="pwd" size="35" value="${dto.pwd }" maxlength="7" class="boxTF"/>&nbsp;(게시물 수정 및 삭제시 필요!!)
					</dd>
				</dl>
		    </div>
		
	</div>
	
	<div id="bbsCreated_footer">
	
		<input type="hidden" name="mode" value="${mode }"/>
	
		<c:if test="${mode=='update' }">
		<input type="hidden" name="boardNum" value="${dto.boardNum }"/>
		</c:if>
		<input type="hidden" name="pageNum" value="${pageNum }"/>
		
		
		<c:if test="${mode=='insert' }">
		<input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value= "다시입력 " class="btn2" onclick="document.myForm.subject.focus();"/>
		</c:if>
		
		<c:if test="${mode=='update' }">
		<input type="button" value=" 수정하기 " class="btn2" onclick="sendIt();"/>
		</c:if>
		
		<input type="button" value= "작성취소 " class="btn2" onclick="javascript:location.href='<%=cp%>/sbbs/list.action';"/>
		
	</div>
	
	</form>



</div>


</body>
</html>
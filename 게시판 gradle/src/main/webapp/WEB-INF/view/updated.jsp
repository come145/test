<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게 시 판</title>

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
		
		str = f.writer.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.");
			f.writer.focus();
			return;
		}		
		/*
		if(!isValidKorean(str)){			
			alert("\n이름을 정확히 입력하세요.");
			f.name.focus();
			return;
		}
		*/
		f.writer.value = str;
		
		if(f.email.value){
			
			if(!isValidEmail(f.email.value)){
				alert("\n정상적인 E-Mail을 입력하세요.");
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
			alert("\n패스워드를 입력하세요.");
			f.pwd.focus();
			return;
		}
		f.pwd.value = str;
		
		
		f.action = "<%=cp%>/board/updated_ok.action";
		f.submit();
		
	}
</script>
</head>
<body>
<div id="bbs">
	<div id="bbs_title">
	게 시 판(Spring3.0)	
	</div>
	
	<form action="" name="myForm" method="post">
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제    목</dt>
				<dd>
			<input type="text" name="subject" value="${dto.subject }" size="74" maxlength="100" class="boxTF"/>
				</dd>							
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				<input type="text" name="writer" value="${dto.writer }" size="35" maxlength="20" class="boxTF"/>
				</dd>							
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				<input type="text" name="email" value="${dto.email }" size="35" maxlength="50" class="boxTF"/>
				</dd>							
			</dl>		
		</div>
	
		<div id="bbsCreated_content" >
			<dl>
				<dt>내    용</dt>
				<dd>
					<textarea rows="12" cols="63" name="content" class="boxTA">${dto.content }</textarea>
				</dd>							
			</dl>		
		</div>
		
		<div class="bbsCreated_noLine">
			<dl>
				<dt>패스워드</dt>
				<dd>
			<input type="password" name="pwd" value="${dto.pwd }" size="35" maxlength="7" class="boxTF"/>
				</dd>							
			</dl>		
		</div>	
	
	</div>	
	
	<div id="bbsCreated_footer">
	
	<input type="hidden" name="num" value="${dto.num }"/>

	<input type="button" value=" 수정하기 " class="btn2"
	onclick="sendIt();"/>
	
	<input type="button" value=" 수정취소 " class="btn2"
	onclick="javascript:location.href='<%=cp%>/board/list.action';"/>	
	</div>
	
	</form>
	
</div>
</body>
</html>
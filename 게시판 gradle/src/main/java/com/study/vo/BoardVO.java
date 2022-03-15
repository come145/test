package com.study.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	
private int num;  //게시글 번호
	
	  //작성자,비번,이메일,제목,내용,작성일 
private String writer,pwd,email,subject,content,created;
private int hitCount;  //조회수

	
	
}

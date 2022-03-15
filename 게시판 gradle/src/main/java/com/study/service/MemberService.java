package com.study.service;

import javax.servlet.http.HttpSession;

import com.study.vo.MemberVO;

public interface MemberService {

	public boolean loginCheck(MemberVO vo,HttpSession session);
	
	public MemberVO viewMember(MemberVO vo);
	
	
	public void logout(HttpSession session);
	
	
}

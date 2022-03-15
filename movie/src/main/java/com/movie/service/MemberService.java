package com.movie.service;

import javax.servlet.http.HttpSession;

import com.movie.vo.MemberVO;

public interface MemberService {

	
public boolean loginCheck(MemberVO vo, HttpSession session);
	
	public MemberVO viewMember(MemberVO vo);
	
	public void logout(HttpSession session);
	
	public String idCheck(String memberId);
	
	public void memberInsert(MemberVO vo);
	
	
}

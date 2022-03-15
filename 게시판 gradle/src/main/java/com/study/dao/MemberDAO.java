package com.study.dao;

import javax.servlet.http.HttpSession;

import com.study.vo.MemberVO;

public interface MemberDAO {

	
	public boolean loginCheck(MemberVO vo);
	
	public MemberVO viewMember(MemberVO vo);
	
	public void logout(HttpSession session);
	
}

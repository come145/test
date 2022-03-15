package com.movie.dao;

import javax.servlet.http.HttpSession;

import com.movie.vo.MemberVO;

public interface MemberDao {

	
	public boolean loginCheck(MemberVO vo);
	
	public MemberVO viewMember(MemberVO vo);
	
	public void logout(HttpSession session);
	
	public String idCheck(String memberId);
	
	public void memberInsert(MemberVO vo);
	
}

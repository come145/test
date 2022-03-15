package com.movie.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;

	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = session.selectOne("login.loginCheck", vo);
		
		return (name == null)? false : true;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return session.selectOne("login.viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String idCheck(String memberId) {
		// TODO Auto-generated method stub
		return session.selectOne("login.idCheck", memberId);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		session.insert("login.insertMember", vo);
	}
	
	
	
	
	
}

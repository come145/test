package com.study.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	SqlSession sqlsession;

	@Override
	public boolean loginCheck(MemberVO vo) {
		
		
		String name = sqlsession.selectOne("member.loginCheck", vo);
		
		
		return (name == null) ? false : true;
		
		
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("member.viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {
		
		
	}
	
	
	
	
}

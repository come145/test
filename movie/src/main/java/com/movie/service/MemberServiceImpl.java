package com.movie.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MemberDao;
import com.movie.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	
	
	@Autowired
	private MemberDao memberdao;

	@Override
	public boolean loginCheck(MemberVO vo ,HttpSession session) {
		// TODO Auto-generated method stub
		
		boolean result = memberdao.loginCheck(vo);
		
		if(result) {
			
			MemberVO vo2 = viewMember(vo);
			
			session.setAttribute("memberId", vo2.getMemberId());
			session.setAttribute("memberName", vo2.getMemberName());
			
		}
		
		
		
		return result;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberdao.viewMember(vo);
	}

	@Override
	public void logout(HttpSession session) {
		
		session.invalidate();
	}

	@Override
	public String idCheck(String memberId) {
		// TODO Auto-generated method stub
		return memberdao.idCheck(memberId);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		
		memberdao.memberInsert(vo);
	}
	
	
	
	
	
	
}

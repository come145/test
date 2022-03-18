package com.movie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.vo.LikeVO;
import com.movie.vo.ReviewVO;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	
	@Autowired
	private SqlSession session;

	@Override
	public List<ReviewVO> list(int seq) {
		
		
		return session.selectList("review.reviewList", seq);
	}

	@Override
	public void reviewInsert(ReviewVO vo) {
		// TODO Auto-generated method stub
		
		session.insert("review.reviewInsert", vo);
	}

	@Override
	public void reviewDelete(int reviewNumber) {
		
		session.delete("review.reviewDelete", reviewNumber);
	}

	@Override
	public int reviewCount(int seq) {
		// TODO Auto-generated method stub
		return session.selectOne("review.reviewCount", seq);
	}

	@Override
	public void reviewUp(int reviewNumber) {
	
		
		session.update("review.reviewUp", reviewNumber);
	}

	@Override
	public void reviewDown(int reviewNumber) {
	
		
		session.update("review.reviewDown", reviewNumber);
	}

	@Override
	public void insertLike(int reviewNumber, int seq , String memberId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("reviewNumber", reviewNumber);
		map.put("seq", seq);
		
		
		session.insert("review.insertLike",map);
	}

	@Override
	public void deleteLike(int reviewNumber,String memberId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("reviewNumber", reviewNumber);
	
		
		session.delete("review.deleteLike", map);
	}

	@Override
	public int likeCheck(int reviewNumber, String memberId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("reviewNumber", reviewNumber);
	
		
		return session.selectOne("review.likeCheck",map);
	}

	@Override
	public int likeCount(String memberId, int reviewNumber) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("reviewNumber", reviewNumber);
		
		
		return session.selectOne("review.likeCount", map);
	}

	
	
	
	
	
}

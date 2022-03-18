package com.movie.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.ReviewDao;
import com.movie.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{

	
	@Autowired
	private ReviewDao dao;

	@Override
	public List<ReviewVO> list(int seq) {
		// TODO Auto-generated method stub
		return dao.list(seq);
	}

	@Override
	public void reviewInsert(ReviewVO vo) {
		// TODO Auto-generated method stub
		
		dao.reviewInsert(vo);
	}

	@Override
	public void reviewDelete(int reviewNumber) {
		
		
		dao.reviewDelete(reviewNumber);
	}

	@Override
	public int reviewCount(int seq) {
		// TODO Auto-generated method stub
		return dao.reviewCount(seq);
	}

	@Override
	public void reviewUp(int reviewNumber) {
		
		
		dao.reviewUp(reviewNumber);
	}

	@Override
	public void reviewDown(int reviewNumber) {
		
		
		dao.reviewDown(reviewNumber);
	}

	@Override
	public void insertLike(int reviewNumber, String memberId, int seq) {
	
		
		dao.insertLike(seq, reviewNumber, memberId);
		
	}

	@Override
	public void deleteLike(int reviewNumber,String memberId) {
		// TODO Auto-generated method stub
		dao.deleteLike(reviewNumber, memberId);
	}

	@Override
	public int likeCheck(int reviewNumber, String memberId) {
		// TODO Auto-generated method stub
		return dao.likeCheck(reviewNumber,memberId);
	}

	@Override
	public int likeCount(int reviewNumber, String memberId) {
		// TODO Auto-generated method stub
		return dao.likeCount(memberId, reviewNumber);
	}

	
		
	
	
	
	
	
}

package com.movie.service;


import java.util.List;

import com.movie.vo.ReviewVO;

public interface ReviewService {

	public List<ReviewVO> list(int seq);
	
	public void reviewInsert(ReviewVO vo);
	
	public void reviewDelete(int reviewNumber);
	
	public int reviewCount(int seq);
	
	
	public void reviewUp(int reviewNumber);
	
	public void reviewDown(int reviewNumber);
	
	public void  insertLike(int reviewNumber, String memberId, int seq);
	
	public void deleteLike(int reviewNumber,String memberId);
	
	public int likeCheck(int reviewNumber, String memberId);
	
	public int likeCount(int reviewNumber, String memberId);
	
}

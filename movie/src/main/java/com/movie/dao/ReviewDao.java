package com.movie.dao;


import java.util.List;

import com.movie.vo.ReviewVO;

public interface ReviewDao {

	
	public List<ReviewVO> list(int seq);
	
	public void reviewInsert(ReviewVO vo);
	
	public void reviewDelete(int reviewNumber);
	
	public int reviewCount(int seq);
	
	
	public void reviewUp(int reviewNumber);
	
	public void reviewDown(int reviewNumber);
	
	
	public void  insertLike(int seq, int reviewNumber, String memberId);
	
	public void deleteLike(int reviewNumber,String memberId);
	
	public int likeCheck(int reviewNumber, String memberId);

	public int likeCount(String memberId, int reviewNumber);
	
	
}

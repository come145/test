package com.movie.dao;

import java.util.List;

import com.movie.vo.MovieVO;

public interface MovieDao {

	
	public List<MovieVO> movieList();
	
	public MovieVO movieDetail(String movieTitle);
	
	public void movieInsert(MovieVO vo);
	
	
	
}

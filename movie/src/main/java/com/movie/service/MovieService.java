package com.movie.service;

import java.util.List;

import com.movie.vo.MovieVO;

public interface MovieService {

	
	public List<MovieVO> movieList();
	
	public MovieVO movieDetail(String movieTitle);
	
	public void movieInsert(MovieVO vo );
}

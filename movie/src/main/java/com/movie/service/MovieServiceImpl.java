package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieDao;
import com.movie.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService{

	
	@Autowired
	private MovieDao moviedao;

	@Override
	public List<MovieVO> movieList() {
		// TODO Auto-generated method stub
		return moviedao.movieList();
	}

	@Override
	public MovieVO movieDetail(String movieTitle) {
		// TODO Auto-generated method stub
		return moviedao.movieDetail(movieTitle);
	}

	@Override
	public void movieInsert(MovieVO vo) {
		// TODO Auto-generated method stub
		
		moviedao.movieInsert(vo);
	}

	
}

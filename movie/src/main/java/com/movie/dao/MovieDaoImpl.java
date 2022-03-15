package com.movie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.vo.MovieVO;


@Repository
public class MovieDaoImpl implements MovieDao{

	@Autowired
	private SqlSession session;

	@Override
	public List<MovieVO> movieList() {
		// TODO Auto-generated method stub
		return session.selectList("movie.movieList");
	}

	@Override
	public MovieVO movieDetail(String movieTitle) {
		// TODO Auto-generated method stub
		return session.selectOne("movie.movieDetail", movieTitle);
	}


	@Override
	public void movieInsert(MovieVO vo) {
		// TODO Auto-generated method stub
		session.insert("movie.movieInsert",vo);
		
	}
	
	
	
	
	
	
}

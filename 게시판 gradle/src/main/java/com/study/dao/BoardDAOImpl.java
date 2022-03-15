package com.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSession sqlsession;
	
	
	@Override
	public List<BoardVO> listAll(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return sqlsession.selectList("board.listAll", map);
	}


	@Override
	public void create(BoardVO vo) {
		
		
		sqlsession.insert("board.insert", vo);
	}


	@Override
	public BoardVO read(int num) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("board.read", num);
	}


	@Override
	public void increaseViewcnt(int num) {
		
		sqlsession.selectOne("board.increaseViewcnt", num);
	}


	@Override
	public void update(BoardVO vo) {
		
		
		sqlsession.update("board.update", vo);
	}


	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sqlsession.delete("board.delete", num);
	}


	@Override
	public int countArticle(String searchOption, String keyword) {
		// TODO Auto-generated method stub
	
		
		//검색옵션 , 키워드 맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		
		
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return sqlsession.selectOne("board.countArticle", map);
	}

	
	
	
	
	
}

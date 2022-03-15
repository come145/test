package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.BoardDAO;
import com.study.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO boarddao;

	@Override
	public List<BoardVO> listAll(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boarddao.listAll(searchOption,keyword);
	}

	@Override
	public void create(BoardVO vo) {
		
		
		boarddao.create(vo);
	}

	@Override
	public BoardVO read(int num) {
		// TODO Auto-generated method stub
		return boarddao.read(num);
	}

	@Override
	public void increaseViewcnt(int num) {
		
		boarddao.increaseViewcnt(num);
	}

	@Override
	public void update(BoardVO vo) {
		
		boarddao.update(vo);
	}

	@Override
	public void delete(int num) {
		
		boarddao.delete(num);
		
	}

	@Override
	public int countArticle(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boarddao.countArticle(searchOption, keyword);
	}
	
	
	
	
	
}

package com.study.service;

import java.util.List;

import com.study.vo.BoardVO;

public interface BoardService {

	
	public List<BoardVO> listAll(String searchOption,String keyword);
	
	public int countArticle(String searchOption, String keyword);
	
	public void create(BoardVO vo);
	
	public BoardVO read(int num);

	public void increaseViewcnt(int num);

	public void update(BoardVO vo);
	
	public void delete(int num);
	
}

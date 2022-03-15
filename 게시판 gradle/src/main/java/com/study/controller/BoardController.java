package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.service.BoardService;
import com.study.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	
	@RequestMapping("/list.action")
	public ModelAndView board(@RequestParam(defaultValue="subject") String searchOption,
			@RequestParam(defaultValue="")String keyword) {
		
		
		List<BoardVO> list = boardservice.listAll(searchOption,keyword);
		
		int count = boardservice.countArticle(searchOption, keyword);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("map", map);
		mav.setViewName("list");
		
		return mav;
	}
	
	@RequestMapping("created.action")
	public String create() {
		
		
		
		return "created";
	}
	
	@RequestMapping("created_ok.action")
	public String created(@ModelAttribute BoardVO vo) {
		
		boardservice.create(vo);
				
		return "redirect:list.action";
	}
	
	
	@RequestMapping("article.action")
	public ModelAndView view(@RequestParam int num , HttpSession session) {
		
		
		boardservice.increaseViewcnt(num);
		
		
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("/article");
		
		
		mav.addObject("dto", boardservice.read(num));
		
		return mav;	
		
	}
	
	 @RequestMapping(value="updated.action")
	    public ModelAndView update(@RequestParam int num){
	    	
		 	ModelAndView mav = new ModelAndView();
		 
		 	mav.setViewName("/updated");
		 
		 	mav.addObject("dto", boardservice.read(num));
		 	
	        return mav; 
	    }
	
	
	@RequestMapping(value="updated_ok.action")
	public String updated(@ModelAttribute BoardVO vo) {
		
		boardservice.update(vo);
		
		return "redirect:list.action";
	}
	

	@RequestMapping("deleted.action")
	public String delete(@RequestParam int num) {
		
		boardservice.delete(num);
		
		return "redirect:list.action";
	}
	
	
	
}

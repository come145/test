package com.movie.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.service.ReviewService;
import com.movie.vo.MemberVO;
import com.movie.vo.ReviewVO;

@Controller
public class ReviewController{
	
	
	@Autowired
	private ReviewService service;
	
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	
	@ResponseBody
	@RequestMapping("/reviewList.do")				
	private List<ReviewVO>  reviewList(Model model,@RequestParam("seq") int seq) throws Exception{
		
		return service.list(seq);
		
	}
	

	
	@RequestMapping
	public String insertReview(ReviewVO vo, HttpSession session) {
		
		String memberId = (String) session.getAttribute("login");
		
		
		
		return "/member/test";
	}
	
	
	// 추천수
	@ResponseBody
	@RequestMapping(value = "/like.do")
	public int updateLike(int seq, int reviewNumber, String memberId , Model model,HttpSession session)throws Exception {
		
		MemberVO login = (MemberVO) session.getAttribute("login");
		
		String loginId = login.getMemberId();
		
		
		int likeCheck = service.likeCheck(reviewNumber, memberId);
		
		
		if (likeCheck == 0) {
			
			
			service.insertLike(seq, memberId , reviewNumber );//like테이블 삽입
			service.reviewUp(reviewNumber);	//게시판테이블 +1
			
			
		}else if(likeCheck == 1) {
			
			service.reviewDown(reviewNumber); //리뷰테이블 -1
			service.deleteLike(reviewNumber, memberId); //like테이블 삭제
			
			
		}
		
		//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
		
		return likeCheck;
	}


	
	
}

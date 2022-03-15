package com.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.service.MemberService;
import com.movie.vo.MemberVO;

@Controller
public class MemberContorller {

	
	@Autowired
	private MemberService service;
	
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	
	//로그인 페이지 이동
	@RequestMapping("/login.do")
	public String login(Model model, MemberVO vo, HttpSession session) {
	
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		return "/movie/login";
	}
	
	
	
	
	
	//로그인 체크
	@RequestMapping("/loginCheck.do")
	public String loginCheck(@ModelAttribute MemberVO vo,HttpSession session, HttpServletRequest request ) {
		
		boolean result = service.loginCheck(vo, session);
		
		
		
		if (result == true) {
			
			session = request.getSession(); // 이전에 생성된 session 객체가 없으면 새로운 객체 생성
			session.setAttribute("login", vo); 

			logger.info("로그인성공");
			
			return "redirect:/main.do";		

		}else {

			return "redirect:/login.do";
				
		}
		
	
	}
	
	//로그아웃
	@RequestMapping("/logout.do") 
	public String logout(HttpSession session) {
		
		service.logout(session);
		
		return "redirect:/login.do";
		
	}
	

	
	// 회원가입 
	@RequestMapping("/addMember.do") 
	public ModelAndView intsertMember(@ModelAttribute MemberVO vo){
		
		service.memberInsert(vo);
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName(null);
		
		
		return mav;
	}

	
	
}

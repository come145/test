package com.study.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.service.MemberService;
import com.study.vo.MemberVO;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); 
	
	@Autowired
	MemberService memberservice;
	
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo,HttpSession session) {
		
		boolean result = memberservice.loginCheck(vo, session);
		
		ModelAndView mav = new ModelAndView();
		
		if(result == true) {
			
		
		
			
		mav.setViewName("list");	
		mav.addObject("msg","success");
		
		}else {
			
			mav.setViewName("login");
			mav.addObject("msg", "failure");
		}
		
		
		
		return mav;
	}
	
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		
		memberservice.logout(session);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		
		return mav;
		
		
	}
	
	
	
	
}

package com.movie.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.movie.service.MovieService;
import com.movie.service.TicketService;
import com.movie.vo.MemberVO;
import com.movie.vo.MoviePayVO;
import com.movie.vo.MovieVO;
import com.movie.vo.TicketVO;


@SessionAttributes("member")
@Controller
public class TicketController {

	
	
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private TicketService ticket;
	
	@Autowired	
	private MovieService movie;
	
	@RequestMapping("/ticketAdd.do")
	public String ticketAdd(Model model,TicketVO vo,HttpSession session) throws JsonProcessingException {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		vo.setId(login.getMemberId());
		
		//vo.setId("come145");
		
		System.out.println(vo.toString());
		logger.info("moveSeat");
		model.addAttribute("reserve", vo);
	
		List<TicketVO> list = ticket.listTicket(vo);
		
		List<String> seat = new ArrayList<String>();
		
		String[] str = new String[list.size()];
		String[] str1 = new String[list.size()];
		String[] str2 = new String[list.size()];
		
		
		for(int i =0; i<list.size(); i++) {
			
		str = list.get(i).getSelectedSeat().split(",");
		str1 = list.get(i).getTitle().split(",");
		str2 = list.get(i).getSelectedTheater().split(",");
		
		
		if (Arrays.asList(str1).contains(vo.getTitle()) &&
				Arrays.asList(str2).contains(vo.getSelectedTheater() + " 3관")) 
				  {
		
			for(int j=0; j< str.length; j++) {
			
				
				
				seat.add(str[j]);
			
			}
		}
		
		
		
		}
	
		model.addAttribute("seat", seat);
	
		return "/ticket/ticket";
	}
	
	
	

	@RequestMapping("/moveKakao.do")
	public String moveKaKao(TicketVO vo,MoviePayVO vo2,MovieVO vo1,HttpSession session,Model model) throws IOException {
		
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		
		Document doc; //document = 문서전체
		
		 doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();   // 웹데이터를 가져올 주소
		
		
		Random rnd = new Random();
		int tkn = rnd.nextInt(999999);
		
		String ticketNumber = String.valueOf(tkn);
		Elements movieOpenDates = doc.select(".txt-info strong");   // 영화 개봉일
		Elements movieAges = doc.select(".ico-grade");    // 연령제한
			
		
		String memberId = login.getMemberId();
		String movieOpenDate = movieOpenDates.get(vo1.getSeq()).text();
		String movieAge = movieAges.get(vo1.getSeq()).text();
		
		vo1 = movie.movieDetail(vo.getTitle());
		
		
		vo.setId(memberId);
		vo.setMoviePeople(ticketNumber);		
		vo.setMovieAge(movieAge);
		vo.setRunningTime(vo1.getMovieTime());
		vo.setMovieDate(movieOpenDate);
		
		model.addAttribute("reserve", vo);
		model.addAttribute("pay", vo2);
		
		
		ticket.ticketInsert(vo);
		
		
		
		return "/ticket/kakao";
		
		
	}
	
	
	
	@RequestMapping("/payKakao.do")
	public String payKakao(Model model,HttpSession session, MoviePayVO vo, TicketVO vo1) throws IOException {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		String memberId = login.getMemberId();
		
		List<TicketVO> list = ticket.listTicket(vo1);
		
		vo.setId(memberId);
		vo.setReserveSequence(list.get(0).getReserveSequence());
		
		
	
			ticket.ticketPayInsert(vo);
		
			
			
			Document doc; //document = 문서전체
			
			 doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();   // 웹데이터를 가져올 주소

			 Elements imgs = doc.select(".thumb-image > img");		//이미지
			 Elements movieTitles = doc.select("div.box-contents strong.title"); //영화제목

			 
			 TicketVO vo2 = ticket.selectTicket(memberId);
			 
			 	
				String movieTitle = vo2.getTitle();
				
				
				 for (int i=0; i< movieTitles.size(); i ++) {
				 
				 String movieTitle1 = movieTitles.get(i).text();
				 String img  = imgs.get(i).attr("src");
				
				 
				 if (movieTitle1.equals(movieTitle)) {
					 
					 
					 model.addAttribute("img", img);
				
					 break;
				 }
			
				 }
				 
				 
				 // 영화 종영시간
				 
				 Date date = vo2.getReserveDate();
				 
				 Calendar cal = Calendar.getInstance();
				 
				 SimpleDateFormat sdformat = new SimpleDateFormat("HH:mm");

				 cal.setTime(date);
				 
				 String add = vo2.getRunningTime();
				 add = add.replaceAll("분", "");
				 
				 
				 cal.add(Calendar.MINUTE, Integer.parseInt(add)); 

				 String today = "";
				 today = sdformat.format(cal.getTime()); 

				 	
				 
				 model.addAttribute("today", today);
				 model.addAttribute("movie", vo2);
				
			 
			 
		
		return "/movie/mypage";
	}
	
	@RequestMapping("/delete.do")
	public String delete(HttpSession session) {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		ticket.ticketDelte();
		
		
		
		
		
		return "redirect:/main.do";
	}
	
	
	
	
	
	
	@RequestMapping("/mypage.do")
	public String mypage(Model model,HttpSession session,TicketVO vo) throws IOException {
			
		MemberVO login = (MemberVO)session.getAttribute("login");
				
		return "/movie/mypage";
	}
	
	
	

	
	@RequestMapping("/ticketTime.do") 
	public String ticketTime(MovieVO vo,HttpSession session) {
				
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		return "/ticket/time";
		
	}
	
	
	@RequestMapping("/ticketTest.do")
	public String tickeTest() {
		
		
		return "/ticket/test";
		
	}
		
		
	}
	
	
	

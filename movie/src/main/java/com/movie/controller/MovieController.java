package com.movie.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document; // jsoup 라이브러리 = HTML 문서에 저장된 데이터를 구문 분석, 추출 및 조작하도록 설계된 오픈 소스
import org.jsoup.select.Elements;
// 크롤링 = 웹페이지를 그대로 가지고와 거기서 데이터를 추출해 내는 행위
// 파싱 = 어떤 페이지(문서, html 등)에서 내가 원하는 데이터를 특정 패턴이나 순서로 추출해 가공하는 것을 말함
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;  // JSON의 자바 오브젝트의 직렬화, 역직렬화를 해주는 오픈 소스 자바 라이브러리
							  // 즉  json object --> java object 또는 그 반대 행위를 돕는 라이브러리

import com.movie.service.MovieService;
import com.movie.service.ReviewService;
import com.movie.vo.MemberVO;
import com.movie.vo.MovieVO;
import com.movie.vo.ReviewVO;


@SessionAttributes("member")
@Controller
public class MovieController {

	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService review;
	
	
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	
	@RequestMapping("/movieDetail.do")
	public ModelAndView movieDetail(HttpSession session,MemberVO member,MovieVO vo,ReviewVO reviewvo,@RequestParam int seq) throws IOException {
		
		
		ModelAndView mav = new ModelAndView();
		
		Document doc; //document = 문서전체
		
		 doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();   // 웹데이터를 가져올 주소
			
		 Elements movieTitles = doc.select("div.box-contents strong.title"); //영화제목
		 Elements imgs = doc.select(".thumb-image > img");		//이미지
		 Elements movieRates = doc.select(".percent span");   // 예매율
		 Elements movieOpenDates = doc.select(".txt-info strong");   // 영화 개봉일
		 Elements movieAges = doc.select(".ico-grade");    // 연령제한
				
		 
		 String movieTitle = movieTitles.get(seq).text();
		 String img  = imgs.get(seq).attr("src");
		 String movieRate = movieRates.get(seq).text();
		 String movieOpenDate = movieOpenDates.get(seq).text();
		 String movieAge = movieAges.get(seq).text();
						
		 
		 vo.setMovieTitle(movieTitle);
		 vo.setImg(img);
		 vo.setMovieRate(movieRate);
		 vo.setMovieOpenDate(movieOpenDate);
		 vo.setMovieAge(movieAge);
		 
		 
		List<ReviewVO> reviewList = review.list(seq);
		 
		 int reviewCount = review.reviewCount(seq);
		 
		 
		 mav.addObject("review", reviewList);
		 mav.addObject("reviewCount", reviewCount);
		 mav.addObject("movie", vo);
		 mav.addObject("movie1", service.movieDetail(movieTitle));
		 
		 
		mav.setViewName("/member/test");
		
		
		return mav;
	}

	

	
	
	@RequestMapping("/main.do")
	public ModelAndView main2(HttpSession session,MovieVO vo1) throws IOException, ParseException {
		
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		
		
		ModelAndView mav = new ModelAndView();
		
		

		Document doc; //document = 문서전체
		
		logger.info("크롤링 " + new Date());
		
		
		
			 doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();   // 웹데이터를 가져올 주소
			 
			 Elements ranks = doc.select(".rank");  //Elements (복수형) ,  순위
			 /* logger.info("rank" + ranks); */
			 
			 Elements imgs = doc.select(".thumb-image > img");		//이미지
				/* logger.info("imgs" + imgs); */
				 
				 Elements movieAges = doc.select(".ico-grade");    // 연령제한
				/* logger.info("ico-grade" + movieAges); */
				 
				 Elements movieTitles = doc.select("div.box-contents strong.title"); //영화제목
				/* logger.info("titles" + movieTitles); */
				 
				 Elements movieRates = doc.select(".percent span");   // 예매율
				/* logger.info("percents" + movieRates); */
				 
				 
				 Elements movieOpenDates = doc.select(".txt-info strong");   // 영화 개봉일
				/* logger.info("percents" + movieOpenDates); */
				
				 
				 
				 List<MovieVO> list = new ArrayList<MovieVO>();
				 
				 String c[] = new String[ranks.size()];
				 
				 Map<String, Object> map = new HashMap<String, Object>();
					
				
				 
				 for(int i=0; i < ranks.size(); i++) {
					 
					 String rank = ranks.get(i).text();
					 String img = imgs.get(i).attr("src");
					 String movieAge = movieAges.get(i).text();
					 String movieTitle = movieTitles.get(i).text();
					 String movieRate = movieRates.get(i).text();
					 String movieOpenDate = movieOpenDates.get(i).text();
					 String reOpen = vo1.getReOpen();
					 
					 int seq = i; 
					 
					 
					 String open = "재개봉";
					 
					 // map으로  c:foreach문(아직못함)
					 if(movieOpenDate.contains(open)) {
				
						 reOpen  = open;

					 }
				
					
						
					String a = movieOpenDate.replaceAll("개봉", "");		
					a= a.replace(".", "-");
					c[i] = a.replaceAll("재", "");
					

						    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					        Calendar c1 = Calendar.getInstance();

						 
							String s_date = c[i];
					        String strToday = sdf.format(c1.getTime());
	 
							
							Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s_date);
							Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strToday);
							
							long diffSec = ( date1.getTime() - date.getTime()) / 1000;
							long diffDays = diffSec / (24*60*60); //일자수 차이
							
						
							
							
							String dday = Long.toString(diffDays);
							
							logger.info(dday);
							
							
							//  dday 띄위기 , 리뷰
							
					 MovieVO vo = new MovieVO(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, seq,dday,reOpen);
					
					 
					 list.add(vo);
					
					 
				 }
				
					
	 
	    map.put("list", list);
	    
		mav.addObject("movie", map);
		mav.setViewName("/movie/main2");
		
		
		
		return mav;
		
		
	}
		
	
	@ResponseBody   // responseBody 어노테이션을 사용하면 Http 요청 body를 자바 객체로 전달 받을수 있다
	@RequestMapping(value = "/crawling.do", method = {RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String getcrawling() {
		
		
		Document doc; //document = 문서전체
		String gson = "";
		logger.info("크롤링 " + new Date());
		
		try {
			
			 doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();   // 웹데이터를 가져올 주소
			 
			 Elements ranks = doc.select(".rank");  //Elements (복수형) ,  순위
			 /* logger.info("rank" + ranks); */
			 
			 Elements imgs = doc.select(".thumb-image > img");		//이미지
				/* logger.info("imgs" + imgs); */
				 
				 Elements movieAges = doc.select(".ico-grade");    // 연령제한
				/* logger.info("ico-grade" + movieAges); */
				 
				 Elements movieTitles = doc.select("div.box-contents strong.title"); //영화제목
				/* logger.info("titles" + movieTitles); */
				 
				 Elements movieRates = doc.select(".percent span");   // 예매율
				/* logger.info("percents" + movieRates); */
				 
				 
				 Elements movieOpenDates = doc.select(".txt-info strong");   // 영화 개봉일
				/* logger.info("percents" + movieOpenDates); */
				
				 
				 List<MovieVO> list = new ArrayList<MovieVO>();
				 
				 
				 for(int i=0; i < ranks.size(); i++) {
					 
					 String rank = ranks.get(i).text();
					 String img = imgs.get(i).attr("src");
					 String movieAge = movieAges.get(i).text();
					 String movieTitle = movieTitles.get(i).text();
					 String movieRate = movieRates.get(i).text();
					 String movieOpenDate = movieOpenDates.get(i).text();
					 int seq = i;
					 
					 
					 
					 MovieVO vo = new MovieVO(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, seq, "0","재개봉");
					 
					
					 
					 list.add(vo);
					 logger.info(vo.toString());
					 
					 	 
				 }
				 
				  gson = new Gson().toJson(list);
			 
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		return gson;
	}
	
	
	
	
	
	
	
	
	
	
}

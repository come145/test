package com.movie.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieVO {

	private String rank;
	private String img;
	private String movieAge;
	private String movieTitle;
	private String movieRate; //예매율
	private String movieOpenDate; //개봉일
	private String movieDirector;
	private String movieActor;
	private String movieKind;
	private String movieTime;
	private String movieDday;
	private String reOpen;
	
	private int seq;

	
	public MovieVO() {
		
	}
	
	
	public MovieVO(String rank, String img, String movieAge, String movieTitle, String movieRate,
			String movieOpenDate,  int seq, String dday,String reOpen) {
		super();
		this.rank = rank;
		this.img = img;
		this.movieAge = movieAge;
		this.movieTitle = movieTitle;
		this.movieRate = movieRate;
		this.movieOpenDate = movieOpenDate;
		this.seq = seq;
		this.movieDday = dday;
		this.reOpen = reOpen;
	}

	@Override
	public String toString() {
		return "MovieVO [rank=" + rank + ", img=" + img + ", movieAge=" + movieAge + ", movieTitle=" + movieTitle
				+ ", movieRate=" + movieRate + ", movieOpenDate=" + movieOpenDate + ", seq=" + seq + ", dday=" + movieDday
				+ "]";
	}

	
	
	
	
	
}

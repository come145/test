package com.movie.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter			// Serializable = 자바 시스템 내부에서 사용되는 오브젝트 또는 Data를 외부의 자바 시스템에서도 사용할수 있게 바이트 형태로 변형시키는 기술
public class TicketVO implements Serializable{

	
			
	private String id; 	// 아이디
	private int reserveSequence;    // 시퀀스 pk
	private String title;  			// 영화제목
	private String runningTime;		// 런닝타임
	private String movieDate;		// 영화개봉일
	private Date reserveDate;		// 영화예매시간
	private String ticketNumber;   // 예매한 사람수
	private String selectedSeat;	//선택자리
	private String selectedTheater;	// 선택영화관 지역
	private String movieAge;		// 영화연령대
	private String moviePeople; // 티켓번호(랜덤)
	
	
	
	private MoviePayVO moviePayVo;
	
	private Date payDate;		//  결제한 날짜 시간
	private String payMoney; // 결제한 비용
		
	public TicketVO() {

	}
	
	public TicketVO(String id, int reserveSequence, String title, String runningTime, String movieDate,
			Date reserveDate, String ticketNumber, String selectedSeat, String selectedTheater, String movieAge) {
		super();
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.reserveDate = reserveDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
	}

	public TicketVO(String id, int reserveSequence, String title, String runningTime, String movieDate,
			Date reserveDate, String ticketNumber, String selectedSeat, String selectedTheater, String movieAge,
			MoviePayVO moviePayVo) {
		super();
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.title = title;
		this.runningTime = runningTime;
		this.movieDate = movieDate;
		this.reserveDate = reserveDate;
		this.ticketNumber = ticketNumber;
		this.selectedSeat = selectedSeat;
		this.selectedTheater = selectedTheater;
		this.movieAge = movieAge;
		this.moviePayVo = moviePayVo;
	}

	@Override
	public String toString() {
		return "TicketVO [id=" + id + ", reserveSequence=" + reserveSequence + ", title=" + title
				+ ", runningTime=" + runningTime + ", movieDate=" + movieDate + ", reserveDate=" + reserveDate
				+ ", ticketNumber=" + ticketNumber + ", selectedSeat=" + selectedSeat + ", selectedTheater="
				+ selectedTheater + ", movieAge=" + movieAge + "]";
	}
	
	
	
	

}

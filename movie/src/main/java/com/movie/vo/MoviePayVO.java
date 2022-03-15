package com.movie.vo;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoviePayVO implements Serializable {
	private String id;
	private int reserveSequence;
	private String payDate;		//  결제한 날짜 시간
	private String payMoney; // 결제한 비용
	
	public MoviePayVO() {
		// TODO Auto-generated constructor stub
	}

	public MoviePayVO(String id, int reserveSequence, String payDate, String payMoney) {
		super();
		this.id = id;
		this.reserveSequence = reserveSequence;
		this.payDate = payDate;
		this.payMoney = payMoney;
	}

	@Override
	public String toString() {
		return "MoviePayVO [id=" + id + ", reserveSequence=" + reserveSequence + ", payDate=" + payDate + ", payMoney="
				+ payMoney + "]";
	}
	
	
	
	
	
}
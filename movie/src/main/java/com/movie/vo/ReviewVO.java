package com.movie.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewVO {

	private int reviewNumber;
	private String memberId;
	private String reviewContent;
	private Date reviewDate;
	private int reviewUp;
	private int seq;
	private int likecnt;
	
	
	@Override
	public String toString() {
		return "ReviewVO [reviewNumber=" + reviewNumber + ", memberId=" + memberId + ", reviewContent=" + reviewContent
				+ ", reviewDate=" + reviewDate + ", reviewUp=" + reviewUp + ", seq=" + seq + ", likecnt=" + likecnt
				+ "]";
	}
	
	
	
}

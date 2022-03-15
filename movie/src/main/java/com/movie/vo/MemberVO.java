package com.movie.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {

	
	private int memberNumber;  // pk
	private String memberId;
	private String memberName;
	private String memberPw;
	private String memberGender;
	private String memberPnum1;
	private String memberPnum2;
	private String memberPnum3;
	private int memberAge;
	private String memberEmail1; // '이메일주소1',
	private String memberEmail2; //'이메일주소2',
	private String memberEmailYn; // '이메일수신여부',
	
	
}

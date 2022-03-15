package com.study.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {

	
	private String userId;
    private String userPw;
    private String userName; 
    private String userEmail; 
    private Date userRegdate; // java.sql.Date
    private Date userUpdatedate;
    
    
    // toString()
    @Override
    public String toString() {
        return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail="
                + userEmail + ", userRegdate=" + userRegdate + ", userUpdatedate=" + userUpdatedate + "]";
    }
    
    
}

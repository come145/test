package com.movie.dao;

import java.util.List;

import com.movie.vo.MoviePayVO;
import com.movie.vo.TicketVO;

public interface TicketDao {

	
	public void ticketInsert(TicketVO vo);
	
	
	public void ticketPayInsert(MoviePayVO vo);
	
	
	//결제 실패시 티켓 딜리트
	public void ticketDelete();
	
	
	//예매성공시
	public TicketVO selectTicket(String id);
	
	
	public List<TicketVO> listTicket(TicketVO vo);

	
	public List<TicketVO> seatList();
	
}

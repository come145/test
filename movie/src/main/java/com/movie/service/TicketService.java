package com.movie.service;

import java.util.List;

import com.movie.vo.MoviePayVO;
import com.movie.vo.TicketVO;

public interface TicketService {

	
	public void ticketInsert(TicketVO vo);
	
	public void ticketPayInsert(MoviePayVO vo);
	
	
	public void ticketDelte();
	
	public TicketVO selectTicket(String id);
	
	public List<TicketVO> listTicket(TicketVO vo);
	
	
	public List<TicketVO> seatList();
}

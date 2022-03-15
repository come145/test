package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.TicketDao;
import com.movie.vo.MoviePayVO;
import com.movie.vo.TicketVO;

@Service
public class TicketServiceImpl implements TicketService{

	
	
	@Autowired
	private TicketDao dao;

	@Override
	public void ticketInsert(TicketVO vo) {
		
		
		dao.ticketInsert(vo);
		
	}

	@Override
	public void ticketPayInsert(MoviePayVO vo) {
		
		
		dao.ticketPayInsert(vo);
	}

	@Override
	public void ticketDelte() {
		
		dao.ticketDelete();
	}

	@Override
	public TicketVO selectTicket(String id) {
		// TODO Auto-generated method stub
		return dao.selectTicket(id);
	}

	@Override
	public List<TicketVO> listTicket(TicketVO vo) {
		// TODO Auto-generated method stub
		return dao.listTicket(vo);
	}

	@Override
	public List<TicketVO> seatList() {
		// TODO Auto-generated method stub
		return dao.seatList();
	}
	
	
	
	
	
}

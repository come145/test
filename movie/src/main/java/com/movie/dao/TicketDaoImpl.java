package com.movie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.vo.MoviePayVO;
import com.movie.vo.TicketVO;

@Repository
public class TicketDaoImpl implements TicketDao{

	
	@Autowired
	private SqlSession sql;

	@Override
	public void ticketInsert(TicketVO vo) {
		
		sql.insert("ticket.insertTicket",vo);
		
	}

	@Override
	public void ticketPayInsert(MoviePayVO vo) {
		
		
		sql.insert("ticket.insertPay", vo);
	}

	@Override
	public void ticketDelete() {
		
		sql.delete("ticekt.deleteTicket");
	}

	@Override
	public TicketVO selectTicket(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne("ticket.selectTicket", id);
	}

	@Override
	public List<TicketVO> listTicket(TicketVO vo) {
		// TODO Auto-generated method stub
		return sql.selectList("ticket.ticketList", vo);
	}

	@Override
	public List<TicketVO> seatList() {
		// TODO Auto-generated method stub
		return sql.selectList("ticket.seatList");
	}
	
	
	
	
	
}

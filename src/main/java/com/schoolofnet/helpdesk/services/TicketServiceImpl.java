package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.TicketRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		return null;
	}

	@Override
	public Ticket create(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public boolean update(Long id, Ticket ticket) {
		return false;
	}

	@Override
	public User show(Long id) {
		return null;
	}

}

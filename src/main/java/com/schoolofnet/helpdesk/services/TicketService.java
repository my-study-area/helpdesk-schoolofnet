package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.ui.Model;

import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;

public interface TicketService {
	public List<Ticket> findAll();
	public Model createTemplate(Model model);
	public Ticket create(Ticket ticket);
	public boolean delete(Long id);
	public boolean update(Long id, Ticket ticket);
	public User show(Long id);
}

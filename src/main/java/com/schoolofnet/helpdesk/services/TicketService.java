package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.ui.Model;

import com.schoolofnet.helpdesk.models.Ticket;

public interface TicketService {
	public List<Ticket> findAll();
	public Model findAllTechinician(Model model);
	public Ticket create(Ticket ticket);
	public boolean delete(Long id);
	public boolean update(Long id, Ticket ticket);
	public Ticket show(Long id);
	public List<Ticket> reportTicketByDay(Integer day);
}

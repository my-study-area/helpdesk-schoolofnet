package com.schoolofnet.helpdesk.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Interaction;
import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.InteractionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteractionServiceImpl implements InteractionService {
	
	@Autowired
	private InteractionRepository interactionRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;

	@Override
	public Interaction create(Interaction interaction,Long ticketId) {
		Ticket ticket = this.ticketService.show(ticketId);
		User userLogged = this.userService.findCurrentUser();
		
		interaction.setTicket(ticket);
		interaction.setUserInteraction(userLogged);
		interaction.setDateCreated(new Date());
		
		return this.interactionRepository.save(interaction);
	}

	@Override
	public boolean delete(Long id, Long ticketId) {
		Interaction interaction = findById(id);
		
		if (interaction == null) {
			return false;
		}
		
		this.interactionRepository.delete(interaction);
		return true;
	}

	private Interaction findById(Long id) {
		return this.interactionRepository.findById(id).orElse(null);
	}

}

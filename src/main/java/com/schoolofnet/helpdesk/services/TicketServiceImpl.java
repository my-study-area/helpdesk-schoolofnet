package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.TicketRepository;
import com.schoolofnet.helpdesk.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Ticket> findAll() {
		return (List<Ticket>) this.ticketRepository.findAll();
	}

	@Override
	public Ticket create(Ticket ticket) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User userLogged = this.userRepository.findByEmail(userName);
		ticket.setUserOpen(userLogged);
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
	public Ticket show(Long id) {
		return this.ticketRepository.findById(id).orElse(null);
	}

	@Override
	public Model findAllTechinician(Model model) {
		
		Role adminRole = this.roleService.findByName("ADMIN");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User userLogged = this.userRepository.findByEmail(userName);
		
		List<User> users = userService.findAllWhereRoleEquals(adminRole.getId(), userLogged.getId());
		model.addAttribute("users", users);
		return model;
	}

}

package com.schoolofnet.helpdesk.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Interaction;
import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.services.TicketService;
import com.schoolofnet.helpdesk.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", this.ticketService.findAll());
		model.addAttribute("currentUser", this.userService.findCurrentUser());
		return "tickets/index";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Ticket ticket = this.ticketService.show(id);
		List<Interaction> interactions = ticket.getInteractions();
		
		model.addAttribute("ticket", ticket);
		model.addAttribute("interaction", new Interaction());
		model.addAttribute("interactions", interactions);
		model.addAttribute("userLoggedIn", this.userService.findCurrentUser());
		return "tickets/show";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		model = this.ticketService.findAllTechinician(model);
		model.addAttribute("ticket", new Ticket());
		return "tickets/create";
	}
	
	@PostMapping
	public String save(@Valid @ModelAttribute("ticket") Ticket ticket,
			BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			return "tickets/create";
		}
		this.ticketService.create(ticket);
		return "redirect:/tickets";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Ticket ticket = this.ticketService.show(id);
		List<Interaction> interactions = ticket.getInteractions();
		model = this.ticketService.findAllTechinician(model);
		model.addAttribute("ticket", ticket);
		model.addAttribute("interactionsCount", interactions.size());
		model.addAttribute("userLoggedIn", this.userService.findCurrentUser());
		return "tickets/edit";
	}
	
	@PutMapping("{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult, Model model ) {
		if (bindingResult.hasErrors()) {
			return "tickets/edit";
		}
		this.ticketService.update(id, ticket);
		return "redirect:/tickets";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") Long id) {
		this.ticketService.delete(id);
		return "redirect:/tickets";
	}

}

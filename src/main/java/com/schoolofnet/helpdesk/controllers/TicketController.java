package com.schoolofnet.helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.services.TicketService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/new")
	public String create(Model model) {
		model = this.ticketService.createTemplate(model);
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

}

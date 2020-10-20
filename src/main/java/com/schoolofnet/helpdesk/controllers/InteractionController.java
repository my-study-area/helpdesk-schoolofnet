package com.schoolofnet.helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Interaction;
import com.schoolofnet.helpdesk.services.InteractionService;

import lombok.AllArgsConstructor;

@RequestMapping("/tickets/{ticketId}/interactions")
@Controller
@AllArgsConstructor
public class InteractionController {
	
	@Autowired
	private InteractionService InteractionService;

	@PostMapping
	public String save(
			@PathVariable("ticketId") Long ticketId,
			@Valid @ModelAttribute("interaction") Interaction interaction,
			BindingResult bindingResult, 
			Model model) {
		if (bindingResult.hasErrors()) {
			return "tickets/show";
		}
		this.InteractionService.create(interaction, ticketId);
		return "redirect:/tickets/" + ticketId;
	}
	
	@DeleteMapping("{id}")
	public String delete(
			@PathVariable("ticketId") Long ticketId,
			@PathVariable("id") Long id,
			Model model) {
		this.InteractionService.delete(id, ticketId);
		return "redirect:/tickets/" + ticketId;
	}

}

package com.schoolofnet.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolofnet.helpdesk.services.TicketService;

@Controller
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public String ticketReport(@RequestParam(required = false, value = "day") Integer day, Model model) {
		model.addAttribute("list", this.ticketService.reportTicketByDay(day));
		return "reports/ticket";
	}
}

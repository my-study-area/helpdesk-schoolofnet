package com.schoolofnet.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {
	
	@GetMapping("/tickets")
	public String ticketReport(Model model) {
		return "reports/ticket";
	}
}

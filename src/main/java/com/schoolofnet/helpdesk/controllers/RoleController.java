package com.schoolofnet.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@GetMapping
	public String  index(Model model) {
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String  create(Model model) {
		return "roles/create";
	}
	
	@PostMapping
	public String  save(Model model) {
		return null;
	}
	
	@DeleteMapping
	public String  delete(Model model) {
		return null;
	}
	
}

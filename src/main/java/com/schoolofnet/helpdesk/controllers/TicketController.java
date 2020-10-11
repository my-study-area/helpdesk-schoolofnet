package com.schoolofnet.helpdesk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.services.RoleService;
import com.schoolofnet.helpdesk.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
	
//	private static final Long ROLE_ID = 1l;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/new")
	public String create(Model model) {
		Role adminRole = this.roleService.findByName("ADMIN");
		List<User> users = userService.findAllWhereRoleEquals(adminRole.getId());
//		List<User> users = userService.findAllwhereRoleEquals(ROLE_ID);
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("users", users);
		return "tickets/create";
	}

}

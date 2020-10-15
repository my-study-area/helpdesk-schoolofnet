package com.schoolofnet.helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.services.RoleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/roles")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String  index(Model model) {
		model.addAttribute("list", roleService.findAll());
		return "roles/index";
	}
	
	@GetMapping("/new")
	public String  create(Model model) {
		model.addAttribute("role", new Role());
		return "roles/create";
	}
	
	@PostMapping
	public String  save(@Valid @ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "roles/create";
		}
		role.setName(role.getName().toUpperCase());
		this.roleService.create(role);
		return "redirect:/roles";
	}
	
	@DeleteMapping("{id}")
	public String  delete(@PathVariable("id") Long id, Model model) {
		this.roleService.delete(id);
		return "redirect:/roles";
	}
	
}

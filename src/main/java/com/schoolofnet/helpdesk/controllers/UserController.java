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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.services.RoleService;
import com.schoolofnet.helpdesk.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
    
    @GetMapping
    public String index(Model model) {
    	model.addAttribute("list", userService.findAll());
        return "users/index";
    }
    
    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	User user = this.userService.show(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        userService.update(id, user);
        return "users/edit";
    }
    
    @PostMapping
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
			return "users/create";
		}
    	this.userService.create(user);
    	return "redirect:/users";
    }
    
    @PutMapping("{id}")
    public String upadate(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
			return "users/edit";
		}
    	this.userService.update(id, user);
    	return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
    	this.userService.delete(id);
		return "redirect:/users";
    }
    
}

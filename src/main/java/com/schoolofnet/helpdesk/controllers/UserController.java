package com.schoolofnet.helpdesk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
    
    @GetMapping
    public String index(Model model) {
        return "users/index";
    }
    
    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }
    
    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", new User());
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
    
}

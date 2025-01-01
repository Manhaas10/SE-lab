package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService UserService;
	// creating method handler for home page 
	// (index.html) to display list of Users
	@GetMapping("/") 
	public  String viewHomePage(Model model) {
		model.addAttribute("listUsers", UserService.getAllUsers());
		return "index";
	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		// create model attribute to bind form data
		User User = new User();
		model.addAttribute("User", User);
		return "new_User";
	}
	
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("User") User User,Model model) {
		// save User to data base
		if(User.getName().isEmpty()|| User.getEmail().isEmpty()){
			model.addAttribute("errorMessage","Name and Email cannot be empty.");
			return "error_file";
		}
		UserService.saveUser(User);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get User from the service
		User User = UserService.getUserById(id);
		
		// set User as a model attribute to pre-populate the form
		model.addAttribute("User", User);
		return "update_User";
	}
	
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") long id) {
		
		// call delete User method
		this.UserService.deleteUserById(id);
		return "redirect:/";
	}
}
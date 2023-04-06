package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.buisness.OrdersBusinessServiceInterface;
import com.gcu.buisness.SecurityBusinessService;
import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	// Using the Autowired annotation removes the need for getters and setters.
	// When autowiring properties in Bean, the property's class type is used for searching a 
	// matching Bean definition in the configuration file. If a Bean is found, it is injected
	// into the property. 
	// In this case, autowiring to SpringConfig getOrdersBusiness method. 
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
		
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Make call to Security business service
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		// Make call to the Security Business service.
		service.test();
		
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		
		return "orders";
	}
	
}

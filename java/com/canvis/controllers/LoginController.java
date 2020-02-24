package com.canvis.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.canvis.forms.LoginForm;
import com.canvis.models.User;
import com.canvis.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	/**
	 * Shows login form
	 * @param loginForm
	 * @return
	 */
	@RequestMapping("/users/login")
	public String login(LoginForm loginForm){
		// User doesn't need to re-enter credentials
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ( (auth instanceof AnonymousAuthenticationToken) ) {
			return "users/login";
		} else {
			return "redirect:/";
		}
	}	
	/**
	 * Display user's registration form 
	 * @return
	 */
	@RequestMapping("/users/register")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject(user);
		modelAndView.setViewName("users/register");
		return modelAndView;
	}
	@RequestMapping(value = "users/register", method = RequestMethod.POST)
	public ModelAndView registration(@Valid User user, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		User userExists = this.userservice.findByUserName(user.getUserName());
		modelAndView.setViewName("users/register");
		if( userExists != null ){
			bindingResult.rejectValue("userName", "error.user", "User exists");
		}
		if( !bindingResult.hasErrors() ){
			this.userservice.create(user);
			modelAndView.addObject("successMessage", "User has been created");
			modelAndView.addObject("user", new User());
		}
		return modelAndView;
		
	}

}

/**
 * 
 */
package com.itachi.ekart.startup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itachi.ekart.startup.models.User;

/**
 * @author itachi
 *
 */
@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping(value="/login")
	public String login()
	{
		System.out.println("get login");
		return "Login";
	}
	
	@PostMapping(value="/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("post login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home");
		mv.addObject("username", username);
		mv.addObject("password", password);
		return mv;
	}
	@GetMapping(value="/register")
	public String register()
	{
		System.out.println("get register");
		return "Register";
	}
	
	@PostMapping(value="/register")
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("confirm") String confirm,@RequestParam("email") String email)
	{
		System.out.println("post register");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home");
		mv.addObject("username", username);
		mv.addObject("password", password);
		mv.addObject("confirm", confirm);
		mv.addObject("email", email);
		return mv;
	}
	
	@GetMapping(value="/home")
	public String home()
	{
		return "Home";
	}
	
	@GetMapping(value="/error")
	public String error()
	{
		return "Error";
	}
}

package com.itachi.connect.controllers;

import com.itachi.connect.dao.Users;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;

import com.itachi.connect.startup.DataSource;
import com.itachi.connect.startup.LogHandler;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {
	Logger logger = new LogHandler().getLoggerBean(Controller1.class);
	DataSource ds = null;
	Connection con = null;
	Controller1() {
		System.out.println("controller initialized");
		logger.trace("trace: initializing controller1...");
		logger.debug("debug: initializing controller1...");
		logger.warn("warn: initializing controller1...");
		logger.error("error: initializing controller1...");
		logger.fatal("fatal: initializing controller1...");
	}

	Map<String, String> inputStrMap = null;
	Map<String, String> inputObjMap = null;

	@RequestMapping(value = "/LogIn", method = RequestMethod.GET)
	public String loginGet(HttpServletRequest request, HttpServletResponse response) {
		return "LogIn";
	}

	@RequestMapping(value = "/LogIn", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, HttpServletResponse response) {
		return "LogIn";
	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public ModelAndView signupGet(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		inputStrMap = new HashMap<String, String>();
		mv.setViewName("SignUp");
		return mv;
	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public ModelAndView sigupPost(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		Users users = new Users();
		ds = new DataSource();
		con = ds.getConnection();
		inputStrMap = new HashMap<String, String>();
		users.addUser(inputStrMap);
		mv.setViewName("DashBoard");
		return mv;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(HttpServletRequest request, HttpServletResponse response,
	ModelAndView mv) { return signupGet(request,response,mv); }
	
	@RequestMapping(value = "/", method = RequestMethod.POST) 
	public ModelAndView homePost(HttpServletRequest request, HttpServletResponse response,
	  ModelAndView mv) { return signupGet(request,response,mv); }
	  
	@RequestMapping(value = "/DashBoard", method = RequestMethod.GET)
	public ModelAndView dashboardGet(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		inputStrMap = new HashMap<String, String>();
		mv.setViewName("DashBoard");
		return mv;
	}
}

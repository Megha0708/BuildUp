package com.buildup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.UserDao;
import com.buildup.model.User;
import com.buildup.model.UserCredentials;

@Controller
public class UserController {
	
	@Autowired
	UserDao userdao;
	public UserController()
	{}
	
	@RequestMapping(value ="/usersignup",method=RequestMethod.GET)
	public ModelAndView showUserdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("signup","user",new User());
		return mvc;
	}

	@RequestMapping(value="/InsertUser", method=RequestMethod.POST)
	public ModelAndView addUser(User user) 
	{
		UserCredentials userCreden= new UserCredentials();
		ModelAndView m1=new ModelAndView("signup","user",new User());
		
		userCreden.setEnabled(true);
		userCreden.setPassword(user.getPassword());
		userCreden.setRole("ROLE_USER");
		userCreden.setUsername(user.getUsername());
		
		userdao.insert(user);
		userdao.insertcreden(userCreden);
		return m1;
	}
}
	
	 


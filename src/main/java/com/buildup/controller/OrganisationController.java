package com.buildup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.DomainDao;
import com.buildup.dao.OrganisationDao;
import com.buildup.dao.UserDao;
import com.buildup.model.Fields;
import com.buildup.model.Organisation;
import com.buildup.model.UserCredentials;

@Controller
public class OrganisationController {
	
	@Autowired
	private OrganisationDao orgdao;
	
	@Autowired
	private DomainDao ddao;
	
	@Autowired
	private UserDao udao;
	
	public OrganisationController()
	{}
	
	@RequestMapping(value ="/orgsignup",method=RequestMethod.GET)
	public ModelAndView showUserdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("orgreg","org",new Organisation());
		String domains =ddao.Retrive();
		mvc.addObject("mylist3",domains);
		return mvc;
	}

	@RequestMapping(value="/InsertOrganisation", method=RequestMethod.POST)
	public ModelAndView addUser(Organisation org) 
	{
		UserCredentials orgCreden= new UserCredentials();
		ModelAndView m1=new ModelAndView("orgreg","org",new Organisation());
		
		
		orgCreden.setPassword(org.getPassword());
		orgCreden.setEnabled(true);
		orgCreden.setUsername(org.getUsername());
		orgCreden.setRole("ROLE_MENTOR");
		orgdao.insert(org);
		udao.insertcreden(orgCreden);
		
		return m1;
	}
	@RequestMapping(value ="/showMentor",method=RequestMethod.GET)
	public ModelAndView showMentordetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("mentor","organisation",new Organisation());
		String fields = orgdao.Retrive();
		mvc.addObject("mylist", fields);
	
		return mvc;
	}
}
	
	 


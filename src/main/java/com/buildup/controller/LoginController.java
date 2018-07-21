package com.buildup.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.UserDao;
import com.buildup.model.User;


@Controller
public class LoginController 
{
	@Autowired
	UserDao udao;
	public LoginController()
	{}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginSuccessful")
	public String login_session_attributes(HttpSession session,Model model)
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
	

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		String role="ROLE_USER";
		int size=0;
		
		System.out.println("Login :"+username);
		
		for (GrantedAuthority authority : authorities) 
		{
			if(authority.getAuthority().equals(role))
			{
				
				String mylist3=udao.retrieve(username);
				model.addAttribute("mylist3",mylist3);
				session.setAttribute("Userid", username);
		
				page="index";
//		page="lesson";
				session.setAttribute("UserLoggedIn",true);
				
				

				System.out.println("My Session	:"+session.getId());
		    }
			else if(authority.getAuthority().equals("ROLE_MENTOR"))
		    {
				session.setAttribute("UserLoggedIn",true);
				session.setAttribute("Userid", username);
			session.setAttribute("Mentor", "true");
			page="skype";
			}
			else 
		    {
				session.setAttribute("Userid", username);
			session.setAttribute("Administrator", "true");
			page="index";
			}
		}
		return page;
		
	}
	
	
	@RequestMapping("/Login")
	public String showlogin() 
	{
	System.out.println("Hiii Login");
	return "Login";
	}
	
	
	
	@RequestMapping("/userproductview")
	public ModelAndView show() 
	{
	System.out.println("Hiii Show");
	ModelAndView mvc = new ModelAndView("UserView","uv",new User());
	return mvc;
	}
	
	
	
	
	@RequestMapping("/Admin")
	public String Admin() 
	{
	System.out.println("Hiii Admin");
	return "AdminHeader";
	}
	
	
	
	@RequestMapping("/Suplier")
	public String Supplier() 
	{
	System.out.println("Hiii Supplier");
	return "SupplierView";
	}
	
	
	
	@RequestMapping("/Products")
	public String pro() 
	{
	System.out.println("Hiii Supplier");
	return "productreg";
	}
	
	
	
	@RequestMapping(value = "/perform_logout")
	public String homelogout() 
	{
	return "Login";
	}
	
}

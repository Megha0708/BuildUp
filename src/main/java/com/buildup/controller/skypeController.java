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


import com.buildup.model.Skype;
import com.buildup.model.go;

@Controller
public class skypeController{




@RequestMapping("/goback")
public ModelAndView go() 
{
System.out.println("hiiiiiiiiiiii");

ModelAndView mvc1 = new ModelAndView("index"," ",new go());
return mvc1;
}
}
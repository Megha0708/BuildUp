package com.buildup.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.BranchesDao;
import com.buildup.dao.DomainDao;
import com.buildup.dao.FieldsDao;
import com.buildup.model.Domain;
import com.buildup.model.Skype;

@Controller
public class DomainController 
{
	@Autowired
	private DomainDao ddao;
	
	@Autowired
	private BranchesDao bdao;
	
	@Autowired
	private FieldsDao fdao;
	
	@RequestMapping(value ="/domainAdd",method=RequestMethod.GET)
	public ModelAndView showUserdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("domainreg","domain",new Domain());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		String domains = ddao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		mvc.addObject("mylist3",domains);
		return mvc;
	}

	@RequestMapping(value="/addDomain", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("domain")Domain domain , BindingResult result) 
	{
		
		ModelAndView mvc=new ModelAndView("domainreg","domain",new Domain());
		ddao.insert(domain);
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		String domains = ddao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		mvc.addObject("mylist3",domains);
		
		String path="C:\\ThinkNew\\BuildUp\\src\\main\\webapp\\resources\\My_Design\\Dimages\\";
		path=path+String.valueOf(domain.getDid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=domain.getDimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
              			fos.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised "+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		
		return mvc;
	}

	@RequestMapping(value = "/DeleteDomain", method = RequestMethod.GET)
  	public ModelAndView DeleteSupplier(@RequestParam("did") int did) {

  		ddao.Delete(did);
		ModelAndView mvc=new ModelAndView("domainreg","domain",new Domain());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		String domains = ddao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		mvc.addObject("mylist3",domains);
  		return mvc;
  	}
  	
  	@RequestMapping(value="/plzUpdatedDomain", method=RequestMethod.GET)
  	public ModelAndView plzUpdatedSupplier(@RequestParam("did")int did)
  	{
  		Domain Domain=ddao.UpdateDomain(did);
          boolean data=true;
  		ModelAndView mvc=new ModelAndView("domainreg","domain",Domain);
  		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		String domains = ddao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		mvc.addObject("mylist3",domains);  		
		mvc.addObject("checkk",data);
  	   return mvc;
  	}

  	@RequestMapping(value="/plzNowUpdatedDomain", method=RequestMethod.POST)
  	public ModelAndView plzNowUpdatedSupplier(@ModelAttribute("domain")Domain domain,HttpServletRequest request)
  	{
  		
  		String did=request.getParameter("did");
  		String dname=request.getParameter("dname");
  		String fname=request.getParameter("fname");
  		String bname=request.getParameter("bname");
  		String desp=request.getParameter("description");
  		String price=request.getParameter("price");
  		boolean data=false;
  		int did1=Integer.parseInt(did);
  		float p=Float.parseFloat(price);
  		ddao.NowUpdateDomain(did1, dname,bname,fname, desp,p);
		ModelAndView mvc=new ModelAndView("domainreg","domain",new Domain());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		String domains = ddao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		mvc.addObject("mylist3",domains);
  		mvc.addObject("checkk",data);
  	   return mvc;
  	}
  	@RequestMapping(value="/dDescription", method=RequestMethod.GET)
	public ModelAndView showProduct(@RequestParam("did")int cid)
	{
		
       int data=3;
		ModelAndView mvc1 = new ModelAndView("domain","domain",new Domain());
		//String branches=bdao.Retrive1();
		//String fields =fdao.Retrive();
		String domains = ddao.Retrive1(cid);
		//mvc1.addObject("mylist1",branches);
		//mvc1.addObject("mylist2",fields);
		mvc1.addObject("mylist3",domains);
  		mvc1.addObject("checkk",data);
	   return mvc1;
	}
  	@RequestMapping(value = "/DisplayProduct", method = RequestMethod.GET)
	public ModelAndView showProductAdmin() 
	{
		
		
		ModelAndView mvc = new ModelAndView("domainreg","domain",new Domain());
		
		

		String domains = ddao.Retrive();
		mvc.addObject("mylist3",domains);
  		
	
		return mvc;
	}
  	
  	@RequestMapping("/skypeview")
	public ModelAndView show() 
	{
	System.out.println("hiiiiiiiiiiii");
	
	ModelAndView mvc = new ModelAndView("skype","skype",new Skype());
	return mvc;
	}
}

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
import com.buildup.dao.FieldsDao;
import com.buildup.model.Branches;
import com.buildup.model.Fields;


@Controller
public class BranchesController 
{
	@Autowired
	private BranchesDao bdao;
	
	@Autowired
	private FieldsDao fdao;
	
	@RequestMapping(value ="/branchAdd",method=RequestMethod.GET)
	public ModelAndView showBranchdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("branchreg","branch",new Branches());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		return mvc;
	}

	@RequestMapping(value="/addBranch", method=RequestMethod.POST)
	public ModelAndView addBranch(@ModelAttribute("branch")Branches branch , BindingResult result ) 
	{
		
		ModelAndView mvc=new ModelAndView("branchreg","branch",new Branches());
		bdao.insert(branch);
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
		
		String path="C:\\ThinkNew\\BuildUp\\src\\main\\webapp\\resources\\My_Design\\Bimages\\";
		path=path+String.valueOf(branch.getBid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=branch.getBimage();
		
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

	@RequestMapping(value = "/DeleteBranch", method = RequestMethod.GET)
  	public ModelAndView DeleteSupplier(@RequestParam("bid") int bid) {

  		bdao.Delete(bid);
		ModelAndView mvc=new ModelAndView("branchreg","branch",new Branches());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
  		return mvc;
  	}
  	
  	@RequestMapping(value="/plzUpdatedBranch", method=RequestMethod.GET)
  	public ModelAndView plzUpdatedSupplier(@RequestParam("bid")int bid)
  	{
  		Branches branch=bdao.UpdateBranch(bid);
          boolean data=true;
  		ModelAndView mvc=new ModelAndView("branchreg","branch",branch);
  		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
  		mvc.addObject("checkk",data);
  	   return mvc;
  	}

  	@RequestMapping(value="/plzNowUpdatedBranch", method=RequestMethod.POST)
  	public ModelAndView plzNowUpdatedSupplier(@ModelAttribute("branch")Branches branch,HttpServletRequest request)
  	{
  		
  		String bid=request.getParameter("bid");
  		String fname=request.getParameter("fname");
  		String bname=request.getParameter("bname");
  		String desp=request.getParameter("description");
  		
  		boolean data=false;
  		int bid1=Integer.parseInt(bid);
  		bdao.NowUpdateBranch(bid1, bname,fname, desp);
		ModelAndView mvc=new ModelAndView("branchreg","branch",new Branches());
		String branches=bdao.Retrive();
		String fields =fdao.Retrive();
		mvc.addObject("mylist1",branches);
		mvc.addObject("mylist2",fields);
  		mvc.addObject("checkk",data);
  	   return mvc;
  	}
	
  	@RequestMapping(value="/bDescription", method=RequestMethod.GET)
	public ModelAndView showProduct(@RequestParam("bid")int cid)
	{
		
       int data=3;
		ModelAndView mvc1 = new ModelAndView("branch","branch",new Branches());
		String branches=bdao.Retrive1(cid);
		mvc1.addObject("mylist2",branches);
//		String pocc=ddao.Retrive2(cid);
//		mvc1.addObject("poc",pocc);
		mvc1.addObject("checkk",data);
	   return mvc1;
	}
}

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
import com.buildup.model.Fields;


@Controller
public class FieldsController 
{

	@Autowired
	private FieldsDao fdao;
	
	@Autowired
	private BranchesDao bdao;
	
	@RequestMapping(value ="/fieldAdd",method=RequestMethod.GET)
	public ModelAndView showUserdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("fieldsreg","field",new Fields());
		String fields = fdao.Retrive();
		mvc.addObject("mylist", fields);
	
		return mvc;
	}

	@RequestMapping(value="/addField", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("field")Fields field , BindingResult result) 
	{
		
		ModelAndView mvc=new ModelAndView("fieldsreg","field",new Fields());
		
		System.out.println("Inside Controller");
		
		fdao.insert(field);
		
		String fields = fdao.Retrive();
		mvc.addObject("mylist", fields);
		
		String path="C:\\ThinkNew\\BuildUp\\src\\main\\webapp\\resources\\My_Design\\Fimages\\";
		path=path+String.valueOf(field.getFid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=field.getFimage();
		
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
	
	@RequestMapping(value = "DeleteField", method = RequestMethod.GET)
  	public ModelAndView DeleteSupplier(@RequestParam("fid") int fid) {

  		fdao.Delete(fid);
		ModelAndView mvc=new ModelAndView("fieldsreg","field",new Fields());
  		String fields = fdao.Retrive();
  		mvc.addObject("mylist", fields);
  		return mvc;
  	}
  	
  	@RequestMapping(value="/plzUpdatedField", method=RequestMethod.GET)
  	public ModelAndView plzUpdatedSupplier(@RequestParam("fid")int fid)
  	{
  		Fields field=fdao.UpdateField(fid);
          boolean data=true;
  		ModelAndView mvc=new ModelAndView("fieldsreg","field",field);
  		String suppliers=fdao.Retrive();
  		mvc.addObject("mylist",suppliers);
  		mvc.addObject("checkk",data);
  	   return mvc;
  	}

  	@RequestMapping(value="/plzNowUpdatedField", method=RequestMethod.POST)
  	public ModelAndView plzNowUpdatedSupplier(@ModelAttribute("field")Fields field,HttpServletRequest request)
  	{
  		
  		String fid=request.getParameter("fid");
  		String fname=request.getParameter("fname");
  		String desp=request.getParameter("description");
  		
  		boolean data=false;
  		int fid1=Integer.parseInt(fid);
  		fdao.NowUpdateField(fid1, fname, desp);
		ModelAndView mvc=new ModelAndView("fieldsreg","field",new Fields());
  		String suppliers=fdao.Retrive();
  		mvc.addObject("mylist",suppliers);
  		mvc.addObject("checkk",data);
  	   return mvc;
  	}
	
  	@RequestMapping(value="/fDescription", method=RequestMethod.GET)
	public ModelAndView showProduct(@RequestParam("fid")int cid)
	{
		
       int data=3;
		ModelAndView mvc1 = new ModelAndView("field","field",new Fields());
		String suppliers=fdao.Retrive1(cid);
  		mvc1.addObject("mylist1",suppliers);
  		//String supplier=bdao.Retrive();
  	//	mvc1.addObject("mylist2",supplier);
		mvc1.addObject("checkk",data);
	   return mvc1;
	}
	
}

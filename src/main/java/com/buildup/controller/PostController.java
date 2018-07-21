package com.buildup.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.CommentDao;
import com.buildup.dao.PostDao;
import com.buildup.model.Comment;
import com.buildup.model.Post;

@Controller
public class PostController {
	@Autowired
	PostDao pdao;
	
	@Autowired
	CommentDao cdao;
	
	
	public PostController()
	{}
	
	@RequestMapping(value ="/postup",method=RequestMethod.GET)
	public ModelAndView showPostdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("makepost","po",new Post());
		
		String comm = cdao.Retrive1();
		mvc.addObject("comments",comm);
		String posts = pdao.Retrive();
		mvc.addObject("mylist", posts);
		
		return mvc;
	}
	
	
	
	


	@RequestMapping(value = "/Insertpost", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("po")Post po,BindingResult result) 
	{
		
		ModelAndView m1=new ModelAndView("makepost","po",new Post());
		
		pdao.insert(po);
		
		String path="C:\\ThinkNew\\BuildUp\\src\\main\\webapp\\resources\\My_Design\\Pimages\\";
		path=path+String.valueOf(po.getpId())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=po.getPimage();
		
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
		 boolean data=false;
		
		String posts = pdao.Retrive();
		 m1.addObject("checkk",data);
		m1.addObject("mylist", posts);
		String comm = cdao.Retrive1();
		m1.addObject("comments",comm);


		
		return m1;
	}
	
	@RequestMapping(value="/plzUpdatedpost", method=RequestMethod.GET)
	public ModelAndView plzUpdatedProduct(@RequestParam("pid")int cid)
	{
		Post poc=pdao.UpdatePost(cid);
       boolean data=true;
		ModelAndView m1=new ModelAndView("makepost","po",poc);
		String posts = pdao.Retrive();
		
		String comm = cdao.Retrive1();
		m1.addObject("comments",comm);

		m1.addObject("mylist", posts);
		m1.addObject("checkk",data);
	   return m1;
	}
	
	
	@RequestMapping(value="/likepost", method=RequestMethod.GET)
	public ModelAndView like(@RequestParam("pid")int cid,@RequestParam("userid")String uid)
	{
		pdao.LikePost(cid,uid);
		ModelAndView m1=new ModelAndView("makepost","po",new Post());

		System.out.println("username:"+uid);
		
		
		
        boolean data=false;
		
		String posts = pdao.Retrive();
		 m1.addObject("checkk",data);
		m1.addObject("mylist", posts);
		String comm = cdao.Retrive1();
		m1.addObject("comments",comm);


		
		return m1;
	}


}

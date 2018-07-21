package com.buildup.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.buildup.dao.CommentDao;
import com.buildup.dao.PostDao;
import com.buildup.model.Comment;
import com.buildup.model.Post;

@Controller
public class CommentController {
	@Autowired
	private CommentDao cdao;
	
	@Autowired
	private PostDao pdao;
	
	
	@RequestMapping(value ="/showComment",method=RequestMethod.GET)
	public ModelAndView makeComment(@RequestParam("pid")int cid) 
	{	
		
		ModelAndView mvc=new ModelAndView("makepost","po",new Post());
		String branches=cdao.Retrive(cid);
		mvc.addObject("comments",branches);
		String posts = pdao.Retrive();
		mvc.addObject("mylist", posts);
		return mvc;
	}

	@RequestMapping(value="/makeComment", method=RequestMethod.GET)
	public ModelAndView addComment(@RequestParam("pid")int cid,@RequestParam("uid")String vid,@RequestParam("comment")String comments ) 
	{
		
		ModelAndView mvc=new ModelAndView("makepost","po",new Post());
		Comment c= new Comment();
		c.setPid(cid);
		c.setUid(vid);
		c.setComment(comments);
		cdao.insert(c);
		String branches=cdao.Retrive(cid);
		mvc.addObject("comments",branches);
		String posts = pdao.Retrive();
		mvc.addObject("mylist", posts);
		return mvc;
	}
	

	
}

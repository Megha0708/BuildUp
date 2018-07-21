package com.buildup.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buildup.dao.CartDao;
import com.buildup.dao.OrderDetailsDao;
import com.buildup.dao.DomainDao;
import com.buildup.dao.UserDao;
import com.google.gson.Gson;
import com.buildup.model.Cart;

import com.buildup.model.OrderDetails;
import com.buildup.model.Domain;
import com.buildup.model.User;

@Controller
public class CartControler {
	
	@Autowired
	DomainDao pdao;
	@Autowired
	CartDao cadao;
	@Autowired
	UserDao udao;
	@Autowired
	OrderDetailsDao odao;
	public CartControler()
	{}
	
	
	public float getGrandTotal(List<Cart> li)
	{
		ListIterator<Cart> itr=li.listIterator();
		float grandtotal=0;
		while(itr.hasNext())
		{
			Cart cd1=(Cart)itr.next();

			grandtotal=grandtotal+(cd1.getPrice());
			
		}
		return grandtotal;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/Carddetails", method = RequestMethod.GET)
	public String CardDetails(@RequestParam("pid")int cid,HttpSession session,Model m) 
	{
		
		System.out.println("This is my id"+ " "+cid);
		Domain ob=pdao.DisplayImage(cid);
		System.out.println("Thisssssssssss is my id"+ " "+cid);
		
		Cart cd=new Cart();
		cd.setPrice(ob.getPrice());
		cd.setDid(ob.getDid());
		
		cd.setName(ob.getDname());
		
		
		System.out.println("okkkkkkkkkk is my id"+ " "+cid);
		System.out.println("My Session"+session.getId());
		List<Cart> li=new ArrayList<Cart>();
		if(session.getAttribute("mycart")==null)
		{
			
			System.out.println("hii"+cd);
			li.add(cd);
			
		}
		else
		{
		 li=(ArrayList<Cart>)session.getAttribute("mycart");
		System.out.println("hii"+cd);
		li.add(cd);
		
		}
		session.setAttribute("mycart", li);
		int size=li.size();
		System.out.println(size);
		System.out.println(li);
		session.setAttribute("count",size);
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
	
		   m.addAttribute("cartitm",li);
		 
		System.out.println(session.getAttribute("mycart"));
		
		return "AddToCart";
	}
	@RequestMapping(value="/Removecart", method=RequestMethod.GET)
	public ModelAndView DeleteCart(@RequestParam("pid")int cid,HttpSession session)
	{
		System.out.println("This is my id"+ " "+cid);
		List<Cart> ld=(ArrayList<Cart>)session.getAttribute("mycart");
		ListIterator<Cart> lit=(ListIterator<Cart>) ld.listIterator();
		while(lit.hasNext())
		{
			Cart d=lit.next();
		if(d.getDid()==cid)
		{
			
			System.out.println(ld.indexOf(d));
			ld.remove(ld.indexOf(d));
			break;
		}
		}
		int size=ld.size();
		session.setAttribute("mycart",ld);
		session.setAttribute("count",size);
		ModelAndView mv = new ModelAndView("AddToCart", "addcart", new Cart());
		

		mv.addObject("cartitm",ld);
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(ld)));
		return mv;

	
		
	}
	
	@RequestMapping(value = "/HeyOrderConfirmation", method = RequestMethod.GET)
	public ModelAndView orderConfirm(HttpSession session)
	{
		@SuppressWarnings("unchecked")
		List<Cart>	li	=  (ArrayList<Cart>)session.getAttribute("mycart");
	

		Gson gsonli = new Gson();
		String gs = gsonli.toJson(li);
		session.setAttribute("cart", gs);
			ModelAndView  mv = new ModelAndView("OrderConfermation","addcart",new Cart());
			mv.addObject("cart",gs);
			mv.addObject("name",udao.name((String)session.getAttribute("Userid")));
			mv.addObject("address",udao.address((String)session.getAttribute("Userid")));
			mv.addObject("emailid",udao.email((String)session.getAttribute("Userid")));
			mv.addObject("mobile",udao.Mobile((String)session.getAttribute("Userid")));
			session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
			return mv;
	}
	@RequestMapping(value = "/giveMessage", method = RequestMethod.GET)
	public ModelAndView message(HttpSession session)
	{
		ModelAndView  mv = new ModelAndView("lesson","addcart",new Cart());
		return mv;
	}
	@RequestMapping(value = "/AddToCartgoback", method = RequestMethod.GET)
	public ModelAndView  cartgoback(HttpSession session,Model m)
	{
		
		
		@SuppressWarnings("unchecked")
		List<Cart>	li	=  (ArrayList<Cart>)session.getAttribute("mycart");
		ModelAndView mv = new ModelAndView("AddToCart", "addcart", new Cart());

		mv.addObject("cartitm",li);
		System.out.println(session.getAttribute("mycart"));
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		System.out.println("grandtotal");
		return mv;
			
	}
	@RequestMapping(value = "/PaymentConfirmed", method = RequestMethod.GET)
	public ModelAndView  paymentconfirm(HttpSession session) {
		List<Cart>	li	=  (ArrayList<Cart>)session.getAttribute("mycart");
		
		for(Cart cd:li)
		{
			cadao.showCardDetails(cd);
		}
		ModelAndView mv = new ModelAndView("PaymentConfermation", "addcart", new Cart());

		return mv;

	}
	@RequestMapping(value = "/thanku", method = RequestMethod.POST)
	public ModelAndView  Thanku(HttpSession session) {

	       
			ModelAndView v= new ModelAndView("Thankyou","OrderDetails",new OrderDetails());
			//v.addObject("data",data);
			//System.out.println(data);
			return v ;
			
	    }
//	@RequestMapping(value = "/updateqty", method = RequestMethod.GET)
//	public String updateqty(@RequestParam("qty")int qty,@RequestParam("pid")int cid,HttpSession session,Model m) 
//	{
//
//		System.out.println("Quantity:"+qty);
//		System.out.println("Product ID:"+cid);
//		ArrayList<Cart> li = (ArrayList<Cart>) session.getAttribute("mycart");
//		ListIterator<Cart> lit = (ListIterator<Cart>) li.listIterator();
//		while (lit.hasNext()) 
//		{
//			Cart d = lit.next();
//			if (d.getPid() == cid) 
//			{
//				d.setQty(qty);
//				d.setTotal(d.getQty()*d.getPrice());
//				lit.set(d);
//				break;
//			}
//			
//		}
//
//		m.addAttribute("cartitm",li);
//		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
//		
//		return "AddToCart";
//		
//
//}
	@RequestMapping(value = "/GoToCart", method = RequestMethod.GET)
	public ModelAndView gotocart(HttpSession session) {

		
		List<Cart> li=new ArrayList<Cart>();
		if(session.getAttribute("mycart")!=null)
		{
		 li=(ArrayList<Cart>)session.getAttribute("mycart");
		
		
		}
		else
		{
			
		}
		ModelAndView mv = new ModelAndView("AddToCart", "addcart", new Cart());
		mv.addObject("cartitm", li);

		System.out.println(session.getAttribute("cart"));
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		return mv;

	}	
	@RequestMapping(value = "/OrderConfirmed", method = RequestMethod.GET)
	public ModelAndView  orderconfirmed(HttpSession session) {
		List<Cart>	li	=  (ArrayList<Cart>)session.getAttribute("mycart");
		System.out.println("yoooouser");
		User userdetails=udao.display((String)session.getAttribute("Userid"));
		
		System.out.println("yoooouser2222");
	       String email=userdetails.getEmailid();
	       String phon= userdetails.getMobile();
	       
	       String user= userdetails.getUsername();
	       String addr=userdetails.getAddress();
	       
	       System.out.println("yoooo");
	       String fullAddress= user +"\t"+addr+"\t"+phon;
	       OrderDetails d= new OrderDetails();
			d.setPaymentMode("Cash on Delivery");
	       d.setUserId(session.getAttribute("Userid").toString());
	       d.setOrderDate(new Date());
	       d.setOrderStatus("processing");
	       
	       String f = session.getAttribute("grandtotal").toString();
	       
	       d.setGrandTotal(Float.valueOf(f));
	       d.setAddress(fullAddress);
	       
	       odao.addOrderDetails(d);
	       System.out.print("Order saved");
	       int ordId=d.getOrderId();
	       session.setAttribute("oid", ordId);
	       for(Cart cd:li)
	       {
	    	   cd.setOrderID(ordId);
	    	   cadao.showCardDetails(cd);
	    	  System.out.print("Cart detail saved");
	    	   
	       }
	       String data=odao.getOrderDetail(d.getOrderId());
	       ModelAndView mv= new ModelAndView("AfterConfirmed");
	       
			//ModelAndView v= new ModelAndView("Thankyou","OrderDetails",new OrderDetails());
			mv.addObject("data",data);
			System.out.println(data);
			return mv ;
	}
	@RequestMapping(value = "/Last", method = RequestMethod.GET)
	public ModelAndView  lastpagedone(HttpSession session) {
		List<Cart>	li	=  (ArrayList<Cart>)session.getAttribute("mycart");
		 int oid=(Integer)session.getAttribute("oid");
		 
		 OrderDetails d= new OrderDetails();
	      String data=odao.getOrderDetail(oid);
				ModelAndView v= new ModelAndView("Last","OrderDetail",new OrderDetails());
			v.addObject("data",data);

			return v ;
		
		
	}


}

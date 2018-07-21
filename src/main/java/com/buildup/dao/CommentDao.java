package com.buildup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Comment;
import com.google.gson.Gson;

@Repository
public class CommentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Comment c) 
	{
		Session session =sessionFactory.openSession();
		
		
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(c);
		session.flush();
		tx.commit();
		session.close();
	}
	public String Retrive(int pid)
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 Query qry = connection.createQuery("FROM Comment where pid= :post");
		 qry.setParameter("post",pid);
		 List listdata= qry.list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
	
	public String Retrive1()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Comment").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
	
	
	public void Delete(int bid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Comment ob=(Comment)session.get(Comment.class, bid);
		session.delete(ob);
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
}
	
	


}

package com.buildup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Liked;
import com.buildup.model.Post;

import com.google.gson.Gson;

@Repository
public class PostDao 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	public void insert(Post post)
	{
		Session session =sessionFactory.openSession();
		
		System.out.println("Insert Method Called for postDetails");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(post);
		session.flush();
		tx.commit();
		session.close();
   }
	public String Retrive()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Post").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
	
	public Post UpdatePost(Integer id) 
	{
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Post ob=(Post)session.get(Post.class, id);
		tx.commit();
		session.close();
		return ob;
	}
	
	public void LikePost(Integer id, String uid) {
		
		
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Query qry = session.createQuery("FROM Liked l where l.uid= :java4s and l.pid= :java5s");
		qry.setParameter("java4s",uid);
		qry.setParameter("java5s",id);
		List listdata=qry.list();
		if(listdata.isEmpty())
		{      Post ob=(Post)session.get(Post.class, id);
		       int likes=ob.getLikes()+1;
		
		        ob.setLikes(likes);
		        session.update(ob);
		        
		        Liked l= new Liked();
		        l.setPid(id);
		        l.setUid(uid);
		        session.save(l);
		        
		}
		else
		{
			Post ob=(Post)session.get(Post.class, id);
		       int likes=ob.getLikes()-1;
		       
		       ob.setLikes(likes);
		        session.update(ob);
		        
		      /*  Liked l= new Liked();
		       for(List row : listdata)
		        	l.setId(Integer.parseInt(row.toString()));
		        l.setId(listdata.get(0));
		        l.setPid(id);
		        l.setUid(uid);    
		        session.delete(l);  */  
		        
		    
		        
		        Query qry1 = session.createQuery("delete Liked l where l.uid= :java4s and l.pid= :java5s");
				qry1.setParameter("java4s",uid);
				qry1.setParameter("java5s",id); 
				
				int result = qry1.executeUpdate();   
		        
		}
		tx.commit();
		session.close();
	
	}
}

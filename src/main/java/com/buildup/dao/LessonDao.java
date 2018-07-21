package com.buildup.dao;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Lesson;
import com.google.gson.Gson;


@Repository
public class LessonDao 
{

	 @Autowired
	 private  SessionFactory sf;
	    
	 
	 public void insert(Category category)
		{
	        Session session =sf.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			session.save(category);
			session.flush();
			tx.commit();
			session.close();
			
		}
		
		public String Retrive()
		{
			Session connection=sf.openSession();
			Transaction tx=connection.getTransaction();
			tx.begin();
		
			 List listdata = connection.createQuery("FROM Lesson").list();
			 Gson gson = new Gson();
			 String jsonNames = gson.toJson(listdata);
			 tx.commit();
			 connection.close();
		     return jsonNames;

		}
		
		public void Delete(Integer cid) {
			Session session =sf.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			Lesson ob=(Lesson)session.get(Lesson.class, cid);
			session.delete(ob);
			tx.commit();
			session.close();
			System.out.println("Delete Method Called");
	}
		
		
		
	

}

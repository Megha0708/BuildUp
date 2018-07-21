package com.buildup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Fields;
import com.google.gson.Gson;

@Repository
public class FieldsDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Fields field) {
		Session session =sessionFactory.openSession();
		
		System.out.println("Inside Dao");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(field);
		session.flush();
		tx.commit();
		session.close();
   }

	public String Retrive()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Fields").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
	public String Retrive1(int cid)
	{
	Session connection=sessionFactory.openSession();
	Transaction tx=connection.getTransaction();
	tx.begin();

	 Query qry = connection.createQuery("FROM Fields p where p.fid= :java4s");
	 qry.setParameter("java4s",cid);
	 List listdata=qry.list();
	 Gson gson = new Gson();
	 String jsonNames = gson.toJson(listdata);
	 tx.commit();
	 connection.close();
     return jsonNames;

     
	}
	
	public void Delete(int fid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Fields ob=(Fields)session.get(Fields.class, fid);
		session.delete(ob);
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
}
	
	public Fields UpdateField(Integer fid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Fields ob=(Fields)session.get(Fields.class, fid);
		tx.commit();
		session.close();
		return ob;
	}
	public void NowUpdateField(int fid,String fname,String description) 
	{
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Fields ob=(Fields)session.get(Fields.class, fid);
		ob.setFname(fname);
		ob.setDescription(description);
        
		session.update(ob);
		tx.commit();
		session.close();
		System.out.println("Update Method Called");
	
	}

}
	
	
	


package com.buildup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Domain;
import com.google.gson.Gson;


@Repository
public class DomainDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Domain domain) 
	{
		Session session =sessionFactory.openSession();
		
		
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(domain);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public String Retrive()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Domain").list();
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
		Query qry=connection.createQuery("From Domain d where d.did=:java4s");
		qry.setParameter("java4s", cid);
		 List listdata = qry.list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
	
	public void Delete(int did) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Domain ob=(Domain)session.get(Domain.class, did);
		session.delete(ob);
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
}
	
	public Domain UpdateDomain(Integer did) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Domain ob=(Domain)session.get(Domain.class, did);
		tx.commit();
		session.close();
		return ob;
	}
	public void NowUpdateDomain(int did,String dname, String bname, String fname,String description,float price) 
	{
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Domain ob=(Domain)session.get(Domain.class, did);
		ob.setBname(bname);
		ob.setDname(dname);
		ob.setFname(fname);
		ob.setDescription(description);
        ob.setPrice(price);
		session.update(ob);
		tx.commit();
		session.close();
		System.out.println("Update Method Called");
	
	}
	public Domain DisplayImage(int ccid)
	{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Domain ok=(Domain)session.get(Domain.class,ccid);
	session.close();
	return ok;
	}
}

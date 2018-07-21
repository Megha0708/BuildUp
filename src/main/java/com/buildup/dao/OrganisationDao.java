package com.buildup.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.Organisation;
import com.google.gson.Gson;
@Repository
public class OrganisationDao {  //we keep all the methods in dao
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	public void insert(Organisation org) {
	
Session session =sessionFactory.openSession();
		
		System.out.println("Insert Method Called for OrganisationDetails");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(org);
		session.flush();
		tx.commit();
		session.close();
	}
	public String Retrive()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Organisation").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}

}


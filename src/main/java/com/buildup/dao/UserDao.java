package com.buildup.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buildup.model.User;
import com.buildup.model.UserCredentials;
import com.google.gson.Gson;


@Repository
public class UserDao {  //we keep all the methods in dao
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(User user) {
		Session session =sessionFactory.openSession();
		
		System.out.println("Insert Method Called for UserDetails");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(user);
		session.flush();
		tx.commit();
		session.close();
   }

	public void insertcreden(UserCredentials userCreden) {
        Session session =sessionFactory.openSession();
		System.out.println("Insert Method Called for UserCredentials");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(userCreden);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public String retrieve(String uname) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		 Query qry = session.createQuery("FROM User u where u.username= :java4s");
		 qry.setParameter("java4s",uname);
		 List listdata=qry.list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		tx.commit();
		session.close();
        return jsonNames;
}

	
	public String name(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String name = ((User) cr.add(Restrictions.like("username", uname)).list().get(0)).getUsername();
		session.close();
		return name;

	}
	public String address(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String addr = ((User) cr.add(Restrictions.like("username", uname)).list().get(0)).getAddress();
		session.close();
		return addr;

	}
	public String email(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String email = ((User) cr.add(Restrictions.like("username", uname)).list().get(0)).getEmailid();
		session.close();
		return email;

	}
	public String Mobile(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String mobile = ((User) cr.add(Restrictions.like("username", uname)).list().get(0)).getMobile();
		session.close();
		return mobile;

	}	
	
	public User display(String uname)
	{
		Session session = sessionFactory.openSession();
		System.out.println(uname);
		Criteria cr=session.createCriteria(User.class);
		User ru=(User)cr.add(Restrictions.like("username",uname)).list().get(0);
		session.close();
		return ru;

}
}

	
	




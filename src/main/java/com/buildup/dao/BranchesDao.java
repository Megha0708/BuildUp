package com.buildup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.buildup.model.Branches;
import com.google.gson.Gson;

import org.springframework.stereotype.Repository;

@Repository
public class BranchesDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Branches branch) 
	{
		Session session =sessionFactory.openSession();
		
		
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(branch);
		session.flush();
		tx.commit();
		session.close();
	}
	public String Retrive()
	{
		Session connection=sessionFactory.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Branches").list();
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
		Query qry=connection.createQuery("FROM Branches b where b.bid= :java4s");
		qry.setParameter("java4s",cid);
		 List listdata = qry.list();
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
		Branches ob=(Branches)session.get(Branches.class, bid);
		session.delete(ob);
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
}
	
	public Branches UpdateBranch(Integer bid) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Branches ob=(Branches)session.get(Branches.class, bid);
		tx.commit();
		session.close();
		return ob;
	}
	public void NowUpdateBranch(int bid,String bname,String fname,String description) 
	{
		Session session =sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Branches ob=(Branches)session.get(Branches.class, bid);
		ob.setBname(bname);
		ob.setFname(fname);
		ob.setDescription(description);
        
		session.update(ob);
		tx.commit();
		session.close();
		System.out.println("Update Method Called");
	
	}

}

package dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Admins;
import beans.Employees;

public class Userdao {
	// Employee registration
	
	public int eregister(String name, String email, String salary, String password )
	{
		int rtn =0;
		try {
		Employees user = new Employees();
		user.setName(name);
		user.setEmail(email);
		user.setSalary(salary);
		user.setPassword(password);
	
		Configuration cfg = new Configuration();
		
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		rtn = (int) session.save(user);
		
		t.commit();
		session.close();
		sf.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rtn;
	}
	
	// Admins registration
	public int aregister(String name, String email, String salary, String password )
	{
		int rtn =0;
		try {
		Admins user = new Admins();
		user.setName(name);
		user.setEmail(email);
		user.setSalary(salary);
		user.setPassword(password);
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		rtn = (int) session.save(user);
		
		session.flush();
		session.clear();
		t.commit();
		session.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rtn;
	}
	
	// Test Employee login 
	public Employees eauthenticate(String email, String password)
	{
		Employees user=null;
		try {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		Query<?> query=session.createQuery("from Employees where email=:e and password=:p");
		query.setParameter("e",email);
		query.setParameter("p",password);
		List<?> list=query.list();
		Iterator<?> itr=list.iterator();
		   if(itr.hasNext())
		     {
			user=(Employees) itr.next();
		     } 
		System.out.println("This is user "+user);
		  t.commit();
		  session.close();
		  sf.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
		}
		return user;
	}
	
	// Test Administration Login
	public Admins aauthenticate(String email, String password)
	{
		Admins user=null;
		try {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		Query<?> query=session.createQuery("from Admins where email=:e and password=:p");
		query.setParameter("e",email);
		query.setParameter("p",password);
		List<?> list=query.list();
		Iterator<?> itr=list.iterator();
		   if(itr.hasNext())
		     {
			user=(Admins) itr.next();
		     } 
		System.out.println("This is user "+user);
		t.commit();
		session.close();
		sf.close();
		    }
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
		}
		return user;
	}
	
	
	public void updateEmail(Integer id, String email)
	{
	try {
	
		
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	Query query2=session.createQuery("update Employees set email=:e where Emp_id=:eid");
	query2.setParameter("e", email);
	query2.setParameter("eid", id);
	query2.setCacheable(false);
	query2.executeUpdate();	
	tx.commit();
	session.close();
	sf.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	
	
	public void updateName(Integer id,String name)
	{
		try {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query1=session.createQuery("update Employees set Emp_name=:n where Emp_id=:eid");
		query1.setParameter("n", name);
		query1.setParameter("eid", id);
		query1.setCacheable(false);
		query1.executeUpdate();
		tx.commit();
		session.close();
		sf.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	
	
	public void updateSalary(Integer id, String salary)
	{
	try
	{
       // Employees user = new Employees();
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//user.setSalary(salary);
		Query query3=session.createQuery("update Employees set salary=:s where Emp_id=:eid");
		query3.setParameter("s", salary);
		query3.setParameter("eid", id);
		query3.setCacheable(false);
		query3.executeUpdate();
	
	tx.commit();
	session.close();
	sf.close();
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	
	public void deleteEmp(Integer id)
	{
	try {
	Employees user = new Employees();
	user.setId(id);
	Configuration cfg = new Configuration();
	cfg.configure("resources/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction t = session.beginTransaction();
	//Query<?> query=session.createQuery("from Employees where email=:e and password=:p");
	Query<Employees> query = session.createQuery("delete from Employees where Emp_id=:eid");
	query.setParameter("eid",id);
	query.executeUpdate();
	t.commit();
	session.close();
	sf.close();
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }

 }

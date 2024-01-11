package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.entity.Student2;
import com.hiber.HibernateUtil;


public class LaunchMain {


public static void main(String[] args) {
	Session session=null;
	Transaction transaction=null;
	boolean flag=false;
	try {
	session=HibernateUtil.getSession();
	  if(session!=null)
		  transaction=session.beginTransaction();
	  if(transaction!=null)
	  {
		  Student2 st=new Student2();
		  st.setId(4);
		  st.setName("tumari");
		  st.setAge(22);
		  st.setCity("sand");
		  session.save(st);
		  flag=true;
	  }
	}catch(HibernateException e) {
	   e.printStackTrace();	
	}
	catch(Exception e) {
		e.printStackTrace();	
	}
	finally {
		if(flag) {
		    transaction.commit();
		    System.out.println("data is saved");
		}
		else {
			transaction.rollback();
			System.out.println("not able to store the data in db");
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
}
}

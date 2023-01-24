package com.p5.demo;

import com.p5.demoentity.Coustemer;
import com.p5.demoentity.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CreateCoustemer {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			Coustemer c1=new Coustemer("sanjay","c","jio,airtel");
			System.out.println("saving");
			entityManager.persist(c1);
			System.out.println("coustemer: "+c1);
			System.out.println("saved....");
			Service s1=new Service(636081527);
			Service s2=new Service(990025395);
			c1.addService(s1);
			c1.addService(s2);
			entityManager.persist(s1);
			entityManager.persist(s2);
			System.out.println("saved services: "+c1.getServices());
			entityTransaction.commit();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			entityManager.close();
		}
	}

}

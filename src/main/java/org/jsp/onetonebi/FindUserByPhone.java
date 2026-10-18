package org.jsp.onetonebi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindUserByPhone {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<User> q = em.createQuery("select u from User u where u.phone = ?1",User.class);
		System.out.println("Enter User Phone : ");
		q.setParameter(1, sc.nextLong());
		User u = q.getSingleResult();
		if(u!=null) {
			System.out.println(u);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	
	}
}

package org.jsp.onetonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumberAndDob {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select c.user from AadharCard c where c.number = ?1 and c.dob = ?2");
		System.out.println("Enter AadharCard Number : ");	
		q.setParameter(1, sc.nextLong());
		System.out.println("Enter DOB(DD-MM-YYYY) : ");
		q.setParameter(2, sc.next());
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e) {
			System.err.println("No Record Found !!!");
		}
		finally {
			sc.close();
		}
	
	}
}

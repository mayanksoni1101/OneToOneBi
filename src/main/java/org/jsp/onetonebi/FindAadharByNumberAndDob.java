package org.jsp.onetonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByNumberAndDob {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select c from AadharCard c where c.number = ?1 and c.dob = ?2");
		System.out.println("Enter Aadhar Card Number = ");
		q.setParameter(1, sc.nextLong());
		System.out.println("Enter Dob(DD-MM-YYYY) : ");
		q.setParameter(2, sc.next());
		try {
		AadharCard card = (AadharCard) q.getSingleResult();
		System.out.println(card);
		}
		catch(NoResultException e) {
			System.err.println("No Record Found !!!");
		}
		finally {
			sc.close();
		}
	
	}
}

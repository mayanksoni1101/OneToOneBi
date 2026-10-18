package org.jsp.onetonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserNameAndPhone {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select u.card from User u where u.phone = ?1 and u.name = ?2");
		System.out.println("Enter User Phone : ");
		q.setParameter(1, sc.nextLong());
		sc.nextLine();
		System.out.println("Enter User Name : ");
		q.setParameter(2, sc.nextLine());
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

package org.jsp.onetonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select a.user from AadharCard a where a.id = ?1");
		System.out.println("Enter the Aadhar Card Id : ");
		q.setParameter(1, sc.nextInt());
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e) {
			System.out.println("No Record Found !!!");
		}
		finally {
			sc.close();
		}
	}
}

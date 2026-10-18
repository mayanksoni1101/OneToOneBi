package org.jsp.onetonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindUserByName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<User> q = em.createQuery("select u from User u where u.name = ?1",User.class);
		System.out.println("Enter User Name : ");
		q.setParameter(1, sc.nextLine());
		List<User> ul = q.getResultList();
		if(!ul.isEmpty()) {
			ul.forEach(System.out::println);
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

package org.jsp.onetonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindUserById {
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
	EntityManager em = emf.createEntityManager();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the User Id : ");
	User u = em.find(User.class, sc.nextInt());
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

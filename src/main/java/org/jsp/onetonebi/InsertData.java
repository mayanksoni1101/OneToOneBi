package org.jsp.onetonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		User u = new User();
		u.setName("Mayank Soni");
		u.setPassword("admin");
		u.setPhone(9485688456l);
		
		AadharCard card = new AadharCard();
		card.setNumber(3646415861979132l);
		card.setDob("11-01-2004");
		card.setAddress("Sirsa-Haryana");
		card.setUser(u);
		
		u.setCard(card);
		em.persist(u);
		etran.commit();
	}
}

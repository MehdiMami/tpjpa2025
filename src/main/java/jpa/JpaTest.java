package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import Entity.Event;
import Entity.User;
import Entity.Ticket;
import java.util.Date;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEntities();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

	private void createEntities() {
		// Create and persist Users
		User user1 = new User("Alice Johnson", "alice.johnson@example.com");
		User user2 = new User("Bob Brown", "bob.brown@example.com");
		manager.persist(user1);
		manager.persist(user2);

		// Create and persist Events
		Event event1 = new Event("Music Concert", "New York", new Date(), "Music");
		Event event2 = new Event("Art Exhibition", "Paris", new Date(), "Art");
		manager.persist(event1);
		manager.persist(event2);

		// Create and persist Tickets
		Ticket ticket1 = new Ticket("VIP", 150.0, event1);
		ticket1.setUser(user1);
		Ticket ticket2 = new Ticket("Regular", 50.0, event1);
		ticket2.setUser(user2);
		Ticket ticket3 = new Ticket("VIP", 200.0, event2);
		ticket3.setUser(user1);
		Ticket ticket4 = new Ticket("Regular", 75.0, event2);
		ticket4.setUser(user2);
		manager.persist(ticket1);
		manager.persist(ticket2);
		manager.persist(ticket3);
		manager.persist(ticket4);
	}
}
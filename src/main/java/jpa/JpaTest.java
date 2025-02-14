package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.Query;
import Entity.Event;
import Entity.User;
import Entity.PremiumTicket;
import Entity.LastMinuteTicket;
import java.util.Date;
import java.util.List;

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
			test.runQueries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

	private void createEntities() {

		User user1 = new User("Alice Johnson", "alice.johnson@example.com");
		User user2 = new User("Bob Brown", "bob.brown@example.com");
		manager.persist(user1);
		manager.persist(user2);


		Event event1 = new Event("Music Concert", "New York", new Date(), "Music");
		Event event2 = new Event("Art Exhibition", "Paris", new Date(), "Art");
		manager.persist(event1);
		manager.persist(event2);


		PremiumTicket premiumTicket1 = new PremiumTicket("VIP", 150.0, event1, "A1");
		premiumTicket1.setUser(user1);
		PremiumTicket premiumTicket2 = new PremiumTicket("VIP", 200.0, event2, "B1");
		premiumTicket2.setUser(user1);
		manager.persist(premiumTicket1);
		manager.persist(premiumTicket2);


		LastMinuteTicket lastMinuteTicket1 = new LastMinuteTicket("Regular", 50.0, event1);
		lastMinuteTicket1.setUser(user2);
		LastMinuteTicket lastMinuteTicket2 = new LastMinuteTicket("Regular", 75.0, event2);
		lastMinuteTicket2.setUser(user2);
		manager.persist(lastMinuteTicket1);
		manager.persist(lastMinuteTicket2);
	}

	private void runQueries() {
		TypedQuery<PremiumTicket> namedQuery = manager.createNamedQuery("PremiumTicket.findAll", PremiumTicket.class);
		List<PremiumTicket> premiumTickets = namedQuery.getResultList();
		System.out.println("Named Query - All PremiumTickets: " + premiumTickets);

		Query query = manager.createQuery("SELECT l.user.name FROM LastMinuteTicket l");
		List<LastMinuteTicket> lastMinuteTickets = query.getResultList();
		System.out.println("Normal Query - All LastMinuteTickets: " + lastMinuteTickets);
	}
}
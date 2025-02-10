

| ![][image1] | Master 1 SIR  | ![][image2] |
| :---- | :---: | ----: |

   
**à la découverte de JPA**

Les objectifs de ce travail pratique sont les suivants :

* Comprendre les mécanismes de JPA  
* Réaliser une application en utilisant JPA en se plaçant dans un cadre classique de développement sans serveur d’application au départ.

**Recommandations.** Ce TP utilise des technologies abordées en cours d’un point de vue théorique, mais la documentation technique peut être facilement trouvée sur internet.  
Quelques exemples de sites qui fournissent de la documentation sur JPA sont les suivantes:  
[https://en.wikibooks.org/wiki/Java\_Persistence](https://en.wikibooks.org/wiki/Java_Persistence)  
[http://www.oracle.com/technetwork/middleware/ias/toplink-jpa-annotations-096251.html](http://www.oracle.com/technetwork/middleware/ias/toplink-jpa-annotations-096251.html)

Être autodidacte est une compétence essentielle pour tout informaticien; n'hésitez pas à chercher des tutoriels si vous êtes bloqués.

# **Sujet : Application de Vente de Tickets de Concert en Ligne**

## **1\. Introduction**

### **1.1 Contexte**

L'objectif de ce projet est de développer une application web et mobile permettant aux utilisateurs d'acheter des tickets de concert en ligne. L'application doit offrir une expérience utilisateur fluide, sécurisée et intuitive, tout en permettant aux organisateurs de concerts de gérer simplement leurs événements.

### **1.2 Objectifs**

* Permettre aux utilisateurs de rechercher, consulter et acheter des tickets de concert.  
* Offrir une plateforme de gestion pour les organisateurs d'événements.  
* Assurer la sécurité des transactions et des données utilisateurs.  
* Proposer une interface responsive et accessible sur un navigateur web.

---

### **1.3. Fonctionnalités**

### **Fonctionnalités pour les Utilisateurs**

* **Recherche et Consultation des Concerts** :  
  * Recherche de concerts par artiste, lieu, date, genre musical.  
  * Affichage des détails de l'événement (date, lieu, prix, description).  
  * Filtres et tris (par prix, date, popularité).  
* **Achat de Tickets** :  
  * Sélection des places (si applicable).  
  * Envoi du ticket par email ou téléchargement direct.  
  * Option d'annulation et de remboursement (selon les conditions de l'organisateur).  
* **Gestion des Tickets** :  
  * Accès à un espace personnel pour consulter les tickets achetés.  
  * Possibilité de transférer un ticket à un autre utilisateur.  
* **Notifications** :  
  * Alertes pour les nouveaux concerts, rappels d'événements, et offres spéciales.

### **Fonctionnalités pour les Organisateurs**

* **Gestion des Événements** :  
  * Création, modification et suppression d'événements.  
  * Ajout de détails (date, lieu, description, prix, capacité).  
  * Gestion des stocks de tickets.  
* **Statistiques et Rapports** :  
  * Suivi des ventes en temps réel.  
  * Rapports sur les performances des événements.  
* **Communication** :  
  * Envoi de notifications aux acheteurs de tickets (changements d'horaire, annulations, etc.).

### **2.3 Fonctionnalités Administrateur.**

* **Gestion des Événements** :  
  * Validation des événements créés par les organisateurs.  
  * Modération des contenus.

---

### **1.4 Exigences Techniques**

### **Plateformes**

* **Web** : Compatibilité avec les navigateurs modernes (Chrome, Firefox, Safari, Edge).

### **Technologies**

* **Front-end** : HTML5, CSS3, JavaScript (React.js ou Angular).  
* **Back-end** : Java (JPA)  
* **Base de données** : MySQL, PostgreSQL.  
* **Paiement** : Intégration d'API de paiement (Stripe, PayPal, etc.) (optionelle ;).


---

### **1.5 Design et Expérience Utilisateur (UX/UI)**

### **Design**

* Interface moderne et épurée.  
* Palette de couleurs et typographie cohérentes avec la marque.  
* Expérience utilisateur intuitive et accessible.

### **Responsive Design**

* Adaptation de l'interface à tous les dispositifs (desktop, mobile, tablette).  
* Temps de chargement optimisé.

.   
Dans une première étape, nous nous intéressons uniquement au modèle métier de cette application. Faites un premier diagramme de classes sur feuille blanche de ce modèle métier, créer les classes Java correspondantes et utilisons JPA pour créer la base de données et la couche d’accès aux données. 

Organisation.

Vous trouverez un template de projet sur [https://github.com/barais/tpjpa2023](https://github.com/barais/tpjpa2023)

Vous pouvez forker le projet contenant :

* Un template de projet pour la construction d’application autonome utilisant JPA, hibernate et hsqldb. 

Décompressez ce projet sur votre compte et importez dans eclipse ou intelliJ. 

**Pour eclipse 4.X**  
Depuis eclipse 4.X, le support de maven s’est amélioré. Pour importer votre projet. File \-\> import \-\> maven \-\> existing maven project.  
Votre projet est configuré.

**Démarrage de la base de données**. Puis dans la version copiée sur votre compte allez dans le répertoire du projet. Vous trouverez là le script de démarrage de la base de données (run-hsqldb-server.sh) et le script du démarrage du Manager (show-hsqldb.sh). Lancez le système de base de données, puis le *Manager*. Connectez vous à la base de données (login : sa – et pas de mot de passe : \-- URL de connexion : jdbc:hsqldb:hsql://localhost/ ). Le fichier de données se trouve dans le répertoire Data. Vous pourrez supprimer l'ensemble des fichiers de ce répertoire si vous souhaitez réinitialiser complètement votre système de base de données.

Question 0\.  
Regardez rapidement le pom.xml, vous constaterez que c’est un projet simple avec deux dépendances (hibernate et hsqldb (driver jdbc pour hsqldb)). 

Ce qui donne finalement les dépendances suivantes.   
![][image3]

Question 1\.

Transformez  une première classe en entité. 

Travaillez uniquement sur le champ id et les attributs de la classe. Créez plusieurs instances de cette classe. Rendez ces instances persistantes. Regardez dans le manager de la base de données le résultat.

Vous devez obtenir ce genre de code **mais sur vos classes métier.**

	 	 	  
**package** test.testjpa.domain;

**import** javax.persistence.Entity;  
**import** javax.persistence.GeneratedValue;  
**import** javax.persistence.Id;  
**import** javax.persistence.ManyToOne;

@Entity  
**public** **class** Employee {  
	**private** Long id;

	**private** String name;

	**private** Department department;

	**public** Employee() {  
	}

	**public** Employee(String name, Department department) {  
		**this**.name \= name;  
		**this**.department \= department;  
	}

	**public** Employee(String name) {  
		**this**.name \= name;  
	}

	@Id  
	@GeneratedValue  
	**public** Long getId() {  
		**return** id;  
	}

	**public** **void** setId(Long id) {  
		**this**.id \= id;  
	}

	**public** String getName() {  
		**return** name;  
	}

	**public** **void** setName(String name) {  
		**this**.name \= name;  
	}

	@ManyToOne  
	**public** Department getDepartment() {  
		**return** department;  
	}

	**public** **void** setDepartment(Department department) {  
		**this**.department \= department;  
	}

	@Override  
	**public** String toString() {  
		**return** "Employee \[id=" \+ id \+ ", name=" \+ name \+ ", department="  
				\+ department.getName() \+ "\]";  
	}

}

Question 2\.

Même travail avec une première association entre deux entités.

Vous devez obtenir un code qui ressemble à cela mais sur vos classes métier. N’oubliez pas de remplacer les attributs mis à *Transient* sur vos classes précédentes. 

	 	 	  
**package** test.testjpa.domain;

**import** java.util.ArrayList;  
**import** java.util.List;

**import** javax.persistence.CascadeType;  
**import** javax.persistence.Entity;  
**import** javax.persistence.GeneratedValue;  
**import** javax.persistence.Id;  
**import** javax.persistence.OneToMany;

@Entity  
**public** **class** Department {

	**private** Long id;

	**private** String name;

	**private** List\<Employee\> employees \= **new** ArrayList\<Employee\>();

	**public** Department() {  
		**super**();  
	}

	**public** Department(String name) {  
		**this**.name \= name;  
	}

	@Id  
	@GeneratedValue  
	**public** Long getId() {  
		**return** id;  
	}

	**public** **void** setId(Long id) {  
		**this**.id \= id;  
	}

	**public** String getName() {  
		**return** name;  
	}

	**public** **void** setName(String name) {  
		**this**.name \= name;  
	}

	@OneToMany(mappedBy \= "department", cascade \= CascadeType.*PERSIST*)  
	**public** List\<Employee\> getEmployees() {  
		**return** employees;  
	}

	**public** **void** setEmployees(List\<Employee\> employees) {  
		**this**.employees \= employees;  
	}  
}

Question 3\.

Finissez le modèle métier présenté précédemment. Intégrez une classe de service permettant de peupler la base mais aussi de faire des requêtes sur la base de données.

Le code pour créer les entités peut ressembler à cela :

	 	 	  
**package** test.testjpa.jpa;

**import** java.util.List;

**import** javax.persistence.EntityManager;  
**import** javax.persistence.EntityManagerFactory;  
**import** javax.persistence.EntityTransaction;  
**import** javax.persistence.Persistence;

**import** test.testjpa.domain.Employee;  
**import** test.testjpa.domain.Department;

**public** **class** JpaTest {

	**private** EntityManager manager;

	**public** JpaTest(EntityManager manager) {  
		**this**.manager \= manager;  
	}  
	/\*\*  
	 \* **@param** args  
	 \*/  
	**public** **static** **void** main(String\[\] args) {  
		EntityManagerFactory factory \=     
 			 Persistence.*createEntityManagerFactory*("example");  
		EntityManager manager \= factory.createEntityManager();  
		JpaTest test \= **new** JpaTest(manager);

		EntityTransaction tx \= manager.getTransaction();  
		tx.begin();  
		**try** {  
			test.createEmployees();  
		} **catch** (Exception e) {  
			e.printStackTrace();  
		}  
		tx.commit();

		test.listEmployees();  
			  
   	 manager.close();  
		System.*out*.println(".. done");  
	}

	**private** **void** createEmployees() {  
		**int** numOfEmployees \= manager.createQuery("Select a From Employee a", Employee.**class**).getResultList().size();  
		**if** (numOfEmployees \== 0\) {  
			Department department \= **new** Department("java");  
			manager.persist(department);

			manager.persist(**new** Employee("Jakab Gipsz",department));  
			manager.persist(**new** Employee("Captain Nemo",department));

		}  
	}

	**private** **void** listEmployees() {  
		List\<Employee\> resultList \= manager.createQuery("Select a From Employee a", Employee.**class**).getResultList();  
		System.*out*.println("num of employess:" \+ resultList.size());  
		**for** (Employee next : resultList) {  
			System.*out*.println("next employee: " \+ next);  
		}  
	}}

## ***Question 4\. Connexion à une base mysql***

Modifiez le fichier *persistence.xml* afin de vous connecter sur une base de données *MySQL* de l'istic.  
Pour ce faire connecter vous sur http://anteros.istic.univ-rennes1.fr (besoin du vpn [https://istic.univ-rennes1.fr/intranet/services\#section-4](https://istic.univ-rennes1.fr/intranet/services#section-4)) pour vous créer votre base de données. Puis en vous inspirant de l’exemple suivant [http://snipplr.com/view/4450/](http://snipplr.com/view/4450/) modifiez votre fichier persistence.xml pour vous connecter à votre base de données.  
Il est aussi nécessaire d’ajouter le driver jdbc vers mysql. Pour ce faire ajoutez la dépendance dans le pom.xml

Si vous vous connecter à l’IISTIC (anteros)  
		\<dependency\>  
			\<groupId\>mysql\</groupId\>  
			\<artifactId\>mysql\-connector-java\</artifactId\>  
			\<version\>5.1.49\</version\>  
		\</dependency\>

Si vous vous connectez à votre mysql installé sur votre machine.  
 	 	 	  
		\<dependency\>  
			\<groupId\>mysql\</groupId\>  
			\<artifactId\>mysql\-connector-java\</artifactId\>  
			\<version\>8.0.22\</version\>  
		\</dependency\>

## ***Question 5\. Portez votre application et gérer au minimum une relation d’héritage, les requêtes, une requête nommée.*** 

	  
Pour l’héritage, on peut imaginer des “tickets” de type différents, par exemple  des tickets premium ou des tickets “last minute” sans place réservée.  
Tester différentes stratégies d’héritage et regarder l’impact sur la structure de votre base de donnée relationnelle.

Faites vos requêtes en utilisant les criteria query.  
http://stackoverflow.com/questions/5705291/select-in-equivalent-in-jpa2-criteria

## ***Question 6\.  Mise en évidence du problème de n+1 select.*** 

Pour comprendre le problème du n+1 select.   
récupérez le code joint depuis github.   
[https://github.com/barais/tpM2s.git](https://github.com/barais/tpM2s.git)

Comme d’habitude c’est un projet Maven.   
Lancez JPAtest pour peupler la base de données.  
Lancez N1select pour faire une requête en chargement paresseux (problème du n+1 select)  
Lancez JoinFetch pour faire une requête en chargement au plus tôt (sans le problème du n+1 select)  
Comparez les performances et le nombre de requêtes réellement effectuées. 

Bon TP

Adrien et Olivier

---

[image1]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAF4AAAA1CAAAAADtigMrAAAEt0lEQVR4XrVX4XkrKQxMS2qBMtSG2qAE/aUE2qAEWqAE3Yyw85K9hPX5u6fE9i4LgxgJMfsRf9U+rg2/WVd5mvXrw1/tNfheRGNWExdcY6ayrl1+tlfghwDQfQxTk1aLyuoiLy3hBfgiS3rxEqK1SOlNShGpUq4df7Bb+CoS4GR2GUtlWIyQWdRcMO2187/sDr5W4M8OfqS0hOtFa+9lclq9dr/aDXwzMfPlVtbqpgr2mTdF6gC6eb0OuNgZfiFFdIjoXEAGOr/wA55KMINkXod8tzO8IWMAI7GMftN9mhpSp4KfPm7ie4RfUl0ENGzshDabDQvoUUato9+4f4JfyL+ypib6dpxfiDevQmoDb3Id9c1O8ETH+Gl9uSrSppu1DviYnCg068TR/RO8cLeWMghoURURyPa+gmtpSFmt5/pwgG9cOPYmAml0Fdi+Bp+MQMJjLnYosuf82Q7wuzyCe/CyGFJUTeRkw6PZqoV3Focz+7fwsYM6B2syl7CA3732cO4ITnAd+MVO8CgsQ4bSe4DPXjnTrLg2W9xeoUieeJMc8OtakC0j0veMp86GVAEykzNsTPFT4TnAY9l9mDPRUWYmvGS6q3rCd8L7LNMlw/2zHeAt0yL3Uef/9Me2BVcGeMTBa1Vk7nXkHzvAM7DVGuCatlhk41EZFtMy4QdKpx021gEe24ihNUNIOwkB9zXc1Lt75hP3rfb3uRcrm3AU+fTdUROMmZPwQ6UuezcxVzTta2ah555lOcgczbQhOrO+vgnv9D5YL5OIWE9tMDszFE08tMa7RWFKwTFI8klFurwfeFKD3VahGs6K5ACPgk5FVhhUBpc1oYOasXiemOI4KHJ2/ghPKaNzgGOmY51MTs8nqPfWGsu9npg/w0cthrPEB7lOtvti1W+MbJtaR9N5SssbeFQ16L2iY/NfkZMzCw+iQP0A6Xl2/gZ+CmuuVlvUl2A5WWcgxPJkOcY17uCjdm+TFUZj7IBSJCCJupdF6q8DLnYDHwgfRcHiInbpGoaEgSQMrOxG5dzDBzU9N1ga0xzbdhWUMpn/g4RleqYiMcM6GnQxzsWxsCPGc5ed7B4eWs3oNNeBeXAMyipQsKcy/2kf4XdWqfG3OTQnXxy4kvuB/pL3tJWCrE6VZp2K+drhF3sRnjag8uE1lcLL9h/g37GPQHY5z2p8PISSwFP9OTctdDZPrfwEi4RvBcFrJj1UHIUJRu73FAxFGZR9I5/wHEx4T7HKZ2sutOLlIfj/KC2LN49reVw4fzYCf2Etvc2bBzzO1ISH7wVCNYg0cohe4J9A+Nl7lscvPCrZ/IDflvAzl1bYWvdX9pn4Yxn45j15WFfv8W6EIfswzqHPUvEFPspK7ws8zIxNalHdH/Bs2vAD1/zNFwc0Q8wa4YNqrbrD97Ir3Vf4IY33PI4295l/PMp/8/7hpMOtVamKysP7VHWROB9kqiei8JuDsw86O3nSpP8P/JfQPgLYcyo6XHJoRjCfEL4w9ITfpOPj1RlFJKUnOYTf5GBfTVzXJIfzOLQEZ9GEH7ivLcpDWSX8i3ZffH+yl+Hfsw9qvHxv3b8Uqlv07Zee5+1nezbu/+z1GPi8+uzOpr/u/T/+NzEy71c5UAAAAABJRU5ErkJggg==>

[image2]: <data:image/png;base64,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>

[image3]: <data:image/png;base64,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>
package app;

import javax.persistence.EntityManager;

import conf.JPAUtil;
import model.Produto;

public class Main {

	 public static void main(String[] args) {
			
	 EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	 entityManager.getTransaction().begin();

	 Produto produto = new Produto("Leite", 19.75, 1);
	        
	 entityManager.persist(produto);
	 entityManager.getTransaction().commit();
	 entityManager.close();

	 JPAUtil.shutdown();
	 }

	}

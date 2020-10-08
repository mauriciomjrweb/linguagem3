package app;

import java.util.List;

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
		
		
		entityManager.getTransaction().begin();
		Produto prodcon = entityManager.find(Produto.class, 1);
		
		System.out.println(prodcon.toString());

		List<Produto> produtos = entityManager.createQuery("FROM " + Produto.class.getName()).getResultList();
		
		entityManager.close();
		
		JPAUtil.shutdown();
	}

}

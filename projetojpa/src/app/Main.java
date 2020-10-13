package app;

import java.util.List;

import javax.persistence.EntityManager;

import conf.JPAUtil;
import model.Produto;
import model.Tipo;

public class Main {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		// CREATE PRODUTO (persist)
		Produto produto1 = new Produto("0011", "Cafeteria 2000", 20.59, Tipo.FISICO, 10, true);
		Produto produto2 = new Produto("0012", "Vassoura X200", 199.69, Tipo.FISICO, 5, true);
		Produto produto3 = new Produto("0013", "PANO", 9.69, Tipo.FISICO, 0, false);
		em.getTransaction().begin();
		em.persist(produto1);
		em.persist(produto2);
		em.persist(produto3);
		em.getTransaction().commit();
		//

		// READ/UPDATE UM PRODUTO 1 (find)
		Produto produto1con = em.find(Produto.class, 1);
		produto1con.setQuantidade(9);
		produto1con.setDescricao("CAFETEIRA");
		em.merge(produto1con);
		//

		// READ/DELETE
		Produto produto2con = em.find(Produto.class, 2);
		em.getTransaction().begin();
		em.remove(produto2con);
		em.getTransaction().commit();
		//

		// READ ALL PRODUTOS (query)
		List<Produto> produtos = em.createQuery("FROM " + Produto.class.getName()).getResultList();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		//

		em.close();

		JPAUtil.shutdown();
	}

}

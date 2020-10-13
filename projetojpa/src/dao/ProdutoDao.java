package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conf.JPAUtil;
import model.Produto;

public class ProdutoDao implements Dao<Produto> {

	private EntityManager em;

	public ProdutoDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Produto get(int id) {
		return em.find(Produto.class, id);
	}

	@Override
	public List<Produto> getAll() {
		Query query = em.createQuery("SELECT p FROM Produto p");
		return query.getResultList();
	}

	@Override
	public void save(Produto p) {
		executeInsideTransaction(entityManager -> entityManager.persist(p));

	}

	@Override
	public void update(Produto p) {
		executeInsideTransaction(entityManager -> entityManager.merge(p));
	}

	@Override
	public void delete(Produto p) {
		executeInsideTransaction(entityManager -> entityManager.remove(p));
	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}

/*
 * Reference: https://www.baeldung.com/java-dao-pattern
 */
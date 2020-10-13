package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Produto;

public class ProdutoDao implements Dao<Produto> {

	private EntityManager em;

	public ProdutoDao() {

	}

	@Override
	public Optional<Produto> get(long id) {
		return Optional.ofNullable(em.find(Produto.class, id));
	}

	@Override
	public List<Produto> getAll() {
		Query query = em.createQuery("SELECT p FROM Produto p");
		return query.getResultList();
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

}

//https://www.baeldung.com/java-dao-pattern

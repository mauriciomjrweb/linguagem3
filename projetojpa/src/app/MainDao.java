package app;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import conf.JPAUtil;
import dao.ProdutoDao;
import model.Produto;
import model.Tipo;

public class MainDao {

	public static void main(String[] args) {

		//EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		// CREATE PRODUTO (persist)
		Produto produto1 = new Produto("0011", "Cafeteria 2000", 20.59, Tipo.FISICO, 10, true);
		Produto produto2 = new Produto("0012", "Vassoura X200", 199.69, Tipo.FISICO, 5, true);
		Produto produto3 = new Produto("0013", "PANO", 9.69, Tipo.FISICO, 0, false);
	
		ProdutoDao daop = new ProdutoDao();
		daop.save(produto1);
		daop.save(produto2);
		daop.save(produto3);
		
		Produto prodcon1 = daop.get(1);
		prodcon1.setQuantidade(5);
		prodcon1.setDescricao("CAFE");
		daop.update(prodcon1);
		
		Produto prodcon2 = daop.get(2);
		daop.delete(prodcon2);
		
		List<Produto> produtos = daop.getAll();
		
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
		JPAUtil.shutdown();
		
	}

}

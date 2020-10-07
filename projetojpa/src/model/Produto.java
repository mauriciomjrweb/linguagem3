package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	private double preco;
	private int quantidade;

	 public Produto() { }

	 public Produto(String descricao, double preco, int quantidade) {
			this.descricao = descricao;
			this.preco = preco;
			this.quantidade = quantidade;
		}

	 public int getId() { return id; }
	 public void setId(int id) { this.id = id; }

	 public String getDescricao() { return descricao; }
	 public void setDescricao(String descricao) { this.descricao = descricao; }
	 
	 public double getPreco() { return preco; }
	 public void setPreco(double preco) { this.preco = preco; }

	 public int getQuantidade() { return quantidade; }
	 public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

} 
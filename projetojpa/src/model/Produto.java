package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 10, unique = true)
	private String referencia;
	
	@Column(name = "pro_descricao", nullable = false )
	private String descricao;
	
	@Column(precision = 6, scale = 2)
	private double preco;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private int quantidade;
	
	@Transient
	private boolean disponivel;

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

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", referencia=" + referencia + ", descricao=" + descricao + ", preco=" + preco
				+ ", tipo=" + tipo + ", quantidade=" + quantidade + ", disponivel=" + disponivel + "]";
	}
	
	

} 
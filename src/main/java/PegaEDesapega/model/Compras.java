package PegaEDesapega.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Compras")
public class Compras {

	@Id
	private String id_Produto;
	
	private String Numero_cartao_credito;
	private String Bandeira_do_cartao;
	private String validade_do_cartao;
	private double valor;
	private String Nome_produto;
	private String id_comprador;
	private String id_vendedor;
	
	public Compras() {
		// TODO Auto-generated constructor stub
	}
	
	public Compras(String numero_cartao_credito, String bandeira_do_cartao, String validade_do_cartao,
			String id_comprador, String id_Produto, String id_vendedor, int qtd, double Valor, String produto) {
		super();
		Numero_cartao_credito = numero_cartao_credito;
		Bandeira_do_cartao = bandeira_do_cartao;
		this.validade_do_cartao = validade_do_cartao;
		this.id_comprador = id_comprador;
		this.id_Produto = id_Produto;
		this.id_vendedor = id_vendedor;
		this.Nome_produto = produto;
		this.valor = Valor;
	}
	
	public String getNumero_cartao_credito() {
		return Numero_cartao_credito;
	}


	public void setNumero_cartao_credito(String numero_cartao_credito) {
		Numero_cartao_credito = numero_cartao_credito;
	}


	public String getBandeira_do_cartao() {
		return Bandeira_do_cartao;
	}


	public void setBandeira_do_cartao(String bandeira_do_cartao) {
		Bandeira_do_cartao = bandeira_do_cartao;
	}


	public String getValidade_do_cartao() {
		return validade_do_cartao;
	}


	public void setValidade_do_cartao(String validade_do_cartao) {
		this.validade_do_cartao = validade_do_cartao;
	}


	public String getId_comprador() {
		return id_comprador;
	}


	public void setId_comprador(String id_comprador) {
		this.id_comprador = id_comprador;
	}


	public String getId_Produto() {
		return id_Produto;
	}


	public void setId_Produto(String id_Produto) {
		this.id_Produto = id_Produto;
	}


	public String getId_vendedor() {
		return id_vendedor;
	}


	public void setId_vendedor(String id_vendedor) {
		this.id_vendedor = id_vendedor;
	}
	public String getNome_produto() {
		return Nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		Nome_produto = nome_produto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	
	
	
	

}

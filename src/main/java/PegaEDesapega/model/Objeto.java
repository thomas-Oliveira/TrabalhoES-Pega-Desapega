package PegaEDesapega.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Objeto")
public class Objeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String id_dono;
	  
	private String Nome; 
	private String Descricao;
	private Double Valor;
	private String Categoria;
	
	public Objeto() {}
	
	public Objeto(Long id, String Nome, String Descricao, Double Valor) {
		this.Descricao = Descricao;
		this.id = id;
		this.Nome = Nome;
		this.Valor = Valor;
	}
	
	public Long getID(){
		return id;
	}
	public void setid(Long id){
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome; 
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descrição) {
		Descricao = descrição;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	
	@Override
	public String toString() {
		return "Objeto: " + Nome +" Valor: "+ Valor +  " Drecrição: " + Descricao;
	}
	public String getId_dono() {
		return id_dono;
	}
	public void setId_dono(String id_dono) {
		this.id_dono = id_dono;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	

}

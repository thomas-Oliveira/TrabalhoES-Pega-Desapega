package PegaEDesapega.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="Usuario")
public class Usuario {
	
	@NotNull 
	@Size(min=2, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min=5, max=100, message="O tamanho deve ser entre {min} e {max}")
	private String email;
	
	private String endereco;
	
	@Id
	@NotNull
	private String cpf;
	
	@NotNull
	private String Senha;
			
	public Usuario() {}
	
	public Usuario(String Cpf, String nome, String email, String endereco, String senha) {
		this.cpf = Cpf;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.Senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		this.Senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getcpf() {
		return cpf;
	}
	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
	

	@Override
	public String toString() {
		return "Usuario [" +"senha= "+ Senha + " cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + "]";
	}

	
}
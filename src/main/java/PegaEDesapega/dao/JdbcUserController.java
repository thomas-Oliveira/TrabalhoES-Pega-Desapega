package PegaEDesapega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PegaEDesapega.model.Usuario;



public class JdbcUserController {

	private Connection connection;

	public JdbcUserController() {
		this.connection = new PegaEDesapega.dao.ConnectionFactory().getConnection();
	}
	
	private Usuario mapRow(ResultSet rs) throws SQLException {
		Usuario contato = new Usuario();
		contato.setcpf(rs.getString("cpf"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		contato.setSenha(rs.getString("senha"));
		return contato;
	}
	
	public void adiciona(Usuario user) {
		String sql = "insert into Usuario " + 
				"(cpf,nome,email,endereco,senha)" + 
				" values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getcpf());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getEndereco());
			stmt.setString(5, user.getSenha());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(String cpf) {
		try {
			String sql = "delete from Usuario where cpf = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario buscar(String cpf){
		try {
			Usuario result = null;
			String sql = "select * from Usuario where cpf = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = mapRow(rs);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Usuario contato) {
		try {
			String sql = "update Usuario set nome = ?,email = ?,endereco = ?,senha = ? where cpf = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4, contato.getSenha());
			stmt.setString(5, contato.getcpf());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
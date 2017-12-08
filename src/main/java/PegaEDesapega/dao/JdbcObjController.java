package PegaEDesapega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PegaEDesapega.model.Objeto;

public class JdbcObjController {

	private Connection connection;

	public JdbcObjController() {
		this.connection = new PegaEDesapega.dao.ConnectionFactory().getConnection();
	}

	public void adiciona(Objeto obj) {
		String sql = "insert into Objeto " + 
				"(id_dono, nome, descricao, valor, categoria)" + 
				" values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				obj.setid(rs.getLong(1));
			}
			stmt.setString(1, obj.getId_dono());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getDescricao());
			stmt.setDouble(4, obj.getValor());
			stmt.setString(5, obj.getCategoria());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			String sql = "delete from Objeto where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Objeto mapRow(ResultSet rs) throws SQLException {
		Objeto contato = new Objeto();
		contato.setCategoria(rs.getString("categoria"));
		contato.setDescricao(rs.getString("descricao"));
		contato.setid(rs.getLong("id"));
		contato.setId_dono(rs.getString("id_dono"));
		contato.setNome(rs.getString("nome"));
		contato.setValor(rs.getDouble("valor"));
		return contato;
	}

	public List<Objeto> getLista(String id) {
		try {
			List<Objeto> Objetos = new ArrayList<Objeto>();
			PreparedStatement stmt;
			String sql = "select * from Objeto where id_dono = ? ORDER BY id";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Objeto Obj = mapRow(rs);
				Objetos.add(Obj);
			}
			rs.close();
			stmt.close();
			return Objetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Objeto> getLista() {
		try {
			List<Objeto> Objetos = new ArrayList<Objeto>();
			PreparedStatement stmt;
			String sql = "select * from Objeto ORDER BY id DESC";
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Objeto Obj = mapRow(rs);
				Objetos.add(Obj);
			}
			rs.close();
			stmt.close();
			return Objetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Objeto obj) {
		try {
			String sql = "update Objeto set nome = ?, descricao = ?, valor = ?, categoria = ? where (id = ? and id_dono = ?)";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getDescricao());
			stmt.setDouble(3, obj.getValor());
			stmt.setString(4, obj.getCategoria());
			stmt.setLong(5, obj.getID());
			stmt.setString(6, obj.getId_dono());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Objeto buscar(Long long1){
		try {
			Objeto result = null;
			String sql = "select * from Objeto where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, long1);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = mapRow(rs);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Objeto> getListaProcurar(String psq) {
		try {
			List<Objeto> Objetos = new ArrayList<Objeto>();
			PreparedStatement stmt; 
			String sql = "select * from Objeto where (Nome ilike '%" + psq + "%')";
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Objeto Obj = mapRow(rs);
				Objetos.add(Obj);
			}
			rs.close();
			stmt.close();
			return Objetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Objeto> getListaCAtegoria(String psq) {
		try {
			List<Objeto> Objetos = new ArrayList<Objeto>();
			PreparedStatement stmt; 
			String sql = "select * from Objeto where categoria = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, psq);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Objeto Obj = mapRow(rs);
				Objetos.add(Obj);
			}
			rs.close();
			stmt.close();
			return Objetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

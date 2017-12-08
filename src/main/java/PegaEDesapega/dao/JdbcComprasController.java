package PegaEDesapega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PegaEDesapega.model.Compras;

public class JdbcComprasController {
	
	private Connection connection;

	public JdbcComprasController() {
		this.connection = new PegaEDesapega.dao.ConnectionFactory().getConnection();
	}
	
	public void adiciona(Compras obj) {
		String sql = "insert into Compras " + 
				"(Numero_cartao_credito, Bandeira_do_cartao, validade_do_cartao, id_comprador, id_Produto, id_vendedor, nome_produto, Valor)" + 
				" values (?,?,?,?,?,?,?,?)";
		try { 
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, obj.getNumero_cartao_credito());
			stmt.setString(2, obj.getBandeira_do_cartao()); 
			stmt.setString(3, obj.getValidade_do_cartao());
			stmt.setString(4, obj.getId_comprador());
			stmt.setString(5, obj.getId_Produto());
			stmt.setString(6, obj.getId_vendedor());
			stmt.setString(7, obj.getNome_produto());
			stmt.setDouble(8, obj.getValor());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Compras obj) {
		try {
			String sql = "update Objeto set Numero_cartao_credito = ?, Bandeira_do_cartao = ?, validade_do_cartao = ?, id_comprador = ?, id_Produto = ?, id_vendedor = ?, Quantidade = ?, valor_total_compra = ?, nome_produto = ?, valor_unitario = ? where (id_produto = ?)";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, obj.getNumero_cartao_credito());
			stmt.setString(2, obj.getBandeira_do_cartao()); 
			stmt.setString(3, obj.getValidade_do_cartao());
			stmt.setString(4, obj.getId_comprador());
			stmt.setString(5, obj.getId_Produto());
			stmt.setString(6, obj.getId_vendedor());
			stmt.setString(7, obj.getNome_produto()); 
			stmt.setString(8, obj.getId_Produto());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(String id_Produto) {
		try {
			String sql = "delete from Compras where id_Produto = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, id_Produto);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private Compras mapRow(ResultSet rs) throws SQLException {
		Compras c = new Compras();
		c.setBandeira_do_cartao(rs.getString("Bandeira_do_cartao"));
		c.setId_comprador(rs.getString("id_comprador"));
		c.setId_Produto(rs.getString("id_produto"));
		c.setId_vendedor(rs.getString("id_vendedor"));
		c.setValidade_do_cartao(rs.getString(("validade_do_cartao")));
		c.setNumero_cartao_credito(rs.getString("numero_cartao_credito"));
		c.setNome_produto(rs.getString("nome_produto"));
		c.setValor(rs.getDouble("Valor"));
		return c;
	}
	
	public List<Compras> ListCompras(String comprador){
		try {
			List<Compras> compra = new ArrayList<Compras>();
			PreparedStatement stmt;
			String sql = "select * from Compras where id_comprador = ? ORDER BY id_comprador";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, comprador);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Compras cp = mapRow(rs);
				compra.add(cp);
			}
			rs.close();
			stmt.close();
			return compra;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Compras buscar(String id_comprador, String id_Produto){
		try {
			Compras result = null;
			String sql = "select * from Compras where id_comprador = ? and id_Produto = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, id_comprador);
			stmt.setString(2, id_Produto);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = mapRow(rs);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

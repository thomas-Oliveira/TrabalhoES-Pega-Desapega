package PegaEDesapega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcImagemController {

	private Connection connection;

	public JdbcImagemController() {
		this.connection = new PegaEDesapega.dao.ConnectionFactory().getConnection();
	}

	
	public Boolean inserir(byte[] img, Long id, Long id_produto)
    {
        Boolean retorno = false;
        String sql = "INSERT INTO Imagens id, id_produto, imagem values (?,?,?)";
        
        try
        {
        	PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setLong(2, id_produto);
            stmt.setBytes(3, img);
            stmt.executeUpdate();
            retorno = true;
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return retorno;
    
    }
	
	
}

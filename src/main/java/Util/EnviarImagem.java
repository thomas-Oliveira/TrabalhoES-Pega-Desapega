package Util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import PegaEDesapega.dao.JdbcImagemController;

@SuppressWarnings("serial")
public class EnviarImagem extends JFrame{
	
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;
	public static PreparedStatement pstmt = null;

	//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new ImagemBanco().setVisible(true);
//	}
	
	public EnviarImagem(){
		try{
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Importar imagem");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			String caminhoImagem = null;
			int a = fileChooser.showOpenDialog(null);
			/**
			 *  Se a for igual a zero e porque o usuario clicou em salvar, se for 1 e porque clicou em cancelar
			 */
			if (true)//a==0)
			{	
				caminhoImagem = fileChooser.getSelectedFile().getAbsolutePath();// Aqui estou pegando o nome do arquivo e o endereco dele  
				File input = new File(caminhoImagem);//Seleciona o arquivo do disco		
				//Aqui eu redimensiono a imagem a partir do file, 128x128 px  
				BufferedImage imageInput = ImageIO.read(input);  
				BufferedImage scaled = new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2d = scaled.createGraphics();
				g2d.drawImage(imageInput, 0, 0, 128, 128, null);
				g2d.dispose();
				//Crie um ByteArrayOutputStream
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				
				(new JdbcImagemController()).inserir(byteArrayOutputStream.toByteArray(), Long.parseLong("1"), Long.parseLong("2"));
				
//				//Jogue a imagem lá dentro do byteArrayOutputStream
//				ImageIO.write(scaled, "png", byteArrayOutputStream);
//				//Prepara a sql e logo em seguida inser os bytes no campo parametrizado
//				pstmt = connection.prepareStatement("INSERT INTO imagens values (0,?)");// o ? significa que ainda completareios parametros que faltam
//				pstmt.setBytes(1, byteArrayOutputStream.toByteArray()); //Complemento agora, passando a posicao do parametro e o valor
//				pstmt.executeUpdate();// Insiro no BD
//				
//				//Fazendo processo contrario e pegaremos a imagem do banco para exibir, primeiro vamos pegar qual foi ID gerada pela chave
//				//primaria auto incremento.
//				statement= connection.createStatement();
//				resultSet= statement.executeQuery("SELECT DISTINCT LAST_INSERT_ID() FROM imagens");        
//				resultSet.next();
//				int id = resultSet.getInt(1);// Esse é a chave primaria do registro
//				//Carregando o resultSet com a nossa busca
//				resultSet = pstmt.executeQuery("SELECT * FROM imagens WHERE id="+id);
//				resultSet.next();
//				//Pegando a imagem (a partiri dos bytes que veio do banco) do registro pesquisado
//				Image img = Toolkit.getDefaultToolkit().createImage(resultSet.getBytes(2));
//				//Fechando a conexao
//				connection.close();
//				//Montando o imageIcon a partir do image
//				ImageIcon imageIcon = new ImageIcon(img);
//				//Criando o grafico para mostrar o resultado
//				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				setSize(160,172);
//				this.setLayout(null);
//				JLabel label = new JLabel();
//				label.setIcon(imageIcon);
//				label.setBounds(10,10,128,128);
//				setLocationRelativeTo(null);
//				this.add(label);
			}
			else{
				System.exit(0);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO");
		}		
	}
}
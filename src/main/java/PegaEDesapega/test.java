package PegaEDesapega;

import java.util.Scanner;

import PegaEDesapega.UsuarioController.UserControllerDao;
import PegaEDesapega.model.Objeto;
import PegaEDesapega.model.Usuario;

public class test {
	public static void main(String[] args) {
	
    	
    	System.out.println("Cadastrar Usuario - 1");
    	System.out.println("Remover Usuario - 2");
    	System.out.println("Cadastrar Objeto - 3");
    	UserControllerDao UC = new UserControllerDao();
    	Scanner entrada =  new Scanner(System.in);
    	
    	int op = entrada.nextInt();
    	
    	switch (op) {
		case 1:{
			entrada.nextLine();
			String nome = entrada.nextLine();
			String email = entrada.next();
			String endereco = entrada.next();
			String cpf = entrada.next();
			String senha  = entrada.next();
			
			UC.cadastro(new Usuario(cpf, nome, email, endereco, senha));
			
					
			break;
		}case 2:{
			String cpf = entrada.next();
			
			UC.RemoverUsuario(cpf);
			break;
		}case 3:{
			Long id = entrada.nextLong();
			String Nome = entrada.next();
			String Descricao = entrada.next();
			Double Valor = entrada.nextDouble();
			String Cpf_user = entrada.next();
				
			UC.cadastroObj(new Objeto(id, Nome, Descricao, Valor), Cpf_user);
			break;
		}case 4:{
			long id = entrada.nextLong();
			
			UC.RemoverObj(id);
			break;
		}
		
		default:
			break;
		}
    	
    	entrada.close();
	}
}

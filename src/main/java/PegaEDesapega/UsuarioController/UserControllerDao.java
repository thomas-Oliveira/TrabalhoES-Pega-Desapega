package PegaEDesapega.UsuarioController;

import java.util.List;

import PegaEDesapega.dao.JdbcComprasController;
import PegaEDesapega.dao.JdbcObjController;
import PegaEDesapega.dao.JdbcUserController;
import PegaEDesapega.model.Compras;
import PegaEDesapega.model.Objeto;
import PegaEDesapega.model.Usuario;

public class UserControllerDao {
	
	JdbcUserController User_dao = new JdbcUserController();
	JdbcObjController Obj_dao = new JdbcObjController();
	JdbcComprasController comp_dao = new JdbcComprasController();
	
	public String cadastro(Usuario user) {		
		User_dao.adiciona(user);
		return "Sucesso";
	}
	
	public void RemoverUsuario(String cpf){
		User_dao.remove(cpf);
	}
	
	public void cadastroObj(Objeto obj, String cpf_dono){
		obj.setId_dono(cpf_dono);
		Obj_dao.adiciona(obj);
	}
	
	public void RemoverObj(Long id){
		Obj_dao.remove(id);
	}
	
	public Usuario Buscar_Usuario(String cpf){
		return User_dao.buscar(cpf);
	}
	
	public Objeto Buscar_Objeto(Long long1){
		return Obj_dao.buscar(long1);
	}
	
	public List<Objeto> Buscar_Objetos(String psq){
		return Obj_dao.getListaProcurar(psq);
	}
	
	public List<Objeto> Buscar_Objetos_Categoria(String cate){
		return Obj_dao.getListaCAtegoria(cate);
	}
	
	public void Alterar_user(Usuario user){
		User_dao.altera(user);
	}
	
	public List<Objeto> GetObjetos(String cpf){
		return Obj_dao.getLista(cpf);
	}
	
	public List<Objeto> GetObjetos(){
		return Obj_dao.getLista();
	}
	
	public void Alterar_obj(Objeto obj){
		Obj_dao.altera(obj);
	}
	
	public void AddCompra(Compras cp){
		comp_dao.adiciona(cp);
	}
	
	public List<Compras> GetCompras(String comprador){
		return comp_dao.ListCompras(comprador);
	}
	
	public Compras buscar_compra(String id_comprador, String id_Produto){
		return comp_dao.buscar(id_comprador, id_Produto);
	}
	
	public void AlterarCompra(Compras c){
		comp_dao.altera(c);
	}
	
	public void remover_compra(String id_Produto){
		comp_dao.remove(id_Produto);
	}
	
}

package PegaEDesapega.UsuarioController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import PegaEDesapega.model.Compras;
import PegaEDesapega.model.Objeto;
import PegaEDesapega.model.Usuario;
import Util.EnviarImagem;

@Controller
public class UserController {

	UserControllerDao dao = new UserControllerDao();

	@RequestMapping("/Login")
	public String Login(HttpServletRequest request,Usuario aux){
		Usuario user = dao.Buscar_Usuario(aux.getcpf());
		System.out.println(user.getcpf());
		if (user.getSenha().equals(aux.getSenha())){
			request.getSession().setAttribute("usuario", user);
			request.getSession().setAttribute("nome", user.getNome());
			request.getSession().setAttribute("email", user.getEmail());
			request.getSession().setAttribute("endereco", user.getEndereco());
			request.getSession().setAttribute("cpf", user.getcpf());
			request.getSession().setAttribute("Logado", true);
		}
		return "redirect:/";
	}

	@RequestMapping("/Logout")
	public String Logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/";
	}

	@RequestMapping("/ProcurarCate")
	public String procurarCAte(HttpServletRequest request, String Procurar){
		try{
		List<Objeto> objts = dao.Buscar_Objetos_Categoria(Procurar);
		request.getSession().setAttribute("MostraIndex", "Produtos sobre: " + Procurar);
		request.getSession().setAttribute("produtosIndex", objts);
		}catch (Exception e) {
			System.out.println(e);
		}
		return "Home";
	}
	
	@RequestMapping("/Procurar")
	public String procurar(HttpServletRequest request, String Procurar){
		try{
		List<Objeto> objts = dao.Buscar_Objetos(Procurar);
		request.getSession().setAttribute("MostraIndex", "Produtos sobre: " + Procurar);
		request.getSession().setAttribute("produtosIndex", objts);
		}catch (Exception e) {
			System.out.println(e);
		}
		return "Home";
	}

	@RequestMapping("/Cadastro")
	public String Cadastro(HttpServletRequest request, Usuario user){
		dao.cadastro(user);
		return "redirect:/";
	}

	@RequestMapping("/Myaccount")
	public String account(HttpServletRequest request, Usuario user){
		return "/Myaccount";
	}

	@RequestMapping("/AlterarUser")
	public String AlterUser(HttpServletRequest request, Usuario aux){
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		if (!(aux.getEmail() == null)){
			user.setEmail(aux.getEmail());
			request.getSession().setAttribute("email", user.getEmail());
		}
		if (!(aux.getEndereco() == null)){
			user.setEndereco(aux.getEndereco());
			request.getSession().setAttribute("endereco", user.getEndereco());
		}
		if (!(aux.getSenha() == null)){
			user.setSenha(aux.getSenha());
		}
		dao.Alterar_user(user);
		return "/Myaccount";
	}

	@RequestMapping("/AddObj")
	public String AddObj(HttpServletRequest request, Objeto obj){
		System.out.println("aqui");
		dao.cadastroObj(obj, ((Usuario) request.getSession().getAttribute("usuario")).getcpf());
		return "redirect:/Myaccount";
	}

	@RequestMapping("/MostrarProdutos")
	public String Mostrar(HttpServletRequest request){
		List<Objeto> objts = dao.GetObjetos(((Usuario) request.getSession().getAttribute("usuario")).getcpf());
		request.getSession().setAttribute("produtos", objts);
		return "/Myaccount";
	}

	@RequestMapping("/CarrinhoMostrar")
	public String carrinhomostrar(HttpServletRequest request){
		try{ 
			String comprador = (String) request.getSession().getAttribute("cpf");
			List<Compras> comps = dao.GetCompras(comprador);
			double valorTotal = 0.0;
			for(Compras c : comps ){
				valorTotal += c.getValor();
			}
			request.getSession().setAttribute("carrinho_qtd", comps.size());
			request.getSession().setAttribute("meu_carrinho", comps);
			request.getSession().setAttribute("carrinho_valor_total", valorTotal);
		}catch(Exception e){
		}
		return "/Cart";
	}

	@RequestMapping("/Carrinho")
	public String carrinho(HttpServletRequest request, String id_vendedor, String id_produto){
		try	{
			String cpf = (String) request.getSession().getAttribute("cpf");
			Objeto obj = dao.Buscar_Objeto(Long.parseLong(id_produto));
			Compras compra = new Compras("", "", "",cpf, id_produto, id_vendedor, 1, obj.getValor(), obj.getNome());
			dao.AddCompra(compra);
		} catch (Exception e){
			System.out.print(e);
		}

		return "redirect:/CarrinhoMostrar";
	}

	@RequestMapping("/AlterarObjr")
	public String AlterObj(HttpServletRequest request, Objeto aux){
		Objeto obj = dao.Buscar_Objeto(aux.getID());
		if(!(aux.getValor() == null)){
			obj.setValor(aux.getValor());
		}
		if(!(aux.getDescricao() == null)){
			obj.setDescricao(aux.getDescricao());
		}
		if(!(aux.getNome() == null)){
			obj.setNome(aux.getNome());
		}
		dao.Alterar_obj(obj);
		return "redirect:/MostrarProdutos";
	}

	@RequestMapping("/Remover")
	public String remover_produto(HttpServletRequest request, Long id){
		dao.RemoverObj(id); 
		return "redirect:/MostrarProdutos";
	}

	@RequestMapping("/Produto")
	public String product(HttpServletRequest request, Long id){
		Objeto objt = dao.Buscar_Objeto(id);
		request.getSession().setAttribute("objt_produto", objt);
		return "/Product";
	}

	@RequestMapping("/Imagem")
	public String Imagem(HttpServletRequest request){
		new EnviarImagem().setVisible(true);
		return "";
	}

	@RequestMapping("/Mensagens")
	public String mensagens(HttpServletRequest request){
		return "/Mensagens";
	}
	
	@RequestMapping("/RemoverCompra")
	public String removercompra(HttpServletRequest request, String id){
		dao.remover_compra(id);
		return "redirect:/CarrinhoMostrar";
	}
	
	@RequestMapping("/ConfirmePagamento")
	public String ConfirmePagamento(HttpServletRequest request){
		return "/ConfimeCompra";
	}
	
	@RequestMapping("/FinalizarCompra")
	public String FinalizarCompra(HttpServletRequest request){
		@SuppressWarnings("unchecked")
		List<Compras> comps = (List<Compras>) request.getSession().getAttribute("meu_carrinho");
		
		for (Compras c: comps){
			dao.RemoverObj(Long.parseLong(c.getId_Produto()));
			dao.remover_compra(c.getId_Produto());
		}
		
		request.getSession().setAttribute("carrinho_qtd", comps.size());
		request.getSession().setAttribute("meu_carrinho", comps);
		request.getSession().setAttribute("carrinho_valor_total", 0);
		
		return "redirect:/";
	}
	
	
}

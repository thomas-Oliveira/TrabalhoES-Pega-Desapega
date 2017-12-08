package PegaEDesapega.UsuarioController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import PegaEDesapega.model.Objeto;


@Controller
public class IndexController {
	
	UserControllerDao dao = new UserControllerDao();
	
	@RequestMapping("/")
    public String index(HttpServletRequest request) {
		List<Objeto> objts = dao.GetObjetos();
		request.getSession().setAttribute("MostraIndex", "Novos Produtos");
		request.getSession().setAttribute("produtosIndex", objts);
        return "Home";
    }
}

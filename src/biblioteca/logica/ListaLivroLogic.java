package biblioteca.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class ListaLivroLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Livro> livros = new LivroDAO().getLivros();
		req.setAttribute("livros", livros);	
		return "/WEB-INF/jsp/listarLivros.jsp";
	}
}
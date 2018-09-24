package biblioteca.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class RemoveLivroLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		Livro livro = new Livro();
		livro.setId(id);
		LivroDAO dao = new LivroDAO();
		dao.remover(livro);
		System.out.println("Excluindo livro... ");
		return "mvc?logica=ListaLivroLogic";
	}
}
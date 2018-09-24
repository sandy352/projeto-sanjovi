package biblioteca.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class AdicionaLivroLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String edicao = request.getParameter("edicao");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String editora = request.getParameter("editora");
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livro.setEdicao(edicao);
		livro.setAno(ano);
		livro.setEditora(editora);
		LivroDAO dao = new LivroDAO();
		if(dao.inserir(livro)) {
			System.out.println("Adicionando Livro...");
			return "mvc?logica=ListaLivroLogic";
			}else {
				request.setAttribute("mensagem", "Erro, não foi possível adicionar o Livro " + nome + ".");	
				return "/WEB-INF/jsp/erro.jsp";
			}
		}
}
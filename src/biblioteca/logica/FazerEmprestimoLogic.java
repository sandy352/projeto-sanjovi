package biblioteca.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.LivroDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Livro;
import biblioteca.models.Emprestimo;

public class FazerEmprestimoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long idLivro = Long.parseLong(request.getParameter("idLivro"));
		int matriculaAluno = Integer.parseInt(request.getParameter("matriculaAluno"));
		EmprestimoDAO eDAO = new EmprestimoDAO();
		Emprestimo e = new Emprestimo();
		Aluno a = new AlunoDAO().getByMatricula(matriculaAluno);
		//Esse IF verifica se o livro passado aqui já foi pego
		if (eDAO.LivroEmprestado(a.getId())) {

			if (eDAO.qtdLivrosPegos(a.getId())) {
				//Esse daqui verifica se o aluno já pegou 3 livros
				
				Livro l = new LivroDAO().getById(idLivro);
				e.setAluno(a);
				e.setLivro(l);
				eDAO.inserir(e);
				System.out.print("Deu certo");
				request.setAttribute("mensagem", "Emprestimo feito com sucesso.");
				return "mvc?logica=ListaEmprestimosLogic";
			} else {
				//Aqui é o else do if que verifica a qtde de livros
				System.out.print("Deu merda");
				request.setAttribute("mensagem", "Erro, livro já emprestado.");
				return "/WEB-INF/jsp/erro.jsp";
			}
		} else {
			
			// Aqui é o else do if que verifica se o livro já foi peg
			System.out.print("Deu merda");
			request.setAttribute("mensagem", "Erro, o aluno já pegou 3 livros.");
			return "/WEB-INF/jsp/erro.jsp";
			
			
		}

	}
}

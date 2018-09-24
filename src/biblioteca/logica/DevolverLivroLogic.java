package biblioteca.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.EmprestimoDAO;


public class DevolverLivroLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmprestimoDAO eDAO = new EmprestimoDAO();
		long idLivro = Long.parseLong(request.getParameter("idLivro"));
		long idAluno = Long.parseLong(request.getParameter("idAluno"));
		if(eDAO.devolucao(idAluno, idLivro)) {
			request.setAttribute("mensagem", "Devolução feita com sucesso.");
			return "mvc?logica=ListaEmprestimosLogic";
			
		}else {
			request.setAttribute("mensagem", "Erro, a devolução não pode ser feita");	
			return "/WEB-INF/jsp/erro.jsp";
		}
		
	}
}

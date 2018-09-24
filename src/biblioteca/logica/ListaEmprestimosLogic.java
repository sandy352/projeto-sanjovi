package biblioteca.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.EmprestimoDAO;
import biblioteca.models.Emprestimo;


public class ListaEmprestimosLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Emprestimo> emprestimos = new EmprestimoDAO().getEmprestimos();

		req.setAttribute("emprestimos", emprestimos);	
		return "/WEB-INF/jsp/listarEmprestimos.jsp";
	}

}

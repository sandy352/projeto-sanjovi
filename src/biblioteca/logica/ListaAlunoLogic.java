package biblioteca.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.daos.EmprestimoDAO;
import biblioteca.models.Aluno;

public class ListaAlunoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Aluno> alunos = new AlunoDAO().getAlunos();
		req.setAttribute("alunos", alunos);	
		return "/WEB-INF/jsp/listarAlunos.jsp";
	}
}
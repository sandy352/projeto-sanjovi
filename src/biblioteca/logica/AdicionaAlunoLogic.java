package biblioteca.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;

public class AdicionaAlunoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro de conversão da data");
		}

		Aluno a = new Aluno();
		a.setNome(nome);
		a.setMatricula(matricula);
		a.setEndereco(endereco);
		a.setDataNascimento(dataNascimento);
		AlunoDAO dao = new AlunoDAO();
		if (dao.inserir(a)) {
			System.out.println("Adicionando Aluno");
			return "mvc?logica=ListaAlunoLogic";
		} else {
			request.setAttribute("mensagem", "Erro, não foi possível adicionar o Aluno " + nome + ".");
			return "/WEB-INF/jsp/erro.jsp";
		}
	}
}

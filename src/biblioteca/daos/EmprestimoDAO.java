package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into emprestimos (idAluno, idLivro, dataEmprestimo) values (?, ?, ?);";
		Calendar cal = Calendar.getInstance();
		Long cal1 = cal.getTimeInMillis();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, emprestimo.getAluno().getId());
			stmt.setLong(2, emprestimo.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(cal1));
			
			
			inserir2(emprestimo.getLivro().getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	// Um método pra colocar o atributo "devolvido" no "inserir", pq o java n aceita
	// dois comandos SQL em um trecho só

	public void inserir2(Long idLivro) {
		
		// Sql, pegue esse ID, veja qual livro tem esse id, e coloque o campo "emprestado" dele pra verdadeiro
		String sql = "update livros set emprestado = true where id = ?;";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idLivro);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	// Aqui é a quantidade de livros que um aluno pegou

	public boolean qtdLivrosPegos(Long idAluno) {

		String sql = "select * from emprestimos where idAluno = ? and devolvido = false;";
		int qtdDeLivrosEmprestados = 0;

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idAluno);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// While que conta quantos livros ele tem que não foram devolvidos

				qtdDeLivrosEmprestados++;
			

			}
			stmt.close();

			// Esse IF verifica se os livros emprestados são maior que 3, se sim, ele
			// retorna falso(Lembrando
			// que esse método aqui só retorna uma resposta se ele pode pegar ou não)


			if (qtdDeLivrosEmprestados >= 3) {
				// Retorna Falso caso tenha mais de 3 livros emprestados
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// Método pra ver se o livro tá emprestado ou não
	public boolean LivroEmprestado(Long idLivro) {
		String sql = "select * from livros where id = ? and emprestado = true;";
		int LivroEmprestado = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, idLivro);
			ResultSet rs = stmt.executeQuery();

			// While que conta quantas vezes o livro foi emprestado
			while (rs.next()) {
				LivroEmprestado++;
			}

			// If que vê se o Livro foi emprestado
			if (LivroEmprestado > 1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	public boolean devolucao(long idAluno, long idLivro) {
		Calendar cal = Calendar.getInstance();
		Long cal1 = cal.getTimeInMillis();

		// Update = Edita uma linha do Banco de dados(no caso, edita a dataDevolucao
		// passando um idAluno e idLivro)
		// O devolvido tá true pq como a gente já sabe que isso aqui é pra devolver, já
		// pode colocar logo de cara
		String sql = "update emprestimos set dataDevolucao=?, devolvido=true where idAluno=? and idLivro=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(cal1));
			stmt.setLong(2, idAluno);
			stmt.setLong(3, idLivro);
			// Esse "devolucao2" veio dali de baixo, pq o sql n deixa executar dois comandos
			// diferentes de uma só
			// vez
			devolucao2(idLivro);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Mesma coisa que o "inserir2", apenas pq o sql não aceita dois comandos

	public void devolucao2(Long idLivro) {
		String sql = "update livros set emprestado=false where id=?;";
		// Isso aqui edita o atributo "emprestado" do livro de verdadeiro pra falso
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idLivro);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// pesquisar emprestimos pela matricula

	public List<Emprestimo> pesquisarPorMatricula(int matriculaAluno) {
		List<Emprestimo> result = new ArrayList<>();
		String sql = "select * from emprestimos where idAluno = ?;";
		Aluno a = new AlunoDAO().getByMatricula(matriculaAluno);

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, a.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Emprestimo e = new Emprestimo();

				
				Livro livro = new Livro();
				// Novo objeto livro
				
				livro.setId(rs.getLong("idLivro"));
				// Boto o id do novo livro
				
				e.setLivro(livro);
				// Coloco esse novo livro no emprestimo

				
				Aluno aluno = new Aluno();
				// Novo aluno
				
				aluno.setId(rs.getLong("idAluno"));
				// Boto o id do novo aluno
				
				e.setAluno(aluno);
				// Coloco esse novo aluno no emprestimo

				// Datas

				Calendar data = Calendar.getInstance();
				 
				//pego a data de emprestimo que veio do SQL
				data.setTime(rs.getDate("dataEmprestimo"));
				// coloco no emprestimo
				e.setDataEmprestimo(data);

				//pego a data de Devolucao que veio do SQL
				data.setTime(rs.getDate("dataDevolucao"));
				// coloco no emprestimo
				e.setDataDevolucao(data);

				result.add(e);
			}
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Emprestimo> getEmprestimos() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Emprestimo e = new Emprestimo();
				Aluno a = new AlunoDAO().getById(rs.getLong("idAluno"));
				Livro l = new LivroDAO().getById(rs.getLong("idLivro"));
				e.setAluno(a);
				e.setLivro(l);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				e.setDataEmprestimo(data);

				// Como houveram problemas com a data de devolução ser nula, então eu fiz uma lógica

				// se a data de devolucao que veio do SQL não estiver vazia(null)
				if (rs.getDate("dataDevolucao") != null) {
					//então eu posso converter ela 
					data.setTime(rs.getDate("dataDevolucao"));
					
					// E colocar ela no objeto emprestimo
					e.setDataDevolucao(data);
					
				} else {
					//mas se ela estiver vazia, então eu coloco null direto, pq o null do SQL e o null do java tem conflitos e dão bug
					e.setDataDevolucao(null);
				}

				result.add(e);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("delete from emprestimos where idLivro=? and idAluno =?;");
			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.setLong(2, emprestimo.getAluno().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

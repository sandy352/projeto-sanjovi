package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Livro;

public class LivroDAO {

	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Livro livro) {

		String sql = "insert into livros (nome, autor, editora, ano, edicao) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setInt(4, livro.getAno());
			stmt.setString(5, livro.getEdicao());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	
	public List<Livro> pesquisar(String nomeLivro) {
		List<Livro> result = new ArrayList<>();
		String sql = "select * from livros where titulo like ?;";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nomeLivro);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			Livro l = new Livro();
			l.setId(rs.getLong("id"));
			l.setNome(rs.getString("nome"));
			l.setAutor(rs.getString("autor"));
			l.setEditora(rs.getString("editora"));
			l.setAno(rs.getInt("ano"));
			l.setEdicao(rs.getString("edicao"));
			result.add(l);
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Livro> getLivros() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Livro
				Livro l = new Livro();
				l.setId(rs.getLong("id"));
				l.setNome(rs.getString("nome"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				l.setAno(rs.getInt("ano"));
				l.setEdicao(rs.getString("edicao"));
				result.add(l);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Livro livro) {
		String sql = "update livros set nome=?, autor=?, editora=?, ano=?, edicao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setInt(4, livro.getAno());
			stmt.setString(5, livro.getEdicao());
			stmt.setLong(6, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livros where id=?;");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livro getById(Long id) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Livro();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				result.setAno(rs.getInt("ano"));
				result.setEdicao(rs.getString("edicao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Livro getByNome(String nome) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros where nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Livro();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				result.setAno(rs.getInt("ano"));
				result.setEdicao(rs.getString("edicao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}

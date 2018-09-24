package biblioteca.models;

import java.util.Calendar;
import java.util.List;

public class Aluno {
	private Long id;
	private String nome;
	private int matricula;
	private String endereco;
	private Calendar dataNascimento;
	private List<Livro> LivrosAtrasados;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<Livro> getLivrosAtrasados() {
		return LivrosAtrasados;
	}
	public void setLivrosAtrasados(List<Livro> livrosAtrasados) {
		LivrosAtrasados = livrosAtrasados;
	}
	
}
